package br.com.lulishouseprojetos.controller;

import br.com.lulishouseprojetos.StageUtil;
import br.com.lulishouseprojetos.adapter.MockAdapter;
import br.com.lulishouseprojetos.port.DatabasePortI;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.Data;

import java.io.IOException;

@Data
public class LoginController extends Controller {

    @FXML
    private Label desc = new Label("Realize o login, para ter acesso.");

    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;

    @FXML
    protected void onLoginButtonClick() throws IOException {
        Alert alert;

        if (database.doLogin(login.getText(), senha.getText())) {
            alert = new Alert(Alert.AlertType.INFORMATION, "Login e Senha validos!");
            currentUser = database.getUserByLogin(login.getText());
            StageUtil.SetupPage(stage, "lulishouse", this);
        } else {
            alert = new Alert(Alert.AlertType.ERROR, "Login ou Senha invalidos!");
        }
        alert.setHeaderText("Important Message");
        alert.showAndWait();
    }

    @Override
    public void setupPage() {
        super.setupPage();
        database = new MockAdapter();
    }
}