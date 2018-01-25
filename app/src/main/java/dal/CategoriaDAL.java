package dal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import DatabaseHelper.DBHelper;
import dto.CategoriaDTO;


/**
 * Created by Hernan on 08-06-16.
 */
public class CategoriaDAL
{
    private Context context;
    DBHelper db;

    public CategoriaDAL(Context context)
    {
        this.context = context;
    }

    public List<CategoriaDTO> GetCategorias(Context context) {
        db = new DBHelper(context.getApplicationContext());
        SQLiteDatabase sqlite = db.getWritableDatabase();

        List<CategoriaDTO> lista = new ArrayList<CategoriaDTO>();
        String[] valores_recuperar = {"id_categoria", "categoria"};
        Cursor c = sqlite.query("categoria", valores_recuperar,
                null, null, null, null, null);
        c.moveToFirst();
        do {
            CategoriaDTO categoria = new CategoriaDTO(Integer.parseInt(c.getString(0)), c.getString(1));
            lista.add(categoria);
        } while (c.moveToNext());
        sqlite.close();
        c.close();
        return lista;
    }
}
