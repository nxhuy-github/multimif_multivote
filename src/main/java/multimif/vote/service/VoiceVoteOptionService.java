package multimif.vote.service;

import multimif.vote.modele.VoiceVoteOption;
import multimif.vote.modele.VoteOption;

import java.util.List;

public interface VoiceVoteOptionService {
    void addVoiceVoteOption(VoiceVoteOption voiceVoteOption);
    List<VoiceVoteOption> getListVoiceVoteOptions(int idVoteOption);
}
