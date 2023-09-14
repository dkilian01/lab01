package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import knapsackProblem.Instance;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class BaseController{
    protected static MediaPlayer player = new MediaPlayer(new Media(Paths.get("src/gui/music/music.wav").toUri().toString()));
    protected static ArrayList<Instance> instancesList = new ArrayList<>();
    protected static Locale locale = Locale.getDefault();
    ResourceBundle msgs = ResourceBundle.getBundle("Language.Language", locale);
    protected static NumberFormat numberFormat = NumberFormat.getInstance(locale);


    public FXMLLoader changeScene(String view, MouseEvent mouseEvent) throws IOException {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/"+view+".fxml"));
        stageTheEventSourceNodeBelongs.setScene(new Scene(fxmlLoader.load()));
        return fxmlLoader;
    }

    protected void setLocale(){

        locale = Locale.getDefault();
        if(!locale.toString().equals("pl_PL") && !locale.toString().equals("en_GB") && !locale.toString().equals("en_US")){
            locale = new Locale("en_US");
        }
        numberFormat = NumberFormat.getInstance(locale);

    }
}
