package br.unibh.pessoas;

import java.util.Date;
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
	
	@Test
	public void testePessoaFisicaInserirEExcluir(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica p = new PessoaFisica(101l, "Pedro Igor da Silva", "Rua das Flores", "3198574638", "09472618199", "pedro@pedro.com.br", new Date(), "M");
		dao.insert(p);
		PessoaFisica pessoa = dao.find("Pedro Igor da Silva");
		Assert.assertEquals(pessoa.getNome(), "Pedro Igor da Silva");
		
		dao.delete(pessoa);
		
		PessoaFisica pessoa2 = dao.find("Pedro Igor da Silva");
		Assert.assertNull(pessoa2);
	}
}
