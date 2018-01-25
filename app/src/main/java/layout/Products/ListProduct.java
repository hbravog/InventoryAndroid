package layout.Products;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.thesis.inventory.inventoryandroid.R;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import Util.Singleton;
import dto.ProductoDTO;
import services.AppController;

public class ListProduct extends AppCompatActivity {

    Singleton singleton = new Singleton();
    List<ProductoDTO> listProduct;
    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        list = (ListView) findViewById(R.id.listview);
        this.GetAllProductList();
        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
    }

    // Not using options menu in this tutorial
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void GetAllProductList()
    {
        String url = singleton.getIp() + "InventoryRest/rs/service/getAllProduct";
        listProduct = new  ArrayList<>();
        JsonArrayRequest jreq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if(response.length() > 0)
                        {
                            try
                            {
                                // Pass results to ListViewAdapter Class
                                adapter = new ListViewAdapter(getApplicationContext(), TransnformDTO(response));
                                // Binds the Adapter to the ListView
                                list.setAdapter(adapter);
                            } catch (JSONException e) {
                                e.printStackTrace();
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

    public List<ProductoDTO> TransnformDTO(JSONArray jArray) throws JSONException
    {
        List<ProductoDTO> listdata = new ArrayList<ProductoDTO>();
        ProductoDTO dto;
        if (jArray != null)
        {
            for (int i=0;i<jArray.length();i++)
            {
                dto = new ProductoDTO();
                dto.setStock(jArray.optJSONObject(i).get("stock").toString());
                dto.setNombre(jArray.optJSONObject(i).get("nombre").toString());
                dto.setCod_produto(jArray.optJSONObject(i).get("cod_produto").toString());
                listdata.add(dto);
            }
        }
        return listdata;
    }
}
