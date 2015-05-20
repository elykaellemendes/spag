/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.apresentacao.controladores;

import br.org.apaebrasil.spag.dominio.EstadoCivil;
import br.org.apaebrasil.spag.dominio.Paciente;
import br.org.apaebrasil.spag.dominio.Sexo;
import br.org.apaebrasil.spag.dominio.repositorio.Pacientes;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author fbc
 */
@Named
@ViewScoped
public class ControladorPacientes implements Serializable {

    private static final long serialVersionUID = 1;

    @Inject
    private Pacientes pacientes;

    private Paciente paciente = new Paciente();

    private List<Paciente> todosPacientes;

    public void consultar() {
        System.out.println("Consultando...");
        todosPacientes = pacientes.recuperarTodos();

        for (Paciente p : todosPacientes) {
            System.out.println(p);
        }
    }

    public void novo() {
        System.out.println("Novo...");
        paciente = new Paciente();
    }

    public void adicionar() {
        System.out.println("Adicionando...");
        pacientes.inserir(paciente);
        System.out.println("Adicionado...");

        System.out.println("Consultando no adicionar...");
        consultar();
        System.out.println("Consultado no adicionar...");

//        FacesMessage msg = new FacesMessage("Paciente registrado!");
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//
//        RequestContext.getCurrentInstance().execute("PF('novoPacienteDialog').hide()");
//        RequestContext.getCurrentInstance().update("frm:msgs-geral");
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<Paciente> getTodosPacientes() {
        return todosPacientes;
    }

    public Sexo[] getSexos() {
        return Sexo.values();
    }

    public EstadoCivil[] getEstadosCivil() {
        return EstadoCivil.values();
    }
}
