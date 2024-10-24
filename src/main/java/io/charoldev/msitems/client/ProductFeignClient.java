package io.charoldev.msitems.client;

import io.charoldev.msitems.model.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-products")
public interface ProductFeignClient {

    @GetMapping("/api/products")
    List<ProductDto> findAll();

    @GetMapping("/api/products/{id}")
    ProductDto details(@PathVariable Long id);
}
