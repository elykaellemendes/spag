/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.apresentacao.controladores;

import br.org.apaebrasil.spag.dominio.EstadoCivil;
import br.org.apaebrasil.spag.dominio.Paciente;
import br.org.apaebrasil.spag.dominio.Sexo;
import br.org.apaebrasil.spag.dominio.UF;
import br.org.apaebrasil.spag.dominio.repositorio.Pacientes;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

    private Paciente paciente;
    private List<Paciente> todosPacientes;

    public void consultar() {
        todosPacientes = pacientes.recuperarTodos();
    }

    public void novo() {
        paciente = new Paciente();
    }

    public String adicionar() {
        pacientes.inserir(paciente);
        consultar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Paciente cadastrado com sucesso!"));
        
        return "/pacientes/visualiza.xhtml?faces-redirect=true";
    }

    public void alterar() {
        pacientes.alterar(paciente);
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

    public UF[] getUFS() {
        return UF.values();
    }
    
    public void detalhe(Paciente paciente) {
        this.paciente = paciente;
    }
}
