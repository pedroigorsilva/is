package com.pedro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pedro.dao.ClienteDAO;
import com.pedro.entidades.Cliente;

public class CadastraUsuarioServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter(); 
	
		String id    = request.getParameter("id");
		String nome  = request.getParameter("nome");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha"); 
		
		if(id == null){
			if(ClienteDAO.insert(new Cliente(nome, email, login, senha))){ 
				out.print("<p style=\"color:blue\">Cliente Salvo com sucesso</p>"); 
				RequestDispatcher rd=request.getRequestDispatcher("insert.jsp");
				rd.include(request,response);
			} else{ 
				out.print("<p style=\"color:red\">Ocorreu um erro ao salvar o cliente</p>"); 
				RequestDispatcher rd=request.getRequestDispatcher("insert.jsp");
				rd.include(request,response); 
			}
		} else {
			Long userId = Long.parseLong(id);
			if(ClienteDAO.update(new Cliente(userId, nome, email, login, senha))){ 
				out.print("<p style=\"color:blue\">Cliente Editado com sucesso</p>"); 
				RequestDispatcher rd=request.getRequestDispatcher("editar.jsp");
				rd.include(request,response);
			} else{ 
				out.print("<p style=\"color:red\">Ocorreu um erro ao editar o cliente</p>"); 
				RequestDispatcher rd=request.getRequestDispatcher("editar.jsp");
				rd.include(request,response); 
			}
		}
		
		out.close(); 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            Long id = Long.parseLong(request.getParameter("id"));
            Cliente cliente = ClienteDAO.find(id);
            ClienteDAO.delete(cliente);
            forward = "list.jsp";
            request.setAttribute("users", ClienteDAO.findAll()); 
        } else if (action.equalsIgnoreCase("edit")){
            forward = "editar.jsp";
            Long id = Long.parseLong(request.getParameter("id"));
            Cliente cliente = ClienteDAO.find(id);
            request.setAttribute("user", cliente);
        } else if (action.equalsIgnoreCase("lista")){
            forward = "list.jsp";
            request.setAttribute("users", ClienteDAO.findAll());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}