package Controller;

public class Hard implements GameActions {

    private int fruitCount=100;
    private int bombCount=50;
    private int specialFruitCount=20;


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
