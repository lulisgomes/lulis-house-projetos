package br.com.lulishouseprojetos.model.entity.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class TipoUsuario {
    public static final String DEV = "DEV";
    public static final String ADMIN = "ADMIN";
    public static final String FORNECEDOR = "FORNECEDOR";
    public static final String USUARIO = "USUARIO";
    private TipoUsuario(){}
}
