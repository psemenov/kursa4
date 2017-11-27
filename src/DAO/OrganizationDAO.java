package DAO;

import Entities.OrganizationEntity;

import javax.persistence.EntityManager;

public class OrganizationDAO {
    EntityManager em;

    public OrganizationDAO(EntityManager em){
        this.em = em;
    }

    public OrganizationEntity create(OrganizationEntity org){
        em.persist(org);
        return org;
    }

    public OrganizationEntity read(int id){
        return em.find(OrganizationEntity.class , id);
    }

    public void update(OrganizationEntity org){
        em.getTransaction().begin();
        em.merge(org);
        em.getTransaction().commit();
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(em.find(OrganizationEntity.class , id));
        em.getTransaction().commit();
    }
}
