package com.almoxarifado.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario", schema = "almoxarifado")
public class Funcionario {

    @Id
    private String cpf_funcionario;
    private String departamento;



    public Funcionario() {
        // Construtor padrão necessário
    }

    public Funcionario(String cpf_funcionario, String departamento) {
        this.cpf_funcionario = cpf_funcionario;
        this.departamento = departamento;
    }

    public String getCpf_funcionario() {
        return cpf_funcionario;
    }

    public void setCpf_funcionario(String cpf_funcionario) {
        this.cpf_funcionario = cpf_funcionario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
