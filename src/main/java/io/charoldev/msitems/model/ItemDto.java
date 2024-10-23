package io.charoldev.msitems.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemDto {

    private ProductDto productDto;
    private int quantity;
    private Double total;
}
