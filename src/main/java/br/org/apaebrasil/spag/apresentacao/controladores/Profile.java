/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.apresentacao.controladores;

import br.org.apaebrasil.spag.dominio.Funcionario;
import br.org.apaebrasil.spag.dominio.Profissional;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fbc
 */
@Named
@SessionScoped
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;

    private Profissional profissional;
    private Date dataLogin;

    public Profile() {
    }

    public boolean estaLogado() {
        return profissional != null && profissional.getNome() != null;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Date getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(Date dataLogin) {
        this.dataLogin = dataLogin;
    }
}
