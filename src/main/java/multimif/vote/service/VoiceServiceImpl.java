package multimif.vote.service;

import multimif.vote.dao.VoiceDAO;
import multimif.vote.dao.VoiceDAOImpl;
import multimif.vote.modele.Voice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoiceServiceImpl implements VoiceService {
    private VoiceDAO VoiceDAO;

    public VoiceServiceImpl(){
        VoiceDAO = new VoiceDAOImpl();
    }

    @Transactional
    public void addVoice(Voice Voice) {
        VoiceDAO.addVoice(Voice);
    }

    @Transactional
    public void updateVoice(Voice Voice) {
        VoiceDAO.updateVoice(Voice);
    }

    @Transactional
    public List<Voice> listVoice() {
        return VoiceDAO.listVoice();
    }

    @Transactional
    public List<Voice> listVoiceByVoteId(int idVote) {
        return VoiceDAO.listVoiceByVoteId(idVote);
    }

    @Transactional
    public Voice getVoiceById(int id) {
        return VoiceDAO.getVoiceById(id);
    }

    @Transactional
    public void removeVoice(int id) {
        VoiceDAO.removeVoice(id);
    }
}
