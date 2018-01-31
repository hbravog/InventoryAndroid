package layout.Products;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.thesis.inventory.inventoryandroid.R;

import layout.InventoryAndWarhouse.AvailablePhysical.AvailablePhysical;

public class MainProduct extends AppCompatActivity {

    private Button btnNuevoProducto;
    private Button btnProductList;
    private Button btnDisponible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_product);
        AddListeneronButton();

    }


    public void AddListeneronButton()
    {
        btnNuevoProducto = (Button) findViewById(R.id.btnNuevoProducto);
        btnNuevoProducto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainProduct.this, CreateProduct.class);
                MainProduct.this.startActivity(myIntent);
            }
        });

        btnProductList = (Button) findViewById(R.id.btnProductList);
        btnProductList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent myIntent2 = new Intent(MainProduct.this, ListProduct.class);
                MainProduct.this.startActivity(myIntent2);
            }
        });

        btnDisponible = (Button) findViewById(R.id.btnAjuste);
        btnDisponible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent3 = new Intent(MainProduct.this,AvailablePhysical.class);
                MainProduct.this.startActivity(myIntent3);
            }
        });
    }
}
