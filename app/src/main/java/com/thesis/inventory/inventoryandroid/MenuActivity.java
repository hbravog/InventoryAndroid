package com.thesis.inventory.inventoryandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import Generics.Globals;
import layout.InventoryAndWarhouse.AvailablePhysical.AvailablePhysicalMain;
import layout.InventoryAndWarhouse.InventoryMain;
import layout.inventory.InventoryList;
import services.AppController;
import layout.Products.MainProduct;

public class MenuActivity extends AppCompatActivity {


    private Button btnInventario, btnProducto,btnInventoryWarehouse;
    Globals globals = new Globals();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        AddListeneronButton();
    }
/*
    public void ValidateInventory()
    {
        String url = globals.getIp() + "InventoryRest/rs/service2/getInventoryActive";

        JsonArrayRequest jreq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        if(response.length() > 0)
                        {
                            Globals g = Globals.getInstance();
                            g.setUser("Hernan");

                            Intent myIntent = new Intent(MenuActivity.this, InventoryList.class);
                            myIntent.putExtra("jsonArrayInventory",response.toString());
                            MenuActivity.this.startActivity(myIntent);
                        }
                        else
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                            builder.setMessage("No hay inventario activo").setTitle("Error inventario");
                            AlertDialog dialog = bu15585ilder.create();
                            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //...
                                }});
                            dialog.show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        AppController.getInstance().addToRequestQueue(jreq, "jreq");
    }
*/
    public void AddListeneronButton()
    {
        btnInventario = (Button) findViewById(R.id.btnInventario);
        btnInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // ValidateInventory();
            }
        });

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
