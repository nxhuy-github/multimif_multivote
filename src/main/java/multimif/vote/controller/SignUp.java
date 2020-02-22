package multimif.vote.controller;

import multimif.vote.modele.Member;
import multimif.vote.service.MemberService;
import multimif.vote.service.MemberServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Controller
@RequestMapping(value="/signup")
public class SignUp {

    private MemberService memberService = new MemberServiceImpl();

    @InitBinder
    public void binder(WebDataBinder binder) {
        binder.registerCustomEditor(Timestamp.class, "birthdayMember", new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date parsedDate = dateFormat.parse(value);
                    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
                    setValue(timestamp);
                } catch (ParseException e) {
                    setValue(null);
                    e.printStackTrace();
                }
            }
        });
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView signUp(@ModelAttribute("member") Member member,
                               @RequestParam(value = "inputPasswordConfirm") String confirmPass,
                               @RequestParam(value = "mailMember") String email) {

        ModelAndView modelAndView;
        if(member.getPasswordMember().equals(confirmPass)){
            Member dummyMember = this.memberService.getMemberByEmail(email);
            if(dummyMember == null){
                member.setIdRoleMember(2);
                member.setEnabledMember(1);
                System.out.println(member.toString());
                this.memberService.addMember(member);

                modelAndView = new ModelAndView("login");
                modelAndView.addObject("message", "Congratulation, your inscription is successful");
                return modelAndView;
            }else{
                modelAndView = new ModelAndView("signup");
                return modelAndView;
            }
        }else{
            modelAndView = new ModelAndView("signup");
            return modelAndView;
        }
    }

}
