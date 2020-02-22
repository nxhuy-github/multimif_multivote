package multimif.vote.service;

import multimif.vote.modele.MajoritarianRepresentation;

import java.util.List;

public interface MajoritarianRepresentationService {
    void addMajoritarianRepresentation(MajoritarianRepresentation majoritarianRepresentation);
    void updateMajoritarianRepresentation(MajoritarianRepresentation majoritarianRepresentation);
    List<MajoritarianRepresentation> listMajoritarianRepresentation();
    MajoritarianRepresentation getVoteMajoritarianRepresentationById(int id);
    void removeMajoritarianRepresentation(int id);
}
