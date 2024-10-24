package io.charoldev.msitems.controller;

import io.charoldev.msitems.model.ItemDto;
import io.charoldev.msitems.service.IItemService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final IItemService itemService;

    public ItemController(@Qualifier("itemServiceWebClient") IItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemDto> list() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id) {
        Optional <?> itemOptional = itemService.findById(id);
        return itemOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404)
                        .body(Collections.singletonMap("message", "Item not found"))
                );
    }
}
