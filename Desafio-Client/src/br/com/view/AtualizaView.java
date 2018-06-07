package br.com.view;

import java.util.Scanner;

import br.com.service.ContaService;
import br.com.to.Conta;

public class AtualizaView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Conta conta = new Conta();
		
		System.out.println("Código");
		conta.getId();
		
		System.out.println("Nome");
		conta.setNome(sc.next() + sc.nextLine());
		
		System.out.println("Saldo");
		conta.setSaldo(sc.nextDouble());
		
		System.out.println("Data de Abertura da Conta");
		conta.getDataAbertura();
		
		ContaService service = new ContaService();
		
		try {
			service.atualizar(conta);
			System.out.println("Atualizado!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		
		sc.close();
	}
}
