package com.almoxarifado.repository;

import com.almoxarifado.models.PedidoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoCompraRepository extends JpaRepository<PedidoCompra, PedidoCompra.PedidoCompraId> {
}
