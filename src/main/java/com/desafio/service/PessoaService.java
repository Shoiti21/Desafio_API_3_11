package com.desafio.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.model.Pessoa;
import com.desafio.repository.repPessoa;

@Service
public class PessoaService {
	@Autowired
	private repPessoa rep;
	public List<Pessoa> listar() {
		return rep.findAll();
	}

	public ResponseEntity<Pessoa> pesquisar(Long codigo) {
		if(!rep.findById(codigo).isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(rep.findById(codigo).get());
	}

	public URI salvar(Pessoa pessoa) {
		rep.save(pessoa);
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/pessoa/{codigo}").buildAndExpand(pessoa.getCodigo()).toUri();
	}

	public void deletar(Long codigo) {
		rep.deleteById(codigo);
	}

}
