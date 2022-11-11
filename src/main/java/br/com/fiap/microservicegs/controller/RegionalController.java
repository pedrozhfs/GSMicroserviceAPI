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
import br.com.fiap.microservicegs.model.Regional;
import br.com.fiap.microservicegs.repository.RegionalRepository;

@RestController
@RequestMapping(value="/api")
public class RegionalController {
	
	@Autowired
	private RegionalRepository regionalRepository;
	
	@GetMapping("/regionais")
	@PreAuthorize("hasRole('admin')")
	public List<Regional> listarRegional(){
		return regionalRepository.findAll();
	}
	
	@GetMapping("/regional/{id}")
	@PreAuthorize("hasRole('admin')")
	public Optional<Regional> listarRegionalUnico(@PathVariable(value ="id") long id){
		return regionalRepository.findById(id);
	}
	
	@PostMapping("/criarRegional")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('admin')")
	public Regional adicionarRegional(@RequestBody Regional regional) {
		return regionalRepository.save(regional);
	}
	
	@DeleteMapping("/deletaRegional")
	@PreAuthorize("hasRole('admin')")
	public void deletaRegional(@RequestBody Regional regional) {
		regionalRepository.delete(regional);
	}
	
	@PutMapping("/atualizaRegional")
	@PreAuthorize("hasRole('admin')")
	public Regional atualizaRegional (@RequestBody Regional regional) {
		return regionalRepository.save(regional);
	}

}
