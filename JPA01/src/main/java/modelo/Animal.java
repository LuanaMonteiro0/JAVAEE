package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "animais")
public class Animal {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String especie;
    private Pessoa dono;

    public Animal(String nome, String especie, Pessoa dono) {
        this.nome = nome;
        this.especie = especie;
        this.dono = dono;
    }

    public Animal() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }
}
