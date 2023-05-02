package executable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtils {
    //Singleton
    private static JPAUtils INSTANCE = new JPAUtils();
    private JPAUtils(){}
    public static JPAUtils getInstance(){
        return INSTANCE;
    }
    //

    //JPA
    private final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("FormationJPAPU");
    private final static EntityManager EM = EMF.createEntityManager();

    public static EntityManager getEntityManager(){
        return EM;
    }
    

}
