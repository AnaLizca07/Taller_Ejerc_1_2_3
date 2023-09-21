package ejercicio5.dto;

import java.io.Serializable;

public class CarritoDTO implements Serializable {
    private Integer id;
    private String nombreProducto;
    private double precio;
    private double cantidad;


    public CarritoDTO(Integer id, String nombreProducto, double precio, double cantidad) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "CarritoDTO{" +
                "id=" + id +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
