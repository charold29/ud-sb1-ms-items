package io.charoldev.msitems.service;

import feign.FeignException;
import io.charoldev.msitems.client.ProductFeignClient;
import io.charoldev.msitems.model.ItemDto;
import io.charoldev.msitems.model.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceFeign implements IItemService {

    private final ProductFeignClient client;

    @Override
    public List<ItemDto> findAll() {
        return client.findAll()
                .stream()
                .map((ProductDto product) -> {
                    Integer quantity = (int) (Math.random() * 10) + 1;
                    return new ItemDto(
                            product,
                            quantity,
                            product.getPrice() * quantity
                    );
                }).collect(Collectors.toList());
    }

    @Override
    public Optional<ItemDto> findById(Long id) {
        try{
            ProductDto product = client.details(id);
            return Optional.of(new ItemDto(product, 1, product.getPrice()));
        } catch (FeignException e){
            return Optional.empty();
        }
    }
}
