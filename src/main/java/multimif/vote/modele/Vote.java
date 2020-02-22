package multimif.vote.modele;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "VOTE")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDVOTE")
    private Integer idVote;

    @Column(name = "NAMEVOTE")
    private String nameVote;

    @Column(name = "DESCRIPTIONVOTE")
    private String descriptionVote;

    @Column(name = "ISPUBLICVOTE")
    private boolean isPublicVote;

    @Column(name = "STARTDATEVOTE")
    private Timestamp startDateVote;

    @Column(name = "ENDDATEVOTE")
    private Timestamp endDateVote;

    @Column(name = "CURRENTTURNVOTE")
    private int currentTurnVote;

    @OneToOne
    @JoinColumn(name = "FK_IDOWNERVOTE")
    private Member idOwnerVote;

    @ManyToOne
    @JoinColumn(name = "FK_IDVOTETYPEVOTE")
    private VoteType idVoteVoteType;

    @OneToMany(mappedBy = "idVoteVoteOption", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Collection<VoteOption> voteOptions;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "votes")
//    Collection<Member> members;

    public Collection<VoteOption> getVoteOptions() {
        return voteOptions;
    }

    public void setVoteOptions(Collection<VoteOption> voteOptions) {
        this.voteOptions = voteOptions;
    }


    public VoteType getIdVoteVoteType() {
        return idVoteVoteType;
    }

    public void setIdVoteVoteType(VoteType idVoteVoteType) {
        this.idVoteVoteType = idVoteVoteType;
    }

    /**
     * get idVote
     * @return idVote
     */
    public Integer getIdVote() {
        return idVote;
    }

    /**
     * set idVote
     * @param idVote
     */
    public void setIdVote(Integer idVote) {
        this.idVote = idVote;
    }

    /**
     * get nameVote
     * @return nameVote
     */
    public String getNameVote() {
        return nameVote;
    }

    /**
     * set voteName
     * @param nameVote
     */
    public void setNameVote(String nameVote) {
        this.nameVote = nameVote;
    }

    /**
     * get descriptionVote
     * @return descriptionVote
     */
    public String getDescriptionVote() {
        return descriptionVote;
    }

    /**
     * set descriptionVote
     * @param descriptionVote
     */
    public void setDescriptionVote(String descriptionVote) {
        this.descriptionVote = descriptionVote;
    }

    /**
     * get PublicVote
     * @return  isPublicVote
     */
    public boolean isPublicVote() {
        return isPublicVote;
    }

    /**
     * set PublicVote
     * @param publicVote
     */
    public void setPublicVote(boolean publicVote) {
        isPublicVote = publicVote;
    }

    /**
     * get startDateVote
     * @return startDateVote
     */
    public Timestamp getStartDateVote() {
        return startDateVote;
    }

    /**
     * set startDateVote
     * @param startDateVote
     */
    public void setStartDateVote(Timestamp startDateVote) {
        this.startDateVote = startDateVote;
    }

    /**
     * get endDateVote
     * @return endDateVote
     */
    public Timestamp getEndDateVote() {
        return endDateVote;
    }

    /**
     * set endDateVote
     * @param endDateVote
     */
    public void setEndDateVote(Timestamp endDateVote) {
        this.endDateVote = endDateVote;
    }

    /**
     * get currentTurnVote
     * @return currentTurnVote
     */
    public int getCurrentTurnVote() {
        return currentTurnVote;
    }

    /**
     * set currentTurnVote
     * @param currentTurnVote
     */
    public void setCurrentTurnVote(int currentTurnVote) {
        this.currentTurnVote = currentTurnVote;
    }

    public Member getIdOwnerVote() {
        return idOwnerVote;
    }

    public void setIdOwnerVote(Member idOwnerVote) {
        this.idOwnerVote = idOwnerVote;
    }
}
