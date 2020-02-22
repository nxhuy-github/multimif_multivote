package multimif.vote.dao;

import multimif.vote.modele.VoiceVoteOption;
import multimif.vote.modele.VoteOption;

import java.util.List;

public interface VoiceVoteOptionDAO {
    void addVoiceVoteOption(VoiceVoteOption voiceVoteOption);
    List<VoiceVoteOption> getListVoiceVoteOptions(int idVoteOption);
}
