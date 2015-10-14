package example2;

/**
 * Created by Veezq on 2015-10-10.
 */
public class Domain {

    private DOMAIN_TYPE domainType;
    private int yearOfCreation;
    private double price;
    private String name;

    public DOMAIN_TYPE getDomainType() {
        return domainType;
    }

    public void setDomainType(DOMAIN_TYPE domainType) {
        this.domainType = domainType;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    enum DOMAIN_TYPE{
        PL, EU
    }
}
