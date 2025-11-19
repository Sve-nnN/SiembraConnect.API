package com.upc.siembraconnect.Producto;

import com.upc.siembraconnect.Producto.application.ProductoService;
import com.upc.siembraconnect.Producto.domain.Product;
import com.upc.siembraconnect.Producto.dto.ProductoRequest;
import com.upc.siembraconnect.Producto.dto.ProductoResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductoResponse> listar() {
        return service.listar().stream().map(com.upc.siembraconnect.Producto.transformer.ProductoMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductoResponse obtener(@PathVariable String id) {
        try {
            Product p = service.obtener(UUID.fromString(id));
            return com.upc.siembraconnect.Producto.transformer.ProductoMapper.toResponse(p);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<ProductoResponse> crear(@RequestBody ProductoRequest req) {
        Product domain = com.upc.siembraconnect.Producto.transformer.ProductoMapper.toDomain(req);
        Product saved = service.crear(domain);
        ProductoResponse resp = com.upc.siembraconnect.Producto.transformer.ProductoMapper.toResponse(saved);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saved.getId().toString()).toUri();
        return ResponseEntity.created(location).body(resp);
    }

    @PutMapping("/{id}")
    public ProductoResponse actualizar(@PathVariable String id, @RequestBody ProductoRequest req) {
        try {
            Product existing = service.obtener(UUID.fromString(id));
            com.upc.siembraconnect.Producto.transformer.ProductoMapper.updateDomain(existing, req);
            Product saved = service.actualizar(existing.getId(), existing);
            return com.upc.siembraconnect.Producto.transformer.ProductoMapper.toResponse(saved);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable String id) {
        try {
            service.eliminar(UUID.fromString(id));
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }
    }
}