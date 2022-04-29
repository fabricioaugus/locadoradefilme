package com.locadora.locadoradefilme.model;

import javax.persistence.*;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer codigo;
    @Column(length=80, nullable=false)
    String titulo;
    @Column(length=70, nullable=false)
    String subTitulo;
    // Idioma idioma;

    public Filme() {
    }

    public Filme(Integer codigo, String titulo, String subTitulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.subTitulo = subTitulo;
    }
    public Filme setCodigo(Integer codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public Filme setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public Filme setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
        return this;
    }

    public Integer getCodigo() {
        return codigo;
    }

}
