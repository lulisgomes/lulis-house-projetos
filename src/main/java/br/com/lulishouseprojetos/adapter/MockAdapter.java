package br.com.lulishouseprojetos.adapter;

import br.com.lulishouseprojetos.model.entity.equipe.Equipe;
import br.com.lulishouseprojetos.model.entity.projeto.Projeto;
import br.com.lulishouseprojetos.model.entity.usuario.TipoUsuario;
import br.com.lulishouseprojetos.model.entity.usuario.Usuario;
import br.com.lulishouseprojetos.port.DatabasePortI;

import java.util.ArrayList;
import java.util.List;

public class MockAdapter implements DatabasePortI {

    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Equipe> equipes = new ArrayList<>();

    static {
        Usuario admin = new Usuario(
                "admin",
                "123",
                "admin",
                "Luciana",
                "Gomes",
                "lulis@gomes.com",
                "admin");
        usuarios.add(admin);

        Usuario fornecedor = new Usuario(
                "fornecedor",
                "123",
                "fornecedor",
                "Luciana",
                "Gomes",
                "lulis@gomes.com",
                "");
        usuarios.add(fornecedor);

        Usuario cliente = new Usuario(
                "cliente",
                "123",
                "usuario",
                "Luciana",
                "Gomes",
                "lulis@gomes.com",
                "");
        usuarios.add(cliente);

        for (int i = 1; i <= 10; i++){
            Equipe equipe = new Equipe();
            equipe.setDesc("Desc" + i);
            equipe.setId(String.valueOf(i));
            equipe.setNome("Nome - " + i);
            equipe.setMembros(new ArrayList<>());
            equipe.setProjetos(new ArrayList<>());

            equipes.add(equipe);
        }
        List<String> membrosEquipe0 = new ArrayList<>();
        membrosEquipe0.add(fornecedor.getLogin());
        membrosEquipe0.add(cliente.getLogin());
        equipes.get(0).setMembros(membrosEquipe0);

        List<String> membrosEquipe1 = new ArrayList<>();
        membrosEquipe1.add(fornecedor.getLogin());
        membrosEquipe1.add(cliente.getLogin());
        equipes.get(1).setMembros(membrosEquipe1);

        List<String> membrosEquipe2 = new ArrayList<>();
        membrosEquipe2.add(fornecedor.getLogin());
        equipes.get(2).setMembros(membrosEquipe2);

        List<String> membrosEquipe3 = new ArrayList<>();
        membrosEquipe3.add(cliente.getLogin());
        equipes.get(3).setMembros(membrosEquipe3);


    }

    @Override
    public Usuario addUser(Usuario user) {
        if (user != null){
            usuarios.add(user);
            return user;
        }
        return null;
    }

    @Override
    public Usuario getUserByLogin(String login) {
        for(Usuario u : usuarios){
            if (u.getLogin().equals(login)){
                return u;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> getUsersByTipo(String tipo) {
        return null;
    }

    @Override
    public boolean doLogin(String login, String senha) {
        for (Usuario u : usuarios){
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isLogged(Usuario u) {
        return u.getLogin().equals("lulis");
    }

    @Override
    public Equipe addEquipe(Equipe equipe) {
        return null;
    }

    @Override
    public Equipe getEquipeByLogin(String login) {
        return null;
    }

    @Override
    public List<Equipe> getEquipesByUser(Usuario user) {
        if (user.getTipo().equalsIgnoreCase(TipoUsuario.ADMIN)) {
            return equipes;
        } else if(user.getTipo().equalsIgnoreCase(TipoUsuario.USUARIO) || user.getTipo().equalsIgnoreCase(TipoUsuario.FORNECEDOR)){
            List<Equipe> es = new ArrayList<>();
            for (Equipe e : equipes){
                for (String m : e.getMembros()){
                    if(m.equals(user.getLogin())){
                        es.add(e);
                    }
                }
            }
            return es;
        }
        return new ArrayList<>();
    }

    @Override
    public Projeto addProjeto(Projeto projeto) {
        return null;
    }

    @Override
    public Projeto getProjetoByLogin(String login) {
        return null;
    }

    @Override
    public List<Projeto> getProjetosByEquipe(Equipe equipe) {
        return null;
    }
}
