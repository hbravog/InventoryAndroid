package layout.InventoryAndWarhouse.Location;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.thesis.inventory.inventoryandroid.R;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;
import Generics.Globals;
import adapter.LocationAdapter;
import dto.LocationDTO;
import services.AppController;

public class LocationView  extends AppCompatActivity
{
    Globals globals = new Globals();
    private RecyclerView reyclerViewLocation;
    private RecyclerView.Adapter mAdapter;
    private Toolbar tlb;
    List<LocationDTO> listLocation = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_location_view);


        tlb = (Toolbar) findViewById(R.id.toolblar_location);
        setSupportActionBar(tlb);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        reyclerViewLocation = (RecyclerView) findViewById(R.id.reyclerViewLocation);
        reyclerViewLocation.setHasFixedSize(true);
        reyclerViewLocation.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new LocationAdapter(GetAllLocation());
        reyclerViewLocation.setAdapter(mAdapter);
    }


    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_new:
                Intent intent = new Intent(this,LocationAdd.class);
                this.startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public List<LocationDTO> GetAllLocation()
    {
        String url = globals.getIp() + "InventoryRest/rs/service/getAllLocation";
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
                                    listLocation.add(new LocationDTO(Integer.parseInt(response.getJSONObject(i).get("id").toString()),
                                            response.getJSONObject(i).get("location").toString(),
                                            Integer.parseInt(response.getJSONObject(i).get("warehouse").toString())));
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
        return listLocation;
    }
}
