/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.apresentacao.controladores;

import br.org.apaebrasil.spag.dominio.Especializacao;
import br.org.apaebrasil.spag.dominio.Profissional;
import br.org.apaebrasil.spag.dominio.repositorio.Profissionais;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Pc
 */
@Named
@ViewScoped
public class ControladorProfissionais implements Serializable{
    
    private static final long serialVersionUID = 1;
    
    @Inject
    private Profissionais profissionais;
    
    private Profissional profissional = new Profissional();
    
    private List<Profissional> todosProfissionais;
    
    public void consultar() {
        System.out.println("Consultando...");
        todosProfissionais = profissionais.recuperarTodos();

        for (Profissional pf : todosProfissionais) {
            System.out.println(pf);
        }
    }

    public void novo() {
        System.out.println("Novo...");
        profissional = new Profissional();
    }

    public void adicionar() {
        System.out.println("Adicionando...");
        profissionais.inserir(profissional);
        System.out.println("Adicionado...");

        System.out.println("Consultando no adicionar...");
        consultar();
        System.out.println("Consultado no adicionar...");
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public List<Profissional> getTodosProfissionais() {
        return todosProfissionais;
    }

    public Especializacao[] getEspecializacao() {
        return Especializacao.values();
    }
    
}
