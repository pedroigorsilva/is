package br.unibh.pessoas;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.pessoas.entidades.PessoaFisica;
import br.unibh.pessoas.entidades.PessoaJuridica;
import br.unibh.pessoas.persistencia.PessoaFisicaDAO;
import br.unibh.pessoas.persistencia.PessoaJuridicaDAO;

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
	
	@Test
	public void testePessoaFisicaUpdateEExcluir(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica p = new PessoaFisica(101l, "Pedro Igor da Silva", "Rua das Flores, 161", "3158374638", "09437618139", "pedro@pedro2.com.br", new Date(), "M");
		dao.insert(p);
		PessoaFisica pessoa = dao.find("Pedro Igor da Silva");
		Assert.assertEquals(pessoa.getNome(), "Pedro Igor da Silva");
		
		pessoa.setNome("Pedro Teste");
		dao.update(pessoa);
		
		PessoaFisica pessoaUpdate = dao.find("Pedro Teste");
		Assert.assertEquals(pessoaUpdate.getNome(), "Pedro Teste");
		
		dao.delete(pessoaUpdate);
		
		PessoaFisica pessoa2 = dao.find("Pedro Igor da Silva");
		Assert.assertNull(pessoa2);
	}
	
	@Test
	public void testePessoaJuridicaFindAll(){
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		List<PessoaJuridica> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 100);
	}
	
	@Test
	public void testePessoaJuridicaFind(){
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica pessoa = dao.find(2L);
		Assert.assertEquals(pessoa.getNome(), "Aladdin R. Buchanan");
	}
	
	@Test
	public void testePessoaJuridicaInserirEExcluir(){
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica p = new PessoaJuridica(101l, "Pedro Igor", "Rua das Flores", "3198574638", "09472618199", new Date(), "www.example.com");
		dao.insert(p);
		PessoaJuridica pessoa = dao.find("Pedro Igor");
		Assert.assertEquals(pessoa.getNome(), "Pedro Igor");
		
		dao.delete(pessoa);
		
		PessoaJuridica pessoa2 = dao.find("Pedro Igor");
		Assert.assertNull(pessoa2);
	}
	
	@Test
	public void testePessoaJuridicaUpdateEExcluir(){
		PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
		PessoaJuridica p = new PessoaJuridica(101l, "Pedro Igor", "Rua das Flores", "3198574638", "09472618199", new Date(), "www.example.com");
		dao.insert(p);
		PessoaJuridica pessoa = dao.find("Pedro Igor");
		Assert.assertEquals(pessoa.getNome(), "Pedro Igor");
		
		pessoa.setNome("Pedro Teste");
		dao.update(pessoa);
		
		PessoaJuridica pessoaUpdate = dao.find("Pedro Teste");
		Assert.assertEquals(pessoaUpdate.getNome(), "Pedro Teste");
		
		dao.delete(pessoaUpdate);
		
		PessoaJuridica pessoa2 = dao.find("Pedro Teste");
		Assert.assertNull(pessoa2);
	}
}
