package Controller;

import Model.ObjectType;

public class ResumeState implements State {
    Game FruitNinja ;
    private int Score ;


    public ResumeState(Game game) {
        FruitNinja = game ;
    }


    @Override
    public int scoreCount(ObjectType type) {
        return Score ;
    }

    @Override
    public int getScore() {
        return Score;
    }

    @Override
    public void setScore(int score) {
Score = score;
    }


}
