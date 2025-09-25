package br.com.lulishouseprojetos.model.entity.projeto;

import lombok.Data;

import java.util.Date;

@Data
public class Projeto {
    protected String id;
    protected String nome;
    protected String desc;
    protected Date inicio;
    protected Date fim;
    protected String adminId;
    protected ProjetoStatus status;
}
