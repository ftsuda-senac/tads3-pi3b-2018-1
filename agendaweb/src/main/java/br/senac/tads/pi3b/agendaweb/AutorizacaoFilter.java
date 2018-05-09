/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.agendaweb;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebFilter(filterName = "AutorizacaoFilter",
	urlPatterns = {"/protegido/*"},
	servletNames = {"CadastroPessoaServlet", "HomeServlet", 
	  "ChernobylServlet"})
public class AutorizacaoFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request,
	  ServletResponse response, FilterChain chain)
	  throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse
	    = (HttpServletResponse) response;

    HttpSession sessao = httpRequest.getSession();

    // Verifica se existe informacao do usuario na sessao
    if (sessao.getAttribute("usuario") == null) {
      // Usuario nao está logado
      httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
      return;
    }

    UsuarioSistema usuario
	    = (UsuarioSistema) sessao.getAttribute("usuario");
    if (verificarPermissao(usuario, httpRequest, httpResponse)) {
      // Significa que usuario tem permissao de acesso
      chain.doFilter(request, response);
    } else {
      // Usuario nao tem permissao - mostra tela de erro
      httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro-nao-autorizado.jsp");
    }

  }

  @Override
  public void destroy() {
  }

  @Override
  public void init(FilterConfig filterConfig) {

  }

  private boolean verificarPermissao(UsuarioSistema usuario,
	  HttpServletRequest request,
	  HttpServletResponse response) {

    String paginaAcessada = request.getRequestURI();
    String pagina
	    = paginaAcessada.replace(request.getContextPath(), "");

    if (pagina.startsWith("/home")) {
      return true;
    } else if (pagina.startsWith("/protegido/chernobyl")
	    && (usuario.verificarPapel("FODON") || usuario.verificarPapel("GOD"))) {
      return true;
    }
    return false;
  }

}
