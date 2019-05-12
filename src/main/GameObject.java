package main;

import java.awt.image.BufferedImage;


public interface GameObject {
    public ObjectType getObjectType();

    public int getXPosition();

    public int getYPosition();

    public int getMaxHeight();

    public int getInitialVelocity();

    public int getFallingVelocity();

    public Boolean isSliced();

    public Boolean hasMovedOffScreen();

    public void slice();

    public void move(double time);

    public BufferedImage[] getBufferedImages();
}
