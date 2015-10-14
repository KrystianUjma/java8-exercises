package example2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Veezq on 2015-10-10.
 */
public class DomainExampleStream2 {



    public static void main(String[] args) {
        new DomainExampleStream2().test();
    }

    private void test(){
        List<Domain> domains = createDomains();


        double highestPrice = domains.stream()
                .filter(new Predicate<Domain>() {
                    @Override
                    public boolean test(Domain domain) {
                        return domain.getYearOfCreation() == 2005;
                    }
                })
                .map(new Function<Domain, Double>() {
                    @Override
                    public Double apply(Domain domain) {
                        return domain.getPrice();
                    }
                })
                .max(Comparator.naturalOrder())
                        .get();
//                .mapToDouble(new ToDoubleFunction<Domain>() {
//                    @Override
//                    public double applyAsDouble(Domain value) {
//                        return value.getPrice();
//                    }
//                })
//                .max().getAsDouble();

        System.out.println(highestPrice);
//
//
//        double highestPrice2 = domains.stream()
//                                        .filter((Domain domain) -> domain.getYearOfCreation() == 2005)
//                                        .mapToDouble((Domain value) -> value.getPrice())
//                                        .max()
//                                        .getAsDouble();
//
//        System.out.println(highestPrice2);
//
//
//        double highestPrice3 = domains.stream()
//                .filter(domain -> domain.getYearOfCreation() == 2005)
//                .mapToDouble(value -> value.getPrice()).max().getAsDouble();
//
//        System.out.println(highestPrice3);
//
//
        System.out.println(
                domains.stream()
                        .filter(DomainExampleStream2::isYear2005Static)
                        .mapToDouble(value -> value.getPrice())
                        .max()
                        .getAsDouble()
        );

//        OptionalDouble temp = domains.stream()
//                .filter(DomainExampleStream2::isYear2005Static)
//                .filter(DomainExampleStream2::isEU)
//                .mapToDouble(value -> value.getPrice())
//                .max();


        System.out.println(
                domains.stream()
                        .filter(DomainExampleStream2::isYearGreaterThan2005)
                        .filter(DomainExampleStream2::isPriceEven)
                        .map(DomainExampleStream2::doubleIt)
                        .findFirst()
                        .get()
        );


        double price = 0.0;
        for(Domain domain: domains){
            if(domain.getYearOfCreation() > 2005){
                if(domain.getPrice() % 2 == 0){
                    price = domain.getPrice() * 2;
                    break;
                }
            }
        }

        System.out.println(price);

    }

    private static boolean isYearGreaterThan2005(Domain domain) {
        System.out.println("isYearGreaterThan2005 " + domain.getName());
        return domain.getYearOfCreation() > 2005;
    }

    private static boolean isPriceEven(Domain domain) {
        System.out.println("isPriceEven " + domain.getName());
        return domain.getPrice() % 2 == 0;
    }

    private static double doubleIt(Domain domain) {
        System.out.println("doubleIt " + domain.getName());
        return domain.getPrice() * 2;
    }


    private static boolean isEU(Domain domain) {
        System.out.println("isEU " + domain.getDomainType());
        return domain.getDomainType().equals(Domain.DOMAIN_TYPE.EU);
    }

    private boolean isYear2005(int yearOfCreation) {
        return yearOfCreation == 2005;
    }

    private static boolean isYear2005Static(Domain domain){
        System.out.println("isYear2005Static " + domain.getYearOfCreation());
        return domain.getYearOfCreation() == 2005;
    }



    private List<Domain> createDomains(){
        Domain d1 = new Domain();
        d1.setDomainType(Domain.DOMAIN_TYPE.EU);
        d1.setPrice(11);
        d1.setYearOfCreation(2005);
        d1.setName("a");

        Domain d2 = new Domain();
        d2.setDomainType(Domain.DOMAIN_TYPE.EU);
        d2.setPrice(31);
        d2.setYearOfCreation(2006);
        d2.setName("b");

        Domain d3 = new Domain();
        d3.setDomainType(Domain.DOMAIN_TYPE.EU);
        d3.setPrice(31);
        d3.setYearOfCreation(2005);
        d3.setName("c");

        Domain d4 = new Domain();
        d4.setDomainType(Domain.DOMAIN_TYPE.EU);
        d4.setPrice(50);
        d4.setYearOfCreation(2006);
        d4.setName("d");

        Domain d5 = new Domain();
        d5.setDomainType(Domain.DOMAIN_TYPE.EU);
        d5.setPrice(40);
        d5.setYearOfCreation(2005);
        d5.setName("e");

        Domain d6 = new Domain();
        d6.setDomainType(Domain.DOMAIN_TYPE.PL);
        d6.setPrice(20);
        d6.setYearOfCreation(2007);
        d6.setName("f");

        return Arrays.asList(d1, d2, d3, d4, d5, d6);
//        return Arrays.asList(d4);
    }
}
