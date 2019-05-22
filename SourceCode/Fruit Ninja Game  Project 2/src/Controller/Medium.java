package Controller;

public class Medium implements  GameActions {


    private int fruitCount=70;
    private int bombCount=25;
    private int specialFruitCount=15;


    @Override
    public int getFruitCount() {
        return fruitCount;
    }


    @Override
    public int getSpecialFruitCount() {
        return specialFruitCount;
    }

    @Override
    public int getBombCount() {
        return bombCount;
    }
}
