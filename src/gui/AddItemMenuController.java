package gui;


//import com.sun.xml.internal.ws.util.StringUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import knapsackProblem.Item;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class AddItemMenuController extends BaseController implements Initializable {
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField valueTextField;
    @FXML
    private Label weightLabel;
    @FXML
    private Label valuseLabel;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnCancel;

    ProblemMenuController controller;

    public void setController(ProblemMenuController controller) {
        this.controller = controller;
    }


    private void setLanguage() {
        btnAdd.setText(msgs.getString("Add"));
        btnCancel.setText(msgs.getString("Cancel"));
        valuseLabel.setText(msgs.getString("enter_new_item_value"));
        weightLabel.setText(msgs.getString("enter_new_item_weight"));
    }

    public void btnAddClicked(MouseEvent mouseEvent) {
        Item item = new Item();
        if (isInteger(weightTextField.getText())) {
            item.setWeight(Integer.parseInt(weightTextField.getText()));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(msgs.getString("Error"));
            alert.setHeaderText(msgs.getString("bad_item_weight"));
            alert.setContentText(msgs.getString("enter_correct_item_weight"));

            ButtonType buttonTypeOne = new ButtonType(msgs.getString("OK"));
            alert.getButtonTypes().setAll(buttonTypeOne);
            alert.showAndWait();
            return;
        }

        String value = valueTextField.getText();
        value  = value.replace(',', '.');


        if (isDouble(value)) {
            item.setValue(Double.parseDouble(value));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(msgs.getString("Error"));
            alert.setHeaderText(msgs.getString("bad_item_value"));
            alert.setContentText(msgs.getString("enter_correct_item_value"));

            ButtonType buttonTypeOne = new ButtonType(msgs.getString("OK"));
            alert.getButtonTypes().setAll(buttonTypeOne);
            alert.showAndWait();
            return;
        }
        controller.sendNewItem(item);
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();
    }

    public void btnCancelClicked(MouseEvent mouseEvent) {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();
    }

    public boolean isDouble(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
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
        valueTextField.setPromptText(numberFormat.format(0.00));
    }
}
