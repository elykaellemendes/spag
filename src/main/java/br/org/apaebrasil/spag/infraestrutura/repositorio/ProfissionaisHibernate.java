/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import br.org.apaebrasil.spag.dominio.Profissional;
import br.org.apaebrasil.spag.dominio.Usuario;
import br.org.apaebrasil.spag.dominio.repositorio.Profissionais;
import java.util.List;
import java.util.Objects;
import javax.persistence.Query;

/**
 *
 * @author Pc
 */
public class ProfissionaisHibernate extends RepositorioHibernate<Profissional, Integer> implements Profissionais{

    @Override
    public List<Profissional> porProfissional(String nome) {
        return manager.createQuery("from Profissional p where p.nome = :nome").getResultList();
    }

    @Override
    public List<Profissional> porCpf(String cpf) {
        return manager.createQuery("from Profissional p where p.cpf = :cpf").getResultList();
    }

    @Override
    public List<Profissional> porEspecializacao(String especializacao) {
        return manager.createQuery("from Profissional p where p.especializacao = :especializacao").getResultList();
    }

    @Override
    public Profissional porUsuario(Usuario usuario) {
        Objects.requireNonNull(usuario, "usuário inválido");

        Query query = manager.createQuery("FROM Profissional p WHERE p.login = :login AND p.senha = :senha");
        query.setParameter("login", usuario.getLogin());
        query.setParameter("senha", usuario.getSenha());

        return (Profissional) query.getSingleResult();
    }
}
