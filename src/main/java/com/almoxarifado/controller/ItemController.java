package com.almoxarifado.controller;

import com.almoxarifado.models.Item;
import com.almoxarifado.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/itens")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> listarItens() {
        return itemService.listarTodos();
    }

    @GetMapping("/{nomeItem}")
    public ResponseEntity<Item> buscarItem(@PathVariable String nomeItem) {
        Optional<Item> item = itemService.buscarPorNome(nomeItem);
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Item criarItem(@RequestBody Item item) {
        return itemService.criarOuAtualizarItem(item);
    }

    @PutMapping("/{nomeItem}")
    public ResponseEntity<Item> atualizarItem(@PathVariable String nomeItem, @RequestBody Item item) {
        if (!itemService.buscarPorNome(nomeItem).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        item.setNomeItem(nomeItem); // Certificar que estamos atualizando o item correto
        return ResponseEntity.ok(itemService.criarOuAtualizarItem(item));
    }

    @DeleteMapping("/{nomeItem}")
    public ResponseEntity<Void> deletarItem(@PathVariable String nomeItem) {
        if (!itemService.buscarPorNome(nomeItem).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        itemService.deletarItem(nomeItem);
        return ResponseEntity.noContent().build();
    }
}
