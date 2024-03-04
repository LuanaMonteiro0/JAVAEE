package dao;

import jakarta.persistence.EntityManager;
import modelo.Pessoa;

public class PessoaDAO {
    private EntityManager em;

    public PessoaDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrarPessoa(Pessoa p){
        this.em.persist(p);
        this.em.flush();
    }
}
