package id.ac.polinema.skorviewmodel.viewmodels;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import java.util.ArrayList;

import id.ac.polinema.skorviewmodel.fragments.ScoreFragment;
import id.ac.polinema.skorviewmodel.fragments.ScoreFragmentDirections;
import id.ac.polinema.skorviewmodel.models.GoalScorer;

public class ScoreViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<GoalScorer>> homeGoalScorerList =
            new MutableLiveData<>(new ArrayList<GoalScorer>());
    private final MutableLiveData<ArrayList<GoalScorer>> awayGoalScorerList =
            new MutableLiveData<>(new ArrayList<GoalScorer>());

    public int getHomeScore() {
        return homeGoalScorerList.getValue().size();
    }

    public int getAwayScore() {
        return awayGoalScorerList.getValue().size();
    }

    public void setGoalScorer(String team, GoalScorer goalScorer) {
        if (team.equals(ScoreFragment.HOME)) {
            homeGoalScorerList.getValue().add(goalScorer);
        } else {
            awayGoalScorerList.getValue().add(goalScorer);
        }
    }

    public void onAddHomeClick(View view) {
        ScoreFragmentDirections.GoalScorerAction action =
                ScoreFragmentDirections.goalScorerAction(ScoreFragment.HOME);
        Navigation.findNavController(view).navigate(action);
    }

    public void onAddAwayClick(View view) {
        Log.e("tests","sadsadasdsad");
        ScoreFragmentDirections.GoalScorerAction action =
                ScoreFragmentDirections.goalScorerAction(ScoreFragment.AWAY);
        Navigation.findNavController(view).navigate(action);
    }

    public String getHomeScorer() {
        String text = "";
        for (GoalScorer goalScorer : homeGoalScorerList.getValue()){
            text+=goalScorer.toString();
        }
        return text;
    }

    public String getAwayScorer() {
        String text = "";
        for (GoalScorer goalScorer : awayGoalScorerList.getValue()){
            text+=goalScorer.toString();
        }
        return text;
    }

}

