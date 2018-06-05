package br.com.dao;

import java.util.List;

public interface GenericDAO <T,K> {

	void cadastrar(T entidade);
	void atualizar(T entidade);
	void remover(K chave);
	T buscar(K chave);
	
	List<T> listar();
	
	void commit();
	
}



