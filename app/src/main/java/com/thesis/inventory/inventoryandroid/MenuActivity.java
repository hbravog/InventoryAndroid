package com.thesis.inventory.inventoryandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import layout.InventoryAndWarhouse.InventoryMain;
import layout.Products.MainProduct;

public class MenuActivity extends AppCompatActivity {


    private Button btnProducto,btnInventoryWarehouse;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        AddListeneronButton();
    }

    public void AddListeneronButton()
    {
        btnProducto = (Button) findViewById(R.id.btnProductos);
        btnProducto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MenuActivity.this, MainProduct.class);
                MenuActivity.this.startActivity(myIntent);
            }
        });

        btnInventoryWarehouse = (Button)findViewById(R.id.btnInvAlm);
        btnInventoryWarehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0)
            {
               Intent intMainWareHouse = new Intent(MenuActivity.this, InventoryMain.class);
                MenuActivity.this.startActivity(intMainWareHouse);
            }
        });


    }
}
