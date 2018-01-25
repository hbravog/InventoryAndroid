package dto;

/**
 * Created by Hernan on 11-07-16.
 */
public class AlmacenDTO
{
    private int id_almacen;
    private  String almacen;

    public  AlmacenDTO(int _id, String _almacen)
    {
        id_almacen = _id;
        almacen = _almacen;
    }

    @Override
    public String toString()
    {
        return almacen;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }
}
