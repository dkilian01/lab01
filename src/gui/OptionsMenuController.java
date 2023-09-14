package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import knapsackProblem.BruteForce;
import knapsackProblem.Greedy;
import knapsackProblem.RandomSolution;


import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;


public class OptionsMenuController extends BaseController implements Initializable {
    @FXML
    private CheckBox cbMusic;
    @FXML
    private ChoiceBox languageChoiceBox;
    @FXML
    private Label labelLanguage;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnAccept;

    private boolean musicDefault;
    private Locale localeDefault;

    public void btnCancelClicked(MouseEvent mouseEvent) throws IOException {
        if (musicDefault) {
            //player.setCycleCount(MediaPlayer.INDEFINITE);
           // player.play();
        } else {
            //player.stop();
        }
        locale = localeDefault;
        changeScene("StartMenu", mouseEvent);
    }

    public void btnAcceptClicked(MouseEvent mouseEvent) throws IOException {
        changeScene("StartMenu", mouseEvent);
    }

    public void chMusicClicked(MouseEvent mouseEvent) throws InterruptedException {
        if (cbMusic.isSelected()) {
           // player.setCycleCount(MediaPlayer.INDEFINITE);
            //player.play();
        } else {
           // player.stop();
        }
    }

    private void setLanguage() {
        btnCancel.setText(msgs.getString("Cancel"));
        btnAccept.setText(msgs.getString("Confirm"));
        labelLanguage.setText(msgs.getString("Language") + ":");
        cbMusic.setText(msgs.getString("Music"));
    }

    private void setSelectionModel() {
        if (locale.toString().equals("pl_PL") || locale.toString().equals("pl_pl")) {
            languageChoiceBox.getSelectionModel().select(2);
        } else if (locale.toString().equals("en_GB")) {

            languageChoiceBox.getSelectionModel().select(0);
        } else if (locale.toString().equals("en_US")) {
            languageChoiceBox.getSelectionModel().select(1);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        localeDefault = locale;
        musicDefault = cbMusic.isSelected();
        setChoiceBox();
        setSelectionModel();
        setLanguage();
        if (player.getStatus().equals(MediaPlayer.Status.PLAYING)) cbMusic.setSelected(true);

        languageChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                switch (number2.intValue()) {
                    case 0:
                        locale = new Locale("en", "GB");
                        msgs = ResourceBundle.getBundle("Language.Language", locale);
                        numberFormat = NumberFormat.getInstance(locale);
                        break;
                    case 1:
                        locale = new Locale("en", "US");
                        msgs = ResourceBundle.getBundle("Language.Language", locale);
                        numberFormat = NumberFormat.getInstance(locale);
                        break;
                    case 2:
                        locale = new Locale("pl", "PL");
                        msgs = ResourceBundle.getBundle("Language.Language", locale);
                        numberFormat = NumberFormat.getInstance(locale);
                        break;
                }
                setLanguage();
            }
        });
    }

    private void setChoiceBox() {
        languageChoiceBox.getItems().addAll("English - GB", "English - US", "Polski - PL");
    }
}
