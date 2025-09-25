module br.com.lulishouseprojetos.lulishouseprojetos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires static lombok;

    opens br.com.lulishouseprojetos to javafx.fxml;
    exports br.com.lulishouseprojetos;
    exports br.com.lulishouseprojetos.controller;
    opens br.com.lulishouseprojetos.controller to javafx.fxml;
}