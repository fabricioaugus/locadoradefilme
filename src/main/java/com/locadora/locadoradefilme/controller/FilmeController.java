package com.locadora.locadoradefilme.controller;

import com.locadora.locadoradefilme.model.Filme;
import com.locadora.locadoradefilme.repositories.FilmeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/filmes")
public class FilmeController {
    private final FilmeRepository filmeRepository;

    public FilmeController(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @GetMapping
    public Iterable<Filme> findById() {
        return filmeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> findById(@PathVariable Integer id) {
        Optional<Filme> optionalFilme = filmeRepository.findById(id);
        if (optionalFilme.isPresent()) {
            return new ResponseEntity<>(optionalFilme.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Filme> saveFilme(@RequestBody Filme filme) {
        Filme filmeCreated = filmeRepository.save(filme);
        return new ResponseEntity<Filme>(filmeCreated, HttpStatus.CREATED);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<Filme> updateFilme(@RequestBody Filme filme, @PathVariable("id") Integer id) {
        if (filmeRepository.existsById(id)) {
            filme.setCodigo(id);
            Filme filmeUpdate = filmeRepository.save(filme);
            return new ResponseEntity<Filme>(filmeUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Filme> deleteFilme(@PathVariable("id") Integer id) {
        Optional<Filme> optionalFilme = filmeRepository.findById(id);
        if (optionalFilme.isPresent()) {
            Filme filme = optionalFilme.get();
            filmeRepository.delete(filme);
            return new ResponseEntity<>(optionalFilme.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
