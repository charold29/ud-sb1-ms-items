package io.charoldev.msitems.service;

import io.charoldev.msitems.model.ItemDto;

import java.util.List;
import java.util.Optional;

public interface IItemService {

    List<ItemDto> findAll();
    Optional<ItemDto> findById(Long id);
}
