/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.apresentacao.controladores;

import br.org.apaebrasil.spag.dominio.Profissional;
import br.org.apaebrasil.spag.dominio.Usuario;
import br.org.apaebrasil.spag.dominio.repositorio.Profissionais;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author fbc
 */
@Named
@RequestScoped
public class ControladorLogin {

    @Inject
    private Profissionais profissionais;

    @Inject
    private Profile profile;
    
    private Profissional profissional;
    private String usuario;
    private String senha;

    public String login() {
        profissional = profissionais.porUsuario(new Usuario(usuario, senha));

        if (profissional != null) {
            profile.setProfissional(profissional);
            
            return "/inicio.xhtml?faces-redirect=true";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage mensagem = new FacesMessage("Usuário/Senha inválidos!");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }

        return null;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
