package br.com.recode.agencia.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cliente {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String nascimento;
    
    @Column(nullable = false)
    private String telefone;
    
    @Column(nullable = false)
    private String cpf;
    

    public Cliente() {
    }

    public Cliente(Long idCliente, String nome, String nascimento, String telefone, String cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.cpf =cpf;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setId(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nascimento == null) ? 0 : nascimento.hashCode());
        result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        Cliente other = (Cliente) obj;
        if (nascimento == null) {
            if (other.nascimento != null)
                return false;
        } else if (!nascimento.equals(other.nascimento))
            return false;
        if (idCliente == null) {
            if (other.idCliente != null)
                return false;
        } else if (!idCliente.equals(other.idCliente))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (telefone == null) {
            if (other.telefone != null)
                return false;
        } else if (!telefone.equals(other.telefone))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [nascimento=" + nascimento + ", idCliente=" + idCliente + ", nome=" + nome + ", telefone="
                + telefone +" , cpf="+cpf+"]";
    }

    
}