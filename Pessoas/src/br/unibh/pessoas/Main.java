package br.unibh.pessoas;

import java.util.Date;

import br.unibh.pessoas.entidades.PessoaFisica;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PessoaFisica p1 = new PessoaFisica(1l, "Pedro", "Rua Das Flores", "3197394912", "0947274829", "teste@teste.com.br", new Date(), "M");
		System.out.println(p1);
	}

}
