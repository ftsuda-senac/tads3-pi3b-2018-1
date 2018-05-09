/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.agendaweb;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("usuario") != null) {
      // Usuario ja esta logado
      response.sendRedirect(request.getContextPath() + "/home");
    } else {
      request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
	      .forward(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    String username = request.getParameter("username");
    String senha = request.getParameter("senha");

    UsuarioSistemaService service = new UsuarioSistemaService();
    UsuarioSistema usuario = service.buscarPorUsername(username);
    if (usuario != null && usuario.validarSenha(senha)) {
      // Usuario existe e senha está correta
      HttpSession sessao = request.getSession();
      sessao.setAttribute("usuario", usuario);
      response.sendRedirect(request.getContextPath() + "/home");
    } else {
      // Erro no login - mostrar tela de erro
      request.getRequestDispatcher("/WEB-INF/jsp/erro-login.jsp")
	      .forward(request, response);
    }
  }

}
