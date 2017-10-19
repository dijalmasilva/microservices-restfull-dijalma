package br.com.dijalmasilva.rest.hotel.repository;

import br.com.dijalmasilva.rest.hotel.model.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {
}
