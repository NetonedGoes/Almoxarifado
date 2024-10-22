package com.almoxarifado.service;

import com.almoxarifado.models.Item;
import com.almoxarifado.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> listarTodos() {
        return itemRepository.findAll();
    }

    public Optional<Item> buscarPorNome(String nomeItem) {
        return itemRepository.findById(nomeItem);
    }

    public Item criarOuAtualizarItem(Item item) {
        return itemRepository.save(item);
    }

    public void deletarItem(String nomeItem) {
        itemRepository.deleteById(nomeItem);
    }
}