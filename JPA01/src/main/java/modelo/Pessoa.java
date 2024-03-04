package modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoas")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String telefone;

    @OneToMany (cascade = {CascadeType.ALL})
    @JoinColumn(name = "pessoa_id")
    private List<Animal> animalEstimacao = new ArrayList<>();

    public Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    public Pessoa(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Animal> getAnimalEstimacao() {
        return animalEstimacao;
    }

    public void addAnimalEstimacao(Animal a) {
        animalEstimacao.add(a);
    }
}
