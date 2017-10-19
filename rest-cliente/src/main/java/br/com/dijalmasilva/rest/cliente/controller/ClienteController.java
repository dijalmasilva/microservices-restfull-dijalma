package br.com.dijalmasilva.rest.cliente.controller;

import br.com.dijalmasilva.rest.cliente.model.Cliente;
import br.com.dijalmasilva.rest.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.io.Serializable;
import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 17/10/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteController implements Serializable {

    @Autowired
    private ClienteService servicoCliente;

    @GetMapping
    List<Cliente> getClientes() {
        return servicoCliente.getClientes();
    }

    @PostMapping
    ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
        Cliente saved = servicoCliente.saveCliente(cliente);

        if (saved != null) {
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(new Cliente(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    ResponseEntity<Cliente> getById(@PathVariable Long id) {
        Cliente find = servicoCliente.getById(id);
        if (find != null) {
            return new ResponseEntity<>(find, HttpStatus.OK);
        }

        return new ResponseEntity<>(new Cliente(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    ResponseEntity<Cliente> editCliente(@PathVariable Long id, Cliente cliente) {
        Cliente edit = servicoCliente.editCliente(id, cliente);

        if (edit != null) {
            return new ResponseEntity<>(edit, HttpStatus.OK);
        }

        return new ResponseEntity<>(new Cliente(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/filter/cpf/{cpf}")
    ResponseEntity<Cliente> getByCpf(@PathVariable String cpf) {
        Cliente find = servicoCliente.getByCpf(cpf);

        if (find != null) {
            return new ResponseEntity<>(find, HttpStatus.OK);
        }

        return new ResponseEntity<>(new Cliente(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    void deleteCliente(@PathVariable Long id) {
        servicoCliente.deleteCliente(id);
    }
}
