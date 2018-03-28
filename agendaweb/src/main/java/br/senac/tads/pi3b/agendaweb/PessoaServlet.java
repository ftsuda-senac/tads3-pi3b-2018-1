/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.agendaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "PessoaServlet", urlPatterns = {"/pessoa"})
public class PessoaServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    
    String nome = request.getParameter("nome");
    String dtNasc = request.getParameter("nascimento");
    
    List<Pessoa> resultados = new ArrayList<Pessoa>();
    Pessoa p1 = new Pessoa(1L, "Fulano da Silva", "23/03/2000");
    resultados.add(p1);
    Pessoa p2 = new Pessoa(2L, "Ciclana de Souza", "01/12/1999");
    resultados.add(p2);
    resultados.add(new Pessoa(3L, "Beltrana da Silva", "03/04/2001"));
    if (nome != null && dtNasc != null) {
      resultados.add(new Pessoa(4L, nome, dtNasc));
    }
    
    request.setAttribute("pessoas", resultados);
    RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("WEB-INF/jsp/lista-pessoa.jsp");
    dispatcher.forward(request, response);

  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

  }


}
