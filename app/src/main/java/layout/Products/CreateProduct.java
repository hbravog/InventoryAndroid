package layout.Products;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import Util.QrCodeHelper;
import Util.Singleton;
import dal.QrImagePathFile;
import dto.CategoriaDTO;
import dto.ProveedorDTO;
import services.AppController;

public class CreateProduct extends AppCompatActivity   {

    Button registrar;
    private EditText codProducto;
    private EditText descripcion;
    private EditText precio;

    Object item;
    private Spinner spinner_prov,spn_categoria;
    String contents;


    List<CategoriaDTO> listCategory;
    ArrayList<CategoriaDTO> lista = new ArrayList<>();
    ArrayList<ProveedorDTO> listProv = new ArrayList<>();

    Singleton singleton = new Singleton();

    QrCodeHelper qrCodeHelper = new QrCodeHelper();
    QrImagePathFile pathFile = new QrImagePathFile();
    public CreateProduct() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_create_product);

        codProducto = (EditText) findViewById(R.id.txtcodProducto);
        descripcion = (EditText) findViewById(R.id.txtProducto);
        precio = (EditText) findViewById(R.id.txtPrecio);
        spn_categoria = (Spinner) findViewById(R.id.spn_categoria);
        spinner_prov = (Spinner) findViewById(R.id.spinner_prov);

        this.GetAllCategory();
        this.GetAllProviders();
        AddListeneronButton();
    }

    protected void CreateProduct()
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());
        Singleton g = Singleton.getInstance();

        if(TextUtils.isEmpty(descripcion.getText().toString()))
        {
            descripcion.setError("Ingrese una Descripcion");
            return;
        }
        else
        {
            ProveedorDTO dto = (ProveedorDTO)spinner_prov.getSelectedItem();
            int id_prov = dto.getId();

            CategoriaDTO dto1 = (CategoriaDTO)spn_categoria.getSelectedItem();
            int id_cat = dto1.getId();


            String url = singleton.getIp() + "InventoryRest/rs/service/AddProduct?p1=" + codProducto.getText().toString().trim() + "&p2=" + descripcion.getText().toString()+ "&p3=" + id_prov + "&p4=" + g.getUser() +  "&p5=" + "qrcode" + "&p6=" + precio.getText()+ "&p7=" + id_cat;
            StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
                @Override
                public void onResponse(String s) {
                    if(s.equals("1000")){
                       Toast.makeText(getApplicationContext(), "El producto ya existe en el sistema.", Toast.LENGTH_LONG).show();
                     }
                    else if(s.equals("0"))
                    {
                        Toast.makeText(getApplicationContext(), "Producto fue registrado correctamente.", Toast.LENGTH_LONG).show();
                        CleanControl();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Se produjo un error al registrar producto. contacte al administrador del sistema.", Toast.LENGTH_LONG).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
            AppController.getInstance().addToRequestQueue(request, "jreq");
        }
    }

    protected Boolean ValidateProduct(String cod)
    {
        Boolean exist = false;
        return exist;
    }

    private void CleanControl()
    {
        descripcion.setText("");
        codProducto.setText("");
        precio.setText("");
        //spn_categoria;
        //spinner_prov;
    }

    public void AddListeneronButton()
    {
        registrar = (Button) findViewById(R.id.btRegistrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                CreateProduct();
            }
        });


    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {

                contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
                Log.i("App", "Scan unsuccessful");
            }
        }
    }

    public void GetAllCategory()
    {

        String url = singleton.getIp() + "InventoryRest/rs/service/getAllCategory";
        listCategory = new  ArrayList<>();
        JsonArrayRequest jreq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if(response.length() > 0)
                        {
                             for(int i=0;i<response.length();i++)
                            {
                                try {
                                    JSONObject c = response.getJSONObject(i);
                                    int id = Integer.parseInt(c.getString("id").toString());
                                    String cat =  c.getString("categoria");
                                    lista.add(new CategoriaDTO(id,cat));
                                    spn_categoria = (Spinner) findViewById(R.id.spn_categoria);

                                    ArrayAdapter<CategoriaDTO> adapter =
                                            new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, lista);
                                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                                    spn_categoria.setAdapter(adapter);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        AppController.getInstance().addToRequestQueue(jreq, "jreq");
    }

    public void GetAllProviders()
    {
        String url = singleton.getIp() + "InventoryRest/rs/service/getAllProvider";
        listCategory = new  ArrayList<>();
        JsonArrayRequest jreq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if(response.length() > 0)
                        {
                            for(int i=0;i<response.length();i++)
                            {
                                try {
                                    JSONObject c = response.getJSONObject(i);
                                    int id = Integer.parseInt(c.getString("id").toString());
                                    String prov =  c.getString("proveedor");
                                    listProv.add(new ProveedorDTO(id,prov));
                                    spinner_prov = (Spinner) findViewById(R.id.spinner_prov);

                                    ArrayAdapter<ProveedorDTO> adapter =
                                            new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, listProv);
                                    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                                    spinner_prov.setAdapter(adapter);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        AppController.getInstance().addToRequestQueue(jreq, "jreq");
    }
}
