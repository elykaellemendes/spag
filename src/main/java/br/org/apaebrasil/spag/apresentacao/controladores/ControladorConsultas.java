/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.apresentacao.controladores;

import br.org.apaebrasil.spag.dominio.Consulta;
import br.org.apaebrasil.spag.dominio.Paciente;
import br.org.apaebrasil.spag.dominio.Profissional;
import br.org.apaebrasil.spag.dominio.repositorio.Consultas;
import br.org.apaebrasil.spag.dominio.repositorio.Pacientes;
import br.org.apaebrasil.spag.dominio.repositorio.Profissionais;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Pc
 */
@Named
@ViewScoped
public class ControladorConsultas implements Serializable {

    private static final long serialVersionUID = 1;

    @Inject
    private Consultas consultas;

    @Inject
    private Pacientes pacientes;

    @Inject
    private Profissionais profissionais;

    private Consulta consulta;

    // Este profissional deve estar na sessão!
    private Profissional profissional;

    public void novo() {
        consulta = new Consulta();
        consulta.setPaciente(new Paciente());
        profissional = profissionais.recuperar(1);
    }

    public void adicionar() {
        consulta.setDataHora(new Date());
        consulta.setProfissional(profissional);
        consulta.setRegistro(new Date().getTime() + "");

        consultas.inserir(consulta);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Consulta cadastrada com sucesso!"));
    }

    public void alterar() {
        consultas.alterar(consulta);
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<Consulta> getConsultasPorPaciente() {
        Paciente p = consulta.getPaciente();

        if (p != null) {
            if (p.getNome() != null && !p.getNome().isEmpty()) {
                return consultas.porPaciente(p);
            } else {
                return Collections.EMPTY_LIST;
            }
        }

        return Collections.EMPTY_LIST;
    }

    public Paciente getPaciente() {
        return consulta.getPaciente();
    }

    public void setPaciente(Paciente paciente) {
        this.consulta.setPaciente(paciente);
    }

    public List<Paciente> pacientesPorNome(String nome) {
        return pacientes.porNome(nome);
    }

    public void onItemSelect(SelectEvent event) {
        this.consulta.setPaciente((Paciente) event.getObject());
    }
}
