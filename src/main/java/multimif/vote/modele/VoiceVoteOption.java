package multimif.vote.modele;

import javax.persistence.*;

@Entity
@IdClass(VoiceVoteOptionPK.class)
@Table(name = "VOICEVOTEOPTION")
public class VoiceVoteOption {
    @Id
    @Column(name = "FK_IDVOICEVOICEVOTEOPTION")
    private int idVoiceVoiceVoteOption;

    @Id
    @Column(name = "FK_IDVOTEOPTIONVOICEVOTEOPTION")
    private int idVoteOptionVoiceVoteOption;

    @Column(name = "DATAVOICEVOTEOPTION")
    private String dataVoiceVoteOption;
//
//    @ManyToOne
//    @JoinColumn(name="FK_IDVOTEOPTIONVOICEVOTEOPTION")
//    private VoteOption voteOption;

    public int getIdVoiceVoiceVoteOption() {
        return idVoiceVoiceVoteOption;
    }

    public void setIdVoiceVoiceVoteOption(int idVoiceVoiceVoteOption) {
        this.idVoiceVoiceVoteOption = idVoiceVoiceVoteOption;
    }

    public int getIdVoteOptionVoiceVoteOption() {
        return idVoteOptionVoiceVoteOption;
    }

    public void setIdVoteOptionVoiceVoteOption(int idVoteOptionVoiceVoteOption) {
        this.idVoteOptionVoiceVoteOption = idVoteOptionVoiceVoteOption;
    }

    public String getDataVoiceVoteOption() {
        return dataVoiceVoteOption;
    }

    public void setDataVoiceVoteOption(String dataVoiceVoteOption) {
        this.dataVoiceVoteOption = dataVoiceVoteOption;
    }

//    public VoteOption getVoteOption() {
//        return voteOption;
//    }
//
//    public void setVoteOption(VoteOption voteOption) {
//        this.voteOption = voteOption;
//    }
}
