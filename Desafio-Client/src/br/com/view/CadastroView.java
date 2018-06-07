package br.com.view;

import java.util.Calendar;
import java.util.Scanner;

import br.com.service.ContaService;
import br.com.to.Conta;

public class CadastroView {

	public static void main(String[] args) {
		
		//Ler os dados
		Scanner sc = new Scanner(System.in);
		
		Conta conta = new Conta();
		
		
		System.out.println("ID");
		conta.setId(sc.nextInt());
		
		System.out.println("Nome");
		conta.setNome(sc.nextLine() + sc.next());
		
		System.out.println("Saldo");
		conta.setSaldo(sc.nextDouble());
		
		System.out.println("Data de Abertura da Conta");
		conta.setDataAbertura(Calendar.getInstance());
		
		//Enviar para o webservice
		ContaService service = new ContaService();
		try {
			service.cadastrar(conta);
			System.out.println("Cadastrado");
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		sc.close();
	}
}
