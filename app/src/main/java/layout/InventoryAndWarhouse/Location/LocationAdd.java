package layout.InventoryAndWarhouse.Location;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.thesis.inventory.inventoryandroid.R;

import java.util.ArrayList;
import java.util.List;

import Generics.Globals;

public class LocationAdd extends AppCompatActivity
{
    List<LocationAdd> listLocationAdd;
    Globals globals = new Globals();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_location_add);
    }


}
