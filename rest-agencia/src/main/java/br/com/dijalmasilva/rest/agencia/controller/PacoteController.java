package br.com.dijalmasilva.rest.agencia.controller;

import br.com.dijalmasilva.rest.agencia.model.Pacote;
import br.com.dijalmasilva.rest.agencia.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@RestController
@RequestMapping("/pacote")
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;

    @GetMapping
    List<Pacote> getAll() {
        return pacoteService.findAll();
    }

    @PostMapping
    ResponseEntity<Pacote> save(@RequestBody Pacote pacote) {
        Pacote saved = pacoteService.save(pacote);

        if (saved != null) {
            return new ResponseEntity<>(pacote, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(new Pacote(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    ResponseEntity<Pacote> findOne(@PathVariable Long id) {
        Pacote find = pacoteService.findOne(id);

        if (find != null) {
            return new ResponseEntity<>(find, HttpStatus.OK);
        }

        return new ResponseEntity<>(new Pacote(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    ResponseEntity<Pacote> edit(@PathVariable Long id, @RequestBody Pacote pacote) {
        Pacote edit = pacoteService.edit(id, pacote);

        if (edit != null) {
            return new ResponseEntity<>(edit, HttpStatus.OK);
        }

        return new ResponseEntity<>(new Pacote(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        pacoteService.delete(id);
    }
}
