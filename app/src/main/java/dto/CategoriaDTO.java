package dto;

/**
 * Created by Hernan on 08-06-16.
 */
public class CategoriaDTO {
    private int id;
    private String categoria;

    public  CategoriaDTO()
    {

    }

    public  CategoriaDTO(int _id, String desc)
    {
        id = _id;
        categoria = desc;
    }

    @Override
    public String toString()
    {
        return categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return categoria;
    }

    public void setDescripcion(String descripcion) {
        this.categoria = descripcion;
    }

}
