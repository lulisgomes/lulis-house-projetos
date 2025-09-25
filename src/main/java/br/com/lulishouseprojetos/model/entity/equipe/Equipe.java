package br.com.lulishouseprojetos.model.entity.equipe;

import lombok.Data;

import java.util.List;

@Data
public class Equipe {
    protected String id;
    protected String nome;
    protected String desc;
    protected List<String> membros;
    protected List<String> projetos;
}
