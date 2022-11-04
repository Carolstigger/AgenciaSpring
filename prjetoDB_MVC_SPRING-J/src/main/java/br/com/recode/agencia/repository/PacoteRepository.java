package br.com.recode.agencia.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recode.agencia.model.Pacote;



public interface PacoteRepository extends JpaRepository<Pacote, Long> {
    
}