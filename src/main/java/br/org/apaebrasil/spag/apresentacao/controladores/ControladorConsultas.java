/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.apresentacao.controladores;

import br.org.apaebrasil.spag.dominio.Consulta;
import br.org.apaebrasil.spag.dominio.repositorio.Consultas;
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
public class ControladorConsultas implements Serializable {

    private static final long serialVersionUID = 1;

    @Inject
    private Consultas consultas;

    private Consulta consulta;

    private List<Consulta> todasConsultas;

    public void consultar() {
        todasConsultas = consultas.recuperarTodos();
    }

    public void novo() {
        consulta = new Consulta();
    }

    public void adicionar() {
        consultas.inserir(consulta);
        consultar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Consulta realizada com sucesso!"));
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

    public List<Consulta> getTodasConsultas() {
        return todasConsultas;
    }

}
