package multimif.vote.controller;

import multimif.vote.modele.*;
import multimif.vote.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping(value = "/votes")
public class DoVote {
    private Vote vote;
    private List<VoteOption> voteOptions;
    private ModelAndView modelAndView;

    private VoteService voteService = new VoteServiceImpl();

    private VoiceService voiceService = new VoiceServiceImpl();

    private MemberVoteService memberVoteService = new MemberVoteServiceImpl();

    private VoiceVoteOptionService voiceVoteOptionService = new VoiceVoteOptionServiceImpl();

    private VoteOptionService voteOptionService = new VoteOptionServiceImpl();

    @RequestMapping(value = "/vote/{id}", method = RequestMethod.GET)
    public ModelAndView voteInfo(@PathVariable("id") int id,
                                 @SessionAttribute("voteInProgress") List<Vote> voteInProgress,
                                 @SessionAttribute("voteInHistory") List<Vote> voteInHistory,
                                 @SessionAttribute("voteInFuture") List<Vote> voteInFuture) {

        modelAndView = new ModelAndView("vote_consult");
        vote = this.voteService.getVoteById(id);
        voteOptions = (List<VoteOption>) vote.getVoteOptions();

        if (voteInHistory.contains(vote)) {
            modelAndView.addObject("isInHistory", true);
        }
        if (voteInFuture.contains(vote)) {
            modelAndView.addObject("isInFuture", true);
        }
        if (voteInProgress.contains(vote)) {
            modelAndView.addObject("isInProgress", true);
        }
        modelAndView.addObject("vote", vote);
        modelAndView.addObject("voteChoices", voteOptions);
        return modelAndView;
    }

    @RequestMapping(value = "/vote/dovote", method = RequestMethod.POST)
    public ModelAndView doVote() {
        modelAndView = new ModelAndView("vote");
        modelAndView.addObject("vote", vote);
        modelAndView.addObject("voteChoices", voteOptions);
        return modelAndView;
    }

    @RequestMapping(value = "/vote/confirm", method = RequestMethod.POST)
    public ModelAndView confirmVote(@SessionAttribute("member") Member member,
                                    @SessionAttribute("voteInProgress") List<Vote> voteInProgress,
                                    @SessionAttribute("voteInHistory") List<Vote> voteInHistory,
                                    @RequestParam("idVoteOption")int idVoteOption) {
        modelAndView = new ModelAndView("vote_confirm");
        VoteOption voteOption = this.voteOptionService.getVoteOptionById(idVoteOption);

        MemberVote memberVote = new MemberVote();
        memberVote.setIdMemberMemberVote(member.getIdMember());
        memberVote.setIdVoteMemberVote(vote.getIdVote());
        memberVote.setCurrentTurnMemberVote(vote.getCurrentTurnVote());
        memberVoteService.addMemberVote(memberVote);

        voteInHistory.add(vote);
        voteInProgress.remove(vote);

        SecretKey secretKey;
        String encodedKey;
        Voice voice = new Voice();
        VoiceVoteOption voiceVoteOption = new VoiceVoteOption();
        try {
            secretKey = KeyGenerator.getInstance("AES").generateKey();
            encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            modelAndView.addObject("secretKey", encodedKey);
            System.out.println(encodedKey);

            voice.setIdVoteVoice(vote);
            voice.setKeyVoice(encodedKey);
            voice.setTurnVoice(vote.getCurrentTurnVote());
            voiceService.addVoice(voice);
//            for (VoteOption vO : vote.getVoteOptions()) {
//                voiceVoteOption.setIdVoteOptionVoiceVoteOption(vO.getIdVoteOption());
//                voiceVoteOption.setIdVoiceVoiceVoteOption(voice.getIdVoice());
//                voiceVoteOption.setDataVoiceVoteOption(vO.getNameVoteOption());
//                voiceVoteOptionService.addVoiceVoteOption(voiceVoteOption);
//            }
            voiceVoteOption.setIdVoteOptionVoiceVoteOption(voteOption.getIdVoteOption());
            voiceVoteOption.setIdVoiceVoiceVoteOption(voice.getIdVoice());
            voiceVoteOption.setDataVoiceVoteOption(voteOption.getNameVoteOption());
            voiceVoteOptionService.addVoiceVoteOption(voiceVoteOption);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

}
