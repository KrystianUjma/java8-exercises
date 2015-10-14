package example2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Veezq on 2015-10-10.
 */
public class DomainExample {

    public static void main(String[] args) {
        new DomainExample().test();
    }

    private void test(){
        List<Domain> domains = createDomains();

        Double highestPrice = 0.0;

        for(Domain domain : domains){
            if(domain.getYearOfCreation() == 2005){
                if(domain.getPrice() > highestPrice){
                    highestPrice = domain.getPrice();
                }
            }
        }

        System.out.println("result is: " + highestPrice);

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
