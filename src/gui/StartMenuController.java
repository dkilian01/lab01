package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class StartMenuController extends BaseController implements Initializable {
    @FXML
    private Button btnExit;
    @FXML
    private Button btnSolveProblem;
    @FXML
    private Label labelWelcome;
    @FXML
    private MenuItem menuItemExit;
    @FXML
    private MenuItem menuItemAbout;
    @FXML
    private MenuItem menuItemSettings;
    @FXML
    private Menu menuMenu;
    @FXML
    private Label todayIsLabel;
    @FXML
    private Label dataLabel;

    public void btnSolveProblemClicked(MouseEvent mouseEvent) throws IOException {
        changeScene("ProblemMenu", mouseEvent);
    }

    public void btnExitClicked(MouseEvent mouseEvent) {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();
    }

    public void menuItemSettingsClicked(ActionEvent actionEvent) throws IOException {
        Stage stageTheEventSourceNodeBelongs =(Stage) btnExit.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/OptionsMenu.fxml"));
        stageTheEventSourceNodeBelongs.setScene(new Scene(fxmlLoader.load()));
    }

    public void menuItemAboutClicked(ActionEvent actionEvent) throws IOException {
        Stage stageTheEventSourceNodeBelongs =(Stage) btnExit.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/AboutView.fxml"));
        stageTheEventSourceNodeBelongs.setScene(new Scene(fxmlLoader.load()));

    }

    public void menuItemExit(ActionEvent actionEvent) {
        Stage stageTheEventSourceNodeBelongs =(Stage) btnExit.getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();
    }

    private void setLanguage() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, locale);
        btnSolveProblem.setText(msgs.getString("Solve_problem"));
        btnExit.setText(msgs.getString("Exit"));
        labelWelcome.setText(msgs.getString("Welcome") + "!");
        todayIsLabel.setText(msgs.getString("TodayIs"));
        dataLabel.setText(df.format(new Date()));
        menuItemSettings.setText(msgs.getString("Settings"));
        menuItemAbout.setText(msgs.getString("About_us"));
        menuItemExit.setText(msgs.getString("Exit"));
        menuMenu.setText(msgs.getString("Menu"));
    }
    public void setDefLocale(){
        setLocale();
        setLanguage();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLanguage();
    }
}
