package dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import DatabaseHelper.DBHelper;
import dto.InventoryDTO;


/**
 * Created by Hernan on 03-07-16.
 */
public class InventoryDAL
{
    private Context context;
    DBHelper db;

    public InventoryDAL(Context context)
    {
        this.context = context;
    }

    public List<InventoryDTO> GetAllInventoryActive()
    {
        List<InventoryDTO> lista = new ArrayList<InventoryDTO>();
        db = new DBHelper(context.getApplicationContext());
        SQLiteDatabase sqlite = db.getWritableDatabase();
        String col [] = {"id_inventario","inventario","fecha","estado"};
        Cursor c = db.getReadableDatabase().query("inventario",col,null,null,null,null,null);
        List ret = new ArrayList();
        int iId,iInventario,iFecha,iEstado;
        iId = c.getColumnIndex("id_inventario");
        iInventario = c.getColumnIndex("inventario");
        iFecha = c.getColumnIndex("fecha");
        iEstado = c.getColumnIndex("estado");
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            InventoryDTO dto = new InventoryDTO();
            dto.setInventario(c.getString(iInventario));
            dto.setId_inventario(Integer.parseInt(c.getString(iId)));
            dto.setEstado(c.getString(iEstado));
            dto.setFecha(c.getString(iFecha));
            dto.setUsuario("hernan");

            ret.add(dto);
        }
        AddInventory(ret);
        return  ret;
    }


    public void AddInventory(List<String> lista)
    {
        InventoryDTO dto;
        for (int i = 0; i < lista.size(); i++) {
            ContentValues values = new ContentValues();
            values.put("inventario", lista.get(i).toString());
            values.put("fecha",lista.get(i).toString());
            values.put("estado",lista.get(i).toString());
            db = new DBHelper(context.getApplicationContext());
            SQLiteDatabase sqlite = db.getWritableDatabase();
            sqlite.insert("inventario",null,values);
        }
    }
    /*
    public void AddInventory(List<InventoryDTO> lista)
    {
        InventoryDTO dto;
        for (int i = 0; i < lista.size(); i++) {
            ContentValues values = new ContentValues();
            values.put("inventario", lista.get(i).getInventario());
            values.put("fecha",lista.get(i).getFecha());
            values.put("estado",lista.get(i).getEstado());
            db = new DBHelper(context.getApplicationContext());
            SQLiteDatabase sqlite = db.getWritableDatabase();
            sqlite.insert("inventario",null,values);
        }
    }*/
}
