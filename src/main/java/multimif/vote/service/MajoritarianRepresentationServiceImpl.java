package multimif.vote.service;

import multimif.vote.dao.MajoritarianRepresentationDAO;
import multimif.vote.dao.MajoritarianRepresentationDAOImpl;
import multimif.vote.modele.MajoritarianRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MajoritarianRepresentationServiceImpl implements MajoritarianRepresentationService{
    private MajoritarianRepresentationDAO majoritarianRepresentationDAO;

    public MajoritarianRepresentationServiceImpl(){
        majoritarianRepresentationDAO = new MajoritarianRepresentationDAOImpl();
    }

    @Transactional
    public void addMajoritarianRepresentation(MajoritarianRepresentation MajoritarianRepresentation) {
        majoritarianRepresentationDAO.addMajoritarianRepresentation(MajoritarianRepresentation);
    }

    @Transactional
    public void updateMajoritarianRepresentation(MajoritarianRepresentation MajoritarianRepresentation) {
        majoritarianRepresentationDAO.updateMajoritarianRepresentation(MajoritarianRepresentation);
    }

    @Transactional
    public List<MajoritarianRepresentation> listMajoritarianRepresentation() {
        return majoritarianRepresentationDAO.listMajoritarianRepresentation();
    }

    @Transactional
    public MajoritarianRepresentation getVoteMajoritarianRepresentationById(int id) {
        return majoritarianRepresentationDAO.getVoteMajoritarianRepresentationById(id);
    }

    @Transactional
    public void removeMajoritarianRepresentation(int id) {
        majoritarianRepresentationDAO.removeMajoritarianRepresentation(id);
    }

}
