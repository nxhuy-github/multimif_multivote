package multimif.vote.controller;
import multimif.vote.modele.Member;
import multimif.vote.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/login")
public class LogIn {
    private MemberService memberService = new MemberServiceImpl();

    @RequestMapping(method = RequestMethod.POST)
    public String logIn(@RequestParam(value = "mailMember") String email,
                        @RequestParam(value = "passwordMember") String pass,
                        RedirectAttributes ra)  {
        if(email != null && pass != null){
            Member dummyMember = this.memberService.getMemberByEmail(email);
            if(dummyMember.getPasswordMember().equals(pass)){
                ra.addFlashAttribute("mail", email);
                return "redirect:/listVotes";
            }else{
                return "login";
            }
        }else{
            return "login";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listVote(@ModelAttribute("member") Member member){
        return "login";
    }
}
