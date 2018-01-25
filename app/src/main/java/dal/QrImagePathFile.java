package dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import DatabaseHelper.DBHelper;


/**
 * Created by Hernan on 06-07-16.
 */
public class QrImagePathFile
{
    DBHelper db;
    private Context context;
    public  boolean AddPath(String path,String cod,String data,Context context)
    {
        db = new DBHelper(context);
        SQLiteDatabase sqlite = db.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("cod_prod",cod);
        content.put("ruta",path+"/"+cod+".png");
        content.put("qr_data",data);
        long rowInserted = sqlite.insert("qr_imagen", null, content);

        if(rowInserted != -1)
        {
            return true;
        }
        else
        {
            return  false;
        }
    }
}
