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
    public ComboBox<String> combo_driving_type;
    public ComboBox<String> combo_tire;
    public TableView<Registro> table_results;
    public TableColumn<Registro, Integer> column_id;
    public TableColumn<Registro, String> column_wear;
    public Button button_calculate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> compuestos = FXCollections.observableArrayList();
        compuestos.addAll("Blando", "Superblando", "Ultrablando");
        combo_tire.setItems(compuestos);
        combo_tire.getSelectionModel().selectFirst();

        ObservableList<String> modos = FXCollections.observableArrayList();
        modos.addAll("Neutral", "Atacar", "Conservar");
        combo_driving_type.setItems(modos);
        combo_driving_type.getSelectionModel().selectFirst();

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

        ITipoConduccion drivingStyle = getDrivingStyle(combo_driving_type.getValue());
        String compound = combo_tire.getValue();
        INeumatico tire = PirelliFactory.ObtenerNeumatico(compound);

        int i = 0;
        float vidaUtil = 100f;

        while (vidaUtil > 0) {
            vidaUtil = drivingStyle.calcularDesgaste(tire, vidaUtil);
            if (vidaUtil <= 0) {
                break;
            }
            table_results.getItems().add(new Registro(i += 1, vidaUtil));
        }
    }

    private ITipoConduccion getDrivingStyle(String opt){
        switch (opt) {
            case "Conservar":
                return new Conservar();
            case "Atacar":
                return new Atacar();
            default:
                return new Neutral();
        }
    }
}
