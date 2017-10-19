package br.com.dijalmasilva.rest.hotel.controller;

import br.com.dijalmasilva.rest.hotel.model.Hotel;
import br.com.dijalmasilva.rest.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    List<Hotel> getAll() {
        return hotelService.findAll();
    }

    @PostMapping
    ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        Hotel saved = hotelService.save(hotel);

        if (saved != null) {
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(new Hotel(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    ResponseEntity<Hotel> getOne(@PathVariable Long id) {
        Hotel hotel = hotelService.find(id);

        if (hotel != null) {
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        }

        return new ResponseEntity<>(new Hotel(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    ResponseEntity<Hotel> edit(@PathVariable Long id, @RequestBody Hotel hotel) {
        Hotel edit = hotelService.edit(id, hotel);
        if (edit != null) {
            return new ResponseEntity<>(edit, HttpStatus.OK);
        }

        return new ResponseEntity<>(new Hotel(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        hotelService.delete(id);
    }
}
