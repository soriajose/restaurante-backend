package com.undec.restaurante.service;

import com.undec.restaurante.dto.Response;
import com.undec.restaurante.model.Restaurante;
import com.undec.restaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Response findAll() {
        Response response = new Response();
        response.getMessaje();
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        response.setData(restauranteList);
        return response;
    }

    public Response findOne(Integer id) throws Exception {
        Response response = new Response();
        Restaurante restaurante = restauranteRepository.findById(id).get();
        response.setData(restaurante);
        return response;

    }

    public Response delete(Integer id) {
        Response response = new Response();
        restauranteRepository.delete(restauranteRepository.getOne(id));
        response.setData("ok");
        return response;
    }

    public Response update(Restaurante input) {
        Response response = new Response();
        restauranteRepository.save(input);
        response.setData("ok");
        return response;
    }

    public Response save(Restaurante r) {
        Response response = new Response();
        response.setData(restauranteRepository.save(r));
        return response;
    }

    public Response getrestoByPrecio(String precio) {
        Response response = new Response();
        response.setData(restauranteRepository.findAllByPrecio(precio));
        return response;
    }
}
