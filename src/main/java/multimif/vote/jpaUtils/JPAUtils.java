package multimif.vote.jpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    public static final EntityManager entityManager;

    static {
        try{
            entityManager = Persistence.createEntityManagerFactory("voting").createEntityManager();
        } catch (Throwable th){
            System.err.println("Initial EntityManagerFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);
        }
    }

    public static EntityManager getEntityManager() { return entityManager;}
}
