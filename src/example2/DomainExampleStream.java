package example2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

/**
 * Created by Veezq on 2015-10-10.
 */
public class DomainExampleStream {

    public static void main(String[] args) {
        new DomainExampleStream().test();
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
                .mapToDouble(new ToDoubleFunction<Domain>() {
                    @Override
                    public double applyAsDouble(Domain value) {
                        return value.getPrice();
                    }
                }).max().getAsDouble();

        System.out.println(highestPrice);


        double highestPrice2 = domains.stream()
                                        .filter((Domain domain) -> domain.getYearOfCreation() == 2005)
                                        .mapToDouble((Domain value) -> value.getPrice())
                                        .max()
                                        .getAsDouble();

        System.out.println(highestPrice2);


        double highestPrice3 = domains.stream()
                                        .filter(domain -> domain.getYearOfCreation() == 2005)
                                        .mapToDouble(value -> value.getPrice())
                                        .max()
                                        .getAsDouble();

        System.out.println(highestPrice3);



    }


    private List<Domain> createDomains(){
        Domain d1 = new Domain();
        d1.setDomainType(Domain.DOMAIN_TYPE.EU);
        d1.setPrice(10);
        d1.setYearOfCreation(2005);

        Domain d2 = new Domain();
        d2.setDomainType(Domain.DOMAIN_TYPE.EU);
        d2.setPrice(30);
        d2.setYearOfCreation(2005);

        Domain d3 = new Domain();
        d3.setDomainType(Domain.DOMAIN_TYPE.PL);
        d3.setPrice(20.1);
        d3.setYearOfCreation(2007);

        return Arrays.asList(d1, d2, d3);
    }
}
