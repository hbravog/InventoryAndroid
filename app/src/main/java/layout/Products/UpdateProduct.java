package layout.Products;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import com.thesis.inventory.inventoryandroid.R;

public class UpdateProduct extends AppCompatActivity {

    private EditText codProducto;
    private EditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_update_product);

        String cod_prod = "";
        Intent intent = getIntent();
        if(intent.hasExtra("cod_prod"))
        {
            cod_prod = getIntent().getExtras().get("cod_prod").toString();
        }
        //LoadProduct(cod_prod);

    }
/*

    protected void LoadProduct(String cod)
    {
        ProductoDAL productoDAL = new ProductoDAL(this);
        ProductoDTO dto = new ProductoDTO();
        dto = productoDAL.ProductByCod(cod);
        if(dto != null)
        {
            codProducto.setText(dto.getCod_produto());
            descripcion.setText(dto.getNombre());
        }
    }
    */
}
