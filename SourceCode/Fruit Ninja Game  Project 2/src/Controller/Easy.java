package Controller;

public class Easy implements GameActions{

    private int fruitCount=50;
    private int bombCount=5;
    private int specialFruitCount=10;



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

