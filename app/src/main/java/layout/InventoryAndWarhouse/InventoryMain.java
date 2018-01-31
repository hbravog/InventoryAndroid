package layout.InventoryAndWarhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.thesis.inventory.inventoryandroid.MenuActivity;
import com.thesis.inventory.inventoryandroid.R;

import layout.InventoryAndWarhouse.AvailablePhysical.AvailablePhysicalMain;
import layout.Products.MainProduct;

public class InventoryMain extends AppCompatActivity {

    private Button available;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_main);
        AddListeneronButton();
    }

    public void AddListeneronButton()
    {

        available = (Button)findViewById(R.id.btnDisponible);
        available.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0)
            {
                Intent intMainWareHouse = new Intent(InventoryMain.this, AvailablePhysicalMain.class);
                InventoryMain.this.startActivity(intMainWareHouse);
            }
        });
    }
}


