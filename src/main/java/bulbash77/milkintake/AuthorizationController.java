package bulbash77.milkintake;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthorizationController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnLoginSingUp;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label welcomeText;

    @FXML
    void onBtnLoginSingUp(ActionEvent event) throws IOException {
        System.out.println("onBtnLoginSingUp(ActionEvent event)");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MilkIntakeApplication.class.getResource("frmSingUp.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("frmSingUp.fxml"));
        stage.setTitle("Регистрация пользователя!");
        stage.setMinHeight(260);
        stage.setMinWidth(260);
        stage.setResizable(false);
        Scene scene = new Scene(fxmlLoader.load()); //, 260, 260);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow());
        stage.show();

    }

    @FXML
    void initialize() {
//        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'frmAuthorization.fxml'.";
//        assert btnLoginSingUp != null : "fx:id=\"btnLoginSingUp\" was not injected: check your FXML file 'frmAuthorization.fxml'.";
//        assert txtLogin != null : "fx:id=\"txtLogin\" was not injected: check your FXML file 'frmAuthorization.fxml'.";
//        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'frmAuthorization.fxml'.";
//        assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'frmAuthorization.fxml'.";
        btnLogin.setOnAction(actionEvent -> {
            System.out.println("--- btnLogin.setOnAction  ---");
            System.out.println("actionEvent.getEventType(): "+actionEvent.getEventType().toString());
            System.out.println("actionEvent: "+actionEvent.toString());});

    }

}
