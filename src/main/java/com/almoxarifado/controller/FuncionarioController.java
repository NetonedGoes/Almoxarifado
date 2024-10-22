package com.almoxarifado.controller;

import com.almoxarifado.models.Funcionario;
import com.almoxarifado.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    // Create - POST
    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario) {
        try {
            Funcionario novoFuncionario = funcionarioRepository.save(funcionario);
            return ResponseEntity.ok(novoFuncionario);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }


    // Read - GET (todos os funcionários)
    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    // Read - GET (funcionário por CPF)
    @GetMapping("/{cpf}")
    public ResponseEntity<Funcionario> getFuncionarioByCpf(@PathVariable String cpf) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(cpf);
        return funcionario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update - PUT
    @PutMapping("/{cpf}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable String cpf, @RequestBody Funcionario funcionarioDetails) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(cpf);
        
        if (funcionario.isPresent()) {
            Funcionario updatedFuncionario = funcionario.get();
            updatedFuncionario.setDepartamento(funcionarioDetails.getDepartamento());
            funcionarioRepository.save(updatedFuncionario);
            return ResponseEntity.ok(updatedFuncionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete - DELETE
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable String cpf) {
        if (funcionarioRepository.existsById(cpf)) {
            funcionarioRepository.deleteById(cpf);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
