package br.com.dijalmasilva.rest.agencia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@Entity
public class Pacote implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Long idPassagem;
    private Long idReserva;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(Long idPassagem) {
        this.idPassagem = idPassagem;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }
}
