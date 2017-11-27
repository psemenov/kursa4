package DAO;

import Entities.NationEntity;

import javax.persistence.EntityManager;

public class NationDAO {
    EntityManager em;

    public NationDAO(EntityManager em){
        this.em = em;
    }

    public NationEntity create(NationEntity nation){
        em.persist(nation);
        return nation;
    }

    public NationEntity read(int id){
        return em.find(NationEntity.class , id);
    }

    public void update(NationEntity nation){
        em.getTransaction().begin();
        em.merge(nation);
        em.getTransaction().commit();
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(em.find(NationEntity.class , id));
        em.getTransaction().commit();
    }
}
