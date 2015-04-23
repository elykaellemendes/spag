package br.org.apaebrasil.spag.dominio.repositorio;

import java.util.List;

public interface Repositorio<T, I> {
    public void inserir(T t);
    public void alterar(T t);
    public T recuperar(I i);
    public List<T> recuperarTodos();
}
