package executable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import gui.Menu;
import jakarta.persistence.EntityManager;
import model.Adress;
import model.Adress2;
// import model.Adress;
import model.Book;
import model.BookCategory;
import model.CD;
import model.Customer;
import model.OrderLine;
import model.PurchaseOrder;

public class JPAMain {
    public static void main(String[] args) {
        EntityManager em = JPAUtils.getEntityManager();
        //System.out.println(em);

        Book livre = new Book();
        livre.setDescription("MaDesc");
        livre.setTitle("MonTritre");
        livre.setIsbn("MonIsbn");

        Book livre3 = new Book();
        livre3.setTitle("Best Title Ever");
        livre3.setPrice(56f);
        livre3.setDescription("This is a good description");
        livre3.setIsbn("1234567890");
        livre3.setNbOfPages(253);
        livre3.setCategory(BookCategory.ADVENTURE);
        // System.out.println(BookCategory.MYSTERY.ordinal());
        // livre3.setCategory(BookCategoryEnum.COMMEDY);
        // System.out.println(livre3.getCategory().toString());

        livre3.setTags("Bouhouhouhou");
        livre3.setTags("Oink oink");
        livre3.setTags("null");
        livre3.removeTag("null");
        // System.out.println(livre3.getTags());

        // CD c = new CD();
        // c.setTitle("This is a good title for a CD");
        // c.setDescription("This is a good CD");
        // c.setPrice(12f);
        // c.getTracks().put(1, "première musique");
        // c.getTracks().put(2, "deuxième musique");
        // c.getTracks().put(3, "troisième musique");

        // System.out.println("le cd: " + c.toString());

        // livre3.setIllustrations(true);
        // livre3.setInstant();



        // Customer customer = new Customer("A", "B");
        // Adress adress = new Adress();
        // adress.setStreetName("rue abc");
        // adress.setCity("Paris");
        // adress.setStreetNumber(15);
        // customer.setAdress(adress);
        // customer.setAdress(new Adress(12, "rue abc", "MTP"));

        Customer customer = new Customer("A", "B");
        Adress2 adr2 = new Adress2();
        adr2.setStreetName("rue abc");
        adr2.setCity("Paris");
        adr2.setStreetNumber(15);
        customer.setAdress2(adr2);


        OrderLine l1 = new OrderLine();
        l1.setPrice(100d);
        l1.setQuantity(10);
        l1.setDescription("Desc1");
        PurchaseOrder order = new PurchaseOrder();
        order.setAmount(50);
        order.getOrderLines().add(l1);

        // order.setAmount(50);
        // order.setDate(new Date(01, 10, 1995));
        // OrderLine line1 = new OrderLine();
        // line1.setPrice(100d);
        // line1.setQuantity(10);
        // line1.setDescription("Desc1");
        // order.getOrderLines().add(line1);
        // order.getOrderLines().add(new OrderLine(30, 300, "Description 2"));
        // order.getOrderLines().add(new OrderLine(70, 700, "Description 3"));



        em.getTransaction().begin();
        em.persist(livre3);

        em.persist(l1);
        em.persist(order);

        // em.persist(c);
        // em.persist(livre);

        em.persist(customer);
        em.persist(adr2);
        em.getTransaction().commit();
     

        Book livre2 = em.find(Book.class, 2);

        
        if(livre2 == null) {
            System.out.println("Book not found");
        } else {
            System.out.println(livre2);
        }



        // Menu menu = new Menu();
        // if(menu != null) {System.out.println("opened menu");}



        em.close();
    }
}
