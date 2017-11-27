package DAO;

import Entities.MagicEntity;

import javax.persistence.EntityManager;

public class MagicDAO {
    private EntityManager em;

    public MagicDAO(EntityManager em) {
        this.em = em;
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(em.find(MagicEntity.class,id));
        em.getTransaction().commit();
    }

    public MagicEntity read(int id){
        return em.find(MagicEntity.class , id);
    }

    public MagicEntity create(MagicEntity magic){
        em.getTransaction().begin();
        em.persist(magic);
        em.getTransaction().commit();
        return magic;
    }

    public MagicEntity update(MagicEntity magic){
        em.getTransaction().begin();
        em.merge(magic);
        em.getTransaction().commit();
        return magic;
    }
}
