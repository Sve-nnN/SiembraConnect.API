package com.upc.siembraconnect.config;

import com.upc.siembraconnect.Producto.domain.ProductoRepository;
import com.upc.siembraconnect.Producto.infra.InMemoryProductoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RepositoryConfig {

    @Bean
    @Primary
    public ProductoRepository productoRepository() {
        return new InMemoryProductoRepository();
    }
}
