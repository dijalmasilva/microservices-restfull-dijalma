package br.com.dijalmasilva.rest.passagem.service;

import br.com.dijalmasilva.rest.passagem.model.Passagem;
import br.com.dijalmasilva.rest.passagem.repository.PassagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@Service
public class PassagemService {

    @Autowired
    private PassagemRepository dao;

    public Passagem save(Passagem passagem) {
        return dao.save(passagem);
    }

    public Passagem edit(Long id, Passagem passagem) {
        Passagem find = dao.findOne(id);
        find.setCidadeDestino(passagem.getCidadeDestino());
        find.setCidadeOrigem(passagem.getCidadeOrigem());
        find.setCpfCliente(passagem.getCpfCliente());
        find.setValor(passagem.getValor());
        return dao.save(find);
    }

    public Passagem findOne(Long id) {
        return dao.findOne(id);
    }

    public List<Passagem> findAll() {
        return (List<Passagem>) dao.findAll();
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}
