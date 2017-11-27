package DAO;

import Entities.CharacterEntity;

import javax.persistence.EntityManager;

public class CharacterDAO {
    private EntityManager em;

    public CharacterDAO(EntityManager em) {
        this.em = em;
    }

    public CharacterEntity create(CharacterEntity character){
        em.getTransaction().begin();
        em.persist(character);
        em.getTransaction().commit();
        return character;
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(em.find(CharacterEntity.class , id));
        em.getTransaction().commit();
    }

    public CharacterEntity update(CharacterEntity charater){
        em.getTransaction().begin();
        em.merge(charater);
        em.getTransaction().commit();
        return  charater;
    }

    public CharacterEntity read(int id){
        return em.find(CharacterEntity.class , id);
    }
}
