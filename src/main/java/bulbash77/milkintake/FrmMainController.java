package bulbash77.milkintake;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import static bulbash77.milkintake.db.Config.currentUser;

public class FrmMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> Auto;

    @FXML
    private Button btnChangeData;

    @FXML
    private Button btnRouteAdd;

    @FXML
    private Button btnRouteDelete;

    @FXML
    private Button btnRouteEdit;

    @FXML
    private Button btnTtnAdd;

    @FXML
    private Button btnTtnDelete;

    @FXML
    private Button btnTtnEdit;

    @FXML
    private DatePicker dpCurrentDate;

    @FXML
    private Label lblRouteCount;

    @FXML
    private Label lblTtnCount;

    @FXML
    private MenuItem mmDictCars;

    @FXML
    private MenuItem mmDictSuppliers;

    @FXML
    private MenuItem mmDictUsers;

    @FXML
    private MenuItem mmReportMilkIntake;

    @FXML
    private MenuItem mmRouteAdd;

    @FXML
    private MenuItem mmRouteDelete;

    @FXML
    private MenuItem mmRouteEdit;

    @FXML
    private MenuItem mmTtnAdd;

    @FXML
    private MenuItem mmTtnDelete;

    @FXML
    private MenuItem mmTtnEdit;

    @FXML
    private TableView<?> tvRoutes;

    @FXML
    private TableView<?> tvTtn;

    @FXML
    void onChangeData(ActionEvent event) {

    }

    @FXML
    void onDictCars(ActionEvent event) {

    }

    @FXML
    void onDictSuppliers(ActionEvent event) {

    }

    @FXML
    void onDictUsers(ActionEvent event) {

    }

    @FXML
    void onMenuAbout(ActionEvent event) {
        lblRouteCount.setText("Роль: "+currentUser.getLogin());
    }

    @FXML
    void onReportMilkIntake(ActionEvent event) {

    }

    @FXML
    void onRouteAdd(ActionEvent event) {

    }

    @FXML
    void onRouteDelete(ActionEvent event) {

    }

    @FXML
    void onRouteEdit(ActionEvent event) {

    }

    @FXML
    void onTtnAdd(ActionEvent event) {

    }

    @FXML
    void onTtnDelete(ActionEvent event) {

    }

    @FXML
    void onTtnEdit(ActionEvent event) {

    }

    @FXML
    void initialize() {


    }

}
