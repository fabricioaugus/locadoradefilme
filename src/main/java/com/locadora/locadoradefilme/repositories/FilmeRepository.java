package com.locadora.locadoradefilme.repositories;

import com.locadora.locadoradefilme.model.Filme;
import org.springframework.data.repository.CrudRepository;

public interface FilmeRepository extends CrudRepository<Filme,Integer> {

}