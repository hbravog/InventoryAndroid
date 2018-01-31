package Generics;

import android.graphics.Bitmap;
import android.os.Environment;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Hernan on 04-07-16.
 */
public class QrCodeHelper
{
    public static void GenerateQR(String code,String ruta)
    {
        MultiFormatWriter multiformater = new MultiFormatWriter();
        try {
            BitMatrix bitmatrix = multiformater.encode(code, BarcodeFormat.QR_CODE,100,100);
            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(bitmatrix);
            String filename = code + ".png";
            File sd = Environment.getExternalStorageDirectory();

            //File dest = new File(sd + "/qrimage/" , filename);
            File dest = new File(sd,filename);
            try {
                FileOutputStream out = new FileOutputStream(dest);
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
