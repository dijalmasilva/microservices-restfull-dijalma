package br.com.dijalmasilva.rest.hotel.controller;

import br.com.dijalmasilva.rest.hotel.model.Reserva;
import br.com.dijalmasilva.rest.hotel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    List<Reserva> getAll() {
        return reservaService.findAll();
    }

    @PostMapping
    ResponseEntity<Reserva> saveReserva(@RequestBody Reserva Reserva) {
        br.com.dijalmasilva.rest.hotel.model.Reserva saved = reservaService.save(Reserva);

        if (saved != null) {
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(new Reserva(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    ResponseEntity<Reserva> getOne(@PathVariable Long id) {
        Reserva Reserva = reservaService.findOne(id);

        if (Reserva != null) {
            return new ResponseEntity<>(Reserva, HttpStatus.OK);
        }

        return new ResponseEntity<>(new Reserva(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    ResponseEntity<Reserva> edit(@PathVariable Long id, @RequestBody Reserva Reserva) {
        br.com.dijalmasilva.rest.hotel.model.Reserva edit = reservaService.editReserva(id, Reserva);
        if (edit != null) {
            return new ResponseEntity<>(edit, HttpStatus.OK);
        }

        return new ResponseEntity<>(new Reserva(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        reservaService.delete(id);
    }
}
