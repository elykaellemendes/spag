/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.dominio.repositorio;

import br.org.apaebrasil.spag.dominio.Funcionario;
import java.util.List;

/**
 *
 * @author Pc
 */
public interface Funcionarios extends Repositorio<Funcionario, Integer> {

    public List<Funcionario> porNome(String nome);

    public List<Funcionario> porCpf(String cpf);
}
