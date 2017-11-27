package DAO;

import Entities.PlaceEntity;

import javax.persistence.EntityManager;

public class PlaceDAO {

    EntityManager em;

    public PlaceDAO(EntityManager em){
        this.em = em;
    }

    public PlaceEntity create(PlaceEntity place){
        em.persist(place);
        return place;
    }

    public PlaceEntity read(int id){
        return em.find(PlaceEntity.class , id);
    }

    public void update(PlaceEntity place){
        em.getTransaction().begin();
        em.merge(place);
        em.getTransaction().commit();
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(em.find(PlaceEntity.class , id));
        em.getTransaction().commit();
    }
}
