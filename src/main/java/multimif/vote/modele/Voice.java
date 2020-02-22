package multimif.vote.modele;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Creation of Voice class
 */
@Entity
@Table(name = "VOICE")
public class Voice  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVoice;

    @Column(name = "TURNVOICE")
    private int turnVoice;

    @ManyToOne
    @JoinColumn(name = "FK_IDVOTEVOICE")
    private Vote idVoteVoice;
//
//    @OneToMany(mappedBy = "idVoteVoteOption", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
////    @JoinColumn(name = "FK_IDVOICEVOICEVOTEOPTION" )
//    private Collection<VoiceVoteOption> voiceVoteOptions;

    @Column(name = "KEYVOICE")
    private String keyVoice;

    public int getIdVoice() {
        return idVoice;
    }

    public void setIdVoice(int idVoice) {
        this.idVoice = idVoice;
    }

    public int getTurnVoice() {
        return turnVoice;
    }

    public void setTurnVoice(int turnVoice) {
        this.turnVoice = turnVoice;
    }

    public Vote getIdVoteVoice() {
        return idVoteVoice;
    }

    public void setIdVoteVoice(Vote idVoteVoice) {
        this.idVoteVoice = idVoteVoice;
    }

    public String getKeyVoice() {
        return keyVoice;
    }

    public void setKeyVoice(String keyVoice) {
        this.keyVoice = keyVoice;
    }

//    public Collection<VoiceVoteOption> getVoiceVoteOptions() {
//        return voiceVoteOptions;
//    }
//
//    public void setVoiceVoteOptions(Collection<VoiceVoteOption> voiceVoteOptions) {
//        this.voiceVoteOptions = voiceVoteOptions;
//    }
}
