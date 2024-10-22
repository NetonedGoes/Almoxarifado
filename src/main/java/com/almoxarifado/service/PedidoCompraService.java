package com.almoxarifado.service;

import com.almoxarifado.models.PedidoCompra;
import com.almoxarifado.repository.PedidoCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoCompraService {

    @Autowired
    private PedidoCompraRepository repository;

    public List<PedidoCompra> listarTodos() {
        return repository.findAll();
    }

    public Optional<PedidoCompra> buscarPorId(PedidoCompra.PedidoCompraId id) {
        return repository.findById(id);
    }

    public PedidoCompra salvar(PedidoCompra pedido) {
        return repository.save(pedido);
    }

    public void deletar(PedidoCompra.PedidoCompraId id) {
        repository.deleteById(id);
    }
}
