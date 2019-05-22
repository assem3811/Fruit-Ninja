package View;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class FirstScene  {

    private Sound sound=new Sound();
    private Command soundOnCommand =new SoundOnCommand(sound);
    private Command soundOffCommand =new SoundOffCommand(sound);
    private Control control =new Control();

    private Scene scene;
    private AnchorPane  anchorPane = new AnchorPane();
    private Stage window;
    private HomeScene homeScene;

    FirstScene(Stage stage)  {
        this.window = stage;
    }

    void prepareScene() throws FileNotFoundException {

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
        final Image image1 = new Image("View/Images/logo.png", true);
        imv1.setImage(image1);
        imv1.setFitHeight(250);
        imv1.setFitWidth(600);
        imv1.setLayoutY(0);
        imv1.setLayoutX(200);


        final ImageView imv2 = new ImageView();
        final Image image2 = new Image("View/Images/Watermelonfruit.png",true);
        imv2.setImage(image2);
        imv2.setFitHeight(100);
        imv2.setFitWidth(100);
        imv2.setLayoutY(400);
        imv2.setLayoutX(450);
        imv2.setOnMouseMoved(e->{
            window.setScene(homeScene.getScene());
            final Media media = new Media(new File("E:\\Fruit Ninja Game  Project 2\\src\\View\\Sound\\cut_fruit4.mp3").toURI().toString());
            final MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        });


        Timeline watermelonRotation = new Timeline(
                new KeyFrame(Duration.millis(10), e -> imv2.setRotate(imv2.getRotate() + 1))
        );

        watermelonRotation.setCycleCount(Timeline.INDEFINITE);
        watermelonRotation.play();



        Label start = new Label("Start");
        start.setTextFill(Color.web("lime"));
        start.setFont(new Font(30));
        start.setLayoutY(520);
        start.setLayoutX(475);


        control.SetCommand(soundOnCommand);
        control.PressOnButton();

        final  ImageView imv3 = new ImageView();
        final Image image3 = new Image("View/Images/sound.png",true);
        imv3.setImage(image3);
        imv3.setFitHeight(50);
        imv3.setFitWidth(50);
        imv3.setLayoutY(550);
        imv3.setLayoutX(20);


        final ImageView imv4 = new ImageView();
        final Image image4 = new Image("View/Images/soundOff.png",true);
        imv4.setImage(image4);
        imv4.setFitHeight(50);
        imv4.setFitWidth(50);
        imv4.setLayoutY(550);
        imv4.setLayoutX(20);
        imv4.setVisible(false);



        imv3.setOnMouseClicked(e->{
            imv4.setVisible(true);
            imv3.setVisible(false);
            control.SetCommand(soundOffCommand);
            control.PressOnButton();

        });

        imv4.setOnMouseClicked(e->{
            imv3.setVisible(true);
            imv4.setVisible(false);
            control.SetCommand(soundOnCommand);
            control.PressOnButton();

        });


        anchorPane.setBackground(background);
        anchorPane.getChildren().addAll(imv1,imv2,start,imv3,imv4);


    }


    Scene getScene()
    {
        return this.scene;
    }

    void setHomeScene(HomeScene homeScene) {
        this.homeScene = homeScene;
    }
}