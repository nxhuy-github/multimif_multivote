package multimif.vote.service;

import multimif.vote.modele.VoteType;

import java.util.List;

public interface VoteTypeService {
    void addVoteType(VoteType voteType);
    void updateVoteType(VoteType voteType);
    List<VoteType> listVoteType();
    VoteType getVoteTypeById(int id);
    void removeVoteType(int id);
}
