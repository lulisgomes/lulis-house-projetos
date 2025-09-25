package br.com.lulishouseprojetos.controller;

import br.com.lulishouseprojetos.adapter.MockAdapter;
import br.com.lulishouseprojetos.model.entity.equipe.Equipe;
import br.com.lulishouseprojetos.model.entity.usuario.TipoUsuario;
import br.com.lulishouseprojetos.port.DatabasePortI;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Data;

@Data
public class MainController extends Controller{
    private static DatabasePortI database = new MockAdapter();

    @FXML
    private Label nome_usuario;

    @FXML
    private Label tipo_usuario;

    @FXML
    private Tab trabalhotab;
    @FXML
    private HBox trabalhos;

    @FXML
    private Tab equipestab;
    @FXML
    private HBox equipes;

    @FXML
    private Tab projetostab;
    @FXML
    private HBox projetos;

    @FXML
    private Tab usuariostab;
    @FXML
    private HBox usuarios;

    @FXML
    private Tab admintab;

    @FXML
    private ChoiceBox add_tipo_value;
    @FXML
    private PasswordField add_senha_value;
    @FXML
    private TextField add_name_value;
    @FXML
    private TextField add_login_value;
    @FXML
    private TextField add_name2_value;
    @FXML
    private TextField add_cpf_value;
    @FXML
    private TextField add_email_value;
    @FXML
    private TextField add_cargo_value;

    @FXML
    public void onCadastrarButtonClick() {

    }

    @Override
    public void setupPage() {
        super.setupPage();
        nome_usuario.setText(currentUser.getNome());
        tipo_usuario.setText(currentUser.getTipo());
        trabalhotab.setDisable(true);
        equipestab.setDisable(true);
        projetostab.setDisable(true);
        usuariostab.setDisable(true);
        admintab.setDisable(true);
        switch (currentUser.getTipo().toUpperCase()){
            case TipoUsuario.DEV:
            case TipoUsuario.ADMIN:
                trabalhotab.setDisable(false);
                equipestab.setDisable(false);
                setEquipes(equipes);
                projetostab.setDisable(false);
                usuariostab.setDisable(false);
                admintab.setDisable(false);
                break;
            case TipoUsuario.FORNECEDOR:
                projetostab.setDisable(false);
                break;
            case TipoUsuario.USUARIO:
                projetostab.setDisable(false);
                equipestab.setDisable(false);
                setEquipes(equipes);
            default:
                break;
        }
    }

    public void setEquipes(HBox container){
        for (Equipe e : database.getEquipesByUser(currentUser)){
            Label name = new Label(e.getNome());
            Label desc = new Label(e.getDesc());

            VBox v = new VBox();
            v.getChildren().add(name);
            v.getChildren().add(desc);
            container.getChildren().add(v);
        }
    }
}