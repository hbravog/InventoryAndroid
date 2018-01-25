package services;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Util.Singleton;

/**
 * Created by Hernan on 12-10-16.
 */
public class ProductServices
{

    String resp = "";
    Singleton singleton = new Singleton();
    public String GetAllProductList()
    {

        String url = singleton.getIp() + "InventoryRest/rs/service/getAllProduct";
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


                            Singleton g = Singleton.getInstance();
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
