package mx.unam.aragon.ico.is.cochesapi.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "coches")
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clave;

    @Column(name = "marca_coche", nullable = false, length = 100)
    @NotBlank(message = "El campo no debe de estar en blnco")
    @NotNull(message = "el campo debe de tener algo")
    private String marca;

    @Column (name = "modelo_coche", columnDefinition = "VARCHAR(100) not null")
    @NotBlank(message = "El campo no debe de estar en blnco")
    @NotNull(message = "el campo debe de tener algo")
    private String modelo;

    @Column(name = "color_coche", nullable = true, insertable = true,
            columnDefinition = "VARCHAR(100) DEFAULT 'gris'")
    private String color;

    @Column (name = "precio_coche", nullable = true)
    private Float precio;

    @Column (name = "url_foto", nullable = true, insertable = false,
            columnDefinition = "VARCHAR(500) DEFAULT 'https://cdn1.iconfinder.com/data/icons/image-manipulations/100/13-512.png'")
    private String foto;

    @Override
    public String toString() {
        return "Coche{" +
                "clave=" + clave +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", foto='" + foto + '\'' +
                '}';
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Coche(Integer clave, String marca, String modelo, String color, Float precio, String foto) {
        this.clave = clave;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.foto = foto;
    }

    public Coche() {
    }
}
