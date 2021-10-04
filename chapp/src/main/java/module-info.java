module es.iesfranciscodelosrios.chapp {
    requires transitive javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires jaxb.api;
	requires java.sql;

    opens es.iesfranciscodelosrios.chapp to javafx.fxml;
    exports es.iesfranciscodelosrios.chapp;
}
