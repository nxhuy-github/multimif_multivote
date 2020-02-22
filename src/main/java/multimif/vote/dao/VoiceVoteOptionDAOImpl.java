package multimif.vote.dao;

import multimif.vote.jpaUtils.JPAUtils;
import multimif.vote.modele.VoiceVoteOption;
import multimif.vote.modele.VoteOption;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class VoiceVoteOptionDAOImpl implements VoiceVoteOptionDAO{
    private EntityManager entityManager;

    public VoiceVoteOptionDAOImpl(){
        entityManager = JPAUtils.getEntityManager();
    }

    @Override
    public void addVoiceVoteOption(VoiceVoteOption voiceVoteOption) {
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            entityManager.persist(voiceVoteOption);
            entityManager.getTransaction().commit();
            System.out.println("VoiceVoteOption idVoteOption: "+voiceVoteOption.getIdVoteOptionVoiceVoteOption()
                    +", idVoice: " +voiceVoteOption.getIdVoiceVoiceVoteOption()+"...");
        } catch (NoResultException nre){
            System.out.println("Not found entity");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<VoiceVoteOption> getListVoiceVoteOptions(int idVoteOption) {
        List<VoiceVoteOption> voiceVoteOptions = new ArrayList<>();
        try{
            if(!entityManager.getTransaction().isActive()){
                entityManager.getTransaction().begin();
            }
            TypedQuery<VoiceVoteOption> query = entityManager.createQuery("select vvo " +
                    "from VoiceVoteOption vvo " +
                    "where vvo.idVoteOptionVoiceVoteOption = ?1", VoiceVoteOption.class);
            query.setParameter(1, idVoteOption);
            voiceVoteOptions = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return voiceVoteOptions;
    }
}
