package io.charoldev.msitems.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {

    private ProductDto productDto;
    private int quantity;
}
