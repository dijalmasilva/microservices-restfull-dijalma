package br.com.dijalmasilva.rest.hotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@Entity
public class Reserva implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String dataReservada;
    private String diaDaCriacaoDaReserva;
    @OneToOne
    private Hotel hotel;
    private String cpfCliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataReservada() {
        return dataReservada;
    }

    public void setDataReservada(String dataReservada) {
        this.dataReservada = dataReservada;
    }

    public String getDiaDaCriacaoDaReserva() {
        return diaDaCriacaoDaReserva;
    }

    public void setDiaDaCriacaoDaReserva(String diaDaCriacaoDaReserva) {
        this.diaDaCriacaoDaReserva = diaDaCriacaoDaReserva;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
}
