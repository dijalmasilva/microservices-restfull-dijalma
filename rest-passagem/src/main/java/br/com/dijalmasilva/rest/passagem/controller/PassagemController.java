package br.com.dijalmasilva.rest.passagem.controller;

import br.com.dijalmasilva.rest.passagem.model.Passagem;
import br.com.dijalmasilva.rest.passagem.service.PassagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@RestController
@RequestMapping("/passagem")
public class PassagemController {

    @Autowired
    private PassagemService passagemService;

    @GetMapping
    List<Passagem> getAll() {
        return passagemService.findAll();
    }

    @PostMapping
    ResponseEntity<Passagem> save(@RequestBody Passagem passagem) {
        Passagem saved = passagemService.save(passagem);

        if (saved != null) {
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(new Passagem(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    ResponseEntity<Passagem> findOne(@PathVariable Long id) {
        Passagem find = passagemService.findOne(id);

        if (find != null) {
            return new ResponseEntity<Passagem>(find, HttpStatus.OK);
        }

        return new ResponseEntity<Passagem>(new Passagem(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    ResponseEntity<Passagem> edit(@PathVariable Long id, @RequestBody Passagem passagem) {
        Passagem edit = passagemService.edit(id, passagem);

        if (edit != null) {
            return new ResponseEntity<Passagem>(edit, HttpStatus.OK);
        }

        return new ResponseEntity<Passagem>(new Passagem(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        passagemService.delete(id);
    }
}
