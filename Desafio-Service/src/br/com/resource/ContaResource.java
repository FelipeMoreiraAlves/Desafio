package br.com.resource;

import javax.persistence.EntityManager;

import br.com.dao.ContaDAO;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

public class ContaResource {

	private ContaDAO dao;
	
	//Inicializando o objeto dao no Construtor
	public ContaResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ContaDAOImpl(em);
	}
}
