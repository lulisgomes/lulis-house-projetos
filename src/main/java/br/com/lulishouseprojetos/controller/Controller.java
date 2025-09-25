package br.com.lulishouseprojetos.controller;

import br.com.lulishouseprojetos.model.entity.usuario.Usuario;
import br.com.lulishouseprojetos.port.DatabasePortI;
import javafx.stage.Stage;
import lombok.Data;

import java.util.Hashtable;

@Data
public abstract class Controller {
    protected DatabasePortI database;
    protected Stage stage;
    protected Usuario currentUser;

    public void setupPage(){}
}