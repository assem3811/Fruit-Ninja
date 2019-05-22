package View;

import Model.GameObject;
import Model.ObjFactory;
import Model.ObjectType;
import javafx.animation.AnimationTimer;
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
import Controller.*;
import Model.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Level1Scene {

    private Scene scene;
    private Stage window;
    private AnchorPane anchorPane = new AnchorPane();
    private HomeScene homeScene;
    AnimationTimer timer;
    AnimationTimer timer1;
    private ArrayList<ImageView> drop = new ArrayList<>();
    private ArrayList<ImageView> bombs = new ArrayList<>();
    private SwordImage swordImage = new SwordImage();
    Timeline timeline1;
    Timeline timeline2;
    Timeline timeline3;
    Timeline timeline4;
    Timeline timeline5;
    Timeline timeline6;
    Timeline timeline7;
    ImageView imv3;
    ImageView imv4;
    ImageView imv5;
    private ImageView gameOver;
    private ImageView exit;
    private ImageView play;
    private ImageView resume;
    private ImageView replay;
    private double mouseX;
    private double mousey;
    private ImageView cont;
    private double speed;
    private int missed;
    private int scored  = 0 ;
    private int fruitCount;
    private int bombCount;
    private int specialFruitCount;
    private Label lblScored;
    private Label BestScore;
    private Level1BestScore bestScore = new Level1BestScore();
    private Easy easy = new Easy();
    private Game game = new Game();
    private GameObject watermelonObj = ObjFactory.getShape(ObjectType.FRUIT,200,590 ,20000,700);
    private GameObject kiwiObj = ObjFactory.getShape(ObjectType.FRUIT,200,590,40000,700 );
    private GameObject specialFruit1Obj = ObjFactory.getShape(ObjectType.Special1,200,590,9050,700 );
    private GameObject orangeObj = ObjFactory.getShape(ObjectType.FRUIT,200,590,4550,700 );
    private GameObject specialFruit2Obj = ObjFactory.getShape(ObjectType.Special2, 200, 590, 7050,700 );
    private GameObject bomb2Obj  = ObjFactory.getShape(ObjectType.FatalBomb,200,590,6050,700 );
    private GameObject bomb1Obj = ObjFactory.getShape(ObjectType.DangerousBomb,200,590,5050,700 );


    public Level1Scene(Stage stage)
    {
        this.window = stage;
    }

    public void prepareScene() throws FileNotFoundException {

        missed = 0;
        speed = 1;


        scene = new Scene(anchorPane, 1023, 637);
        /*Image mouse =  new Image("View/Images/sword11.png",true);
        ImageView imageView =  new ImageView(mouse);
        ImageCursor cursor = new ImageCursor(mouse);
        scene.setCursor(new ImageCursor((Image)imageView,mouse.getWidth(),mouse.getHeight()));*/


        FileInputStream input = new FileInputStream("E:\\Fruit Ninja Game  Project 2\\src\\View\\Images\\groundedit.png");
        Image image = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);


        final ImageView imv1 = new ImageView();
        final Image image1 = new Image("View/Images/back.png",true);
        imv1.setImage(image1);
        imv1.setFitHeight(60);
        imv1.setFitWidth(60);
        imv1.setLayoutY(550);
        imv1.setLayoutX(70);
        imv1.setOnMouseClicked(e -> {
            window.setScene(homeScene.getScene());
            gameOver.setVisible(false);
            exit.setVisible(false);
            replay.setVisible(false);
            imv3.setVisible(true);
            imv4.setVisible(true);
            imv5.setVisible(true);
            resume.setDisable(false);
            resume.setVisible(true);
            play.setVisible(false);
            scored =0;
            game.DefaultGameState().setScore(scored);
            lblScored.setText("Score : " +game.DefaultGameState().getScore());
            BestScore.setText("Best Score : " +(bestScore.ReadFromFile().get(bestScore.ReadFromFile().size()-1)));
            bestScore.CompareBestScore(game.DefaultGameState().getScore());
            timeline1.stop();
            timeline2.stop();
            timeline3.stop();
            timeline4.stop();
            timeline5.stop();
            timeline6.stop();
            timeline7.stop();
            timer.stop();
            timer1.stop();

        });


        final ImageView imv2 = new ImageView();
        final Image image2 = new Image("View/Images/HalfWatermelonLogo.png",true);
        imv2.setImage(image2);
        imv2.setFitHeight(70);
        imv2.setFitWidth(70);
        imv2.setLayoutY(0);
        imv2.setLayoutX(0);


        imv3 = new ImageView();
        final Image image3 = new Image("View/Images/red.png",true);
        imv3.setImage(image3);
        imv3.setFitHeight(50);
        imv3.setFitWidth(50);
        imv3.setLayoutY(10);
        imv3.setLayoutX(852);
        imv3.setVisible(true);


        imv4 = new ImageView();
        final Image image4 = new Image("View/Images/red.png",true);
        imv4.setImage(image4);
        imv4.setFitHeight(60);
        imv4.setFitWidth(60);
        imv4.setLayoutY(10);
        imv4.setLayoutX(890);
        imv4.setVisible(true);


        imv5 = new ImageView();
        final Image image5 = new Image("View/Images/red.png",true);
        imv5.setImage(image5);
        imv5.setFitHeight(70);
        imv5.setFitWidth(70);
        imv5.setLayoutY(10);
        imv5.setLayoutX(930);
        imv5.setVisible(true);


        timeline1 = new Timeline(new KeyFrame(Duration.millis(orangeObj.getFallingVelocity()), event -> {
            speed += orangeObj.getFallingVelocity() / 400000;
            drop.add(orange());
            anchorPane.getChildren().add((drop.get(drop.size() - 1)));
        }));
        timeline1.setCycleCount(easy.getFruitCount());


        timeline2 = new Timeline(new KeyFrame(Duration.millis(kiwiObj.getFallingVelocity()), event -> {
            speed += kiwiObj.getFallingVelocity() / 400900;
            drop.add(kiwi());
            anchorPane.getChildren().add(( drop.get(drop.size() - 1)));
        }));
        timeline2.setCycleCount(easy.getFruitCount());


        timeline3 = new Timeline(new KeyFrame(Duration.millis(watermelonObj.getFallingVelocity()), event -> {
            speed += watermelonObj.getFallingVelocity() / 4002000;
            drop.add(watermelon());
            anchorPane.getChildren().add(( drop.get(drop.size() - 1)));
        }));
        timeline3.setCycleCount(easy.getFruitCount());


        timeline4 = new Timeline(new KeyFrame(Duration.millis(specialFruit1Obj.getFallingVelocity()), event -> {
            speed += specialFruit1Obj.getFallingVelocity() / 4090000;
            drop.add(specialFruit1());
            anchorPane.getChildren().add(( drop.get(drop.size() - 1)));
        }));
        timeline4.setCycleCount(easy.getSpecialFruitCount());


        timeline5 = new Timeline(new KeyFrame(Duration.millis(specialFruit2Obj.getFallingVelocity()), event -> {
            speed += specialFruit2Obj.getFallingVelocity() / 4006000;
            drop.add(specialFruit2());
            anchorPane.getChildren().add(( drop.get(drop.size() - 1)));
        }));
        timeline5.setCycleCount(easy.getSpecialFruitCount());



        timeline6 = new Timeline(new KeyFrame(Duration.millis(bomb1Obj.getFallingVelocity()), event -> {
            speed += bomb1Obj.getFallingVelocity() / 4005000;
            bombs.add(bomb1());
            anchorPane.getChildren().add(( bombs.get(bombs.size() - 1)));
        }));
        timeline6.setCycleCount(easy.getBombCount());


        timeline7 = new Timeline(new KeyFrame(Duration.millis(bomb2Obj.getFallingVelocity()), event -> {
            speed += bomb2Obj.getFallingVelocity() / 4005000;
            bombs.add(bomb2());
            anchorPane.getChildren().add(( bombs.get(bombs.size() - 1)));
        }));
        timeline7.setCycleCount(easy.getBombCount());


        gameOver = new ImageView();
        Image gameOverImage = new Image("View/Images/Game Over.png",true);
        gameOver.setImage(gameOverImage);
        gameOver.setFitHeight(400);
        gameOver.setFitWidth(800);
        gameOver.setLayoutY(100);
        gameOver.setLayoutX(100);
        gameOver.setVisible(false);


        exit = new ImageView();
        Image exitImage = new Image("View/Images/exit game.png",true);
        exit.setImage(exitImage);
        exit.setFitWidth(60);
        exit.setFitHeight(60);
        exit.setLayoutY(400);
        exit.setLayoutX(500);
        exit.setVisible(false);
        exit.setOnMouseClicked(e->System.exit(0));

        replay = new ImageView();
        Image replayImage = new Image("View/Images/repeat.png",true);
        replay.setImage(replayImage);
        replay.setFitWidth(60);
        replay.setFitHeight(60);
        replay.setLayoutY(400);
        replay.setLayoutX(400);
        replay.setVisible(false);
        replay.setOnMouseClicked(e->{
           gameOver.setVisible(false);
            exit.setVisible(false);
            replay.setVisible(false);
            imv3.setVisible(true);
            imv4.setVisible(true);
            imv5.setVisible(true);
            resume.setDisable(false);
            scored =0;
            game.DefaultGameState().setScore(scored);
            lblScored.setText("Score : " +game.DefaultGameState().getScore());
            BestScore.setText("Best Score : " +(bestScore.ReadFromFile().get(bestScore.ReadFromFile().size()-1)));
            bestScore.CompareBestScore(game.DefaultGameState().getScore());
            timeline1.playFromStart();
            timeline2.playFromStart();
            timeline3.playFromStart();
            timeline4.playFromStart();
            timeline5.playFromStart();
            timeline6.playFromStart();
            timeline7.playFromStart();
            timer.start();
            timer1.start();
            try {
                handelReply();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        resume = new ImageView();
        Image resumeImage = new Image("View/Images/pause.png",true);
        resume.setImage(resumeImage);
        resume.setFitWidth(60);
        resume.setFitHeight(60);
        resume.setLayoutY(550);
        resume.setLayoutX(150);
        resume.setVisible(true);
        resume.setOnMouseClicked(e->{
            resume.setVisible(false);
            play.setVisible(true);
            timeline1.stop();
            timeline2.stop();
            timeline3.stop();
            timeline4.stop();
            timeline5.stop();
            timeline6.stop();
            timeline7.stop();
            timer.stop();
            timer1.stop();
        });



        play = new ImageView();
        Image playImage = new Image("View/Images/play.png",true);
        play.setImage(playImage);
        play.setFitWidth(60);
        play.setFitHeight(60);
        play.setLayoutY(550);
        play.setLayoutX(150);
        play.setVisible(false);
        play.setOnMouseClicked(e->{
            play.setVisible(false);
            resume.setVisible(true);
            timeline1.play();
            timeline2.play();
            timeline3.play();
            timeline4.play();
            timeline5.play();
            timeline6.play();
            timeline7.play();
            timer.start();
            timer1.start();
        });


        timer1 = new AnimationTimer() {
            @Override
            public void handle(long now) {

                for (ImageView bomb : bombs) {
                    bomb.setLayoutY(bomb.getLayoutY() + speed + bomb.getLayoutY() / 150);
                }
            }
        };
       // timer1.start();


        timer = new AnimationTimer() {
            @Override
            public void handle(long arg0) {
                cont.setLayoutX(mouseX);
                cont.setLayoutY(mousey);
                for (int i = 0; i < drop.size(); i++) {
                    ( drop.get(i)).setLayoutY(( drop.get(i)).getLayoutY() + speed + ( drop.get(i)).getLayoutY() / 150);

                    if (( drop.get(i)).getLayoutY() >= watermelonObj.getYPosition() && (drop.get(i)).getId().equals("Notfruit"))
                    {
                        anchorPane.getChildren().remove((drop.get(i)));
                        drop.remove(i);
                        missed += 1;
                        if (missed ==  1 || missed==2 ||missed==3)
                        {
                            if(!imv3.isVisible() && imv4.isVisible())
                            {
                                imv4.setVisible(false);
                            }
                            else if (imv3.isVisible())
                            {
                                imv3.setVisible(false);
                            }
                            else
                            {
                                imv5.setVisible(false);
                            }
                            if(!imv5.isVisible())
                            {
                            imv5.setVisible(false);
                            gameOver.setVisible(true);
                            exit.setVisible(true);
                            replay.setVisible(true);
                            resume.setDisable(true);
                            timeline1.stop();
                            timeline2.stop();
                            timeline3.stop();
                            timeline4.stop();
                            timeline5.stop();
                            timeline6.stop();
                            timeline7.stop();
                            timer.stop();
                            timer1.stop();
                            bestScore.CompareBestScore(game.DefaultGameState().getScore());
                        }
                        }
                    }
                }
            }
        };
        //timer.start();

        cont = swordImage.sword();
        scene.setOnMouseMoved(e -> {
            mouseX = e.getX();
            mousey=e.getY();
        });


        lblScored = new Label("Score : " +game.DefaultGameState().getScore());
        lblScored.setLayoutX(120);
        lblScored.setLayoutY(10);
        lblScored.setTextFill(Color.web("Yellow"));
        lblScored.setFont(new Font("Bold",30));

        BestScore = new Label("Best Score : "+(bestScore.ReadFromFile().get(bestScore.ReadFromFile().size()-1)));
        BestScore.setLayoutX(120);
        BestScore.setLayoutY(50);
        BestScore.setTextFill(Color.web("Yellow"));
        BestScore.setFont(new Font("Bold",30));

        anchorPane.setBackground(background);
        anchorPane.getChildren().addAll(imv1,imv2,imv3,imv4,imv5,play,resume,replay,exit,gameOver,lblScored,BestScore,cont);

    }

    public Scene getScene() {
        return this.scene;
    }

    public void setHomeScene(HomeScene homeScene) {
        this.homeScene = homeScene;
    }

    private ImageView watermelon(){

        ImageView imv6 = new ImageView();
        Image image6 = new Image("View/Images/Watermelonfruit.png",true);
        Image image7 = new Image("View/Images/cuttedmelon.png",true);
        imv6.setImage(image6);
        imv6.setId("Notfruit");
        imv6.setLayoutX(rand(watermelonObj.getXPosition(), watermelonObj.getMaxXPosition()));
        imv6.setFitWidth(130);
        imv6.setFitHeight(130);
        imv6.setOnMouseMoved(e->
        {
            imv6.setImage(image7);
            imv6.setFitWidth(200);
            imv6.setFitHeight(200);
            imv6.setId("fruit");
            imv6.setDisable(true);
            lblScored.setText("Score : " +game.DefaultGameState().scoreCount(ObjectType.FRUIT));
            final Media media = new Media(new File("E:\\Fruit Ninja Game  Project 2\\src\\View\\Sound\\cut_fruit4.mp3").toURI().toString());
            final MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
            Timeline applerotation = new Timeline(
                    new KeyFrame(Duration.millis(10), event-> imv6.setRotate(imv6.getRotate() + 1))
            );
            applerotation.setCycleCount(Timeline.INDEFINITE);
            applerotation.play();
        });
        return imv6;

    }


    private ImageView orange()
    {
        ImageView imv6 = new ImageView();
        Image image6 = new Image("View/Images/orange.png",true);
        Image image7 = new Image("View/Images/cuttedOrange.png",true);
        imv6.setImage(image6);
        imv6.setId("Notfruit");
        imv6.setLayoutX(rand(orangeObj.getXPosition(), orangeObj.getMaxXPosition()));
        imv6.setFitWidth(130);
        imv6.setFitHeight(130);
        imv6.setOnMouseMoved(e->
        {
            imv6.setImage(image7);
            imv6.setDisable(true);
            imv6.setFitWidth(170);
            imv6.setFitHeight(170);
            imv6.setId("fruit");
            lblScored.setText("Score : " +game.DefaultGameState().scoreCount(ObjectType.FRUIT));
            final Media media = new Media(new File("E:\\Fruit Ninja Game  Project 2\\src\\View\\Sound\\cut_fruit4.mp3").toURI().toString());
            final MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
            Timeline applerotation = new Timeline(
                    new KeyFrame(Duration.millis(10), event-> imv6.setRotate(imv6.getRotate() + 1))
            );
            applerotation.setCycleCount(Timeline.INDEFINITE);
            applerotation.play();
        });
        return imv6;

    }


    private ImageView specialFruit1()
    {
        ImageView imv7 = new ImageView();
        Image image7 = new Image("View/Images/bananaSpecial1.png",true);
        Image image8 = new Image("View/Images/bouns10.png",true);
        imv7.setImage(image7);
        imv7.setId("Notfruit");
        imv7.setLayoutX(rand(specialFruit1Obj.getXPosition(), specialFruit1Obj.getMaxXPosition()));
        imv7.setFitWidth(100);
        imv7.setFitHeight(100);
        imv7.setOnMouseMoved(e->
        {
            imv7.setImage(image8);
            imv7.setDisable(true);
            imv7.setId("fruit");
            lblScored.setText("Score : " +game.DefaultGameState().scoreCount(ObjectType.Special1));
            final Media media = new Media(new File("E:\\Fruit Ninja Game  Project 2\\src\\View\\Sound\\cut_fruit1.mp3").toURI().toString());
            final MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
            Timeline applerotation = new Timeline(
                    new KeyFrame(Duration.millis(10), event-> imv7.setRotate(imv7.getRotate() + 1))
            );
            applerotation.setCycleCount(Timeline.INDEFINITE);
            applerotation.play();
        });
        return imv7;
    }

    private ImageView specialFruit2()
    {
        ImageView imv7 = new ImageView();
        Image image7 = new Image("View/Images/Starfruit1.png",true);
        Image image8 = new Image("View/Images/bouns5.png",true);
        imv7.setImage(image7);
        imv7.setId("Notfruit");
        imv7.setLayoutX(rand(specialFruit2Obj.getXPosition(), specialFruit2Obj.getMaxXPosition()));
        imv7.setFitWidth(100);
        imv7.setFitHeight(100);
        imv7.setOnMouseMoved(e->
        {
            imv7.setImage(image8);
            imv7.setId("fruit");
            imv7.setDisable(true);
            //scored+=5;
            lblScored.setText("Score : " +game.DefaultGameState().scoreCount(ObjectType.Special2));
            final Media media = new Media(new File("E:\\Fruit Ninja Game  Project 2\\src\\View\\Sound\\cut_fruit1.mp3").toURI().toString());
            final MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
            Timeline applerotation = new Timeline(
                    new KeyFrame(Duration.millis(10), event-> imv7.setRotate(imv7.getRotate() + 1))
            );
            applerotation.setCycleCount(Timeline.INDEFINITE);
            applerotation.play();
        });
        return imv7;
    }


    private ImageView kiwi()
    {
        ImageView imv8 = new ImageView();
        Image image8 = new Image("View/Images/kiwi1.png",true);
        Image image9 = new Image("View/Images/kiwiCutted.png",true);
        imv8.setImage(image8);
        imv8.setLayoutX(rand(kiwiObj.getXPosition(),kiwiObj.getMaxXPosition()));
        imv8.setId("Notfruit");
        imv8.setFitWidth(100);
        imv8.setFitHeight(100);
        imv8.setOnMouseMoved(e->
        {
            imv8.setImage(image9);
            imv8.setId("fruit");
            imv8.setDisable(true);
            imv8.setFitWidth(140);
            imv8.setFitHeight(140);
            lblScored.setText("Score : " +game.DefaultGameState().scoreCount(ObjectType.FRUIT));
            final Media media = new Media(new File("E:\\Fruit Ninja Game  Project 2\\src\\View\\Sound\\cut_fruit4.mp3").toURI().toString());
            final MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
            Timeline applerotation = new Timeline(
                    new KeyFrame(Duration.millis(10), event-> imv8.setRotate(imv8.getRotate() + 1))
            );
            applerotation.setCycleCount(Timeline.INDEFINITE);
            applerotation.play();
        });
        return imv8;
    }


    private ImageView bomb1()
    {
        ImageView imv8 = new ImageView();
        Image image8 = new Image("View/Images/bomb1.png",true);
        imv8.setImage(image8);
        imv8.setLayoutX(rand(bomb1Obj.getXPosition(),bomb1Obj.getMaxXPosition()));
        imv8.setFitWidth(100);
        imv8.setFitHeight(100);
        imv8.setOnMouseMoved(e ->{
            imv8.setDisable(true);
                    if(!imv3.isVisible() && imv4.isVisible())
                    {
                        imv4.setVisible(false);
                    }
                    else if (imv3.isVisible())
                    {
                        imv3.setVisible(false);
                    }
                    else
                    {
                        imv5.setVisible(false);
                    }
                    if(!imv5.isVisible())
                    {
                        gameOver.setVisible(true);
                        exit.setVisible(true);
                        replay.setVisible(true);
                        resume.setDisable(true);
                        timeline1.stop();
                        timeline2.stop();
                        timeline3.stop();
                        timeline4.stop();
                        timeline5.stop();
                        timeline6.stop();
                        timeline7.stop();
                        timer.stop();
                        timer1.stop();
                        bestScore.CompareBestScore(game.DefaultGameState().getScore());
                    }
                    final Media media = new Media(new File("E:\\Fruit Ninja Game  Project 2\\src\\View\\Sound\\cut_bomb.mp3").toURI().toString());
                    final MediaPlayer mediaPlayer = new MediaPlayer(media);
                    mediaPlayer.play();
                }
        );
        return imv8;
    }


    private ImageView bomb2()
    {
        ImageView imv8 = new ImageView();
        Image image8 = new Image("View/Images/bomblives1.png",true);
        imv8.setImage(image8);
        imv8.setLayoutX(rand(bomb2Obj.getXPosition(),bomb2Obj.getMaxXPosition()));
        imv8.setFitWidth(100);
        imv8.setFitHeight(100);
        imv8.setOnMouseMoved(e-> {
            imv8.setDisable(true);
            gameOver.setVisible(true);
            exit.setVisible(true);
            replay.setVisible(true);
            resume.setDisable(true);
            timeline1.stop();
            timeline2.stop();
            timeline3.stop();
            timeline4.stop();
            timeline5.stop();
            timeline6.stop();
            timeline7.stop();
            timer.stop();
            timer1.stop();
            bestScore.CompareBestScore(game.DefaultGameState().getScore());
            final Media media = new Media(new File("E:\\Fruit Ninja Game  Project 2\\src\\View\\Sound\\cut_bomb.mp3").toURI().toString());
            final MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        });
        return imv8;
    }


    private void handelReply() throws FileNotFoundException {
        prepareScene();
    }


    private int rand(int min, int max) {
        return (int)(Math.random() * max + min);
    }

}
