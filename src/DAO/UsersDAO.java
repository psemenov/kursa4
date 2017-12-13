package DAO;

import Entities.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsersDAO {
    EntityManager em;

    public UsersDAO(EntityManager em){
        this.em = em;
    }

    public List<UsersEntity> readByLogin(String name){
        TypedQuery<UsersEntity> query = em.createQuery(
                "select p from UsersEntity p where p.login ='"+name+"'"
                ,UsersEntity.class);
        return query.getResultList();
    }

    public List<UsersEntity> readByRating(int rating){
        TypedQuery<UsersEntity> query = em.createQuery(
                "SELECT p from UsersEntity p where p.rating ="+rating
                ,UsersEntity.class);
        return query.getResultList();
    }

    public UsersEntity create(UsersEntity user){
        em.persist(user);
        return user;
    }

    public UsersEntity read(int id){
        return em.find(UsersEntity.class , id);
    }

    public void update(UsersEntity user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
   }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(em.find(UsersEntity.class , id));
        em.getTransaction().commit();
    }

    public List<UsersEntity> readAll(){
        TypedQuery<UsersEntity> query = em.createNamedQuery(
                "Users.readAll"
                ,UsersEntity.class);
        return query.getResultList();
    }

    public void deleteAll(){
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Users.deleteAll");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
