package com.undec.restaurante.controller;

import com.undec.restaurante.dto.Response;
import com.undec.restaurante.model.Restaurante;
import com.undec.restaurante.service.RestauranteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private static final Logger LOG = LoggerFactory.getLogger(RestauranteController.class);

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public ResponseEntity<Response> list() {
        Response response = restauranteService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Consulto solo uno por identificador
    @GetMapping("/{id}")
    public ResponseEntity<Response> getRestoById(@PathVariable(value = "id") Integer restauranteId) throws Exception {
        Response response = restauranteService.findOne(restauranteId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // crea un solo restaurante
    @PostMapping()
    public ResponseEntity<Response> create(@Valid @RequestBody Restaurante restaurante) {
        Response response = restauranteService.save(restaurante);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Actualiza
    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable(value = "id") Integer restauranteId,
                                           @Valid @RequestBody Restaurante input) {
        Response response = restauranteService.update(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // borra
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable(value = "id") Integer restauranteId) {
        Response response = restauranteService.delete(restauranteId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/precio/{precio}")
    public ResponseEntity<Response> getrestoByPrecio(@PathVariable(value = "precio") String precio) {
        Response response = restauranteService.getrestoByPrecio(precio);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
