package multimif.vote.modele;

import java.io.Serializable;
import java.util.HashMap;

public class MemberVotePK implements Serializable {
    public int idVoteMemberVote;
    public int idMemberMemberVote;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

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
}
