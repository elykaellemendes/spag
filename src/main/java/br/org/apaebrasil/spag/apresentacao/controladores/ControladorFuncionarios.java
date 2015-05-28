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
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Pc
 */
@Named
@ViewScoped
public class ControladorFuncionarios implements Serializable{
    
    private static final long serialVersionUID = 1;
    
   @Inject
    private Funcionarios funcionarios;
    
    private Funcionario funcionario = new Funcionario();
    
    private List<Funcionario> todosFuncionarios;
    
    public void consultar() {
        todosFuncionarios = funcionarios.recuperarTodos();
    }

    public void novo() {
        funcionario = new Funcionario();
    }

    public void adicionar() {
        funcionarios.inserir(funcionario);
        consultar();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public List<Funcionario> getTodosFuncionarios() {
        return todosFuncionarios;
    } 
}
