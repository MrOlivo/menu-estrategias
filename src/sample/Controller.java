package sample;

import java.net.URL;
import java.util.ResourceBundle;

import conduccion.*;
import javafx.fxml.Initializable;

import neumaticos.PirelliFactory;
import neumaticos.INeumatico;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {
    public ComboBox<String> comboBoxDrivingStyles;
    public ComboBox<String> comboBoxTyres;
    public TableView<Registro> tableviewResults;
    public TableColumn<Registro, Integer> column_id;
    public TableColumn<Registro, String> column_wear;
    public Button buttonCalculate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> compoundsList = FXCollections.observableArrayList();
        compoundsList.addAll("Soft", "Super-soft", "Ultra-soft");
        comboBoxTyres.setItems(compoundsList);
        comboBoxTyres.getSelectionModel().selectFirst();

        ObservableList<String> driving_list = FXCollections.observableArrayList();
        driving_list.addAll("Neutral", "Attack", "Keep");
        comboBoxDrivingStyles.setItems(driving_list);
        comboBoxDrivingStyles.getSelectionModel().selectFirst();

        column_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        column_wear.setCellValueFactory(new PropertyValueFactory<>("wear"));

        buttonCalculate.setOnAction(actionEvent -> {
            try {
                fillTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void fillTable() {
        ITipoConduccion drivingStyle = ITipoConduccion.getDrivingStyle(comboBoxDrivingStyles.getValue());
        INeumatico tyre = PirelliFactory.getTyre(comboBoxTyres.getValue());

        int i = 0;
        float useful_life = 100f;
        ObservableList<Registro> tempList = FXCollections.observableArrayList();

        do{
            tempList.add(new Registro(i++, useful_life));
            useful_life = drivingStyle.calculateWearing(tyre, useful_life);
        } while (useful_life > 0);

        tableviewResults.setItems(tempList);
    }
}
