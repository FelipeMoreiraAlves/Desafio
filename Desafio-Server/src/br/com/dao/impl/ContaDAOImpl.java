package br.com.dao.impl;

import javax.persistence.EntityManager;

import br.com.dao.ContaDAO;
import br.com.entity.Conta;

public class ContaDAOImpl extends GenericDAOImpl<Conta, Integer> implements ContaDAO {
	public ContaDAOImpl(EntityManager em) {
		super(em);
	}
}
