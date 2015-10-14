package example5;

import java.util.Optional;

/**
 * Created by Veezq on 2015-10-14.
 */
public class ClientOpt {

    private String name;
    private Optional<AddressOpt> address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<AddressOpt> getAddress() {
        return address;
    }

    public void setAddress(Optional<AddressOpt> address) {
        this.address = address;
    }
}
