package dto;

/**
 * Created by Hernan on 01-06-16.
 */
public class ProveedorDTO {

    private int id;
    private String proveedor;

    public  ProveedorDTO(int _id, String prov)
    {
        id = _id;
        proveedor = prov;
    }

    @Override
    public String toString()
    {
        return proveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
}
