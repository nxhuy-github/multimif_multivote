package multimif.vote.dao;

import multimif.vote.modele.MemberVote;
import multimif.vote.modele.MemberVotePK;

import java.util.List;

public interface MemberVoteDAO {
    void addMemberVote(MemberVote MemberVote);
    void updateMemberVote(MemberVote MemberVote);
    List<MemberVote> listMemberVote();
    MemberVote getMemberVoteByIdMemberAndIdVote(MemberVotePK memberVotePK);
    void removeMemberVote(int id);
}
