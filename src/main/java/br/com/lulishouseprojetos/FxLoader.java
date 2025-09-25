package br.com.lulishouseprojetos;

import javafx.stage.Stage;

import java.io.IOException;

public class FxLoader extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        StageUtil.SetupPage(stage, "login", null);
    }
}