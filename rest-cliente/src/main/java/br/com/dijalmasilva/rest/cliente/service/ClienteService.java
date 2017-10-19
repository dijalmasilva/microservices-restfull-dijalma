package br.com.dijalmasilva.rest.cliente.service;

import br.com.dijalmasilva.rest.cliente.model.Cliente;
import br.com.dijalmasilva.rest.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 17/10/17.
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository dao;

    public List<Cliente> getClientes() {
        return (List<Cliente>) dao.findAll();
    }

    public Cliente getById(Long id) {
        return dao.findOne(id);
    }

    public Cliente getByCpf(String cpf) {
        return dao.findByCpf(cpf);
    }

    public Cliente saveCliente(Cliente cliente) {
        return dao.save(cliente);
    }

    public Cliente editCliente(Long id, Cliente cliente) {
        Cliente c = dao.findOne(id);
        c.setCpf(cliente.getCpf());
        c.setNome(cliente.getNome());
        c.setRenda(cliente.getRenda());
        return dao.save(c);
    }

    public void deleteCliente(Long id) {
        dao.delete(id);
    }
}
