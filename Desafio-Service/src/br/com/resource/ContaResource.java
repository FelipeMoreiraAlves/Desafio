package br.com.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import br.com.dao.ContaDAO;
import br.com.entity.Conta;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.ws.entity.Imovel;
import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

public class ContaResource {

	private ContaDAO dao;
	
	//Inicializando o objeto dao no Construtor
	public ContaResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ContaDAOImpl(em);
	}
	
	//Cadastrar nova conta
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Conta conta, @Context UriInfo uri) {
		try {
			dao.cadastrar(conta);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	
		UriBuilder url = uri.getAbsolutePathBuilder();
		url.path(String.valueOf(conta.getCodigo()));
		return Response.created(url.build()).build();
	}
	
	//Listar contas cadastradas
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Conta> listar(){
		return dao.listar();
	}
	
	//Atualizar contas cadastradas
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") int codigo, Conta conta) {
		conta.setId(codigo);
		dao.atualizar(conta);
		try {
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public void remover(@PathParam ("id") int codigo) throws KeyNotFoundException {
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
}
