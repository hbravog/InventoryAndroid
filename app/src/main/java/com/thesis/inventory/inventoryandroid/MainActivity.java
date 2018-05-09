package com.thesis.inventory.inventoryandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;

import Generics.Globals;
import services.AppController;
import services.User;


public class MainActivity extends AppCompatActivity {

    private Button btnLogin;

    private EditText txtRut;
    private EditText txtPass;
    Globals globals = new Globals();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_new) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ValidaUser()
    {
        User user = new User();
        txtRut = (EditText) findViewById(R.id.txtRut);
        txtPass = (EditText) findViewById(R.id.txtPass);


        //final ProgressDialog pDialog = new ProgressDialog(this);
        //pDialog.setMessage("Cargando...");
        //pDialog.show();
        String url = globals.getIp() + "InventoryRest/rs/service/getValidaUsuario?p1="+txtRut.getText().toString().trim()+"&p2="+txtPass.getText().toString().trim()+"";
       //String url = globals.getIp() + "InventoryRest/rs/service/getAllProduct";

        JsonArrayRequest jreq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                public void onResponse(JSONArray response) {
                    if(response.length() > 0)
                    {
                        Globals g = Globals.getInstance();
                        g.setUser("Hernan");

                        try {
                        String a = response.getString(0);

                           // String name = jo.getString("name");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Intent myIntent = new Intent(MainActivity.this, MenuActivity.class);
                        MainActivity.this.startActivity(myIntent);
                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Usuario Invalido").setTitle("Error Login");
                        AlertDialog dialog = builder.create();
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
    //------Listener-----------------------------------//
    public void addListenerOnButton() {

        btnLogin = (Button) findViewById(R.id.btnSingIn);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                ValidaUser();
            }
        });

    }

}
