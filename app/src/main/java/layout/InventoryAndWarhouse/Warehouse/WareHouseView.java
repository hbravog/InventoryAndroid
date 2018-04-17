package layout.InventoryAndWarhouse.Warehouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.thesis.inventory.inventoryandroid.R;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;
import Generics.Globals;
import adapter.WareHouseAdapter;
import dto.AlmacenDTO;
import services.AppController;

public class WareHouseView extends AppCompatActivity {

    private RecyclerView reyclerViewWareHouse;
    private RecyclerView.Adapter mAdapter;
    Globals globals = new Globals();
    List<AlmacenDTO> listProduct;
    List<AlmacenDTO> listWareHouse = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_warehouse_view);

        reyclerViewWareHouse = (RecyclerView) findViewById(R.id.reyclerViewWareHouse);
        reyclerViewWareHouse.setHasFixedSize(true);
        reyclerViewWareHouse.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new WareHouseAdapter(GetAllWareHouse());
        reyclerViewWareHouse.setAdapter(mAdapter);
    }

    public List<AlmacenDTO> GetAllWareHouse()
    {
        String url = globals.getIp() + "InventoryRest/rs/service/getAllWarehouse";
        listProduct = new  ArrayList<>();
        JsonArrayRequest jreq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        if(response.length() > 0)
                        {
                            for(int i =0;i < response.length();i++)
                            {
                                try
                                {
                                    listWareHouse.add(new AlmacenDTO(Integer.parseInt(response.getJSONObject(i).get("id").toString()),response.getJSONObject(i).get("warehouse").toString()));
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
        return listWareHouse;
    }
}
