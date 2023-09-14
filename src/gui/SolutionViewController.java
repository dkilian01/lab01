package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import knapsackProblem.Item;
import knapsackProblem.Solution;

import java.net.URL;
import java.util.ResourceBundle;

public class SolutionViewController extends BaseController  implements Initializable {
    @FXML
    private ListView itemsListView;
    @FXML
    private Label itemsWeightLabel;
    @FXML
    private Label itemsValueLabel;
    @FXML
    private Label itemsInKnapsackLabel;
    private Solution solution;


    public void sendSolution(Solution solution){
        this.solution = solution;
        setSolution();
    }
    private void setSolution(){
        if(solution != null) {
            itemsInKnapsackLabel.setText(msgs.getString("items_in_knapsack"));

            itemsValueLabel.setText(msgs.getString("items_value") + ": " + numberFormat.format(solution.getSolutionValue()));
            itemsWeightLabel.setText(msgs.getString("items_weight") + ": " + solution.getSolutionWeight());

            ObservableList<Item> observableArrayList =
                    FXCollections.observableArrayList(solution.getListOfItems());
            itemsListView.setItems(observableArrayList);

            itemsListView.setCellFactory(param -> new ListCell<Item>() {
                @Override
                protected void updateItem(Item item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setText(null);
                    } else {
                        String str = msgs.getString("Weight") + ": " + item.getWeight() + ", " + msgs.getString("Value").toLowerCase() + ": " + numberFormat.format(item.getValue());
                        setText(str);
                    }
                }
            });
        }
    }

    public void btnBackClicked(MouseEvent mouseEvent) {
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stageTheEventSourceNodeBelongs.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setSolution();
    }
}
