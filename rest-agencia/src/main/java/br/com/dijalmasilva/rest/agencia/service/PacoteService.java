package br.com.dijalmasilva.rest.agencia.service;

import br.com.dijalmasilva.rest.agencia.model.Pacote;
import br.com.dijalmasilva.rest.agencia.repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@Service
public class PacoteService {

    @Autowired
    private PacoteRepository dao;

    public Pacote save(Pacote pacote) {
        return dao.save(pacote);
    }

    public Pacote edit(Long id, Pacote pacote) {
        Pacote find = dao.findOne(id);
        find.setIdPassagem(pacote.getIdPassagem());
        find.setIdReserva(pacote.getIdReserva());
        return dao.save(find);
    }

    public List<Pacote> findAll() {
        return (List<Pacote>) dao.findAll();
    }

    public Pacote findOne(Long id) {
        return dao.findOne(id);
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}
