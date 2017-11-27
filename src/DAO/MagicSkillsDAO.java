package DAO;

import Entities.MagicSkillsEntity;

import javax.persistence.EntityManager;

public class MagicSkillsDAO {
    EntityManager em;

    public MagicSkillsDAO(EntityManager em){
        this.em = em;
    }

    public MagicSkillsEntity create(MagicSkillsEntity skill){
        em.persist(skill);
        return skill;
    }

    public MagicSkillsEntity read(int id){
        return em.find(MagicSkillsEntity.class , id);
    }

    public void update(MagicSkillsEntity skill){
        em.getTransaction().begin();
        em.merge(skill);
        em.getTransaction().commit();
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(em.find(MagicSkillsEntity.class , id));
        em.getTransaction().commit();
    }
}
