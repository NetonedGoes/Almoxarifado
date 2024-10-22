package com.almoxarifado.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pedido_compra", schema = "almoxarifado")
@IdClass(PedidoCompra.PedidoCompraId.class)
public class PedidoCompra {

    @Id
    @Column(name = "fornecedor_email")
    private String fornecedorEmail;

    @Id
    @Column(name = "item_nome")
    private String itemNome;

    @Id
    @Column(name = "catalogo_nome")
    private String catalogoNome;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "status_pedido", nullable = false)
    private String statusPedido;

    // Getters and Setters

    public String getFornecedorEmail() {
        return fornecedorEmail;
    }

    public void setFornecedorEmail(String fornecedorEmail) {
        this.fornecedorEmail = fornecedorEmail;
    }

    public String getItemNome() {
        return itemNome;
    }

    public void setItemNome(String itemNome) {
        this.itemNome = itemNome;
    }

    public String getCatalogoNome() {
        return catalogoNome;
    }

    public void setCatalogoNome(String catalogoNome) {
        this.catalogoNome = catalogoNome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    // Equals and hashCode using composite key fields

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoCompra that = (PedidoCompra) o;
        return fornecedorEmail.equals(that.fornecedorEmail) &&
                itemNome.equals(that.itemNome) &&
                catalogoNome.equals(that.catalogoNome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fornecedorEmail, itemNome, catalogoNome);
    }

    // Composite Key Class
    public static class PedidoCompraId implements Serializable {
        private String fornecedorEmail;
        private String itemNome;
        private String catalogoNome;

        // Getters, Setters, Equals and hashCode methods
        public String getFornecedorEmail() {
            return fornecedorEmail;
        }

        public void setFornecedorEmail(String fornecedorEmail) {
            this.fornecedorEmail = fornecedorEmail;
        }

        public String getItemNome() {
            return itemNome;
        }

        public void setItemNome(String itemNome) {
            this.itemNome = itemNome;
        }

        public String getCatalogoNome() {
            return catalogoNome;
        }

        public void setCatalogoNome(String catalogoNome) {
            this.catalogoNome = catalogoNome;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PedidoCompraId that = (PedidoCompraId) o;
            return fornecedorEmail.equals(that.fornecedorEmail) &&
                    itemNome.equals(that.itemNome) &&
                    catalogoNome.equals(that.catalogoNome);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fornecedorEmail, itemNome, catalogoNome);
        }
    }
}
