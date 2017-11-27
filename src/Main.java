import DAO.BookDAO;
import Entities.BookEntity;
import Entities.UsersEntity;

import javax.faces.component.UIComponent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em;
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        em = emf.createEntityManager();
        BookDAO bookDAO = new BookDAO(em);
        UsersEntity user = new UsersEntity();
        user.setUserId(1);
        user.setLogin("gggg");
        user.setPassword("4r4r4");
        user.setEmail("ewea@eeeq");

        BookEntity book1 = new BookEntity("name134" , 122 , user);

        BookEntity book = bookDAO.read(14);
        book.setbDesc("aaaaaeeeee");
        bookDAO.update(book);
    }
}
