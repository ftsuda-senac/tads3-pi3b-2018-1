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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "ExemploSessaoServlet", urlPatterns = {"/exemplo-sessao"})
public class ExemploSessaoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/jsp/exemplo-sessao.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    String nome = request.getParameter("nome");
    if (nome != null && nome.trim().length() > 0) {
      List<String> nomes = new ArrayList<>();
      nomes.add(nome);
      request.setAttribute("nomes", nomes);
      request.getRequestDispatcher("WEB-INF/jsp/exemplo-sessao.jsp").forward(request, response);
    }

  }

}
