package br.com.lulishouseprojetos.port;

import br.com.lulishouseprojetos.model.entity.equipe.Equipe;
import br.com.lulishouseprojetos.model.entity.projeto.Projeto;
import br.com.lulishouseprojetos.model.entity.usuario.Usuario;

import java.util.List;

public interface DatabasePortI {
    // Usuario
    Usuario addUser(Usuario user);
    Usuario getUserByLogin(String login);
    List<Usuario> getUsersByTipo(String tipo);
    boolean doLogin(String login, String senha);
    boolean isLogged(Usuario u);

    // Equipes
    Equipe addEquipe(Equipe equipe);
    Equipe getEquipeByLogin(String login);
    List<Equipe> getEquipesByUser(Usuario user);

    // Projetos
    Projeto addProjeto(Projeto projeto);
    Projeto getProjetoByLogin(String login);
    List<Projeto> getProjetosByEquipe(Equipe equipe);
}
