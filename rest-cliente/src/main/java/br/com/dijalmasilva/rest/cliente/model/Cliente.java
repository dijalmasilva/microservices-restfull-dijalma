package br.com.dijalmasilva.rest.cliente.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 17/10/17.
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String cpf;
    private BigInteger renda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigInteger getRenda() {
        return renda;
    }

    public void setRenda(BigInteger renda) {
        this.renda = renda;
    }
}
