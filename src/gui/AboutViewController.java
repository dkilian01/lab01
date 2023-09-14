package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutViewController extends BaseController implements Initializable {
    @FXML
    private TextArea textAreaAbout;
    @FXML
    private Label labelAbout;
    @FXML
    private Button btnBack;

    private void setLanguage(){
        textAreaAbout.setText(msgs.getString("text_about"));
        labelAbout.setText(msgs.getString("About_program") + ":");
        btnBack.setText(msgs.getString("Back"));
    }
    public void btnExitClicked(MouseEvent mouseEvent) throws IOException {
        changeScene("StartMenu", mouseEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLanguage();
    }
}
