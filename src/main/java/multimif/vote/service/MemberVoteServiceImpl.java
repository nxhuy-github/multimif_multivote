package multimif.vote.service;

import multimif.vote.dao.MemberVoteDAO;
import multimif.vote.dao.MemberVoteDAOImpl;
import multimif.vote.modele.MemberVote;
import multimif.vote.modele.MemberVotePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberVoteServiceImpl implements MemberVoteService {
    private MemberVoteDAO MemberVoteDAO;

    public MemberVoteServiceImpl(){
        MemberVoteDAO = new MemberVoteDAOImpl();
    }

    @Transactional
    public void addMemberVote(MemberVote MemberVote) {
        MemberVoteDAO.addMemberVote(MemberVote);
    }

    @Transactional
    public void updateMemberVote(MemberVote MemberVote) {
        MemberVoteDAO.updateMemberVote(MemberVote);
    }

    @Transactional
    public List<MemberVote> listMemberVote() {
        return MemberVoteDAO.listMemberVote();
    }

    @Transactional
    public MemberVote getMemberVoteByIdMemberAndIdVote(MemberVotePK memberVotePK) {
        return MemberVoteDAO.getMemberVoteByIdMemberAndIdVote(memberVotePK);
    }

    @Transactional
    public void removeMemberVote(int id) {
        MemberVoteDAO.removeMemberVote(id);
    }
}
