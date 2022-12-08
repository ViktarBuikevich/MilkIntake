module bulbash77.milkintake {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens bulbash77.milkintake to javafx.fxml;
    exports bulbash77.milkintake;
}