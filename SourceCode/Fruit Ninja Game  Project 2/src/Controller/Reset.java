package Controller;

import Model.ObjectType;

public class Reset implements State {

    Game FruitNinja ;
    private int Score ;


    public Reset(Game game) {
        FruitNinja =  game ;
    }


    @Override
    public int scoreCount(ObjectType type) {
        return Score=0;
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
