package multimif.vote.dao;

import multimif.vote.hibernateUtils.HibernateUtil;
import multimif.vote.jpaUtils.JPAUtils;
import multimif.vote.modele.Member;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDAOImpl implements MemberDAO {
    private Session session;

    private EntityManager entityManager;

    public MemberDAOImpl(){
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        entityManager = JPAUtils.getEntityManager();
    }

    public void addMember(Member member) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            entityManager.persist(member);
            entityManager.getTransaction().commit();
            System.out.println("Member added...");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void updateMember(Member member) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            entityManager.merge(member);
            entityManager.getTransaction().commit();
            System.out.println("Member updated...");
        } catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public List<Member> listMember() {
        List<Member> members = new ArrayList<Member>();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            TypedQuery<Member> query = entityManager.createQuery("SELECT m FROM Member m", Member.class);
            members = query.getResultList();
            entityManager.getTransaction().commit();
            System.out.println("List members...");
        } catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        return members;
    }

    public Member getMemberById(int id) {
        Member member = new Member();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            member = entityManager.find(Member.class, new Integer(id));
            entityManager.getTransaction().commit();
            System.out.println("Member id: "+ id +"...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return member;
    }

    public void removeMember(int id) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            Member member = entityManager.find(Member.class, new Integer(id));
            if(member != null){
                entityManager.remove(member);
                System.out.println("Member id: "+ id +" deleted...");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public Member getMemberByEmail(String email){
        Member member = new Member();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            TypedQuery<Member> query = entityManager.createQuery("select m from Member m where m.mailMember = ?1", Member.class);
            query.setParameter(1, email);
            member = query.getSingleResult();
            entityManager.getTransaction().commit();
            System.out.println("Member with email : "+ email +" ...");

        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        if(member.getIdMember() == null){
            return null;
        }else{
            return member;
        }
    }
}
