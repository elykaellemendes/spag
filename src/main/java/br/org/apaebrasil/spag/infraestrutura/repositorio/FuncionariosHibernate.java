/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import br.org.apaebrasil.spag.dominio.Funcionario;
import br.org.apaebrasil.spag.dominio.repositorio.Funcionarios;
import java.util.List;

/**
 *
 * @author Pc
 */
public class FuncionariosHibernate extends RepositorioHibernate<Funcionario, Integer> implements Funcionarios{

    @Override
    public List<Funcionario> porProfissional(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> porCpf(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
