package dal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import DatabaseHelper.DBHelper;
import dto.ProveedorDTO;

/**
 * Created by Hernan on 01-06-16.
 */
public class ProveedorDAL
{
    private Context context;
    DBHelper db;

    public ProveedorDAL(Context context)
    {
        this.context = context;
    }
/*
    public List<ProveedorDTO> GetProveedores(Context context) {
        db = new DBHelper(context.getApplicationContext());
        SQLiteDatabase sqlite = db.getWritableDatabase();

        List<ProveedorDTO> lista = new ArrayList<ProveedorDTO>();
        String[] valores_recuperar = {"id", "proveedor"};
        Cursor c = sqlite.query("proveedor", valores_recuperar,
                null, null, null, null, null);
        c.moveToFirst();
        do {
            ProveedorDTO proveedor = new ProveedorDTO(c.getString(0), c.getString(1));
            lista.add(proveedor);
        } while (c.moveToNext());
        sqlite.close();
        c.close();
        return lista;
    }
    */
}
