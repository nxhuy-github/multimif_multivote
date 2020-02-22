package multimif.vote.service;

import multimif.vote.modele.Voice;

import java.util.List;

public interface VoiceService {
    void addVoice(Voice Voice);
    void updateVoice(Voice Voice);
    List<Voice> listVoice();
    List<Voice> listVoiceByVoteId(int idVote);
    Voice getVoiceById(int id);
    void removeVoice(int id);
}
