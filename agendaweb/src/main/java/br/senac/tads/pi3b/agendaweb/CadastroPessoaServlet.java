/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.agendaweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "CadastroPessoaServlet", urlPatterns = {"/cadastro-pessoa"})
public class CadastroPessoaServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    RequestDispatcher dispatcher
	    = request.getRequestDispatcher("WEB-INF/jsp/form-pessoa.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    
    String nome = request.getParameter("nome");
    String dtNasc = request.getParameter("nascimento");
    
    Pessoa p1 = new Pessoa(1L, nome, dtNasc);
    
    request.setAttribute("pessoaCadastrada", p1);
    
    RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("WEB-INF/jsp/resultado.jsp");
    dispatcher.forward(request, response);

  }

}
