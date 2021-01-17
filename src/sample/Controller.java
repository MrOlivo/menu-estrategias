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
    public ComboBox<String> combo_driving_style;
    public ComboBox<String> combo_tire;
    public TableView<Registro> table_results;
    public TableColumn<Registro, Integer> column_id;
    public TableColumn<Registro, String> column_wear;
    public Button button_calculate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> compound_list = FXCollections.observableArrayList();
        compound_list.addAll("Soft", "Super soft", "Ultra soft");
        combo_tire.setItems(compound_list);
        combo_tire.getSelectionModel().selectFirst();

        ObservableList<String> driving_list = FXCollections.observableArrayList();
        driving_list.addAll("Neutral", "Atacar", "Conservar");
        combo_driving_style.setItems(driving_list);
        combo_driving_style.getSelectionModel().selectFirst();

        column_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        column_wear.setCellValueFactory(new PropertyValueFactory<>("desgaste"));

        button_calculate.setOnAction(actionEvent -> {
            try {
                fillTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void fillTable() {
        table_results.getItems().clear();

        ITipoConduccion drivingStyle = getDrivingStyle(combo_driving_style.getValue());
        INeumatico tire = PirelliFactory.getTyre(combo_tire.getValue());

        int i = -1;
        float vidaUtil = 100f;

        do{
            table_results.getItems().add(new Registro(i += 1, vidaUtil));
            vidaUtil = drivingStyle.calcularDesgaste(tire, vidaUtil);
        } while (vidaUtil > 0);
    }

    private ITipoConduccion getDrivingStyle(String opt){
        switch (opt.toLowerCase()) {
            case "conservar":
                return new Conservar();
            case "atacar":
                return new Atacar();
            default:
                return new Neutral();
        }
    }
}
