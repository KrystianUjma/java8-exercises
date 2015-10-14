package example5;

/**
 * Created by Veezq on 2015-10-14.
 */
public class NoOptionalExample {

    public static void main(String[] args) {

        new NoOptionalExample().start();
    }

    public Client  createClient(){
        Building building = new Building();
//        buildingOpt.setNumber(2);

        Address address = new Address();
        address.setBuilding(building);

        Client client = new Client();
        client.setName("foo");
        client.setAddress(address);

        return client;
    }

    public void start(){
        Client client = createClient();

        int number = 0;

        if(client != null){
            Address address = client.getAddress();
            if(address != null){
                Building building = address.getBuilding();
                if(building.getNumber() > 2){
                    number = building.getNumber();
                }else{
                    number = -1;
                }
            }
        }

        System.out.println(number);

    }
}
