import foo.Email;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
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
