/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.apresentacao.controladores;

import br.org.apaebrasil.spag.dominio.Funcionario;
import br.org.apaebrasil.spag.dominio.repositorio.Funcionarios;
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
public class ControladorFuncionarios implements Serializable {

    private static final long serialVersionUID = 1;

    @Inject
    private Funcionarios funcionarios;
//   repositorio

    private Funcionario funcionario;
    private List<Funcionario> todosFuncionarios;

    public void consultar() {
        todosFuncionarios = funcionarios.recuperarTodos();
    }

    public void novo() {
        funcionario = new Funcionario();
    }

    public String adicionar() {
        funcionarios.inserir(funcionario);
        consultar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Funcionário cadastrado com sucesso!"));
        
        return "/funcionarios/visualiza.xhtml?faces-redirect=true";
    }

    public void alterar() {
        funcionarios.alterar(funcionario);
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public List<Funcionario> getTodosFuncionarios() {
        return todosFuncionarios;
    }
     public void detalhe(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
