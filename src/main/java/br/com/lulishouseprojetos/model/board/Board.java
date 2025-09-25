package br.com.lulishouseprojetos.model.board;

import br.com.lulishouseprojetos.model.entity.usuario.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class Board {
    private String id;
    private String nome;
    private String desc;
    private String adminId;
    private List<Section> sections;
    private List<String> equipes;
}
