package br.com.fiap.microservicegs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.microservicegs.model.Ambiente;
import br.com.fiap.microservicegs.repository.AmbienteRepository;

@RestController
@RequestMapping(value="/api")
public class AmbienteController {

	@Autowired
	private AmbienteRepository ambienteRepository;
	
	@GetMapping("/ambientes")
	@PreAuthorize("hasRole('admin')")
	public List<Ambiente> listarAmbientes(){
		return ambienteRepository.findAll();
	}
	
	@GetMapping("/ambiente/{id}")
	@PreAuthorize("hasRole('admin')")
	public Optional<Ambiente> listarAmbienteUnico(@PathVariable(value ="id") long id){
		return ambienteRepository.findById(id);
	}
	
	@PostMapping("/criarAmbiente")
	@PreAuthorize("hasRole('admin')")
	@ResponseStatus(HttpStatus.CREATED)
	public Ambiente adicionarAmbiente(@RequestBody Ambiente ambiente) {
		return ambienteRepository.save(ambiente);
	}
	
	@DeleteMapping("/deletaAmbiente")
	@PreAuthorize("hasRole('admin')")
	public void deletaAmbiente(@RequestBody Ambiente ambiente) {
		ambienteRepository.delete(ambiente);
	}
	
	@PutMapping("/atualizaAmbiente")
	@PreAuthorize("hasRole('admin')")
	public Ambiente atualizaAmbiente (@RequestBody Ambiente ambiente) {
		return ambienteRepository.save(ambiente);
	}
}
