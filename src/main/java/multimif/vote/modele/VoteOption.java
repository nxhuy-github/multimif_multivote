package multimif.vote.modele;

import javax.persistence.*;
import java.util.Collection;

/**
 * Creation of VoteOption class
 */
@Entity
@Table(name = "VOTEOPTION")
public class VoteOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDVOTEOPTION")
    private int idVoteOption;

    @Column(name = "NAMEVOTEOPTION")
    private String nameVoteOption;

    @Column(name = "DESCRIPTIONVOTEOPTION")
    private String descriptionVoteOption;

    @Column(name = "CURRENTTURNVOTEOPTION")
    private int turnVoteOption;

    @ManyToOne
    @JoinColumn(name = "FK_IDVOTEVOTEOPTION")
    private Vote idVoteVoteOption;
//
//    @OneToMany(mappedBy = "voteOption")
//    private Collection<VoiceVoteOption> voiceVoteOptions;

    public int getIdVoteOption() {
        return idVoteOption;
    }

    public void setIdVoteOption(int idVoteOption) {
        this.idVoteOption = idVoteOption;
    }

    public String getNameVoteOption() {
        return nameVoteOption;
    }

    public void setNameVoteOption(String nameVoteOption) {
        this.nameVoteOption = nameVoteOption;
    }

    public String getDescriptionVoteOption() {
        return descriptionVoteOption;
    }

    public void setDescriptionVoteOption(String descriptionVoteOption) {
        this.descriptionVoteOption = descriptionVoteOption;
    }

    public int getTurnVoteOption() {
        return turnVoteOption;
    }

    public void setTurnVoteOption(int turnVoteOption) {
        this.turnVoteOption = turnVoteOption;
    }

    public Vote getIdVoteVoteOption() {
        return idVoteVoteOption;
    }

    public void setIdVoteVoteOption(Vote idVoteVoteOption) {
        this.idVoteVoteOption = idVoteVoteOption;
    }

//    public Collection<VoiceVoteOption> getVoiceVoteOptions() {
//        return voiceVoteOptions;
//    }
//
//    public void setVoiceVoteOptions(Collection<VoiceVoteOption> voiceVoteOptions) {
//        this.voiceVoteOptions = voiceVoteOptions;
//    }
}
