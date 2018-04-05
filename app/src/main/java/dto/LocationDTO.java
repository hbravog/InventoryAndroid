package dto;

/**
 * Created by hernanbravo on 08-02-18.
 */

public class LocationDTO
{
    private int id;
    private String location;
    private int warehouse;

    public LocationDTO(int id,String location, int warehouse)
    {
        this.id = id;
        this.location = location;
        this.warehouse = warehouse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }
}
