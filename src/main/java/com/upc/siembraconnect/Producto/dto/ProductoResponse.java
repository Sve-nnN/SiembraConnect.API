package com.upc.siembraconnect.Producto.dto;

public class ProductoResponse {
    private String id;
    private String nombre;
    private String productor;
    private String region;

    public ProductoResponse() {}

    public ProductoResponse(String id, String nombre, String productor, String region) {
        this.id = id;
        this.nombre = nombre;
        this.productor = productor;
        this.region = region;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProductor() {
        return productor;
    }

    public String getRegion() {
        return region;
    }
}

