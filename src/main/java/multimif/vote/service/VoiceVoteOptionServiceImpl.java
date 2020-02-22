package multimif.vote.service;

import multimif.vote.dao.VoiceVoteOptionDAO;
import multimif.vote.dao.VoiceVoteOptionDAOImpl;
import multimif.vote.modele.VoiceVoteOption;
import multimif.vote.modele.VoteOption;

import java.util.List;

public class VoiceVoteOptionServiceImpl implements VoiceVoteOptionService{
    private VoiceVoteOptionDAO voiceVoteOptionDAO;

    public VoiceVoteOptionServiceImpl(){
        voiceVoteOptionDAO = new VoiceVoteOptionDAOImpl();
    }

    @Override
    public void addVoiceVoteOption(VoiceVoteOption voiceVoteOption) {
        voiceVoteOptionDAO.addVoiceVoteOption(voiceVoteOption);
    }

    @Override
    public List<VoiceVoteOption> getListVoiceVoteOptions(int idVoteOption) {
        return voiceVoteOptionDAO.getListVoiceVoteOptions(idVoteOption);
    }
}
