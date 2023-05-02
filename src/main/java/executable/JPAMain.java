package executable;

import jakarta.persistence.EntityManager;
import model.Book;

public class JPAMain {
    public static void main(String[] args) {
        EntityManager em = JPAUtils.getEntityManager();
        //System.out.println(em);

        Book livre = new Book();
        livre.setDescription("MaDesc");
        livre.setTitle("MonTritre");
        livre.setIsbn("MonIsbn");

        Book livre3 = new Book();
        livre3.setTitle("qsdf");

        em.getTransaction().begin();
        em.persist(livre);
        em.persist(livre3);
        em.getTransaction().commit();
     

        Book livre2 = em.find(Book.class, 1);
        
        if(livre2 == null) {
            System.out.println("Book not found");
        } else {
            System.out.println(livre2);
        }

        em.close();
    }    
}
