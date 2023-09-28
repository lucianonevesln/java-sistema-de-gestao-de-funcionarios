package com.lucianonevesln.sistemadegestaodefuncionarios.services;

import com.lucianonevesln.sistemadegestaodefuncionarios.entities.FuncionariosModel;
import com.lucianonevesln.sistemadegestaodefuncionarios.repositories.FuncionariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionariosService {
    final FuncionariosRepository funcionariosRepository;

    public FuncionariosService(FuncionariosRepository funcionariosRepository) {
        this.funcionariosRepository = funcionariosRepository;
    }

    @Transactional
    public FuncionariosModel save(FuncionariosModel funcionariosModel) {
        return funcionariosRepository.save(funcionariosModel);
    }

    public List<FuncionariosModel> findAll() {
        return funcionariosRepository.findAll();
    }

    public boolean existsByTelefone(String telefone) {
        return funcionariosRepository.existsByTelefone(telefone);
    }

    public Optional<FuncionariosModel> findById(Integer id) {
        return funcionariosRepository.findById(id);
    }

    public void delete(FuncionariosModel funcionariosModel) {
        funcionariosRepository.delete(funcionariosModel);
    }

}
