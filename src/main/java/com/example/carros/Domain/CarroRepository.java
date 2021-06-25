package com.example.carros.Domain;

import org.springframework.data.repository.CrudRepository;

public interface CarroRepository extends CrudRepository<Carro, Long> {

    Iterable<Carro> findById(String tipo);
}