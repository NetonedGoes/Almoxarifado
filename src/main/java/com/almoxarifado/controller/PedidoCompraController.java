package com.almoxarifado.controller;

import com.almoxarifado.models.PedidoCompra;
import com.almoxarifado.service.PedidoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedido_compra")
public class PedidoCompraController {

    @Autowired
    private PedidoCompraService service;

    @GetMapping
    public List<PedidoCompra> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{fornecedorEmail}/{itemNome}/{catalogoNome}")
    public ResponseEntity<PedidoCompra> buscarPorId(@PathVariable String fornecedorEmail, 
                                                    @PathVariable String itemNome,
                                                    @PathVariable String catalogoNome) {
        PedidoCompra.PedidoCompraId id = new PedidoCompra.PedidoCompraId();
        id.setFornecedorEmail(fornecedorEmail);
        id.setItemNome(itemNome);
        id.setCatalogoNome(catalogoNome);
        Optional<PedidoCompra> pedido = service.buscarPorId(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PedidoCompra criarPedido(@RequestBody PedidoCompra pedido) {
        return service.salvar(pedido);
    }

    @PutMapping("/{fornecedorEmail}/{itemNome}/{catalogoNome}")
    public ResponseEntity<PedidoCompra> atualizarPedido(@PathVariable String fornecedorEmail, 
                                                        @PathVariable String itemNome,
                                                        @PathVariable String catalogoNome, 
                                                        @RequestBody PedidoCompra pedidoAtualizado) {
        PedidoCompra.PedidoCompraId id = new PedidoCompra.PedidoCompraId();
        id.setFornecedorEmail(fornecedorEmail);
        id.setItemNome(itemNome);
        id.setCatalogoNome(catalogoNome);

        Optional<PedidoCompra> pedidoOptional = service.buscarPorId(id);

        if (pedidoOptional.isPresent()) {
            PedidoCompra pedidoExistente = pedidoOptional.get();
            pedidoExistente.setQuantidade(pedidoAtualizado.getQuantidade());
            pedidoExistente.setStatusPedido(pedidoAtualizado.getStatusPedido());
            service.salvar(pedidoExistente);
            return ResponseEntity.ok(pedidoExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{fornecedorEmail}/{itemNome}/{catalogoNome}")
    public ResponseEntity<Void> deletarPedido(@PathVariable String fornecedorEmail, 
                                              @PathVariable String itemNome,
                                              @PathVariable String catalogoNome) {
        PedidoCompra.PedidoCompraId id = new PedidoCompra.PedidoCompraId();
        id.setFornecedorEmail(fornecedorEmail);
        id.setItemNome(itemNome);
        id.setCatalogoNome(catalogoNome);

        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
