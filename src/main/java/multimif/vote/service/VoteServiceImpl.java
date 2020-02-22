package multimif.vote.service;

import multimif.vote.dao.VoteDAO;
import multimif.vote.dao.VoteDAOImpl;
import multimif.vote.modele.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {
    private VoteDAO voteDAO;

    public VoteServiceImpl(){
        voteDAO = new VoteDAOImpl();
    }

    @Transactional
    public void addVote(Vote vote) {
        this.voteDAO.addVote(vote);
    }

    @Transactional
    public void updateVote(Vote vote) {
        this.voteDAO.updateVote(vote);
    }

    @Transactional
    public List<Vote> listVote() {
        return this.voteDAO.listVote();
    }

    @Transactional
    public Vote getVoteById(int id) {
        return this.voteDAO.getVoteById(id);
    }

    @Transactional
    public void removeVote(int id) {
        this.voteDAO.removeVote(id);
    }
}
