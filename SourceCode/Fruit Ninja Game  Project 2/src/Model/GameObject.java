package Model;


public interface GameObject {
    public ObjectType getObjectType();

    public int getXPosition();

    public int getYPosition();

    public int getMaxXPosition();

    public double getFallingVelocity();

    public Boolean isSliced();

    public Boolean hasMovedOffScreen();

    public void slice();

    public void move(double time);

}
