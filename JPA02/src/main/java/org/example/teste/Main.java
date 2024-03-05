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
        Livro l3 = new Livro("O primo Basílio", "Machado de Assis", 150.90);
        Livro l4 = new Livro("Declínio de um homem", "Osamu Dazai", 55.70);
        Livro l5 = new Livro("A guerra dos Tronos", "George R R Martin", 90.85);
        Livro l6 = new Livro("Entendendo Algoritmos", "Aditya Y. Bhargava", 79.40);
        Livro l7 = new Livro("Sobre o ócio", "Senêca", 19.10);

        Livro l8;  //apenas receberá livros recuperados do banco
        EntityManager em = utilitario.JPAutils.getEntityManager();

        em.getTransaction().begin();
        LivroDAO lDAO = new LivroDAO(em);

        //o que está comentado ja está no banco
        //lDAO.cadastrarLivro(l1);
        //lDAO.cadastrarLivro(l2);
        //lDAO.cadastrarLivro(l3);
        //lDAO.cadastrarLivro(l4);
        //lDAO.cadastrarLivro(l5);
        //lDAO.cadastrarLivro(l6);
        //lDAO.cadastrarLivro(l7);

        //atualizando dados atravéz do conceito de recuperação pelo id
        //e ciclo de vida das entidades persistidas
        //l8 = lDAO.encontrarLivroPeloId(2);
        //l8.setTitulo("Senhor dos Aneis: a Sociedade do anel");
        //l8.setPreço(45.99);

        //apagando livro 7
        //l8 = lDAO.encontrarLivroPeloId(7);
        //lDAO.apagarLivro(l8);
        //lDAO.cadastrarLivro(l7);


        em.getTransaction().commit();
        em.close();


    }
}