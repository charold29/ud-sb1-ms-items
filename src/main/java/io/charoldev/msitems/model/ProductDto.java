package io.charoldev.msitems.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private Double price;
    private LocalDate createdAt;
}
