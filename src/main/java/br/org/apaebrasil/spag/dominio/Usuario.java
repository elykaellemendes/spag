/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.dominio;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.Embeddable;

/**
 *
 * @author Pc
 */
@Embeddable
public class Usuario implements Serializable {
    private String login;
    private String senha;

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

    private String criptografar(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return new String(hexCodes(md.digest(senha.getBytes())));
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public Usuario() {
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = criptografar(senha);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = criptografar(senha);
    }
}
