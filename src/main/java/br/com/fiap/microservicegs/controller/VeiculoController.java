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

import br.com.fiap.microservicegs.model.Veiculo;
import br.com.fiap.microservicegs.repository.VeiculoRepository;

@RestController
@RequestMapping(value="/api")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping("/veiculos")
	@PreAuthorize("hasRole('admin')")
	public List<Veiculo> listarVeiculos() {
		return veiculoRepository.findAll();
	}
	
	@GetMapping("/veiculo/{id}")
	@PreAuthorize("hasRole('admin')")
	public Optional<Veiculo> listarVeiculoUnico(@PathVariable(value ="id") long id) {
		return veiculoRepository.findById(id);
	}
	
	@PostMapping("/criarVeiculo")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('admin')")
	public Veiculo adicionarVeiculo(@RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	@DeleteMapping("/deletaVeiculo")
	@PreAuthorize("hasRole('admin')")
	public void deletaVeiculo(@RequestBody Veiculo veiculo) {
		veiculoRepository.delete(veiculo);
	}
	
	@PutMapping("/atualizaVeiculo")
	@PreAuthorize("hasRole('admin')")
	public Veiculo atualizaVeiculo(@RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
}
