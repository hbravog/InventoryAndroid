package layout.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import com.thesis.inventory.inventoryandroid.R;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.List;

import dal.InventoryDAL;
import dto.InventoryDTO;


public class InventoryList extends AppCompatActivity {

    String[] datos2;
    GridView gridView;
    List<String> list = new ArrayList<String>();
    InventoryDAL dal = new InventoryDAL(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_list);
      //  gridView = (GridView) findViewById(R.id.grdEmp);

        Intent intent = getIntent();
        String jsonArray = intent.getStringExtra("jsonArrayInventory");
        try {
            JSONArray array = new JSONArray(jsonArray);
            for (int i=0; i<array.length(); i++) {


                list.add(array.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
            dal.AddInventory(list);
      //  LoadGridInventory(list);
    }


    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        //dbHelp=new DatabaseHelper(this);
        //LoadGridInventory(list);
    }

/*
    private void LoadGridInventory(List lista) {
        //InventoryDAL inventory = new InventoryDAL(this);
        //List lista = inventory.GetAllInventoryActive();
        datos2 = new String[lista.size() * 2];
        int contador = 0;
        for (Object var : lista) {
            InventoryDTO elementos = (InventoryDTO) var;
            datos2[contador] = elementos.getInventario();
            datos2[contador + 1] = elementos.getFecha();
            contador += 2;
        }
        for (int a = 0; a < datos2.length; a++) {
            if (datos2[a] == null) {
                datos2[a] = "-";
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos2);
            gridView.setAdapter(adapter);

        }
    }
    */
}
