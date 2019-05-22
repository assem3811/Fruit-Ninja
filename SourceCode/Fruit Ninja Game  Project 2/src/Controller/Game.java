package Controller;

import Model.*;
import View.*;

import javax.naming.ldap.Control;

public class Game {

    private State state;
    private int score ;
    Bomb bomb;
    DangerousBomb dangerousBomb;
    FatalBomb fatalBomb;
    Fruit fruit;
    ObjectType objectType;
    ObjFactory objFactory;
    Special1 special1;
    Special2 special2;
    FruitNinjaGame fruitNinjaGame;


    State resume ;
    State reset;
    State newGame  ;
    State defaultGame ;
    ObjectType type;

    private  Game ourInstance;

    public Game getInstance() {
        if (ourInstance == null)
            ourInstance = new Game();
        return ourInstance;
    }

    public Game(Bomb bomb, DangerousBomb dangerousBomb, FatalBomb fatalBomb, Fruit fruit, ObjectType objectType, ObjFactory objFactory, Special1 special1, Special2 special2, FruitNinjaGame fruitNinjaGame) {
        this.bomb = bomb;
        this.dangerousBomb = dangerousBomb;
        this.fatalBomb = fatalBomb;
        this.fruit = fruit;
        this.objectType = objectType;
        this.objFactory = objFactory;
        this.special1 = special1;
        this.special2 = special2;
        this.fruitNinjaGame = fruitNinjaGame;
    }

    public Game() {
        resume = new ResumeState(this);
        reset = new Reset (this);
        newGame = new NewGameState(this);
        defaultGame = new DefaultGameState(this) ;

        state = newGame ;

        if(score == 0)
        {
            state = reset ;
        }

    }

    public void setState(State newState) {
        newState  = state;

    }

    public void  scoreCount() {

        state.scoreCount(type);

    }



    public State ResumeState () { return resume; }

    public State Reset() { return  reset; }

    public State NewGame () { return  newGame; }

    public State DefaultGameState () { return defaultGame; }

}
