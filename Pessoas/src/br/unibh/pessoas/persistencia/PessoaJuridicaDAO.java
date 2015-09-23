package br.unibh.pessoas.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.unibh.pessoas.entidades.PessoaJuridica;

public class PessoaJuridicaDAO implements DAO<PessoaJuridica, Long> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public PessoaJuridica find(Long id) {
		try {

			String sql = "select * from tb_pessoa_juridica WHERE id = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setLong(1, id);

			ResultSet res = qb.executeQuery();
			
			if (res.next()) {
				return new PessoaJuridica(
						res.getLong("id"),
						res.getString("nome"), 
						res.getString("endereco"), 
						res.getString("telefone"), 
						res.getString("cnpj"), 
						res.getDate("dataConstituicao"), 
						res.getString("site")); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}

	public PessoaJuridica find(String nome) {
		try {

			String sql = "select * from tb_pessoa_juridica WHERE nome = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setString(1, nome);

			ResultSet res = qb.executeQuery();
			
			if (res.next()) {
				return new PessoaJuridica(
						res.getLong("id"),
						res.getString("nome"), 
						res.getString("endereco"), 
						res.getString("telefone"), 
						res.getString("cnpj"), 
						res.getDate("dataConstituicao"), 
						res.getString("site"));  
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}
	
	@Override
	public void insert(PessoaJuridica t) {
		try {

			String sql = "INSERT INTO tb_pessoa_juridica"
					 	+"(nome, endereco, telefone, cnpj, data_constituicao, site)"
					 	+"VALUES(?, ?, ?, ?, ?, ?)";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setString(1, t.getNome());
			qb.setString(2, t.getEndereco());
			qb.setString(3, t.getTelefone());
			qb.setString(4, t.getCnpj());
			qb.setString(5, dateFormat.format(t.getDataConstituicao()));
			qb.setString(6, t.getSite());
			
			qb.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
	}

	@Override
	public void update(PessoaJuridica t) {
		try {

			String sql = "UPDATE tb_pessoa_fisica SET"
					 	+"nome = ?, endereco = ?, telefone = ?, cnpj =?, data_constituicao = ?, site = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setString(1, t.getNome());
			qb.setString(2, t.getEndereco());
			qb.setString(3, t.getTelefone());
			qb.setString(4, t.getCnpj());
			qb.setString(5, dateFormat.format(t.getDataConstituicao()));
			qb.setString(6, t.getSite());
			
			qb.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
	}

	@Override
	public void delete(PessoaJuridica t) {
		try {

			String sql = "DELETE FROM tb_pessoa_juridica WHERE id = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setLong(1, t.getId());
			
			qb.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
	}

	@Override
	public List<PessoaJuridica> findAll() {
		List<PessoaJuridica> listaPesoaJuridica = new ArrayList<PessoaJuridica>();
		try {
			
			String sql = "select * from tb_pessoa_juridica";
			ResultSet res = JDBCUtil.getConnection().
					prepareStatement(sql).executeQuery();
			
			while (res.next()) {
				listaPesoaJuridica.add(new PessoaJuridica(
						res.getLong("id"),
						res.getString("nome"), 
						res.getString("endereco"), 
						res.getString("telefone"), 
						res.getString("cnpj"), 
						res.getDate("dataConstituicao"), 
						res.getString("site")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return listaPesoaJuridica;
	}

}