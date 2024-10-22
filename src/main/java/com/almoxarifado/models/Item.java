package com.almoxarifado.models;

import jakarta.persistence.*;

@Entity
@Table(name = "itens", schema = "almoxarifado")
public class Item {
    
    @Id
    @Column(name = "nome_item")
    private String nomeItem;
    
    @Column(name = "quantidade")
    private int quantidade;
    
    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "catalogo_nome")
    private String catalogoNome;

    // Getters e Setters
    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getCatalogoNome() {
        return catalogoNome;
    }

    public void setCatalogoNome(String catalogoNome) {
        this.catalogoNome = catalogoNome;
    }
}
