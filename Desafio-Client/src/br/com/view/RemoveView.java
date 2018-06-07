package br.com.view;

import java.util.Scanner;

import br.com.service.ContaService;

public class RemoveView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ID");
		int codigo = (sc.nextInt());
		
		ContaService service = new ContaService();
		
		try {
			service.remover(codigo);
			System.out.println("Removido!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
		
		
	}
}
