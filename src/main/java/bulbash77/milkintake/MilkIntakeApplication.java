package bulbash77.milkintake;

import bulbash77.milkintake.objects.User;
import bulbash77.milkintake.objects.UserRole;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MilkIntakeApplication extends Application {
    //public static User currentUser = null;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MilkIntakeApplication.class.getResource("frmAuthorization.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}