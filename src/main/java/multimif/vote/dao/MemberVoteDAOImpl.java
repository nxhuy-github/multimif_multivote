package multimif.vote.dao;

import multimif.vote.hibernateUtils.HibernateUtil;
import multimif.vote.jpaUtils.JPAUtils;
import multimif.vote.modele.MemberVote;
import multimif.vote.modele.MemberVotePK;
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
public class MemberVoteDAOImpl implements MemberVoteDAO {
    private Session session;

    private EntityManager entityManager;

    public MemberVoteDAOImpl(){
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        entityManager = JPAUtils.getEntityManager();
    }

    public void addMemberVote(MemberVote MemberVote) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            entityManager.persist(MemberVote);
            entityManager.getTransaction().commit();
            System.out.println("MemberVote added...");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void updateMemberVote(MemberVote MemberVote) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            entityManager.merge(MemberVote);
            entityManager.getTransaction().commit();
            System.out.println("MemberVote updated...");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public List<MemberVote> listMemberVote() {
        List<MemberVote> MemberVotes = new ArrayList<MemberVote>();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            TypedQuery<MemberVote> query = entityManager.createQuery("select mv from MemberVote mv", MemberVote.class);
            MemberVotes = query.getResultList();
            entityManager.getTransaction().commit();
            System.out.println("List MemberVotes...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return MemberVotes;
    }

    public MemberVote getMemberVoteByIdMemberAndIdVote(MemberVotePK memberVotePK) {
        MemberVote memberVote = new MemberVote();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            memberVote = entityManager.find(MemberVote.class, memberVotePK);
            entityManager.getTransaction().commit();
            System.out.println("MemberVote idMember: "+ memberVotePK.getIdMemberMemberVote() +
                    ", idVote:"+ memberVotePK.getIdVoteMemberVote() +"...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return memberVote;
    }

    public void removeMemberVote(int id) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            MemberVote member = entityManager.find(MemberVote.class, new Integer(id));
            if(member != null){
                entityManager.remove(member);
                System.out.println("MemberVote id: "+ id +" deleted...");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
