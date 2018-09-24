package Generics;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hernanbravo on 20-08-18.
 */

public class ApplicationSharedPreference
{

    protected final static int DEFAULT = 0;
    static String temp = "";

    public static String readSharedPreference(Context context, String spName, String host){
        SharedPreferences sharedPreferences = context.getSharedPreferences(spName, Context.MODE_PRIVATE);


        return temp = sharedPreferences.getString("name", String.valueOf(DEFAULT));
    }

    public static void writeSharedPreference(Context context,String spName,String host ){

        SharedPreferences sharedPreferences = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", host);
        editor.commit();
    }

}
