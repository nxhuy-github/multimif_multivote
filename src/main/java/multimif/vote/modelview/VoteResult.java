package multimif.vote.modelview;

import java.util.ArrayList;
import java.util.HashMap;

public class VoteResult {
    private ArrayList<String> names;
    private ArrayList<Integer> scores;

    private HashMap<String, Integer> dict;

    public VoteResult() {
        names = new ArrayList<>();
        scores = new ArrayList<>();
        setDict(new HashMap<>());
    }


    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    public HashMap<String, Integer> getDict() {
        return dict;
    }

    public void setDict(HashMap<String, Integer> dict) {
        this.dict = dict;
    }
}
