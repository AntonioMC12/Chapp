module es.iesfranciscodelosrios.chapp {
    requires transitive javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires java.xml;
	requires java.xml.bind;



    opens es.iesfranciscodelosrios.chapp to javafx.fxml,javafx.base,java.xml.bind;
    opens es.iesfranciscodelosrios.chapp.model to javafx.fxml,java.xml.bind;
    opens es.iesfranciscodelosrios.chapp.utils to com.sun.xml.bind;
    exports es.iesfranciscodelosrios.chapp;
   
}
