package layout.InventoryAndWarhouse.AvailablePhysical;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.thesis.inventory.inventoryandroid.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Generics.Globals;
import services.AppController;

public class AvailablePhysicalAdd extends AppCompatActivity {
    Globals globals = new Globals();
    private EditText codProducto,descripcion,cantidad,bodega,ubicacion;
    private Button guardar,buscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_available_physical_add);

        codProducto = (EditText) findViewById(R.id.txtcodProducto);
        descripcion = (EditText) findViewById(R.id.txtProducto);
        cantidad = (EditText) findViewById(R.id.txtCantidad);
        bodega  = (EditText) findViewById(R.id.txtBodega);
        ubicacion = (EditText) findViewById(R.id.txtUbicacion);
        guardar = (Button) findViewById(R.id.btnGuardar);
        buscar = (Button)findViewById(R.id.btnBuscar);

        AddListenerEdit();
        AddListenerButtonFind();
        AddListenerButtonQty();
        AddLoseFocus();
        AddListenerDescriptionButton();
        AddListenerButtonAvailable();

    }

    public void FindItemByCode()
    {
        String url = globals.getIp() + "InventoryRest/rs/service/getProductByCode?p1=" + codProducto.getText().toString().trim();
        JsonArrayRequest jreq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if(response.length() > 0)
                        {
                            for(int i=0;i<response.length();i++)
                            {
                                try {
                                    JSONObject obj = response.getJSONObject(i);
                                    descripcion.setText(obj.getString("nombre"));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Producto ingresado no existe en el sistema.", Toast.LENGTH_LONG).show();
                            CleanControl();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        AppController.getInstance().addToRequestQueue(jreq, "jreq");
    }

    public void AddAvailablePhysical()
    {
        String url = globals.getIp() + "InventoryRest/rs/service/AdjustItemQty?p1=" + codProducto.getText().toString().trim() + "&p2=" + cantidad.getText().toString().trim() + "&p3=" + bodega.getText().toString().trim() + "&p4=" + ubicacion.getText().toString().trim();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String s) {
                if(s.equals("1")){
                    Toast.makeText(getApplicationContext(), "Se realizo un ajuste en la cantidad de : " + codProducto.getText(), Toast.LENGTH_LONG).show();
                    CleanControl();
                }
                else if(s.equals("2"))
                {
                    Toast.makeText(getApplicationContext(), "La combinación de ubicación - bodega no existe.", Toast.LENGTH_LONG).show();
                    CleanControl();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        AppController.getInstance().addToRequestQueue(request, "jreq");
    }
    //--------------------------------Listener-------------------------------------//
    public void AddListenerEdit()
    {
        codProducto = (EditText) findViewById(R.id.txtcodProducto);
        codProducto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                codProducto.setText("");
            }
        });

        cantidad = (EditText) findViewById(R.id.txtCantidad);
        cantidad.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                cantidad.setText("");
            }
        });

        bodega = (EditText) findViewById(R.id.txtBodega);
        bodega.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                bodega.setText("");
            }
        });

        descripcion = (EditText) findViewById(R.id.txtProducto);
        descripcion.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                descripcion.setText("");
            }
        });

        ubicacion = (EditText) findViewById(R.id.txtUbicacion);
        ubicacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ubicacion.setText("");
            }
        });
    }

    public void AddListenerDescriptionButton()
    {
        descripcion = (EditText) findViewById(R.id.txtProducto);
        descripcion.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                codProducto.setText("");
            }
        });

    }

    public void AddListenerButtonFind()
    {
        buscar = (Button) findViewById(R.id.btnBuscar);
        buscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View arg0)
            {
                FindItemByCode();
            }
        });
    }

    public void AddListenerButtonAvailable()
    {
        guardar = (Button) findViewById(R.id.btnGuardar);
        guardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View arg0)
            {
                AddAvailablePhysical();
            }
        });
    }

    public void AddListenerButtonQty()
    {
        cantidad = (EditText) findViewById(R.id.txtCantidad);
        cantidad.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View arg0)
            {
               cantidad.setText("");
            }
        });
    }

    public void AddLoseFocus()
    {
        codProducto.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                  //  codProducto.setText("Codigo de Producto");
                }
            }
        });
    }
    //--------------------------------Listener-------------------------------------//

    public void CleanControl()
    {
        this.codProducto.setText("");
        this.cantidad.setText("");
        this.bodega.setText("");
        this.ubicacion.setText("");
        this.descripcion.setText("");
    }
}

