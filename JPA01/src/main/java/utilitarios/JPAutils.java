package utilitarios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAutils {
    private static final EntityManagerFactory FACTORY
            = Persistence.createEntityManagerFactory("JPA01");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
