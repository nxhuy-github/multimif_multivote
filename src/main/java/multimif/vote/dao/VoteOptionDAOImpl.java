package multimif.vote.dao;

import multimif.vote.hibernateUtils.HibernateUtil;
import multimif.vote.jpaUtils.JPAUtils;
import multimif.vote.modele.VoteOption;
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
public class VoteOptionDAOImpl implements VoteOptionDAO {
    private Session session;

    private EntityManager entityManager;

    public VoteOptionDAOImpl(){
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        entityManager = JPAUtils.getEntityManager();
    }

    public void addVoteOption(VoteOption voteOption) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            entityManager.persist(voteOption);
            entityManager.getTransaction().commit();
            System.out.println("Vote Option added...");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void updateVoteOption(VoteOption voteOption) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            entityManager.merge(voteOption);
            entityManager.getTransaction().commit();
            System.out.println("Vote Option updated...");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public List<VoteOption> listVoteOption() {
        List<VoteOption> voteOptions = new ArrayList<VoteOption>();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            TypedQuery<VoteOption> query = entityManager.createQuery("select vo from VoteOption vo", VoteOption.class);
            voteOptions = query.getResultList();
            entityManager.getTransaction().commit();
            System.out.println("List Votes Options...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return voteOptions;
    }

    public VoteOption getVoteOptionById(int id) {
        VoteOption voteOption = new VoteOption();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            voteOption = entityManager.find(VoteOption.class, new Integer(id));
            entityManager.getTransaction().commit();
            System.out.println("Vote Option id: "+ id +"...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return voteOption;
    }

    public List<VoteOption> getVoteOptionByIdVote(int idVote) {
        List<VoteOption> votes = new ArrayList<VoteOption>();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            TypedQuery<VoteOption> query= entityManager.createQuery("select vo from VoteOption vo where vo.idVoteVoteOption.idVote = ?1", VoteOption.class);
            query.setParameter(1, idVote);
            votes = query.getResultList();
            entityManager.getTransaction().commit();
            System.out.println("Vote Option idVote: "+ idVote +"...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return votes;
    }

    public void removeVoteOption(int id) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            VoteOption voteOption = entityManager.find(VoteOption.class, new Integer(id));
            if(voteOption != null){
                entityManager.remove(voteOption);
                System.out.println("VoteOption id: "+ id +" deleted...");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
