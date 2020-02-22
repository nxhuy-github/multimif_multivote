package multimif.vote.controller;

import multimif.vote.modele.VoiceVoteOption;
import multimif.vote.modele.Vote;
import multimif.vote.modele.VoteOption;
import multimif.vote.modelview.VoteResult;
import multimif.vote.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ResultVote {

    private VoteOptionService  voteOptionService  = new VoteOptionServiceImpl();
    private VoiceVoteOptionService voiceVoteOptionService =  new VoiceVoteOptionServiceImpl();
    private VoteService voteService = new VoteServiceImpl();

    @RequestMapping(value = "/votes/{idVote}/result", method = RequestMethod.GET, produces = "application/json")
    public VoteResult getResultVote(@PathVariable(value = "idVote") int idVote) {
        System.out.println("Result Vote" + idVote);
        Vote                   vote        = voteService.getVoteById(idVote);
        Collection<VoteOption> voteOptions = vote.getVoteOptions();
        VoteResult             voteResult  = new VoteResult();
        for (VoteOption vo : voteOptions) {
            System.out.println("test " + vo.getIdVoteOption());
            List<VoiceVoteOption> voiceVoteOptions = voiceVoteOptionService.getListVoiceVoteOptions(vo.getIdVoteOption());
            voteResult.getNames().add(vo.getNameVoteOption());
            voteResult.getScores().add(voiceVoteOptions.size());
            voteResult.getDict().put(vo.getNameVoteOption(), voiceVoteOptions.size());

        }
        return voteResult;
    }
}
