package DAO;

import Entities.ArticleEntity;

import javax.persistence.EntityManager;

public class ArticleDAO {

    private EntityManager em;

    public ArticleDAO(EntityManager em) {
        this.em = em;
    }

    public ArticleEntity create(ArticleEntity article){
        em.getTransaction().begin();
        em.persist(article);
        em.getTransaction().commit();
        return article;
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(em.find(ArticleEntity.class , id));
        em.getTransaction().commit();

    }

    public ArticleEntity update(ArticleEntity article){
        em.getTransaction().begin();
        em.merge(article);
        em.getTransaction().commit();
        return article;
    }

    public ArticleEntity read(int id){
        return em.find(ArticleEntity.class , id);
    }
}
