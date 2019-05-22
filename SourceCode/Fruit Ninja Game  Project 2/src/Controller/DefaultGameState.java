package Controller;


import Model.ObjectType;

public class DefaultGameState implements State {


    Game FruitNinja ;

    private int Score =0 ;

    public DefaultGameState(Game game) {

        FruitNinja = game ;
    }

    @Override
    public int scoreCount(ObjectType type) {
        if(type.equals(ObjectType.Special1))
        {
            return Score+=10 ;
        }

        else if(type.equals(ObjectType.Special2)){

            return Score +=5 ;
        }
        else if(type.equals(ObjectType.FRUIT))
        {
            return Score+=1;
        }
        else
            return Score+=1 ;
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
