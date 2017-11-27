package DAO;

import Entities.BookEntity;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class BookDAO {

    private EntityManager em;

    public BookDAO(EntityManager em) {
        this.em = em;
    }

    public BookEntity create(BookEntity book){
        em.getTransaction().begin();
        em.persist(book);
        em.flush();
        em.getTransaction().commit();
        return book;
    }
    public void delete(int id){
        try{
            em.getTransaction().begin();
            em.remove(em.find(BookEntity.class , id));
            em.flush();
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public BookEntity update(BookEntity book){
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
        return book;
    }

    public BookEntity read(int id){
        return em.find(BookEntity.class , id);
    }



}
