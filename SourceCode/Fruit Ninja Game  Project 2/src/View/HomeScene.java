package View;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import Controller.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import Model.*;

public class HomeScene {

    private Scene scene ;
    private AnchorPane anchorPane = new AnchorPane();
    private Stage window;
    private FirstScene firstScene;
    private Level1Scene level1Scene;
    private Level2Scene level2Scene;
    private Level3Scene level3Scene;
    private int scored;
    private Game game = new Game();


    HomeScene(Stage stage)
    {
        this.window=stage;
    }

    public void prepareScene() throws FileNotFoundException {

        scene = new Scene(anchorPane,1023,637);

        FileInputStream input = new FileInputStream("E:\\Fruit Ninja Game  Project 2\\src\\View\\Images\\groundedit.png");
        Image image = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);


        final ImageView imv1 = new ImageView();
        final Image image1 = new Image("View/Images/logo.png",true);
        imv1.setImage(image1);
        imv1.setFitHeight(250);
        imv1.setFitWidth(600);
        imv1.setLayoutY(0);
        imv1.setLayoutX(200);


        final ImageView imv2 = new ImageView();
        final Image image2 = new Image("View/Images/back.png",true);
        imv2.setImage(image2);
        imv2.setFitHeight(60);
        imv2.setFitWidth(60);
        imv2.setLayoutY(550);
        imv2.setLayoutX(300);
        imv2.setOnMouseClicked(e->window.setScene(firstScene.getScene()));


        final ImageView imv3 = new ImageView();
        final Image image3 = new Image("View/Images/easy.png",true);
        imv3.setImage(image3);
        imv3.setFitHeight(75);
        imv3.setFitWidth(230);
        imv3.setLayoutY(333);
        imv3.setLayoutX(100);
        imv3.setOnMouseClicked(e->{
            window.setScene(level1Scene.getScene());
            level1Scene.timeline1.playFromStart();
            level1Scene.timeline2.playFromStart();
            level1Scene.timeline3.playFromStart();
            level1Scene.timeline4.playFromStart();
            level1Scene.timeline5.playFromStart();
            level1Scene.timeline6.playFromStart();
            level1Scene.timeline7.playFromStart();
            level1Scene.timer.start();
            level1Scene.timer1.start();
            level1Scene.imv3.setVisible(true);
            level1Scene.imv4.setVisible(true);
            level1Scene.imv5.setVisible(true);
            try {
                level1Scene.prepareScene();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            scored=0;
            game.DefaultGameState().setScore(scored);

        });


        final ImageView imv4 = new ImageView();
        final Image image4 = new Image("View/Images/medium.png",true);
        imv4.setImage(image4);
        imv4.setFitHeight(100);
        imv4.setFitWidth(233);
        imv4.setLayoutY(320);
        imv4.setLayoutX(400);
        imv4.setOnMouseClicked(e->
        {
            window.setScene(level2Scene.getScene());
            level2Scene.timeline1.playFromStart();
            level2Scene.timeline2.playFromStart();
            level2Scene.timeline3.playFromStart();
            level2Scene.timeline4.playFromStart();
            level2Scene.timeline5.playFromStart();
            level2Scene.timeline6.playFromStart();
            level2Scene.timeline7.playFromStart();
            level2Scene.timeline8.playFromStart();
            level2Scene.timer.start();
            level2Scene.timer1.start();
            level2Scene.imv3.setVisible(true);
            level2Scene.imv4.setVisible(true);
            level2Scene.imv5.setVisible(true);
            try {
               level2Scene.prepareScene();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            scored=0;
            game.DefaultGameState().setScore(scored);
        });


        final ImageView imv5 = new ImageView();
        final Image image5 = new Image("View/Images/hard.png",true);
        imv5.setImage(image5);
        imv5.setFitHeight(109);
        imv5.setFitWidth(230);
        imv5.setLayoutY(320);
        imv5.setLayoutX(700);
        imv5.setOnMouseClicked(e->{
            window.setScene(level3Scene.getScene());
            level3Scene.timeline1.playFromStart();
            level3Scene.timeline2.playFromStart();
            level3Scene.timeline3.playFromStart();
            level3Scene.timeline4.playFromStart();
            level3Scene.timeline5.playFromStart();
            level3Scene.timeline6.playFromStart();
            level3Scene.timeline7.playFromStart();
            level3Scene.timeline8.playFromStart();
            level3Scene.timeline10.playFromStart();
            level3Scene.timer.start();
            level3Scene.timer1.start();
            level3Scene.imv3.setVisible(true);
            level3Scene.imv4.setVisible(true);
            level3Scene.imv5.setVisible(true);
            try {
                level3Scene.prepareScene();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            scored=0;
            game.DefaultGameState().setScore(scored);
        });


        anchorPane.setBackground(background);
        anchorPane.getChildren().addAll(imv1,imv2,imv3,imv4,imv5);

    }

    public Scene getScene()
    {
        return this.scene;
    }

    public void setFirstScene(FirstScene firstScene) {
        this.firstScene = firstScene;
    }

    public void setLevel1Scene(Level1Scene level1Scene) {
        this.level1Scene = level1Scene;
    }

    public void setLevel2Scene(Level2Scene level2Scene) {
        this.level2Scene = level2Scene;
    }

    public void setLevel3Scene(Level3Scene level3Scene) {
        this.level3Scene = level3Scene;
    }
}
