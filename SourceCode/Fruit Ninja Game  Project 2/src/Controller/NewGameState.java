package Controller;

import Model.ObjectType;

public class NewGameState implements State {



    private int Score ;
    Game FruitNinja ;

    public NewGameState(Game game) {
        FruitNinja= game;
    }

    @Override
    public int scoreCount(ObjectType type) {
        return Score;
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
