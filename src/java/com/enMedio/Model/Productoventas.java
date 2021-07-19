package com.enMedio.Model;
// Generated 18/07/2021 09:58:52 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Productoventas generated by hbm2java
 */
@Entity
@Table(name="productoventas"
    ,catalog="pruebaenmedio"
)
public class Productoventas  implements java.io.Serializable {


     private int id;
     private Productos productos;
     private Ventas ventas;
     private Integer idProducto;
     private Long monto;
     private Long iva;
     private Long descuento;
     private int cantidad;

    public Productoventas() {
    }

	
    public Productoventas(int id, Productos productos, Ventas ventas, int cantidad) {
        this.id = id;
        this.productos = productos;
        this.ventas = ventas;
        this.cantidad = cantidad;
    }
    public Productoventas(int id, Productos productos, Ventas ventas, Integer idProducto, Long monto, Long iva, Long descuento, int cantidad) {
       this.id = id;
       this.productos = productos;
       this.ventas = ventas;
       this.idProducto = idProducto;
       this.monto = monto;
       this.iva = iva;
       this.descuento = descuento;
       this.cantidad = cantidad;
    }
   
     @Id 
@GeneratedValue(strategy = IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productos_id", nullable=false)
    public Productos getProductos() {
        return this.productos;
    }
    
    public void setProductos(Productos productos) {
        this.productos = productos;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ventas_id", nullable=false)
    public Ventas getVentas() {
        return this.ventas;
    }
    
    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    
    @Column(name="idProducto")
    public Integer getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    
    @Column(name="monto", precision=11, scale=0)
    public Long getMonto() {
        return this.monto;
    }
    
    public void setMonto(Long monto) {
        this.monto = monto;
    }

    
    @Column(name="iva", precision=11, scale=0)
    public Long getIva() {
        return this.iva;
    }
    
    public void setIva(Long iva) {
        this.iva = iva;
    }

    
    @Column(name="descuento", precision=11, scale=0)
    public Long getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(Long descuento) {
        this.descuento = descuento;
    }

    
    @Column(name="cantidad", nullable=false)
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




}

