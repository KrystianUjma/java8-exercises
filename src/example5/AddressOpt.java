package example5;

import java.util.Optional;

/**
 * Created by Veezq on 2015-10-14.
 */
public class AddressOpt {

    private Optional<BuildingOpt> building;

    public Optional<BuildingOpt> getBuilding() {
        return building;
    }

    public void setBuilding(Optional<BuildingOpt> building) {
        this.building = building;
    }
}
