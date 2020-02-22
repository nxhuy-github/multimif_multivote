package multimif.vote.dao;

import multimif.vote.hibernateUtils.HibernateUtil;
import multimif.vote.jpaUtils.JPAUtils;
import multimif.vote.modele.Voice;
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
public class VoiceDAOImpl implements VoiceDAO {
    private Session session;

    private EntityManager entityManager;

    public VoiceDAOImpl(){
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        entityManager = JPAUtils.getEntityManager();
    }

    public void addVoice(Voice Voice) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            entityManager.persist(Voice);
            entityManager.getTransaction().commit();
            System.out.println("Voice added...");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void updateVoice(Voice Voice) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            entityManager.merge(Voice);
            entityManager.getTransaction().commit();
            System.out.println("Voice updated...");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public List<Voice> listVoice() {
        List<Voice> Voices = new ArrayList<Voice>();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            TypedQuery<Voice> query = entityManager.createQuery("select v from Voice v", Voice.class);
            Voices = query.getResultList();
            entityManager.getTransaction().commit();
            System.out.println("List Voices...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return Voices;
    }

    public List<Voice> listVoiceByVoteId(int idVote) {
        List<Voice> Voices = new ArrayList<Voice>();
        try{
            entityManager.getTransaction().begin();
            TypedQuery<Voice> query = entityManager.createQuery("select v from Voice v where v.idVoteVoice= ?1", Voice.class);
            query.setParameter(1, idVote);
            Voices = query.getResultList();
            entityManager.getTransaction().commit();
            System.out.println("List Voices...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return Voices;
    }

    public Voice getVoiceById(int id) {
        Voice Voice = new Voice();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            Voice = entityManager.find(Voice.class, new Integer(id));
            entityManager.getTransaction().commit();
            System.out.println("Voice id: "+ id +"...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return Voice;
    }

    public void removeVoice(int id) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            Voice voice = entityManager.find(Voice.class, new Integer(id));
            if(voice != null){
                entityManager.remove(voice);
                System.out.println("Voice id: "+ id +" deleted...");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
    }

}
