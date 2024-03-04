package testes;

import dao.AnimalDAO;
import dao.PessoaDAO;
import jakarta.persistence.EntityManager;
import modelo.Animal;
import modelo.Pessoa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utilitarios.JPAutils;

@SpringBootApplication
public class PersistindoDados {
    public static void main(String[] args) {
        SpringApplication.run(PersistindoDados.class, args);

        Pessoa p1 = new Pessoa("Luana", "16 3322-4455");
        Animal gato1 = new Animal("gordo", "gato", p1);
        Animal gato2 = new Animal("magrela", "gato", p1);
        p1.addAnimalEstimacao(gato1);
        p1.addAnimalEstimacao(gato2);

        gato1.setDono(p1);

        EntityManager em = JPAutils.getEntityManager();

        PessoaDAO pDAO = new PessoaDAO(em);
        AnimalDAO aDAO = new AnimalDAO(em);

        em.getTransaction().begin();

        aDAO.cadastrarAnimal(gato1);
        aDAO.cadastrarAnimal(gato2);

        gato2.setDono(p1);

        pDAO.cadastrarPessoa(p1);

        em.getTransaction().commit();
        em.close();
    }
}
