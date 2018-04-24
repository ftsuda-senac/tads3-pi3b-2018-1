/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.agendaweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    // Recupera o nome enviado na requisição
    String nome = request.getParameter("nome");

    // Valida se nome não é nulo
    if (nome != null && nome.trim().length() > 0) {

      // Obtém a sessão do usuário
      HttpSession sessao = request.getSession();
      List<String> nomes;

      // Se a lista de nomes não estiver na sessão, cria nova
      if (sessao.getAttribute("nomes") == null) {
	nomes = new ArrayList<>();
	sessao.setAttribute("nomes", nomes);
      }

      // Recupera a lista a partir da sessão do usuário e adiciona nome
      nomes = (List<String>) sessao.getAttribute("nomes");
      nomes.add(nome);

      // Atualiza a lista na sessão
      sessao.setAttribute("nomes", nomes);
    }
    request.getRequestDispatcher("WEB-INF/jsp/exemplo-sessao.jsp").forward(request, response);

  }

}
