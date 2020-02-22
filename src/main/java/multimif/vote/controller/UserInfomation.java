package multimif.vote.controller;

import multimif.vote.modele.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping(value = "/info")
public class UserInfomation {

    @RequestMapping(method = RequestMethod.GET)
    public String userInfo(@SessionAttribute("member") Member member) {
        System.out.println(member.getNameMember());
        System.out.println(member.getMailMember());
        System.out.println(member.getAddressMember());
        return "member_info";
    }
}
