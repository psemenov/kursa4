package DAO;

import Entities.EpisodeEntity;

import javax.persistence.EntityManager;

public class EpisodeDAO {

    private EntityManager em;

    public EpisodeDAO(EntityManager em) {
        this.em = em;
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(em.find(EpisodeEntity.class , id));
        em.getTransaction().commit();
    }

    public EpisodeEntity create(EpisodeEntity episode){
        em.getTransaction().begin();
        em.persist(episode);
        em.getTransaction().commit();
        return episode;
    }

    public EpisodeEntity read(int id){
        return em.find(EpisodeEntity.class , id);
    }

    public EpisodeEntity update(EpisodeEntity episode){
        em.getTransaction().begin();
        em.merge(episode);
        em.getTransaction().commit();
        return episode;
    }
}
