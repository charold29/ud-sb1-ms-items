package io.charoldev.msitems.client;

import io.charoldev.msitems.model.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8001/api/products", name = "ms-products")
public interface ProductFeignClient {

    @GetMapping
    List<ProductDto> findAll();

    @GetMapping("/{id}")
    ProductDto details(@PathVariable Long id);
}
