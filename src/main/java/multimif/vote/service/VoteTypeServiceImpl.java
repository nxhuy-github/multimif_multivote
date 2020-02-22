package multimif.vote.service;

import multimif.vote.dao.VoteTypeDAO;
import multimif.vote.dao.VoteTypeDAOImpl;
import multimif.vote.modele.VoteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoteTypeServiceImpl implements VoteTypeService {
    private VoteTypeDAO voteTypeDAO;

    public VoteTypeServiceImpl(){
        voteTypeDAO = new VoteTypeDAOImpl();
    }

    @Transactional
    public void addVoteType(VoteType voteType) {
        this.voteTypeDAO.addVoteType(voteType);
    }

    @Transactional
    public void updateVoteType(VoteType voteType) {
        this.voteTypeDAO.updateVoteType(voteType);
    }

    @Transactional
    public List<VoteType> listVoteType() {
        return this.voteTypeDAO.listVoteType();
    }

    @Transactional
    public VoteType getVoteTypeById(int id) {
        return this.voteTypeDAO.getVoteTypeById(id);
    }

    @Transactional
    public void removeVoteType(int id) {
        this.voteTypeDAO.removeVoteType(id);
    }
}
