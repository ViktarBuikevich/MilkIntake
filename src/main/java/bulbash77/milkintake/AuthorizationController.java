package bulbash77.milkintake;

import bulbash77.milkintake.collectionsMI.DBUsers;
import bulbash77.milkintake.objects.User;
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
import java.util.Objects;

import static bulbash77.milkintake.db.Config.currentUser;

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
        //System.out.println("onBtnLoginSingUp(ActionEvent event)");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MilkIntakeApplication.class.getResource("frmSingUp.fxml")); // загружаем новый fxml-файл
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("frmSingUp.fxml"));
        stage.setTitle("Регистрация пользователя!");
        stage.setMinHeight(260);
        stage.setMinWidth(260);
        stage.setResizable(false); //указщываем что изменять размер нельзя
        Scene scene = new Scene(fxmlLoader.load()); //, 260, 260);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL); //признак модальности нового окна
        stage.initOwner(((Node)event.getSource()).getScene().getWindow()); // указываем родительское окно для диалога
        ///((Node) event.getSource()).getScene().getWindow().hide();
        stage.show();

    }
    @FXML
    void onBtnLogin(ActionEvent event) throws IOException {
        String loginTxt = txtLogin.getText().trim();
        String passwTxt = txtPassword.getText().trim();
        if (loginUser(loginTxt, passwTxt)){
            //закрытьтекущую сцену (Stage)
            //((Node) event.getSource()).getScene().getWindow().hide(); //.close();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MilkIntakeApplication.class.getResource("frmMain.fxml")); // загружаем новый fxml-файл
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("frmSingUp.fxml"));
        stage.setTitle("Поступление молока!");
        stage.setMinHeight(860);
        stage.setMinWidth(200);
        stage.setResizable(true); //указываем что изменять размер
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        //stage.initModality(Modality.WINDOW_MODAL); //признак модальности нового окна
        stage.initOwner(((Node)event.getSource()).getScene().getWindow()); // указываем родительское окно для диалога
        ((Node) event.getSource()).getScene().getWindow().hide();
        stage.show();
        System.out.println("!!!!!!!Выход!!!!!!!");
        }
        else {
            System.out.println("Логин или пароль пустые");
            return;
        }


    }

    private boolean loginUser(String loginTxt, String passwTxt) {
        //TODO проверяем пользователя из базы
        if(loginTxt.equals("") && passwTxt.equals("")) return false;
         DBUsers dbUser= new DBUsers();
        User userDB = dbUser.getUserFromDB(loginTxt, passwTxt);
        if (Objects.isNull(userDB))
            return false;
        else{
            currentUser =userDB;
            return true;
        }
    }

    @FXML
    void initialize() {
//        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'frmAuthorization.fxml'.";
//        assert btnLoginSingUp != null : "fx:id=\"btnLoginSingUp\" was not injected: check your FXML file 'frmAuthorization.fxml'.";
//        assert txtLogin != null : "fx:id=\"txtLogin\" was not injected: check your FXML file 'frmAuthorization.fxml'.";
//        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'frmAuthorization.fxml'.";
//        assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'frmAuthorization.fxml'.";
//        btnLogin.setOnAction(actionEvent -> {
//            //закрытьтекущую сцену
//            // ((Stage) ((Node) event.getSource()).getScene.getWindow()).close();
//            System.out.println("--- btnLogin.setOnAction  ---");
//            System.out.println("actionEvent.getEventType(): "+actionEvent.getEventType().toString());
//            System.out.println("actionEvent: "+actionEvent.toString());});

    }

}
