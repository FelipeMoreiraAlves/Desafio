package br.com.service;

import org.apache.catalina.WebResource;

import com.sun.security.ntlm.Client;

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
}
