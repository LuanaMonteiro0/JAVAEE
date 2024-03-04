package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.modelo.Livro;

public class LivroDAO {
    private EntityManager em;

    public LivroDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrarLivro(Livro l){
        this.em.persist(l);
        this.em.flush();
    }

}
