package multimif.vote.modele;

import javax.persistence.*;

/**
 * creation of MajoritarianRepresentation class
 */
@Entity
@Table(name = "MAJORITARIANREPRESENTATION")
public class MajoritarianRepresentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDMAJORITARIANREPRESENTATION")
    private int idMajoritarianRepresentation;

    @Column(name = "FK_IDVOTEMAJORITARIANREPRESENTATION")
    private int idVoteMajoritarianRepresentation;

    public int getIdVoteMajoritarianRepresentation() {
        return idVoteMajoritarianRepresentation;
    }

    public void setIdVoteMajoritarianRepresentation(int idVoteMajoritarianRepresentation) {
        this.idVoteMajoritarianRepresentation = idVoteMajoritarianRepresentation;
    }

    public int getIdMajoritarianRepresentation() {
        return idMajoritarianRepresentation;
    }

    public void setIdMajoritarianRepresentation(int idMajoritarianRepresentation) {
        this.idMajoritarianRepresentation = idMajoritarianRepresentation;
    }
}
