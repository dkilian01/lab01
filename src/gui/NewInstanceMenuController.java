package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewInstanceMenuController extends BaseController implements Initializable {
    @FXML
    private TextField weightTextField;
    @FXML
    private ProblemMenuController controller;
    @FXML
    private Label maxWeightLabel;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnCancel;

    public void setController(ProblemMenuController controller){
        this.controller = controller;
    }

    private void setLanguage(){
        btnAdd.setText(msgs.getString("Add"));
        btnCancel.setText(msgs.getString("Cancel"));
        maxWeightLabel.setText(msgs.getString("enter_max_weight_for_knapsack"));
    }
    public void btnAddClicked(MouseEvent mouseEvent) {
        if (isInteger(weightTextField.getText())) {
           controller.addNewInstance(Integer.parseInt(weightTextField.getText()));
            Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stageTheEventSourceNodeBelongs.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(msgs.getString("Error"));
            alert.setHeaderText(msgs.getString("bad_max_knapsack_weight"));
            alert.setContentText(msgs.getString("enter_correct_correct_knapsack_max_weight"));

            ButtonType buttonTypeOne = new ButtonType(msgs.getString("OK"));
            alert.getButtonTypes().setAll(buttonTypeOne);
            alert.showAndWait();
        }
    }

    public void btnCancelClicked(MouseEvent mouseEvent) {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();
    }

    public boolean isInteger(String strNum) {
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLanguage();
    }
}
