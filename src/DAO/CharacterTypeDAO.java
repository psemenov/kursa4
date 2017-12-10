package DAO;

import Entities.CharacterEntity;
import Entities.CharacterTypeEntity;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CharacterTypeDAO {
    private EntityManager em;

    public CharacterTypeDAO(EntityManager em) {
        this.em = em;
    }

    public void deleteAll(){
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Ctype.deleteAll");
        query.executeUpdate();
        em.getTransaction().commit();
    }

    public List<CharacterTypeEntity> readByAuthor(String author){
        TypedQuery<CharacterTypeEntity> query = em.createQuery(
                "select p from CharacterTypeEntity p join p.userByUserId " +
                        "where p.userByUserId.login ='" +author + "'"
                ,CharacterTypeEntity.class);
        return query.getResultList();
    }

    public List<CharacterTypeEntity> readBySubType(String subType){
        TypedQuery<CharacterTypeEntity> query = em.createQuery(
                "SELECT p from CharacterTypeEntity p " +
                        "where p.csubtypeName ='"+subType+"'"
                ,CharacterTypeEntity.class);
        return query.getResultList();
    }

    public List<CharacterTypeEntity> readByDesc(String desc){
        TypedQuery<CharacterTypeEntity> query = em.createQuery(
                "SELECT p from CharacterTypeEntity p " +
                        "where p.ctypeDesc like '%" +desc+"%'"
                ,CharacterTypeEntity.class);
        return query.getResultList();
    }

    public List<CharacterTypeEntity> readByName(String name){
        TypedQuery<CharacterTypeEntity> query = em.createQuery(
                "SELECT p from CharacterTypeEntity p " +
                        "where p.ctypeName ='"+name+"'"
                , CharacterTypeEntity.class);
        return query.getResultList();
    }

    public List<CharacterTypeEntity> readAll(){
        TypedQuery<CharacterTypeEntity> query = em.createNamedQuery("Ctype.readAll" , CharacterTypeEntity.class);
        return query.getResultList();
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
