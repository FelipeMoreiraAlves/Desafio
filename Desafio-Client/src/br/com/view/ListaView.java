package br.com.view;

import java.util.List;

import br.com.service.ContaService;
import br.com.to.Conta;

public class ListaView {

	public static void main(String[] args) {

		ContaService service = new ContaService();

		try {
			List<Conta> lista = service.listar();

			for (Conta conta : lista) {
				System.out.println(conta.getId());
				System.out.println(conta.getNome());
				System.out.println(conta.getSaldo());
				System.out.println(conta.getDataAbertura());
				System.out.println("*****************");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}

	}

}
