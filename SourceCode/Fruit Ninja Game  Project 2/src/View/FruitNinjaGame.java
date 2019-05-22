package View;

import javafx.application.Application;
import javafx.stage.Stage;

public class FruitNinjaGame extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Fruit Ninja Game");

        FirstScene firstScene = new FirstScene(primaryStage);
        HomeScene homeScene = new HomeScene(primaryStage);
        Level1Scene level1Scene = new Level1Scene(primaryStage);
        Level2Scene level2Scene =  new Level2Scene(primaryStage);
        Level3Scene level3Scene = new Level3Scene(primaryStage);

        firstScene.prepareScene();
        homeScene.prepareScene();
        level1Scene.prepareScene();
        level2Scene.prepareScene();
        level3Scene.prepareScene();

        firstScene.setHomeScene(homeScene);
        homeScene.setFirstScene(firstScene);
        homeScene.setLevel1Scene(level1Scene);
        homeScene.setLevel2Scene(level2Scene);
        homeScene.setLevel3Scene(level3Scene);
        level1Scene.setHomeScene(homeScene);
        level2Scene.setHomeScene(homeScene);
        level3Scene.setHomeScene(homeScene);

        primaryStage.setScene(firstScene.getScene());
        primaryStage.show();

    }
}
