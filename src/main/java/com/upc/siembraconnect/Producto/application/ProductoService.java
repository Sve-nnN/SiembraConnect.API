package com.upc.siembraconnect.Producto.application;

import com.upc.siembraconnect.Producto.domain.Product;
import com.upc.siembraconnect.Producto.domain.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    @Autowired
    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Product> listar() {
        return repository.findAll();
    }

    public Product obtener(UUID id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));
    }

    public Product crear(Product product) {
        // id se genera en repo si es null
        return repository.save(product);
    }

    public Product actualizar(UUID id, Product updated) {
        Product existing = obtener(id);
        // mantener el id
        updated.setId(existing.getId());
        return repository.save(updated);
    }

    public void eliminar(UUID id) {
        // valida existencia
        obtener(id);
        repository.deleteById(id);
    }
}
