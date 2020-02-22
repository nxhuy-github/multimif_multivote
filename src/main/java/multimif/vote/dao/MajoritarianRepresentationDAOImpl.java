package multimif.vote.dao;

import multimif.vote.jpaUtils.JPAUtils;
import multimif.vote.modele.MajoritarianRepresentation;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MajoritarianRepresentationDAOImpl implements  MajoritarianRepresentationDAO{
    private Session session;

    private EntityManager entityManager;

    public MajoritarianRepresentationDAOImpl(){
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        entityManager = JPAUtils.getEntityManager();
    }

    public void addMajoritarianRepresentation(MajoritarianRepresentation majoritarianRepresentation){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(majoritarianRepresentation);
            entityManager.getTransaction().commit();
            System.out.println("MajoritarianRepresentation added...");
        }catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void updateMajoritarianRepresentation(MajoritarianRepresentation majoritarianRepresentation){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(majoritarianRepresentation);
            entityManager.getTransaction().commit();
            System.out.println("MajoritarianRepresentation updated...");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public List<MajoritarianRepresentation> listMajoritarianRepresentation(){
        List<MajoritarianRepresentation> majoritarianRepresentations = new ArrayList<MajoritarianRepresentation>();
        try{
            entityManager.getTransaction().begin();
            TypedQuery<MajoritarianRepresentation> query = entityManager.createQuery("select mr from MajoritarianRepresentation mr", MajoritarianRepresentation.class);
            majoritarianRepresentations = query.getResultList();
            entityManager.getTransaction().commit();
            System.out.println("List MajoritarianRepresentation...");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return majoritarianRepresentations;
    }

    public MajoritarianRepresentation getVoteMajoritarianRepresentationById(int id){

        MajoritarianRepresentation majoritarianRepresentation = new MajoritarianRepresentation();
        try{
            entityManager.getTransaction().begin();
            majoritarianRepresentation = entityManager.find(MajoritarianRepresentation.class, new Integer(id));
            entityManager.getTransaction().commit();
            System.out.println("MajoritarianRepresentation id: "+ id +"...");
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return majoritarianRepresentation;
    }
    public void removeMajoritarianRepresentation(int id){
        try{
            entityManager.getTransaction().begin();
            MajoritarianRepresentation majoritarianRepresentation = entityManager.find(MajoritarianRepresentation.class, new Integer(id));
            if(majoritarianRepresentation != null){
                entityManager.remove(majoritarianRepresentation);
                System.out.println("MajoritarianRepresentation id: "+ id +" deleted...");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
