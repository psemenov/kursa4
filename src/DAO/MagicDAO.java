package DAO;

import Entities.MagicEntity;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class MagicDAO {
    private EntityManager em;

    public MagicDAO(EntityManager em) {
        this.em = em;
    }

    public List<MagicEntity> readByAuthor(String author){
        TypedQuery<MagicEntity> query = em.createQuery(
                "select p from MagicEntity p join p.userByUserId " +
                        "where p.userByUserId.login ='"+author+"'"
            ,MagicEntity.class);
        return query.getResultList();
    }

    public List<MagicEntity> readByDesc(String desc){
        TypedQuery<MagicEntity> query = em.createQuery(
                "select p from MagicEntity p where p.mDesc like '%"+desc+"%'"
                , MagicEntity.class);
        return query.getResultList();
    }

    public List<MagicEntity> readByType(String type){
        TypedQuery<MagicEntity> query = em.createQuery(
                "select p from MagicEntity p where p.mType ='"+type+"'"
                ,MagicEntity.class);
        return query.getResultList();
    }

    public void deleteAll(){
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Magic.deleteAll");
        query.executeUpdate();
        em.getTransaction().commit();
    }

    public List<MagicEntity> readAll(){
        TypedQuery<MagicEntity> query = em.createNamedQuery("Magic.readAll" , MagicEntity.class);
        return query.getResultList();
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
