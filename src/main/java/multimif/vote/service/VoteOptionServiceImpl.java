package multimif.vote.service;

import multimif.vote.dao.VoteOptionDAO;
import multimif.vote.dao.VoteOptionDAOImpl;
import multimif.vote.modele.VoteOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoteOptionServiceImpl implements VoteOptionService {
    private VoteOptionDAO voteOptionDAO;

    public VoteOptionServiceImpl(){
        voteOptionDAO = new VoteOptionDAOImpl();
    }

    @Transactional
    public void setVoteOptionDAO(VoteOptionDAO voteOptionDAO) {
        this.voteOptionDAO = voteOptionDAO;
    }

    @Transactional
    public void addVoteOption(VoteOption voteOption) {
        this.voteOptionDAO.addVoteOption(voteOption);
    }

    @Transactional
    public void updateVoteOption(VoteOption voteOption) {
        this.voteOptionDAO.updateVoteOption(voteOption);
    }

    @Transactional
    public List<VoteOption> listVoteOption() {
        return this.voteOptionDAO.listVoteOption();
    }

    @Transactional
    public VoteOption getVoteOptionById(int id) {
        return this.voteOptionDAO.getVoteOptionById(id);
    }

    @Transactional
    public List<VoteOption> getVoteOptionByIdVote(int idVote) {
        return this.voteOptionDAO.getVoteOptionByIdVote(idVote);
    }

    @Transactional
    public void removeVoteOption(int id) {
        this.voteOptionDAO.removeVoteOption(id);
    }
}
