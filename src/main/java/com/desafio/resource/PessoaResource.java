package com.desafio.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.model.Pessoa;
import com.desafio.service.PessoaService;

@RestController
public class PessoaResource {
	@Autowired
	private PessoaService serv;
	
	@RequestMapping(value="/pessoa", method=RequestMethod.GET)
	public ResponseEntity<?> lista(){
		return ResponseEntity.status(HttpStatus.OK).body(serv.listar());
	}
	@RequestMapping(value="/pessoa/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> pesquisa(@PathVariable("codigo") Long codigo){
		return serv.pesquisar(codigo);
	}
	@RequestMapping(value="/pessoa", method=RequestMethod.POST)
	public ResponseEntity<?> salva(@RequestBody Pessoa pessoa){
		return ResponseEntity.created(serv.salvar(pessoa)).build();
	}
	@RequestMapping(value="/pessoa/{codigo}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleta(@PathVariable("codigo") Long codigo){
		serv.deletar(codigo);
		return ResponseEntity.noContent().build();
	}
}
