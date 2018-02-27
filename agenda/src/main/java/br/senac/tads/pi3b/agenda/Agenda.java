/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author fernando.tsuda
 */
public class Agenda {
    
    private Connection obterConexao() throws ClassNotFoundException, SQLException {
        // 1A) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/agendabd", "root", "");
        return conn;
    }

    public void listar() throws ClassNotFoundException, SQLException {

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT id, nome, dtnascimento FROM PESSOA");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                long id = resultados.getLong("id");
                String nome = resultados.getString("nome");
                Date dtNascimento = resultados.getDate("dtnascimento");
                System.out.println(id + ", " + nome + ", " + dtNascimento);
            }
        }
    }
    
    public void incluir() throws ClassNotFoundException, SQLException {
        
        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO PESSOA (nome, dtnascimento) VALUES (?,?)")) {
            stmt.setString(1, "MARIA DE SOUZA");
            GregorianCalendar cal = new GregorianCalendar(1992, 10, 5); // 5 de novembro de 1992  
            stmt.setDate(2, new java.sql.Date(cal.getTimeInMillis()));
            
            int status = stmt.executeUpdate();
            System.out.println("Status: " + status);
        }
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        try {
            agenda.incluir();
            agenda.listar();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
