/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import br.org.apaebrasil.spag.dominio.repositorio.Repositorio;
import br.org.apaebrasil.spag.infraestrutura.repositorio.util.DaoManagerHiber;
import java.util.List;

/**
 *
 * @author Pc
 */
public class RepositorioHibernate<T, I> implements Repositorio<T, I> {

    @Override
    public void inserir(T t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(T t) {
        DaoManagerHiber.update(t);
    }

    @Override
    public T recuperar(I i) {
        try {
            return (T) DaoManagerHiber.recover("from Agendamento where codigo='" + i + "'").get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public List<T> recuperarTodos() {
        return DaoManagerHiber.recover("from Agendamento");
//        Como fica o codigo acima, tanto de recuperar todos como de recuperar pelo codigo;
    }
}
