package br.com.recode.agencia.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recode.agencia.model.Compra;



public interface CompraRepository extends JpaRepository<Compra, Long> {
    
}