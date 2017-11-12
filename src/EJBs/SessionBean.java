package EJBs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "SessionEJB")
public class SessionBean {
    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager entityManager;
    public SessionBean() {
    }
}
