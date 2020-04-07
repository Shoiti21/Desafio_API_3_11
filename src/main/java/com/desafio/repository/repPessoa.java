package com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.model.Pessoa;

public interface repPessoa extends JpaRepository<Pessoa, Long>{
}
