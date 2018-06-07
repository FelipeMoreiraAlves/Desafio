package br.com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.service.ContaService;
import br.com.to.Conta;

@ManagedBean
public class ContaBean {

	private Conta conta;
	private ContaService service;
	
	@PostConstruct
	private void init() {
		conta = new Conta();
		service = new ContaService();
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public Conta getConta() {
		return conta;
	}
	
	public List<Conta> getContas(){
		try {
			return service.listar();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String salvar() {
		FacesMessage msg;
		try {
			if(conta.getId() == 0) {
				service.cadastrar(conta);
				msg = new FacesMessage("Conta cadastrada com sucesso!!");
			}else {
				service.atualizar(conta);
				msg = new FacesMessage("Cadastro atualizado com sucesso!");
			}
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = new FacesMessage("Erro ao cadastrar/atualizar!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "conta-lista?faces-redirect=true";
		
	}
	
	public String deletar(int codigo) {
		FacesMessage msg;
		try {
			service.remover(codigo);
			msg = new FacesMessage("Conta apagada");
		}catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao apagar conta");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "conta-lista?faces-redirect=true";
	}
}
