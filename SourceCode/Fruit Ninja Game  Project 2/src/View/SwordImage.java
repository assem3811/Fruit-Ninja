package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SwordImage {



    public ImageView sword() {

        ImageView imv3 = new ImageView();
        Image image3 = new Image("View/Images/sword11.png",true);
        imv3.setImage(image3);
        //imv3.setLayoutX(rand(40,120));
        imv3.setFitWidth(150);
        imv3.setFitHeight(150);
        return imv3;
    }


}
