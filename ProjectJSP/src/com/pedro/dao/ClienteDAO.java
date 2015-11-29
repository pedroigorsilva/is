package com.pedro.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pedro.entidades.Cliente;

public class ClienteDAO {

	public static boolean insert(Cliente c) {
		try {

			String sql = "INSERT INTO cliente"
					 	+"(nome, login, senha, email)"
					 	+"VALUES(?, ?, ?, ?)";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setString(1, c.getNome());
			qb.setString(2, c.getLogin());
			qb.setString(3, c.getSenha());
			qb.setString(4, c.getEmail());
			
			qb.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.closeConnection();
		}
		return true;
	}
	
	public static List<Cliente> findAll() {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			
			String sql = "select * from cliente";
			ResultSet res = JDBCUtil.getConnection().
					prepareStatement(sql).executeQuery();
			
			while (res.next()) {
				listaClientes.add(new Cliente(
						res.getLong("id"),
						res.getString("nome"), 
						res.getString("login"), 
						res.getString("senha"), 
						res.getString("email")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return listaClientes;
	}
	
	public static Cliente find(Long id) {
		try {

			String sql = "select * from cliente WHERE id = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setLong(1, id);

			ResultSet res = qb.executeQuery();
			
			if (res.next()) {
				return new Cliente(
						res.getLong("id"),
						res.getString("nome"), 
						res.getString("login"), 
						res.getString("senha"), 
						res.getString("email")); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}
	
	public static boolean update(Cliente c) {
		try {

			String sql = "UPDATE cliente SET "
					 	+"nome = ?, login = ?, senha = ?, email = ? "
					 	+"WHERE id = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setString(1, c.getNome());
			qb.setString(2, c.getLogin());
			qb.setString(3, c.getSenha());
			qb.setString(4, c.getEmail());
			qb.setLong(5, c.getId());
			
			qb.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.closeConnection();
		}
		
		return true;
	}
	
	public static boolean delete(Cliente c) {
		try {

			String sql = "DELETE FROM cliente WHERE id = ?";
			
			PreparedStatement qb = JDBCUtil.getConnection().prepareStatement(sql);
			qb.setLong(1, c.getId());
			
			qb.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.closeConnection();
		}
		return true;
	}

}
