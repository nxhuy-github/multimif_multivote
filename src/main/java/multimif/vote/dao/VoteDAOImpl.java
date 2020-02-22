package multimif.vote.dao;

import multimif.vote.hibernateUtils.HibernateUtil;
import multimif.vote.jpaUtils.JPAUtils;
import multimif.vote.modele.Vote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VoteDAOImpl implements VoteDAO {
    private Session session;

    private EntityManager entityManager;

    public VoteDAOImpl(){
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        entityManager = JPAUtils.getEntityManager();
    }

    public void addVote(Vote vote) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            entityManager.persist(vote);
            entityManager.getTransaction().commit();
            System.out.println("Vote added...");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void updateVote(Vote vote) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            entityManager.merge(vote);
            entityManager.getTransaction().commit();
            System.out.println("Vote updated...");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public List<Vote> listVote() {
        List<Vote> votes = new ArrayList<Vote>();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            TypedQuery<Vote> query = entityManager.createQuery("select v from Vote v", Vote.class);
            votes = query.getResultList();
            entityManager.getTransaction().commit();
            System.out.println("List votes...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return votes;
    }

    public Vote getVoteById(int id) {
        Vote vote = new Vote();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            vote = entityManager.find(Vote.class, new Integer(id));
            entityManager.getTransaction().commit();
            System.out.println("Vote id: "+ vote.getIdVote() +"...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return vote;
    }

    public void removeVote(int id) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            Vote vote = entityManager.find(Vote.class, new Integer(id));
            if(vote != null){
                entityManager.remove(vote);
                System.out.println("Vote id: "+ id +" deleted...");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
