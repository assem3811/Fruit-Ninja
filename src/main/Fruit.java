package main;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.image.BufferedImage;

public class Fruit implements GameObject {

    private int xPosition;
    private int yPosition;


    Fruit(int xPosition, int yPosition) {
        this.yPosition = yPosition;
        this.xPosition = xPosition;
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

    public int getYPosition() {

        return yPosition;
    }

    @Override
    public int getMaxHeight() {
        return 0;
    }

    @Override
    public int getInitialVelocity() {
        return 0;
    }

    @Override
    public int getFallingVelocity() {
        return 0;
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
        double velocity  ;
        yPosition = velocity * time ;

    }

    @Override
    public BufferedImage[] getBufferedImages() {
        throw new NotImplementedException();
    }
}
