package br.unibh.pessoas;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.pessoas.entidades.PessoaFisica;
import br.unibh.pessoas.persistencia.PessoaFisicaDAO;

public class Testes {

	@Test
	public void testePessoaFisicaFindAll(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		List<PessoaFisica> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 100);
	}
	
	@Test
	public void testePessoaFisicaFind(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica pessoa = dao.find(1L);
		Assert.assertEquals(pessoa.getNome(), "Slade F. Erickson");
	}
}