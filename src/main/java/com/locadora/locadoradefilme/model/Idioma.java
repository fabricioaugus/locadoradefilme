package com.locadora.locadoradefilme.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Idioma {
    INGLES(1, "Inglês" ),
    PORTUGUES(2,"Português" ),
    MANDARIM(3,"Chinês Mandarim"),
    HINDI(4, "Hindi"),
    ESPANHOL(5,"Espanhol"),
    FRANCES(6,"Francês"),
    ARABE(7,"Árabe"),
    BENGALI(8,"Bengali "),
    RUSSO(9, " Russo"),
    INDONESIO(10,"Indonésio");

    private final int id;
    private final String idioma;

    Idioma(int id, String idioma) {
        this.id = id;
        this.idioma = idioma;
    }

    public int getId() {
        return id;
    }

    public String getIdioma() {
        return idioma;
    }


    public List<String> getIdiomas() {
        List<Idioma> lista = Arrays.asList(Idioma.values());
        List<String> retorno = new ArrayList<String>();
        for (int i = 0; i < lista.size(); i++) {
            retorno.add(lista.get(i).getIdioma());
        }
        return retorno;
    }

}
