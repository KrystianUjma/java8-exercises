package example5;

import java.util.Optional;

/**
 * Created by Veezq on 2015-10-14.
 */
public class OptionalExample {

    public static void main(String[] args) {

        new OptionalExample().start();
    }

    public ClientOpt createClient(){
        BuildingOpt buildingOpt = new BuildingOpt();
        buildingOpt.setNumber(3);

        AddressOpt addressOpt = new AddressOpt();
        addressOpt.setBuilding(Optional.ofNullable(buildingOpt));

        ClientOpt clientOpt = new ClientOpt();
        clientOpt.setName("client");
        clientOpt.setAddress(Optional.ofNullable(addressOpt));

        return clientOpt;
    }

    public void start(){
        ClientOpt clientOpt = createClient();

        Integer number = Optional
                .ofNullable(clientOpt)
                .flatMap(ClientOpt::getAddress)
                .flatMap(AddressOpt::getBuilding)
                .map(BuildingOpt::getNumber)
                .filter(numb -> numb > 2)
                .orElse(-2);

        System.out.println(number);

    }

}
