package io.charoldev.msitems.service;

import io.charoldev.msitems.client.ProductFeignClient;
import io.charoldev.msitems.model.ItemDto;
import io.charoldev.msitems.model.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements IItemService {

    private final ProductFeignClient client;

    @Override
    public List<ItemDto> findAll() {
        return client.findAll()
                .stream()
                .map((ProductDto product) -> {
                    Random random = new Random();
                    Integer quantity = random.nextInt(10) + 1;
                    return new ItemDto(
                            product,
                            quantity,
                            product.getPrice() * quantity
                    );
                }).collect(Collectors.toList());
    }

    @Override
    public Optional<ItemDto> findById(Long id) {
        ProductDto productDto = client.details(id);
        if (productDto == null) {
            return Optional.empty();
        }
        return Optional.of(new ItemDto(
                client.details(id), 1, client.details(id).getPrice()));
    }
}
