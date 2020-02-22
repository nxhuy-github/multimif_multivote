package multimif.vote.modele;

import javax.persistence.*;

/**
 * Creation of MemberVote class
 */
@Entity
@IdClass(MemberVotePK.class)
@Table(name = "MEMBERVOTE")
public class MemberVote {

    @Id
    @Column(name="FK_IDVOTEMEMBERVOTE")
    private int idVoteMemberVote;

    @Id
    @Column(name="FK_IDMEMBERMEMBERVOTE")
    private int idMemberMemberVote;

    public int getIdVoteMemberVote() {
        return idVoteMemberVote;
    }

    public void setIdVoteMemberVote(int idVoteMemberVote) {
        this.idVoteMemberVote = idVoteMemberVote;
    }

    public int getIdMemberMemberVote() {
        return idMemberMemberVote;
    }

    public void setIdMemberMemberVote(int idMemberMemberVote) {
        this.idMemberMemberVote = idMemberMemberVote;
    }

    public int getCurrentTurnMemberVote() {
        return currentTurnMemberVote;
    }

    public void setCurrentTurnMemberVote(int currentTurnMemberVote) {
        this.currentTurnMemberVote = currentTurnMemberVote;
    }

    @Column(name = "CURRENTTURNMEMBERVOTE")
    private int currentTurnMemberVote;


}
