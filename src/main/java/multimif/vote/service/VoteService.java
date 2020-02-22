package multimif.vote.service;

import multimif.vote.modele.Vote;

import java.util.List;

public interface VoteService {
    void addVote(Vote vote);
    void updateVote(Vote vote);
    List<Vote> listVote();
    Vote getVoteById(int id);
    void removeVote(int id);
}
