/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.apresentacao.controladores;

import br.org.apaebrasil.spag.dominio.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Pc
 */
@Named
@ViewScoped
public class ControladorUsuarios implements Serializable{
    private static final long serialVersionUID = 1;
    
    @Inject
    private Usuario usuarios;
    
    private Usuario usuario = new Usuario();
    
    private Usuario usuarioLogado;
    
     private String validaSenha = "";
    
    private List<Usuario> todosUsuarios;
    
    public void realizarLogoff() {
        this.usuarioLogado = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", ex.getMessage()));
        }
    }

}
