package DatabaseHelper;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hernan on 22-05-16.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "/sdcard/InventoryAndroid.sqlite";

    private static String SQL_CREATE_ALMACEN = "CREATE TABLE almacen (\n" +
            "    id_almacen INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    almacen    TEXT);";


    private static final String SQL_CREATE_PRODUCTO =
            "CREATE TABLE producto (\n" +
                    "     id             INTEGER    PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                    "    cod_produto    TEXT       ,\n" +
                    "    nombre         TEXT       ,\n" +
                    "    stock          INTEGER    NOT NULL,\n" +
                    "    proveedor_id   TEXT,\n" +
                    "    estado         INTEGER,\n" +
                    "    fecha_creacion TEXT,\n" +
                    "    usu_creacion   TEXT,\n" +
                    "    almacen_id     INTEGER,\n" +
                    "    ubicacion_id   INTEGER,\n" +
                    "    qr_cod         TEXT (100),\n" +
                    "    medida_id      INTEGER,\n" +
                    "    categoria_id   INTEGER  \n" +
                    ");";
    private static final String SQL_CREATE_PROVEEDOR =
            "CREATE TABLE proveedor (\n" +
                    "    id        INTEGER      PRIMARY KEY AUTOINCREMENT,\n" +
                    "    proveedor TEXT (40, 0) \n" +
                    ");";

    private static final String SQL_CREATE_CATEGORIA = "CREATE TABLE categoria (\n" +
            "    id_categoria INTEGER    PRIMARY KEY AUTOINCREMENT,\n" +
            "    categoria    TEXT (100) \n" +
            ");";

    private static String SQL_CREATE_UMEDIDA = "CREATE TABLE unidad_medida (\n" +
            "    id_unidad   INTEGER    PRIMARY KEY AUTOINCREMENT,\n" +
            "    descripcion TEXT (100) \n" +
            ");\n";

    private static String SQL_CREATE_INVENTARIO = "CREATE TABLE inventario (\n" +
            "                id_inventario INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
            "                inventario    TEXT, \n" +
            "                fecha         TEXT, \n" +
            "                estado        TEXT);";

    private static String SQL_CREATE_QR_IMAGEN = "CREATE TABLE qr_imagen (\n" +
            "    cod_prod TEXT (30) ,\n" +
            "    ruta     TEXT (300),\n" +
            "    qr_data  TEXT (200) \n" +
            ");\n";

   // private static String SQL_CREATE_ALMACEN = "CREATE TABLE almacen (\n" +
     //       "    id_almacen INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
       //     "    almacen    TEXT);";


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS producto";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL(SQL_CREATE_PRODUCTO);
        //db.execSQL(SQL_CREATE_PROVEEDOR);
        //db.execSQL(SQL_CREATE_CATEGORIA);
       // db.execSQL(SQL_CREATE_UMEDIDA);
       // db.execSQL(SQL_CREATE_INVENTARIO);
        //db.execSQL(SQL_CREATE_QR_IMAGEN);
        db.execSQL(SQL_CREATE_ALMACEN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int DATABASE_VERSION) {
        db.execSQL(SQL_DELETE_ENTRIES);

        onCreate(db);
    }

}
