package dao;

import jakarta.persistence.EntityManager;
import modelo.Animal;

public class AnimalDAO {
    private EntityManager em;

    public AnimalDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrarAnimal(Animal a){
        this.em.persist(a);
        this.em.flush();
    }
}
