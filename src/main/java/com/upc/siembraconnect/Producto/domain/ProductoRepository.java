package com.upc.siembraconnect.Producto.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductoRepository {
    List<Product> findAll();
    Optional<Product> findById(UUID id);
    Product save(Product product);
    void deleteById(UUID id);
}

