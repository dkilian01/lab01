package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import knapsackProblem.*;

import java.io.IOException;
import java.net.URL;
import java.text.ChoiceFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class ProblemMenuController extends BaseController implements Initializable {

    @FXML
    private ListView instancesListView;
    @FXML
    private ListView itemsListView;
    @FXML
    private TextField textFieldWeight;
    @FXML
    private ChoiceBox choiceBoxAlgorithm;
    @FXML
    private Button btnAddItem;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnRemoveItem;
    @FXML
    private Button btnAddInstance;
    @FXML
    private Button btnRemoveInstance;
    @FXML
    private Button btnSolve;
    @FXML
    private Label labelAlgorithm;
    @FXML
    private Label labelMaxWeight;
    @FXML
    private Label labelItems;
    @FXML
    private Label labelInstance;
    @FXML
    private Label chooseSackLabel;

    private Instance selectedInstance;
    private Item selectedItem;
    private Algorithm selectedAlgorith;


    public void setInstanceList() {
        ObservableList<Instance> observableArrayList =
                FXCollections.observableArrayList(instancesList);
        instancesListView.setItems(observableArrayList);

        instancesListView.setCellFactory(param -> new ListCell<Instance>() {
            @Override
            protected void updateItem(Instance instance, boolean empty) {
                super.updateItem(instance, empty);

                if (empty || instance == null) {
                    setText(null);
                }else if(instance.getKnapsackMaxWeight() == 0)
                    setText("Not initialized instance");
                else {
                    String str = msgs.getString("Max_weight") +": " + instance.getKnapsackMaxWeight() + ", " +  msgs.getString("Items").toLowerCase() + ": " + instance.getListOfItems().size();
                    setText(str);
                }
            }
        });
    }

    public void setItemsList() {
        if(selectedInstance != null){
        textFieldWeight.setText(Integer.toString(selectedInstance.getKnapsackMaxWeight()));
        ObservableList<Item> observableArrayList =
                FXCollections.observableArrayList(selectedInstance.getListOfItems());
        itemsListView.setItems(observableArrayList);

        itemsListView.setCellFactory(param -> new ListCell<Item>() {
            @Override
            protected void updateItem(Item item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                }
                else {
                    String str = msgs.getString("Weight") +": " + item.getWeight() + ", " + msgs.getString("Value").toLowerCase()+": " + numberFormat.format(item.getValue());
                    setText(str);
                }
            }
        });
        }else{
            ObservableList<Item> observableArrayList =
                    FXCollections.observableArrayList(new ArrayList<Item>());
            itemsListView.setItems(observableArrayList);
        }
    }

    public void btnAddInstaceClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/NewInstanceMenu.fxml"));
        Parent root = fxmlLoader.load();
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Add new item");
        secondaryStage.setScene(new Scene(root));
        secondaryStage.show();

        NewInstanceMenuController controller = fxmlLoader.getController();
        controller.setController(this);

    }

    public void btnRemoveInstanceClicked(MouseEvent mouseEvent) {
        if(selectedInstance != null){
            instancesList.remove(selectedInstance);
            setInstanceList();
            setItemsList();
            textFieldWeight.setText("");
            chooseSackLabel.setText(msgs.getString("choose_knapsack_instance"));
        }
    }

    public void btnAddItemClicked(MouseEvent mouseEvent) throws IOException {
        if(selectedInstance != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/AddItemMenu.fxml"));
            Parent root = fxmlLoader.load();
            Stage secondaryStage = new Stage();
            secondaryStage.setTitle("Add new item");
            secondaryStage.setScene(new Scene(root));
            secondaryStage.show();

            AddItemMenuController controller = fxmlLoader.getController();
            controller.setController(this);

        }
    }

    public void btnRemoveItemClicked(MouseEvent mouseEvent) {
        if(selectedItem != null) selectedInstance.removeItem(selectedItem);
        setItemsList();
        setInstanceList();
    }

    public void btnBackClicked(MouseEvent mouseEvent) throws IOException {
        changeScene("StartMenu", mouseEvent);
    }

    public void btnSolveClicked(MouseEvent mouseEvent) throws IOException {
        if(selectedAlgorith != null && selectedInstance != null){
            Solution solution = selectedAlgorith.foundSolution(selectedInstance);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/SolutionView.fxml"));
            Parent root = fxmlLoader.load();
            Stage secondaryStage = new Stage();
            secondaryStage.setTitle("Solution");
            secondaryStage.setScene(new Scene(root));
            secondaryStage.show();

            SolutionViewController controller = fxmlLoader.getController();
            controller.sendSolution(solution);
        }
    }
    private void setLanguage(){
        btnAddInstance.setText(msgs.getString("Add"));
        btnAddItem.setText(msgs.getString("Add"));
        btnBack.setText(msgs.getString("Back"));
        btnRemoveInstance.setText(msgs.getString("Remove"));
        btnRemoveItem.setText(msgs.getString("Remove"));
        btnSolve.setText(msgs.getString("Resolve"));
        labelInstance.setText(msgs.getString("Instances")+ ":");
        labelAlgorithm.setText(msgs.getString("Choose_algorithm"));
        labelItems.setText(msgs.getString("Items") + ":");
        labelMaxWeight.setText(msgs.getString("Max_weight") + ":");
    }

    public void textFieldWageKeyPressed(KeyEvent keyEvent) {
    }

    public void sendNewItem(Item item) {
        if (item != null) {
            selectedInstance.addItem(item);
            setItemsList();
            setInstanceList();
        }
    }

    public void addNewInstance(int maxWeight) {
        Instance inst = new Instance();
        inst.setKnapsack_max_weight(maxWeight);
        instancesList.add(inst);
        setInstanceList();
    }

    private void setChoiceBox(){
        choiceBoxAlgorithm.getItems().addAll(msgs.getString("Brute_force"), msgs.getString("Greedy") , msgs.getString("Random"));
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(selectedInstance == null){
            chooseSackLabel.setText(msgs.getString("choose_knapsack_instance"));
        }
        setChoiceBox();
        setInstanceList();
        setLanguage();
        instancesListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Instance>() {
            @Override
            public void changed(ObservableValue<? extends Instance> observable, Instance oldValue, Instance newValue) {
                selectedInstance = newValue;
                if(selectedInstance != null){
                    String pattern =
                            msgs.getString("0_items") + "|" +
                                    msgs.getString("1_item") + "|" +
                                    msgs.getString("2_4_items") + "|" +
                                    msgs.getString("5_and_more_items");
                    ChoiceFormat cf = new ChoiceFormat(pattern);
                    chooseSackLabel.setText(msgs.getString("instance_contein") + " "+selectedInstance.getListOfItems().size()+" " + cf.format(selectedInstance.getListOfItems().size()));
                    setItemsList();
                }
            }
        });


        itemsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Item>() {
            @Override
            public void changed(ObservableValue<? extends Item> observable, Item oldValue, Item newValue) {
                selectedItem = newValue;
            }
        });

        choiceBoxAlgorithm.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                switch (number2.intValue()){
                    case 0:
                        selectedAlgorith = new BruteForce();
                        break;
                    case 1:
                        selectedAlgorith = new Greedy();
                        break;
                    case 2:
                        selectedAlgorith = new RandomSolution();
                        break;
                };
            }
        });

    }
}
