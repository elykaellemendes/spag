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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Pc
 */
@Named
@ViewScoped
public class ControladorProfissionais implements Serializable {

    private static final long serialVersionUID = 1;

    @Inject
    private Profissionais profissionais;

    private Profissional profissional;
    private List<Profissional> todosProfissionais;

    public void consultar() {
        todosProfissionais = profissionais.recuperarTodos();
    }

    public void novo() {
        profissional = new Profissional();
    }

    public String adicionar() {
        profissionais.inserir(profissional);
        consultar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Profissional cadastrado com sucesso!"));
        
        return "/profissionais/visualiza.xhtml?faces-redirect=true";
    }

    public void alterar() {
        profissionais.alterar(profissional);
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

    public void detalhe(Profissional profissional) {
        RequestContext.getCurrentInstance().openDialog("detalhe");
    }
}
