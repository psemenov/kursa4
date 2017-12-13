import DAO.MagicSkillsDAO;
import DAO.UsersDAO;
import Entities.BookEntity;
import Entities.MagicEntity;
import Entities.MagicSkillsEntity;
import Entities.UsersEntity;

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
        UsersEntity usr = new UsersEntity();
        usr.setEmail("er");
        usr.setLogin("usr");
        usr.setPassword("666");
        usr.setRating(1000000);
        em.persist(usr);
        em.getTransaction().commit();

    }
}
