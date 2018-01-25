package dto;

/**
 * Created by Hernan on 10-06-16.
 */
public class ProductoDTO
{
    private String cod_produto;
    private String nombre;
    private String stock;
    private String proveedor_id;
    private String estado;
    private String fecha_creacion;
    private String usu_creacion;
    private int almacen_id;
    private int ubicacion_id;
    private String qr_cod;

    public ProductoDTO()
    {

    }

    public ProductoDTO(String cod_produto, String nombre, String stock, String proveedor_id, String estado, String fecha_creacion, String usu_creacion, int almacen_id, int ubicacion_id, String qrCod, String qr_cod)
    {
        this.cod_produto = cod_produto;
        this.nombre = nombre;
        this.stock = stock;
        this.proveedor_id = proveedor_id;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
        this.usu_creacion = usu_creacion;
        this.almacen_id = almacen_id;
        this.ubicacion_id = ubicacion_id;
        this.qr_cod = qr_cod;
    }

    public String getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(String cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(String proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getUsu_creacion() {
        return usu_creacion;
    }

    public void setUsu_creacion(String usu_creacion) {
        this.usu_creacion = usu_creacion;
    }

    public int getAlmacen_id() {
        return almacen_id;
    }

    public void setAlmacen_id(int almacen_id) {
        this.almacen_id = almacen_id;
    }

    public int getUbicacion_id() {
        return ubicacion_id;
    }

    public void setUbicacion_id(int ubicacion_id) {
        this.ubicacion_id = ubicacion_id;
    }

    public String getQr_cod() {
        return qr_cod;
    }

    public void setQr_cod(String qr_cod) {
        this.qr_cod = qr_cod;
    }
}
