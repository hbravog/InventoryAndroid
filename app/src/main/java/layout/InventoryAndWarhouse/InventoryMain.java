package layout.InventoryAndWarhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.thesis.inventory.inventoryandroid.R;

import layout.InventoryAndWarhouse.AvailablePhysical.AvailablePhysicalView;
import layout.InventoryAndWarhouse.Location.LocationView;
import layout.InventoryAndWarhouse.Warehouse.WareHouseView;

public class InventoryMain extends AppCompatActivity
{

    private Button available, location, warehouse;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_main);
        AddListeneronButton();
    }

    public void AddListeneronButton()
    {
        available = (Button)findViewById(R.id.btnDisponible);
        available.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent intMainWareHouse = new Intent(InventoryMain.this, AvailablePhysicalView.class);
                InventoryMain.this.startActivity(intMainWareHouse);
            }
        });

        location = (Button)findViewById(R.id.btnUbicaciones);
        location.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent intMainWareHouse = new Intent(InventoryMain.this, LocationView.class);
                InventoryMain.this.startActivity(intMainWareHouse);
            }
        });

        warehouse = (Button)findViewById(R.id.btnAlmacen);
        warehouse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent intMainWareHouse = new Intent(InventoryMain.this, WareHouseView.class);
                InventoryMain.this.startActivity(intMainWareHouse);
            }
        });
    }
}


