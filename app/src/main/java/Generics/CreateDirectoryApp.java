package Generics;

import android.os.Environment;

import java.io.File;

/**
 * Created by Hernan on 05-07-16.
 */
public class CreateDirectoryApp {

    public static void CreateDirectory()
    {
        boolean success = false;
        File folder = new File(Environment.getExternalStorageDirectory() + "/qrimage/pinturas/");
        success = false;
        if (!folder.exists()) {
            success = folder.mkdirs();
        }
        if (!success) {
        } else {
        }


        File folder2 = new File(Environment.getExternalStorageDirectory() + "/qrimage/Accesorios/");
        success = false;
        if (!folder2.exists()) {
            success = folder2.mkdirs();
        }
    }

}
