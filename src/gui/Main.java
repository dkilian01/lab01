package gui;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmls/startMenu.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Pusheen cat");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        ((StartMenuController)loader.getController()).setDefLocale();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
