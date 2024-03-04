package org.example.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titulo_livro")
    private String titulo;
    @Column(name = "autor_livro")
    private String autor;
    @Column(name = "preco_livro")
    private Double preço;

    public Livro(String titulo, String autor, Double preço) {
        this.titulo = titulo;
        this.autor = autor;
        this.preço = preço;
    }

    public Livro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getPreço() {
        return preço;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }
}
