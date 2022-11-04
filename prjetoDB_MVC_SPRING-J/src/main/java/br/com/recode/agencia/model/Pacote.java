package br.com.recode.agencia.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table
public class Pacote {
	
	//protected int idPacote;
	//protected String destino;
	//protected String tipo;
	//protected double valor;
	


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPacote;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
    private String tipo;
    
    @Column(nullable = false)
    private Double valor;
	
    @Lob
	private byte[] imagem;

    public Pacote() {
    }

    public Pacote(Long idPacote, String destino, String tipo, Double valor) {
        this.idPacote = idPacote;
        this.destino = destino;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Long getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(Long idPacote) {
        this.idPacote = idPacote;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String tipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((destino == null) ? 0 : destino.hashCode());
        result = prime * result + ((idPacote == null) ? 0 : idPacote.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
        Pacote other = (Pacote) obj;
        if (destino == null) {
            if (other.destino != null)
                return false;
        } else if (!destino.equals(other.destino))
            return false;
        if (idPacote == null) {
            if (other.idPacote != null)
                return false;
        } else if (!idPacote.equals(other.idPacote))
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (valor == null) {
            if (other.valor != null)
                return false;
        } else if (!valor.equals(other.valor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [destino=" + destino + ", idPacote=" + idPacote + ", tipo=" + tipo + ", valor="
                + valor + "]";
    }
}

    
