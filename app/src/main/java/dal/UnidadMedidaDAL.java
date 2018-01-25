package dal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import DatabaseHelper.DBHelper;
import dto.UnidadMedidaDTO;

/**
 * Created by Hernan on 08-06-16.
 */
public class UnidadMedidaDAL {
    private Context context;
    DBHelper db;

    public UnidadMedidaDAL(Context context)
    {
        this.context = context;
    }

    public List<UnidadMedidaDTO> GetUnidadMedida(Context context) {
        db = new DBHelper(context.getApplicationContext());
        SQLiteDatabase sqlite = db.getWritableDatabase();

        List<UnidadMedidaDTO> lista = new ArrayList<UnidadMedidaDTO>();
        String[] valores_recuperar = {"id_unidad", "descripcion"};
        Cursor c = sqlite.query("unidad_medida", valores_recuperar,
                null, null, null, null, null);
        c.moveToFirst();
        do {
            UnidadMedidaDTO proveedor = new UnidadMedidaDTO(c.getString(0), c.getString(1));
            lista.add(proveedor);
        } while (c.moveToNext());
        sqlite.close();
        c.close();
        return lista;
    }
}
