package br.com.dijalmasilva.rest.agencia.repository;

import br.com.dijalmasilva.rest.agencia.model.Pacote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@Repository
public interface PacoteRepository extends CrudRepository<Pacote, Long> {
}
