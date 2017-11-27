package DAO;

import Entities.CharacterEntity;
import Entities.CharacterTypeEntity;

import javax.persistence.EntityManager;

public class CharacterTypeDAO {
    private EntityManager em;

    public CharacterTypeDAO(EntityManager em) {
        this.em = em;
    }

    public CharacterTypeEntity create(CharacterTypeEntity ctype){
        em.getTransaction().begin();
        em.persist(ctype);
        em.getTransaction().commit();
        return ctype;
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(em.find(CharacterTypeEntity.class, id));
        em.getTransaction().commit();
    }

    public CharacterTypeEntity read(int id){
        return em.find(CharacterTypeEntity.class , id);
    }

    public CharacterTypeEntity update(CharacterTypeEntity ctype){
        em.getTransaction().begin();
        em.merge(ctype);
        em.getTransaction().commit();
        return ctype;
    }
}
