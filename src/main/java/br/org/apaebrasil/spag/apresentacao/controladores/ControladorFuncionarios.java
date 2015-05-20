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
    
   @Inject
    private Funcionarios funcionarios;
    
    private Funcionario funcionario = new Funcionario();
    
    private List<Funcionario> todosFuncionarios;
    
    public void consultar() {
        System.out.println("Consultando...");
        todosFuncionarios = funcionarios.recuperarTodos();

        for (Funcionario p : todosFuncionarios) {
            System.out.println(p);
        }
    }

    public void novo() {
        System.out.println("Novo...");
        funcionario = new Funcionario();
    }

    public void adicionar() {
        System.out.println("Adicionando...");
        funcionarios.inserir(funcionario);
        System.out.println("Adicionado...");

        System.out.println("Consultando no adicionar...");
        consultar();
        System.out.println("Consultado no adicionar...");
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public List<Funcionario> getTodosFuncionarios() {
        return todosFuncionarios;
    } 
}
