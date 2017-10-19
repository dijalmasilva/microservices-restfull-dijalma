package br.com.dijalmasilva.rest.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@Controller
public class DefaultController {

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    String index() {
        return "index";
    }
}
