package br.org.apaebrasil.spag.dominio.repositorio;

import java.util.List;

public interface Repositorio<T, I> {

    public T inserir(T t);

    public void alterar(T t);

    public T recuperar(I i);

    public void remover(I i);

    public List<T> recuperarTodos();
}
