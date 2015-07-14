/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import br.org.apaebrasil.spag.dominio.Funcionario;
import br.org.apaebrasil.spag.dominio.repositorio.Funcionarios;
import java.util.List;
import java.util.Objects;
import javax.persistence.Query;

/**
 *
 * @author Pc
 */
public class FuncionariosHibernate extends RepositorioHibernate<Funcionario, Integer> implements Funcionarios{

    @Override
    public List<Funcionario> porNome(String nome) {
        Objects.requireNonNull(nome, "nome inválido");

        Query query = manager.createQuery("FROM Funcionario f WHERE f.nome LIKE :nome");
        query.setParameter("nome", "%" + nome + "%");

        return query.getResultList();
    }

    @Override
    public List<Funcionario> porCpf(String cpf) {
        Objects.requireNonNull(cpf, "cpf inválido");

        Query query = manager.createQuery("FROM Funcionario f WHERE f.cpf LIKE :cpf");
        query.setParameter("cpf", "%" + cpf + "%");

        return query.getResultList();
    }
    
    
    
}
