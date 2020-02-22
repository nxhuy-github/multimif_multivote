package multimif.vote.dao;

import multimif.vote.hibernateUtils.HibernateUtil;
import multimif.vote.jpaUtils.JPAUtils;
import multimif.vote.modele.VoteType;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VoteTypeDAOImpl implements VoteTypeDAO {
    private Session session;

    private EntityManager entityManager;

    public VoteTypeDAOImpl(){
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        entityManager = JPAUtils.getEntityManager();
    }

    public void addVoteType(VoteType voteType) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            entityManager.persist(voteType);
            entityManager.getTransaction().commit();
            System.out.println("Vote Type added..");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void updateVoteType(VoteType voteType) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            entityManager.merge(voteType);
            entityManager.getTransaction().commit();
            System.out.println("Vote type updated...");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public List<VoteType> listVoteType() {
        List<VoteType> voteTypes = new ArrayList<VoteType>();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            TypedQuery<VoteType> query = entityManager.createQuery("select vt from VoteType vt", VoteType.class);
            voteTypes = query.getResultList();
            entityManager.getTransaction().commit();
            System.out.println("List Votes Types...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return voteTypes;
    }

    public VoteType getVoteTypeById(int id) {
        VoteType voteType = new VoteType();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            voteType = entityManager.find(VoteType.class, new Integer(id));
            entityManager.getTransaction().commit();
            System.out.println("Vote Type id: "+ id +"...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return voteType;
    }

    public void removeVoteType(int id) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            VoteType voteType = entityManager.find(VoteType.class, new Integer(id));
            if(voteType != null){
                entityManager.remove(voteType);
                System.out.println("VoteType id: "+ id +" deleted...");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
