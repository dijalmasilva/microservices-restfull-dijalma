package br.com.dijalmasilva.rest.hotel.service;

import br.com.dijalmasilva.rest.hotel.model.Reserva;
import br.com.dijalmasilva.rest.hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@Service
public class ReservaService {

    @Autowired
    private ReservaRepository dao;

    public Reserva save(Reserva reserva) {
        reserva.setDiaDaCriacaoDaReserva(LocalDate.now().toString());
        return dao.save(reserva);
    }

    public Reserva editReserva(Long id, Reserva reserva) {
        Reserva find = dao.findOne(id);
        find.setCpfCliente(reserva.getCpfCliente());
        find.setDataReservada(reserva.getDataReservada());
        find.setDiaDaCriacaoDaReserva(reserva.getDiaDaCriacaoDaReserva());
        find.setHotel(reserva.getHotel());
        return dao.save(find);
    }

    public Reserva findOne(Long id) {
        return dao.findOne(id);
    }

    public List<Reserva> findAll() {
        return (List<Reserva>) dao.findAll();
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}
