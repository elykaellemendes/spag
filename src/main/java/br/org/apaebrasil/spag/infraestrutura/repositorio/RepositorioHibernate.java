/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.repositorio;

import br.org.apaebrasil.spag.dominio.repositorio.Repositorio;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Pc
 */
public class RepositorioHibernate<T, I> implements Repositorio<T, I>, Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    protected EntityManager manager;

    protected Class<T> obterClasseEntidade() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> type = (Class<T>) parameterizedType.getActualTypeArguments()[0];

        return type;
    }

    @Override
    public T inserir(T t) {
        manager.getTransaction().begin();
        t = manager.merge(t);
        manager.getTransaction().commit();

        return t;
    }

    @Override
    public void alterar(T t) {
        manager.merge(t);
    }

    @Override
    public T recuperar(I i) {
        return manager.find(obterClasseEntidade(), i);
    }

    @Override
    public void remover(I i) {
        manager.remove(recuperar(i));
    }

    @Override
    public List<T> recuperarTodos() {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(obterClasseEntidade());
        Root<T> from = criteriaQuery.from(obterClasseEntidade());
        criteriaQuery.select(from);

        TypedQuery<T> typedQuery = manager.createQuery(criteriaQuery);

        return typedQuery.getResultList();
    }
}
