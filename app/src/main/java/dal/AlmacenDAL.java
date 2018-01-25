package dal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import DatabaseHelper.DBHelper;
import dto.AlmacenDTO;
import dto.CategoriaDTO;

/**
 * Created by Hernan on 11-07-16.
 */
public class AlmacenDAL
{
    private Context context;
    DBHelper db;

    public AlmacenDAL(Context context)
    {
        this.context = context;
    }

    public List<AlmacenDTO> GetAlamcen(Context context) {
        db = new DBHelper(context.getApplicationContext());
        SQLiteDatabase sqlite = db.getWritableDatabase();

        List<AlmacenDTO> lista = new ArrayList<AlmacenDTO>();
        String[] valores_recuperar = {"id_almacen", "almacen"};
        Cursor c = sqlite.query("almacen", valores_recuperar,
                null, null, null, null, null);
        c.moveToFirst();
        do {
            AlmacenDTO categoria = new AlmacenDTO(Integer.parseInt(c.getString(0)), c.getString(1));
            lista.add(categoria);
        } while (c.moveToNext());
        sqlite.close();
        c.close();
        return lista;
    }
}
