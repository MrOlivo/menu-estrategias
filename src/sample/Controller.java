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
    public ComboBox choice_conduccion;
    public ComboBox choice_neumatico;
    public TableView table_resultados;
    public TableColumn column_id;
    public TableColumn column_desgaste;
    public Button button_calcular;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> compuestos = FXCollections.observableArrayList();
        compuestos.addAll("Blando", "Superblando", "Ultrablando");
        choice_neumatico.setItems(compuestos);
        choice_neumatico.getSelectionModel().selectFirst();

        ObservableList<String> modos = FXCollections.observableArrayList();
        modos.addAll("Neutral", "Atacar", "Conservar");
        choice_conduccion.setItems(modos);
        choice_conduccion.getSelectionModel().selectFirst();

        column_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        column_desgaste.setCellValueFactory(new PropertyValueFactory<>("desgaste"));

        button_calcular.setOnAction(actionEvent -> {
            try {
                llenarTabla();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void llenarTabla() throws Exception {
        table_resultados.getItems().clear();

        ITipoConduccion tipoConduccion = elegirConduccion((String) choice_conduccion.getValue());

        String compuesto = (String) choice_neumatico.getValue();
        INeumatico neumatico = PirelliFactory.ObtenerNeumatico(compuesto);

        int i = 0;
        float vidaUtil = 100f;

        while (vidaUtil > 0) {
            vidaUtil = tipoConduccion.calcularDesgaste(neumatico, vidaUtil);
            if (vidaUtil <= 0) {
                break;
            }
            table_resultados.getItems().add(new Registro(i += 1, vidaUtil));
        }
    }

    private ITipoConduccion elegirConduccion(String opt){
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
