package br.com.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.to.Conta;



public class ContaService {
	private static final String URL = "http://localhost:8080/Desafio-Service/rest/imovel";
	
	private Client client = Client.create();

	public void cadastrar(Conta conta) throws Exception{
		WebResource resource = client.resource(URL);
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, conta);
		
		if(resp.getStatus() != 201) {
			throw new Exception("Erro ao cadastrar!");
		}
	}
	
	public List<Conta> listar() throws Exception {
		WebResource resource = client.resource(URL);
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(resp.getStatus() != 200) {
			throw new Exception("Erro ao listar!");
		}
		return Arrays.asList(resp.getEntity(Conta[].class));
	}

	public void atualizar(Conta conta) throws Exception{
		WebResource resource = client.resource(URL).path(String.valueOf(conta.getId()));
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, conta);
		
		if (resp.getStatus() != 200) {
			throw new Exception("Erro ao atualizar");
		}
	}
	
	public void remover(int codigo) throws Exception{
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		ClientResponse resp = resource.delete(ClientResponse.class);
		
		if(resp.getStatus() != 204) {
			throw new Exception("Erro ao remover!");
		}
	}
		
}
