package dal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;
import DatabaseHelper.DBHelper;
import dto.CategoriaDTO;
import dto.ProductoDTO;

/**
 * Created by Hernan on 09-06-16.
 */
public class ProductoDAL
{
    private Context context;
    DBHelper db;

    public ProductoDAL(Context context)
    {
        this.context = context;
    }


/*
    public List<ProductoDTO> GetAllProduct(Context context) {
        db = new DBHelper(context.getApplicationContext());
        SQLiteDatabase sqlite = db.getWritableDatabase();

        List<ProductoDTO> lista = new ArrayList<ProductoDTO>();
        String[] valores_recuperar = {"cod_produto", "nombre","stock"};
        Cursor c = sqlite.query("producto", valores_recuperar,
                null, null, null, null, null);
        c.moveToFirst();
        do {
            ProductoDTO producto = new ProductoDTO();
            producto.setCod_produto(c.getString(0));
            producto.setNombre(c.getString(1));
            producto.setStock(c.getString(2));
            lista.add(producto);
        } while (c.moveToNext());
        sqlite.close();
        c.close();
        return lista;
    }*/
/*
    public ArrayList<ProductoDTO>  GetAllProduct(Context context) {
        db = new DBHelper(context.getApplicationContext());
        SQLiteDatabase sqlite = db.getWritableDatabase();

        ArrayList<ProductoDTO> lista = new ArrayList<ProductoDTO>();
        String[] valores_recuperar = {"cod_produto", "nombre"};
        Cursor c = sqlite.query("producto", valores_recuperar,
                null, null, null, null, null);
        c.moveToFirst();
        do {
            ProductoDTO categoria = new ProductoDTO();
            categoria.setCod_produto("prueba");
            categoria.setNombre("nombre");
            lista.add(categoria);
        } while (c.moveToNext());
        sqlite.close();
        c.close();
        return lista;
    }

    // Select All Data
    public Cursor GetAllProduct() {
        try {
            db = new DBHelper(context.getApplicationContext());
            SQLiteDatabase sqlite = db.getWritableDatabase();

            String strSQL = "SELECT cod_produto as _id,nombre FROM producto" ;
            Cursor cursor = sqlite.rawQuery(strSQL, null);

            return cursor;

        } catch (Exception e) {
            return null;
        }

    }

    public List GetAllProduct()
    {
        db = new DBHelper(context.getApplicationContext());
        SQLiteDatabase sqlite = db.getWritableDatabase();
        String col [] = {"cod_produto","nombre"};
        Cursor c = db.getReadableDatabase().query("producto",col,null,null,null,null,null);
        List ret = new ArrayList();
        int iId,iNombre;
        iId = c.getColumnIndex("cod_produto");
        iNombre = c.getColumnIndex("nombre");
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            ProductoDTO dto = new ProductoDTO();
            dto.setCod_produto(c.getString(iId));
            dto.setNombre(c.getString(iNombre));
            ret.add(dto);
        }
        return  ret;
    }

    public ProductoDTO ProductByCod(String code)
    {
        ProductoDTO dto;
        ProductoDTO producto = new ProductoDTO();
        db = new DBHelper(context.getApplicationContext());
        SQLiteDatabase sqlite = db.getWritableDatabase();
        String col [] = {"cod_produto","nombre","almacen_id","ubicacion_id"};
        String[] args = new String[] {code};
        Cursor c = db.getReadableDatabase().query("producto",col,"cod_produto=?",args,null,null,null);
        int iId,iNombre,iUbicacion,iAlmacen;
        iId = c.getColumnIndex("cod_produto");
        iNombre = c.getColumnIndex("nombre");
        iUbicacion = c.getColumnIndex("almacen_id");
        iAlmacen = c.getColumnIndex("ubicacion_id");
        while(c.moveToNext())
        {
            dto = new ProductoDTO();
            dto.setCod_produto(c.getString(0));
            dto.setNombre(c.getString(1));
            dto.setUbicacion_id(7);
            dto.setAlmacen_id(8);

            producto = dto;
        }
        c.close();
        return producto;
    }
  */
    public long getMaxID() {
        int id = 0;
        db = new DBHelper(context.getApplicationContext());
        SQLiteDatabase sqlite = db.getWritableDatabase();
        final String MY_QUERY = "SELECT MAX(id) FROM producto";
        final SQLiteStatement stmt = sqlite.compileStatement(MY_QUERY);

        return (int) stmt.simpleQueryForLong();
    }

}
