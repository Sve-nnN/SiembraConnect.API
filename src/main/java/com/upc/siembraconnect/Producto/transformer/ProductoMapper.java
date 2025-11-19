package com.upc.siembraconnect.Producto.transformer;

import com.upc.siembraconnect.Producto.domain.Product;
import com.upc.siembraconnect.Producto.dto.ProductoRequest;
import com.upc.siembraconnect.Producto.dto.ProductoResponse;

public final class ProductoMapper {

    private ProductoMapper() {}

    public static Product toDomain(ProductoRequest req) {
        if (req == null) return null;
        return new Product(null, req.getNombre(), req.getProductor(), req.getRegion());
    }

    public static ProductoResponse toResponse(Product p) {
        if (p == null) return null;
        return new ProductoResponse(
                p.getId() == null ? null : p.getId().toString(),
                p.getNombre(),
                p.getProductor(),
                p.getRegion()
        );
    }

    public static void updateDomain(Product target, ProductoRequest req) {
        if (target == null || req == null) return;
        target.setNombre(req.getNombre());
        target.setProductor(req.getProductor());
        target.setRegion(req.getRegion());
    }
}

