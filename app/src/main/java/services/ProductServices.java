package services;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Generics.Globals;

/**
 * Created by Hernan on 12-10-16.
 */
public class ProductServices
{

    String resp = "";
    Globals globals = new Globals();
    public String GetAllProductList()
    {

        String url = globals.getIp() + "InventoryRest/rs/service/getAllProduct";
        JsonArrayRequest jreq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if(response.length() > 0)
                        {
                            try {
                                JSONObject jo = response.getJSONObject(1);
                                resp = jo.getString("name");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                            Globals g = Globals.getInstance();
                            g.setUser("Hernan");


                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        return resp;
    }

}
