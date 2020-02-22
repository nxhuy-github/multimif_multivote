package multimif.vote.service;

import multimif.vote.modele.MemberVote;
import multimif.vote.modele.MemberVotePK;

import java.util.List;

public interface MemberVoteService {
    void addMemberVote(MemberVote MemberVote);
    void updateMemberVote(MemberVote MemberVote);
    List<MemberVote> listMemberVote();
    MemberVote getMemberVoteByIdMemberAndIdVote(MemberVotePK memberVotePK);
    void removeMemberVote(int id);
}
