package org.example.teste;

import jakarta.persistence.EntityManager;
import org.example.dao.LivroDAO;
import org.example.modelo.Livro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        Livro l1 = new Livro("Admiravel Mundo Novo", "Aldous Huxley", 50.00);
        Livro l2 = new Livro("Senhor dos Aneis", "J R R Tolkien", 40.54);

        EntityManager em = utilitario.JPAutils.getEntityManager();

        em.getTransaction().begin();
        LivroDAO lDAO = new LivroDAO(em);

        lDAO.cadastrarLivro(l1);
        lDAO.cadastrarLivro(l2);

        em.getTransaction().commit();
        em.close();


    }
}