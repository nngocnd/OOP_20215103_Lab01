module Lab02 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens hust.soict.hedspi.javafx to javafx.fxml;
    exports hust.soict.hedspi.javafx;
}
