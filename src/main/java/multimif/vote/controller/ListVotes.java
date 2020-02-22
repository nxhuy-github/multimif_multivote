package multimif.vote.controller;

import multimif.vote.modele.Member;
import multimif.vote.modele.MemberVote;
import multimif.vote.modele.MemberVotePK;
import multimif.vote.modele.Vote;
import multimif.vote.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/listVotes")
@SessionAttributes({"member", "voteInProgress", "voteInHistory", "voteInFuture"})
public class ListVotes {
    private MemberService memberService = new MemberServiceImpl();

    private VoteService voteService = new VoteServiceImpl();

    private MemberVoteService memberVoteService = new MemberVoteServiceImpl();

    @ModelAttribute("member")
    public Member setUpMember(){
        return new Member();
    }

    @ModelAttribute("voteInProgress")
    public List<Vote> setUpVoteInProgress() { return new ArrayList<>();}

    @ModelAttribute("voteInHistory")
    public List<Vote> setUpVoteInHistory(){ return new ArrayList<>(); }

    @ModelAttribute("voteInFuture")
    public List<Vote> setUpVoteInFuture(){ return new ArrayList<>(); }

    @RequestMapping(method = RequestMethod.GET)
    public String listVote(@ModelAttribute(value = "mail")String email,
                           @ModelAttribute("member") Member member,
                           @ModelAttribute("voteInProgress") List<Vote> voteInProgress,
                           @ModelAttribute("voteInHistory") List<Vote> voteInHistory,
                           @ModelAttribute("voteInFuture") List<Vote> voteInFuture){
        if(member.getIdMember() == null){
            if(email.isEmpty()){
                return "login";
            }
            Member dummyMember = this.memberService.getMemberByEmail(email);

            member.setAddressMember(dummyMember.getAddressMember());
            member.setBirthdayMember(dummyMember.getBirthdayMember());
            member.setIdMember(dummyMember.getIdMember());
            member.setMailMember(dummyMember.getMailMember());
            member.setNameMember(dummyMember.getNameMember());
            member.setPasswordMember(dummyMember.getPasswordMember());

            System.out.println(member.toString());

            List<Vote> list = this.voteService.listVote();

            Date actual = new Date();
            Timestamp actualTimeStamp = new Timestamp(actual.getTime());
            boolean isFuture = false;
            boolean isHistory = false;

            for(Vote v : list){
                if(actualTimeStamp.before(v.getStartDateVote())){
                    voteInFuture.add(v);
                    isFuture = true;
                }
                if(actualTimeStamp.after(v.getEndDateVote())){
                    voteInHistory.add(v);
                    isHistory = true;
                }
                MemberVotePK memberVotePK = new MemberVotePK();
                memberVotePK.setIdMemberMemberVote(member.getIdMember());
                memberVotePK.setIdVoteMemberVote(v.getIdVote());
                MemberVote memberVote = this.memberVoteService.getMemberVoteByIdMemberAndIdVote(memberVotePK);
                if(memberVote != null){
                    voteInHistory.add(v);
                }
                if(memberVote == null && !isFuture && !isHistory){
                    voteInProgress.add(v);
                }
                isFuture = isHistory = false;
            }
        }
        return "votes_list";
    }
}
