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
    
    public void consultar() {
//        System.out.println("Consultando...");
//        todosUsuarios = usuarios.recuperarTodos();
//
//        for (Usuario pf : todosUsuarios) {
//            System.out.println(pf);
//        }
    }

    public void novo() {
        System.out.println("Novo...");
        usuario = new Usuario();
    }

//    public void adicionar() {
//          if (!s.getSenha().equals(this.validaSenha)) {
//            FacesContext.getCurrentInstance().addMessage("cadservidor:inSenha",
//                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na Senha!", "As senhas digitadas não conferem!"));
//            return null;
//        }
//
//        s.setSenha(this.criptografar(s.getSenha()));
//        s.setFuncao(funcao);
//        this.rs.inserir(s);
//
//        if (funcao.equals("Administrador")) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Administrador cadastrado com Sucesso!"));
////            try {
////                FacesContext.getCurrentInstance().getExternalContext().redirect("cadastrarCampus.xhtml");
////            } catch (IOException ex) {
////                Logger.getLogger(ControladorServidor.class.getName()).log(Level.SEVERE, null, ex);
////            }
//            return null;
//        }
//
////        try {
////            FacesContext.getCurrentInstance().getExternalContext().redirect("cadastrarServidor.xhtml");
////        } catch (IOException ex) {
////            Logger.getLogger(ControladorServidor.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Servidor cadastrado com Sucesso!"));
//        return null;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//     public boolean verificarSeTemUsuarios() {
//        return this.rs.recuperarTodos().isEmpty();
//    }
//
//    public String realizaLogin(int siape, String senha) {
//        this.usuarioLogado = (Usuario) this.usuarios.recuperar(siape);
//        if (usuarioLogado == null) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Senha ou SIAPE. Incorretos!"));
//            return null;
//        }
//
//        if (!servidorLogado.getSenha().equals(this.criptografar(senha))) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Senha ou SIAPE. Incorretos!"));
//            return null;
//        }
//
//        if (usuarioLogado.getFuncao().equals("Administrador")) {
////            this.setorLogado.setServidor(servidorLogado);
//            ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("adiministradorlogado", servidorLogado);
//
//            try {
//                FacesContext.getCurrentInstance().getExternalContext().redirect("inicialAdministrador.xhtml");
//            } catch (IOException ex) {
//                Logger.getLogger(ControladorServidor.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
////        this.setorLogado = new RepositorioSetorImplemtDB().recuperar(servidorLogado.getSiape());        
//        this.setorLogado = ((RepositorioSetorImplemtDB)rst).recuperarSiape(this.servidorLogado.getSiape());
//
//        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("setorlogado", setorLogado);
//
//        try {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("inicialServidor.xhtml");
//        } catch (IOException ex) {
//            Logger.getLogger(ControladorServidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    public void realizarLogoff() {
        this.usuarioLogado = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", ex.getMessage()));
        }
    }

    private static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }

    private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        String hexString;

        for (int i = 0; i < text.length; i++) {
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length() - 2,
                    hexString.length(), hexOutput, i * 2);
        }
        return hexOutput;
    }

    public String criptografar(String pwd) {
        if (md != null) {
            return new String(hexCodes(md.digest(pwd.getBytes())));
        }
        return null;
    }
}
