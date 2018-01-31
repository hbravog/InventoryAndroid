package layout.InventoryAndWarhouse.Location;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.thesis.inventory.inventoryandroid.R;

import java.util.ArrayList;
import java.util.List;

import Generics.Globals;

public class Location extends AppCompatActivity
{
    List<Location> listLocation ;
    Globals globals = new Globals();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_location_add);
    }

    public void GetAllLocation()
    {
        listLocation = new ArrayList<>();
        String url = globals.getIp() + "InventoryRest/rs/service/getAllLocation";

    }

}
