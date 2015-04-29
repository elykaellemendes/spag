/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pc
 */
@Entity
public class Agendamento implements Serializable {

    @Id
    @GeneratedValue
    private int codigo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @OneToOne
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
    private Especializacao especializacao;

    public Agendamento() {
    }

    public Agendamento(int codigo, Date dataHora, Paciente paciente, Especializacao especializacao) {
        this.codigo = codigo;
        this.dataHora = dataHora;
        this.paciente = paciente;
        this.especializacao = especializacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Especializacao getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(Especializacao especializacao) {
        this.especializacao = especializacao;
    }
}
