import Entities.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em;
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        BookEntity book = new BookEntity();
        book.setbDesc("fefefffffffffwftesthjjy");
        book.setbName("tefffstssffffffsseeeee");
        book.setRating(111);
        book.setUser_id(1);
        //book.setBookId(123);
        em.persist(book);
        em.getTransaction().commit();
    }
}
