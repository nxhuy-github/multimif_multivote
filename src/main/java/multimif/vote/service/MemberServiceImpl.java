package multimif.vote.service;

import multimif.vote.dao.MemberDAO;
import multimif.vote.dao.MemberDAOImpl;
import multimif.vote.modele.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberDAO memberDAO;

    public MemberServiceImpl(){
        memberDAO = new MemberDAOImpl();
    }

    @Transactional
    public void addMember(Member member) {
        memberDAO.addMember(member);
    }

    @Transactional
    public void updateMember(Member member) {
        memberDAO.updateMember(member);
    }

    @Transactional
    public List<Member> listMember() {
        return memberDAO.listMember();
    }

    @Transactional
    public Member getMemberById(int id) {
        return memberDAO.getMemberById(id);
    }

    @Transactional
    public void removeMember(int id) {
        memberDAO.removeMember(id);
    }

    @Transactional
    public Member getMemberByEmail(String email){
        return memberDAO.getMemberByEmail(email);
    }
}
