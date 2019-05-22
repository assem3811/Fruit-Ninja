package Model;

public class Bomb implements  GameObject {

    private int xPosition;
    private int XMax;
    private double velocity;


    public Bomb(int xPosition, int XMax, double velocity) {
        this.xPosition = xPosition;
        this.XMax = XMax;
        this.velocity = velocity;
    }

    @Override
    public ObjectType getObjectType() {
        return null;
    }

    @Override
    public int getXPosition() {
        return xPosition;
    }

    @Override
    public int getMaxXPosition() {
        return XMax;
    }

    @Override
    public int getYPosition() {
        return 0;
    }

    @Override
    public double getFallingVelocity() {
        return velocity;
    }

    @Override
    public Boolean isSliced() {
        return null;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return null;
    }

    @Override
    public void slice() {

    }

    @Override
    public void move(double time) {
        XMax = (int) velocity * (int) time ;
    }

}
