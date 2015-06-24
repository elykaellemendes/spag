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

    private Funcionario funcionario = new Funcionario();
//    selected

    private List<Funcionario> todosFuncionarios;

    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void consultar() {
        todosFuncionarios = funcionarios.recuperarTodos();
    }

    public void novo() {
        funcionario = new Funcionario();
    }

    public void adicionar() {
        funcionarios.inserir(funcionario);
        consultar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Funcionário cadastrado com sucesso!"));
    }

    public Funcionario recuperar(int codigo) {
        return funcionarios.recuperar(codigo);
    }
    
    public void alterar() {
        funcionarios.alterar(funcionario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Funcionário alterado com sucesso!"));
    }

    public List<Funcionario> getTodosFuncionarios() {
        return todosFuncionarios;
    }

    public Funcionario porProfissional(String nome) {
        return (Funcionario) funcionarios.porProfissional(nome);
    }

    public Funcionario porCpf(String cpf) {
        return (Funcionario) funcionarios.porCpf(cpf);
    }
}
