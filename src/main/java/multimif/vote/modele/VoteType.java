package multimif.vote.modele;

import javax.persistence.*;

/**
 * Creation of VoteType class
 */
@Entity
@Table(name = "VOTETYPE")
public class VoteType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDVOTETYPE")
    private int idVoteType;

    @Column(name = "NAMEVOTETYPE")
    private String nameVoteType;

    @Column(name = "TURNCOUNTVOTETYPE")
    private int turnCountVoteType;

    /**
     * get idVoteType
     * @return idVoteType
     */
    public int getIdVoteType() {
        return idVoteType;
    }

    /**
     * set idVoteType
     * @param idVoteType
     */
    public void setIdVoteType(int idVoteType) {
        this.idVoteType = idVoteType;
    }

    /**
     * get nameVoteType
     * @return nameVoteType
     */
    public String getNameVoteType() {
        return nameVoteType;
    }

    /**
     * set nameVoteType
     * @param nameVoteType
     */
    public void setNameVoteType(String nameVoteType) {
        this.nameVoteType = nameVoteType;
    }

    /**
     * get turnCountVoteType
     * @return turnCountVoteType
     */
    public int getTurnCountVoteType() {
        return turnCountVoteType;
    }

    /**
     * set turnCountVoteType
     * @param turnCountVoteType
     */
    public void setTurnCountVoteType(int turnCountVoteType) {
        this.turnCountVoteType = turnCountVoteType;
    }
}
