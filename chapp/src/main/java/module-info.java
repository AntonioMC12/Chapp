module es.iesfranciscodelosrios.chapp {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens es.iesfranciscodelosrios.chapp to javafx.fxml;
    exports es.iesfranciscodelosrios.chapp;
}
