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

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "ExemploServlet", urlPatterns = {"/exemplo1"})
public class ExemploServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensagem = "Primeiro exemplo Servlet";
        
        // Configuração da resposta a ser retornada
        response.setContentType("text/plain"); // Tipo de conteúdo
        response.setCharacterEncoding("UTF-8"); // Codificação do conteúdo
        
        // Abre o objeto de saída para enviar a mensagem ao cliente
        try (PrintWriter out = response.getWriter()) {
            out.println(mensagem);
            out.flush();
        }

    }

}
