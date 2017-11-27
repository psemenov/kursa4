package DAO;

import Entities.UsersEntity;

import javax.persistence.EntityManager;

public class UsersDAO {
    EntityManager em;

    public UsersDAO(EntityManager em){
        this.em = em;
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

}
