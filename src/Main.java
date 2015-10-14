import example2.Domain;
import foo.Email;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Domain d = new Domain();
        d.setName("foo");

        Domain d2 = new Domain();
        d2.setName("bar");

        ArrayList<Domain> list = new ArrayList<>();
        list.add(d);
        list.add(d2);

        Comparator<Domain> comparing = Comparator.comparing(new Function<Domain, String>() {
            @Override
            public String apply(Domain domain) {
                return domain.getName();
            }
        });


        Comparator<String> comp = Comparator.comparing(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });

        List<String> f = Arrays.asList("aaa", "bb");

        f.forEach(System.out::print);
        System.out.println();
        Collections.sort(f,comp);
        f.forEach(System.out::print);
        System.out.println();


        Collections.sort(Arrays.asList(1, 2, 3, 4, 5), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });



        list.forEach((obj) -> System.out.print(obj.getName()));
        System.out.println("--------");
        Collections.sort(list, comparing);
        System.out.println("--------");
        list.forEach((obj) -> System.out.print(obj.getName()));
        System.out.println("--------");
        System.out.println("--------");


        System.out.println("Hello World!");

        List<Integer> strings = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer liczba) {
                return liczba > 3;
            }
        };

        long result = strings.stream()
                .filter((predicate.and(p -> p > 9).or(z -> z > 2)).and(x -> x > 0))
                .count();

        System.out.println(result);





//        Function<Email, Email> addHeader = new Function<Email, Email>() {
//            @Override
//            public Email apply(Email email) {
//                return email.addHeader();
//            }
//        };




        Function<Email, Email> func = new Function<Email, Email>() {
            @Override
            public Email apply(Email email) {
                System.out.println("1-------------------");
                System.out.println(email.toString());
                return email.addHeader();
            }
        }.andThen(new Function<Email, Email>() {
            @Override
            public Email apply(Email email) {
                System.out.println("2------------");
                System.out.println(email.toString());
                return email.checkSpelling();
            }
        }).andThen(new Function<Email, Email>() {
            @Override
            public Email apply(Email email) {
                System.out.println("3-------------");
                System.out.println(email.toString());
                return email.addGreetings();
            }
        });


        Email e = func.apply(new Email("Java"));

        System.out.println(e);


    }
}
