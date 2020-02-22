package multimif.vote.dao;

import multimif.vote.modele.Vote;

import java.util.List;

public interface VoteDAO {
    void addVote(Vote vote);
    void updateVote(Vote vote);
    List<Vote> listVote();
    Vote getVoteById(int id);
    void removeVote(int id);
}
