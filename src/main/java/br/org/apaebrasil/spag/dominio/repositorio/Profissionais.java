/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.dominio.repositorio;

import br.org.apaebrasil.spag.dominio.Profissional;
import br.org.apaebrasil.spag.dominio.Usuario;
import java.util.List;

/**
 *
 * @author Pc
 */
public interface Profissionais extends Repositorio<Profissional, Integer>{
    public List<Profissional> porProfissional (String nome);
    public List<Profissional> porCpf (String cpf);
    public List<Profissional> porEspecializacao (String especializacao);
    public Profissional porUsuario(Usuario usuario);
}
