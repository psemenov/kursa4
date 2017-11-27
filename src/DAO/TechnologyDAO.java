package DAO;

import Entities.TechnologyEntity;

import javax.persistence.EntityManager;

public class TechnologyDAO {
    EntityManager em;

    public TechnologyDAO(EntityManager em){
        this.em = em;
    }

    public TechnologyEntity create(TechnologyEntity tech){
        em.persist(tech);
        return tech;
    }

    public TechnologyEntity read(int id){
        return em.find(TechnologyEntity.class , id);
    }

    public void update(TechnologyEntity tech){
        em.getTransaction().begin();
        em.merge(tech);
        em.getTransaction().commit();
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(em.find(TechnologyEntity.class , id));
        em.getTransaction().commit();
    }
}
