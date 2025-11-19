package com.upc.siembraconnect.Producto.dto;

public class ProductoRequest {
    private String nombre;
    private String productor;
    private String region;

    public ProductoRequest() {}

    public ProductoRequest(String nombre, String productor, String region) {
        this.nombre = nombre;
        this.productor = productor;
        this.region = region;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}

