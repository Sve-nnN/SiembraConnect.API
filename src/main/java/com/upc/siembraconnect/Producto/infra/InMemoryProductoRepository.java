package com.upc.siembraconnect.Producto.infra;

import com.upc.siembraconnect.Producto.domain.Product;
import com.upc.siembraconnect.Producto.domain.ProductoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryProductoRepository implements ProductoRepository {

    private final Map<UUID, Product> store = new ConcurrentHashMap<>();

    public InMemoryProductoRepository() {
        initSample();
    }

    private void initSample() {
        Product p1 = new Product(UUID.randomUUID(), "Papa Canchán", "Juan Pérez", "Junín");
        Product p2 = new Product(UUID.randomUUID(), "Palta Hass", "Agricola Virú", "La Libertad");
        Product p3 = new Product(UUID.randomUUID(), "Café Orgánico", "Coop. Villa Rica", "Pasco");
        save(p1); save(p2); save(p3);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(UUID.randomUUID());
        }
        store.put(product.getId(), product);
        return product;
    }

    @Override
    public void deleteById(UUID id) {
        store.remove(id);
    }
}
