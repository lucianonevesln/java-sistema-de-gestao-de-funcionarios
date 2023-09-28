package com.lucianonevesln.sistemadegestaodefuncionarios.controllers;

import com.lucianonevesln.sistemadegestaodefuncionarios.dtos.FuncionariosDto;
import com.lucianonevesln.sistemadegestaodefuncionarios.entities.FuncionariosModel;
import com.lucianonevesln.sistemadegestaodefuncionarios.services.FuncionariosService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servico-gestao-funcionarios")
public class FuncionariosController {
    final FuncionariosService funcionariosService;

    public FuncionariosController(FuncionariosService funcionariosService) {
        this.funcionariosService = funcionariosService;
    }

    @PostMapping
    public ResponseEntity<Object> saveFuncionario(@RequestBody @Valid FuncionariosDto funcionariosDto) {
        if (funcionariosService.existsByTelefone(funcionariosDto.getTelefone())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: número de telefone já existe!");
        }
        FuncionariosModel funcionariosModel = new FuncionariosModel();
        BeanUtils.copyProperties(funcionariosDto, funcionariosModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionariosService.save(funcionariosModel));
    }

    @GetMapping
    public ResponseEntity<List<FuncionariosModel>> getAllFuncionarios() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionariosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneFuncionario(@PathVariable(value = "id") Integer id) {
        Optional<FuncionariosModel> parkingSpotModelOptional = funcionariosService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFuncionario(@PathVariable(value = "id") Integer id) {
        Optional<FuncionariosModel> parkingSpotModelOptional = funcionariosService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado.");
        }
        funcionariosService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Funcionario excluído com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFuncionario(@PathVariable(value = "id") Integer id,
                                                    @RequestBody @Valid FuncionariosDto funcionariosDto) {
        Optional<FuncionariosModel> parkingSpotModelOptional = funcionariosService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado.");
        }
        var parkingSpotModel = new FuncionariosModel();
        BeanUtils.copyProperties(funcionariosDto, parkingSpotModel);
        parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(funcionariosService.save(parkingSpotModel));
    }

}
