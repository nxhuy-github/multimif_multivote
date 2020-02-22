package multimif.vote.modele;


import javax.persistence.*;
import java.io.Serializable;


/**
 * Creation of Member class
 */
@Entity
@Table(name = "MEMBER")
public class Member implements Serializable {
    @Override
    public String toString() {
        return "Member{" +
                "idMember=" + idMember +
                ", mailMember='" + mailMember + '\'' +
                ", passwordMember='" + passwordMember + '\'' +
                ", nameMember='" + nameMember + '\'' +
                ", birthdayMember='" + birthdayMember + '\'' +
                ", addressMember='" + addressMember + '\'' +
                ", enabledMember=" + enabledMember + '\'' +
                ", idRoleMember=" + idRoleMember +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMember;

    @Column(name = "MAILMEMBER")
    private String mailMember;

    @Column(name = "PASSWORDMEMBER")
    private String passwordMember;

    @Column(name = "NAMEMEMBER")
    private String nameMember;

    @Column(name = "BIRTHDAYMEMBER")
    private String birthdayMember;

    @Column(name = "ADDRESSMEMBER")
    private String addressMember;

    @Column(name = "ENABLEDMEMBER")
    private int enabledMember;

    @Column(name = "FK_IDROLEMEMBER")
    private int idRoleMember;

    public int getIdRoleMember() {
        return idRoleMember;
    }

    public void setIdRoleMember(int idRoleMember) {
        this.idRoleMember = idRoleMember;
    }

    /**
     * get idMember
     * @return idMember
     */
    public Integer getIdMember() {
        return idMember;
    }

    /**
     * set idMember
     * @param idMember
     */
    public void setIdMember(Integer idMember) {
        this.idMember = idMember;
    }

    /**
     * get mailMember
     * @return mailMember
     */
    public String getMailMember() {
        return mailMember;
    }

    /**
     * set mailMember
     * @param mailMember
     */
    public void setMailMember(String mailMember) {
        this.mailMember = mailMember;
    }

    /**
     * get passwordMember
     * @return passwordMember
     */
    public String getPasswordMember() {
        return passwordMember;
    }

    /**
     * set passwordMember
     * @param passwordMember
     */
    public void setPasswordMember(String passwordMember) {
        this.passwordMember = passwordMember;
    }

    /**
     * get nameMember
     * @return nameMember
     */
    public String getNameMember() {
        return nameMember;
    }

    /**
     * set nameMember
     * @param nameMember
     */
    public void setNameMember(String nameMember) {
        this.nameMember = nameMember;
    }

    /**
     * get birthdayMember
     * @return birthdayMember
     */
    public String getBirthdayMember() {
        return birthdayMember;
    }

    /**
     * set birthdayMember
     * @param birthdayMember
     */
    public void setBirthdayMember(String birthdayMember) {
        this.birthdayMember = birthdayMember;
    }

    /**
     * get addressMember
     * @return addressMember
     */
    public String getAddressMember() {
        return addressMember;
    }

    /**
     * set addressMember
     * @param addressMember
     */
    public void setAddressMember(String addressMember) {
        this.addressMember = addressMember;
    }

    public int getEnabledMember() {
        return enabledMember;
    }

    public void setEnabledMember(int enabledMember) {
        this.enabledMember = enabledMember;
    }
}




