package multimif.vote.dao;

import multimif.vote.modele.Vote;
import multimif.vote.modele.VoteOption;

import java.util.List;

public interface VoteOptionDAO {
    void addVoteOption(VoteOption voteOption);
    void updateVoteOption(VoteOption voteOption);
    List<VoteOption> listVoteOption();
    VoteOption getVoteOptionById(int id);
    List<VoteOption> getVoteOptionByIdVote(int idVote);
    void removeVoteOption(int id);
}
