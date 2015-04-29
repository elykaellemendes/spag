/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pc
 */
@ManagedBean
@RequestScoped
@Entity
public class Consulta implements Serializable {
    @Id
    @GeneratedValue
    private int codigo;
    @Column
    private String registro;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    
    @Column
    private String unidade;
    
    @OneToOne
    private Paciente paciente;
    
    @OneToOne
    private Profissional profissional;
    
    @Column
    private String descricao;

    public Consulta() {
    }

    public Consulta(int codigo, String registro, Date dataHora, String unidade, Paciente paciente, Profissional profissional, String descricao) {
        this.codigo = codigo;
        this.registro = registro;
        this.dataHora = dataHora;
        this.unidade = unidade;
        this.paciente = paciente;
        this.profissional = profissional;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    

}
