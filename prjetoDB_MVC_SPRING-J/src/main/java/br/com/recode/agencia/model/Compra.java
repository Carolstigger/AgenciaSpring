package br.com.recode.agencia.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class Compra {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false, name = "data_nascimento")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate data;

    @Column(nullable = false)
    private String formaDePagamento;

    public Compra() {
    }

    public Compra(Long idCompra, Double valor, LocalDate data, String formaDePagamento) {
        this.idCompra = idCompra;
        this.valor = valor;
        this.data = data;
        this.formaDePagamento = formaDePagamento;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((idCompra == null) ? 0 : idCompra.hashCode());
        result = prime * result + ((valor == null) ? 0 : valor.hashCode());
        result = prime * result + ((formaDePagamento == null) ? 0 : formaDePagamento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Compra other = (Compra) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (idCompra == null) {
            if (other.idCompra != null)
                return false;
        } else if (!idCompra.equals(other.idCompra))
            return false;
        if (valor == null) {
            if (other.valor!= null)
                return false;
        } else if (!valor.equals(other.valor))
            return false;
        if (formaDePagamento == null) {
            if (other.formaDePagamento != null)
                return false;
        } else if (!formaDePagamento.equals(other.formaDePagamento))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [data=" + data + ", idCompra=" + idCompra + ", valor=" + valor + ", formaDePagamento="
                + formaDePagamento + "]";
    }

} 
