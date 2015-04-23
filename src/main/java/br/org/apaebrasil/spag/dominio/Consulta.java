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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pc
 */
@ManagedBean
@RequestScoped
@Entity
@Table
public class Consulta implements Serializable {
    @Id
    @GeneratedValue
    private int codigo;
    @Column
    private String numeroRegistro;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;
    
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

    public Consulta(int codigo, String numeroRegistro, Date data, Date horario, String unidade, Paciente paciente, Profissional profissional, String descricao) {
        this.codigo = codigo;
        this.numeroRegistro = numeroRegistro;
        this.data = data;
        this.horario = horario;
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

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
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
