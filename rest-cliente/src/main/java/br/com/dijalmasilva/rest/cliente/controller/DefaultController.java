package br.com.dijalmasilva.rest.cliente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 18/10/17.
 */
@Controller
public class DefaultController {

    @GetMapping(value = {"", "/index"})
    public String index() {
        return "index";
    }
}
