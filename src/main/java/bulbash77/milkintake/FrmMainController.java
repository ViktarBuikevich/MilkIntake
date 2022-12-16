//package bulbash77.milkintake;
//
//public class FrmMainController {
//}
package bulbash77.milkintake;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FrmMainController {

    @FXML
    private ImageView imgView;

    @FXML
    void onMouseClickedImgView(MouseEvent event) {
        System.out.println("--- btnLogin.setOnAction  ---");
        System.out.println("onMouseClickedImgView(MouseEvent event): "+event.getEventType().toString());
        System.out.println("event: "+event.toString());
    }

    @FXML
    void onMouseEnteredImgView(MouseEvent event) {
        System.out.println("--- btnLogin.setOnAction  ---");
        System.out.println("onMouseClickedImgView(MouseEvent event): "+event.getEventType().toString());
        System.out.println("event: "+event.toString());
    }


    @FXML
    void initialize() {
//        assert imgView != null : "fx:id=\"imgView\" was not injected: check your FXML file 'frmMain.fxml'.";

    }

}

