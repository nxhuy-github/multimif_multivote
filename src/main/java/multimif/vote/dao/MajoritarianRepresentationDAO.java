package multimif.vote.dao;

import multimif.vote.modele.MajoritarianRepresentation;

import java.util.List;

public interface MajoritarianRepresentationDAO {
    void addMajoritarianRepresentation(MajoritarianRepresentation majoritarianRepresentation);
    void updateMajoritarianRepresentation(MajoritarianRepresentation majoritarianRepresentation);
    List<MajoritarianRepresentation> listMajoritarianRepresentation();
    MajoritarianRepresentation getVoteMajoritarianRepresentationById(int id);
    void removeMajoritarianRepresentation(int id);
}
