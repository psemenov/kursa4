import DAO.MagicSkillsDAO;
import DAO.UsersDAO;
import Entities.MagicEntity;
import Entities.MagicSkillsEntity;
import Entities.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em;
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        em = emf.createEntityManager();

        em.getTransaction().begin();
        UsersEntity use = em.find(UsersEntity.class, 2);
        MagicSkillsEntity xxx = new MagicSkillsEntity();
        MagicEntity yyy = new MagicEntity();
        yyy.setmType("kek");
        yyy.setUserByUserId(use);
        em.persist(yyy);
        //em.find(MagicSkillsEntity.class, 1);
        xxx.setMagicByMagicId(yyy);
        xxx.setMskillName("chmo");
        xxx.setUserByUserId(use);
        MagicSkillsDAO ud = new MagicSkillsDAO(em);
        ud.create(xxx);
        em.getTransaction().commit();


    }
}
