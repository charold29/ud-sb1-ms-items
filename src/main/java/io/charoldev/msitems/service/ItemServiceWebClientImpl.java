package io.charoldev.msitems.service;

import io.charoldev.msitems.model.ItemDto;
import io.charoldev.msitems.model.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
public class ItemServiceWebClientImpl implements IItemService{

    private final WebClient.Builder webClient;

    @Override
    public List<ItemDto> findAll() {
        return webClient.build()
                .get()
                .retrieve()
                .bodyToFlux(ProductDto.class)
                .map((ProductDto product) -> {
                    Integer quantity = (int) (Math.random() * 10) + 1;
                    return new ItemDto(product, quantity, product.getPrice() * quantity);
                })
                .collectList()
                .block();
    }

    @Override
    public Optional<ItemDto> findById(Long id) {
        return webClient.build()
                .get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(ProductDto.class)
                .map((ProductDto product) -> new ItemDto(product, 1, product.getPrice()))
                .blockOptional();
    }
}
