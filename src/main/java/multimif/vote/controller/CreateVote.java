package multimif.vote.controller;

import multimif.vote.modele.Member;
import multimif.vote.modele.Vote;
import multimif.vote.modele.VoteOption;
import multimif.vote.modele.VoteType;
import multimif.vote.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/createvote")
public class CreateVote {
    private VoteTypeService voteTypeService = new VoteTypeServiceImpl();
    private VoteService voteService = new VoteServiceImpl();
    private VoteOptionService voteOptionService = new VoteOptionServiceImpl();

    @InitBinder
    public void binder(WebDataBinder binder){
        binder.registerCustomEditor(Timestamp.class, "startDateVote", new PropertyEditorSupport(){
            @Override
            public void setAsText(String value){
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
        binder.registerCustomEditor(Timestamp.class, "endDateVote", new PropertyEditorSupport(){
            @Override
            public void setAsText(String value){
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


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView goToCreateVote(){
        ModelAndView modelAndView;
        List<VoteType> listVoteType = this.voteTypeService.listVoteType();
        modelAndView = new ModelAndView("vote_create");
        modelAndView.addObject("voteTypes", listVoteType);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createVote(@ModelAttribute("vote") Vote vote,
                             HttpServletRequest request,
                             @SessionAttribute("member") Member member,
                             @SessionAttribute("voteInProgress") List<Vote> voteInProgress,
                             @SessionAttribute("voteInHistory") List<Vote> voteInHistory,
                             @SessionAttribute("voteInFuture") List<Vote> voteInFuture){
        String[] stringsName = request.getParameterValues("voteOptions.nameVoteOption");
        String[] stringsDesc = request.getParameterValues("voteOptions.descriptionVoteOption");
        int idVoteType = Integer.parseInt(request.getParameter("idVoteType"));
        Collection<VoteOption> voteOptions = new ArrayList<>();

        VoteType voteType = this.voteTypeService.getVoteTypeById(idVoteType);

        for(int i = 0; i < stringsName.length; i++){
            VoteOption voteOption = new VoteOption();

            voteOption.setNameVoteOption(stringsName[i]);
            voteOption.setDescriptionVoteOption(stringsDesc[i]);
            voteOption.setIdVoteVoteOption(vote);
            voteOption.setTurnVoteOption(1);

            voteOptions.add(voteOption);
        }
        vote.setVoteOptions(voteOptions);
        vote.setIdOwnerVote(member);
        vote.setIdVoteVoteType(voteType);
        this.voteService.addVote(vote);

        Date actual = new Date();
        Timestamp actualTimeStamp = new Timestamp(actual.getTime());
        if(actualTimeStamp.before(vote.getStartDateVote())){
            voteInFuture.add(vote);
        }else if(actualTimeStamp.after(vote.getEndDateVote())){
            voteInHistory.add(vote);
        }else{
            voteInProgress.add(vote);
        }
        return "votes_list";
    }
}
