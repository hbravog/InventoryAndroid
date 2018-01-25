package layout.inventory;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.thesis.inventory.inventoryandroid.R;

public class QRtest extends AppCompatActivity {
    private ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrtest);

        imagen = (ImageView) findViewById(R.id.img);
        Bitmap bitmap = getIntent().getParcelableExtra("plc");
        imagen.setImageBitmap(bitmap);


    }

}
