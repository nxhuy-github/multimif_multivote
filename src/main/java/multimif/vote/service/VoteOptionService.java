package multimif.vote.service;

import multimif.vote.modele.VoteOption;

import java.util.List;

public interface VoteOptionService {
    void addVoteOption(VoteOption voteOption);
    void updateVoteOption(VoteOption voteOption);
    List<VoteOption> listVoteOption();
    VoteOption getVoteOptionById(int id);
    List<VoteOption> getVoteOptionByIdVote(int idVote);
    void removeVoteOption(int id);
}
