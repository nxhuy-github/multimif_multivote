package multimif.vote.dao;

import multimif.vote.modele.VoteType;

import java.util.List;

public interface VoteTypeDAO {
    void addVoteType(VoteType voteType);
    void updateVoteType(VoteType voteType);
    List<VoteType> listVoteType();
    VoteType getVoteTypeById(int id);
    //VoteType getVoteTypeByName(String name);
    void removeVoteType(int id);
}
