package br.com.dijalmasilva.rest.hotel.service;

import br.com.dijalmasilva.rest.hotel.model.Hotel;
import br.com.dijalmasilva.rest.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@Service
public class HotelService {

    @Autowired
    private HotelRepository dao;

    public Hotel save(Hotel hotel) {
        return dao.save(hotel);
    }

    public Hotel edit(Long id, Hotel hotel) {
        Hotel find = dao.findOne(id);
        find.setCidade(hotel.getCidade());
        find.setDescricao(hotel.getDescricao());
        find.setNome(hotel.getNome());
        find.setRua(hotel.getRua());
        return dao.save(find);
    }

    public Hotel find(Long id) {
        return dao.findOne(id);
    }

    public List<Hotel> findAll() {
        return (List<Hotel>) dao.findAll();
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}
