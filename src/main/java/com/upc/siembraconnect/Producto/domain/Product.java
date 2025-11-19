package com.upc.siembraconnect.Producto.domain;

import java.util.UUID;

public class Product {
    private UUID id;
    private String nombre;
    private String productor;
    private String region;

    public Product() {}

    public Product(UUID id, String nombre, String productor, String region) {
        this.id = id;
        this.nombre = nombre;
        this.productor = productor;
        this.region = region;
    }

    public static Product create(String nombre, String productor, String region) {
        return new Product(UUID.randomUUID(), nombre, productor, region);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

