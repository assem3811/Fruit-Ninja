package Model;

public class ObjFactory {


    public static  GameObject getShape (ObjectType type , int xPosition , int yPosition , int velocity ,int XMax) {


        switch (type) {

            case FRUIT:

                return new Fruit( xPosition, yPosition  ,velocity , XMax);

            case FatalBomb:

                return new FatalBomb(xPosition, yPosition  ,velocity);

            case DangerousBomb:

                return new DangerousBomb(xPosition, yPosition  ,velocity);

            case Special1:
                return new Special1( xPosition, yPosition  ,velocity , XMax);

            case Special2:
                return new Special2( xPosition, yPosition  ,velocity , XMax);


            default:
                throw new IllegalArgumentException(type.name());

        }
    }

}


