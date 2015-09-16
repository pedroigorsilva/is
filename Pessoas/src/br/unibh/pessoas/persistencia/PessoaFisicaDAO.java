package br.unibh.pessoas.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.unibh.pessoas.entidades.PessoaFisica;

public class PessoaFisicaDAO implements DAO<PessoaFisica, Long> {

	@Override
	public PessoaFisica find(Long id) {
		try {

			String sql = "select * from tb_pessoa_fisica WHERE id = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setLong(1, id);

			ResultSet res = qb.executeQuery();
			
			if (res.next()) {
				return new PessoaFisica(
						res.getLong("id"),
						res.getString("nome"), 
						res.getString("endereco"), 
						res.getString("telefone"), 
						res.getString("cpf"), 
						res.getString("email"), 
						res.getDate("data_nascimento"), 
						res.getString("sexo")); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}

	@Override
	public void insert(PessoaFisica t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PessoaFisica t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PessoaFisica t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PessoaFisica> findAll() {
		List<PessoaFisica> listaPesoaFisica = new ArrayList<PessoaFisica>();
		try {
			
			String sql = "select * from tb_pessoa_fisica";
			ResultSet res = JDBCUtil.getConnection().
					prepareStatement(sql).executeQuery();
			
			while (res.next()) {
				listaPesoaFisica.add(new PessoaFisica(
						res.getLong("id"),
						res.getString("nome"), 
						res.getString("endereco"), 
						res.getString("telefone"), 
						res.getString("cpf"), 
						res.getString("email"), 
						res.getDate("data_nascimento"), 
						res.getString("sexo")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return listaPesoaFisica;
	}

}