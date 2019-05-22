package Model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Fruit implements GameObject {

    private int xPosition;
    private int yPosition;
    private double velocity;
    private  int XMax;


    public Fruit(int xPosition, int yPosition, double velocity, int XMax) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.velocity = velocity;
        this.XMax = XMax;
    }

    @Override
    public ObjectType getObjectType() {
        return ObjectType.FRUIT;
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
        return yPosition;
    }

    @Override
    public double getFallingVelocity() {
        return velocity;
    }

    @Override
    public Boolean isSliced() {
        /*if(slice())
        {

        }*/
        return  false;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return null;
    }

    @Override
    public void slice() {
        throw new NotImplementedException();
    }

    /*
    *it is used to move the object on the screen
    @param deltaTime: time elapsed since the object is thrown
    it is used calculate the new position of
    fruit object.
    */
    @Override
    public void move(double time) {

        xPosition =(int) velocity * (int)time ;

    }

}
