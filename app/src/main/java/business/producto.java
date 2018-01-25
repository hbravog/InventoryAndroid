package business;

import android.content.Context;

import dal.ProductoDAL;

/**
 * Created by Hernan on 06-07-16.
 */
public class producto
{
    //  autonum  + cod proveedor + 3 primeras letras categorias

    public static String GenerateCodeProduct(String codProv,Integer cat,Context context)
    {

        ProductoDAL productoDAL = new ProductoDAL(context.getApplicationContext());
        Long max = productoDAL.getMaxID();


        String code = max + codProv + cat.toString();

        return code;
    }
}
