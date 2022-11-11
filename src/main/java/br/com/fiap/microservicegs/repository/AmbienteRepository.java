package br.com.fiap.microservicegs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.microservicegs.model.Ambiente;

public interface AmbienteRepository extends JpaRepository<Ambiente, Long>{

}
