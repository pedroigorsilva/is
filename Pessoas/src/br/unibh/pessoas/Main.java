package br.unibh.pessoas;

import java.util.Date;

import br.unibh.pessoas.entidades.PessoaFisica;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PessoaFisica pf1 = new PessoaFisica (1L ,"João", "Rua A", "3333-222", "11113333446", "joao@gmail.com", new Date(), "M");

		System.out.println(pf1);
	}

}
