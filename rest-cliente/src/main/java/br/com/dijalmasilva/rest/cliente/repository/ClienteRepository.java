package br.com.dijalmasilva.rest.cliente.repository;

import br.com.dijalmasilva.rest.cliente.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 17/10/17.
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    Cliente findByCpf(String cpf);
}
