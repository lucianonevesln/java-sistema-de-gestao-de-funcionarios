package com.lucianonevesln.sistemadegestaodefuncionarios.repositories;

import com.lucianonevesln.sistemadegestaodefuncionarios.entities.FuncionariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepository extends JpaRepository<FuncionariosModel, Integer> {
    public boolean existsByTelefone(String telefone);
}
