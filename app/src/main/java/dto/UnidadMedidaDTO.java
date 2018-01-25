package dto;

/**
 * Created by Hernan on 08-06-16.
 */
public class UnidadMedidaDTO {
    private String id;
    private String descripcion;

    public  UnidadMedidaDTO(String _id, String desc)
    {
        id = _id;
        descripcion = desc;
    }

    @Override
    public String toString()
    {
        return descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
