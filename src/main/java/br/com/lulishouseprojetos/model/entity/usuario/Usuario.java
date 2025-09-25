package br.com.lulishouseprojetos.model.entity.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    protected String login;
    protected String senha;
    protected String tipo;
    protected String nome;
    protected String sobreNome;
    protected String email;
    protected String cargo;
}
