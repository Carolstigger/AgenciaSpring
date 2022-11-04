package br.com.recode.agencia.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recode.agencia.model.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}