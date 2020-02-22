package multimif.vote.dao;

import multimif.vote.modele.Member;

import java.util.List;

public interface MemberDAO {
    void addMember(Member member);
    void updateMember(Member member);
    List<Member> listMember();
    Member getMemberById(int id);
    Member getMemberByEmail(String email);
    void removeMember(int id);
}
