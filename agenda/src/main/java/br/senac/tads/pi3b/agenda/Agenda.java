/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.agenda;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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

    public List<Pessoa> listar() throws ClassNotFoundException, SQLException {

        List<Pessoa> lista = new ArrayList<Pessoa>();

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT id, nome, dtnascimento FROM PESSOA");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                long id = resultados.getLong("id");
                String nome = resultados.getString("nome");
                Date dtNascimento = resultados.getDate("dtnascimento");
                Pessoa p = new Pessoa();
                p.setId(id);
                p.setNome(nome);
                p.setDtNascimento(dtNascimento);
                lista.add(p);
                //System.out.println(id + ", " + nome + ", " + dtNascimento);
            }
        }
        return lista;
    }

    public void incluir() throws ClassNotFoundException, SQLException {

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt
                    = conn.prepareStatement(
                            "INSERT INTO PESSOA (nome, dtnascimento) VALUES (?,?)",
                            Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, "MARIA DE SOUZA");
                GregorianCalendar cal = new GregorianCalendar(1992, 10, 5); // 5 de novembro de 1992  
                stmt.setDate(2, new java.sql.Date(cal.getTimeInMillis()));

                int status = stmt.executeUpdate();

                // Recupera o ID gerado pelo Banco de dados
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    long idPessoa = generatedKeys.getLong(1);

                    try (PreparedStatement stmt2
                            = conn.prepareStatement(
                                    "INSERT INTO CONTATO (tipo, valor, idpessoa) " // espaco
                                    + "VALUES (?,?,?)")) {
                        // E-mail
                        stmt2.setInt(1, 1);
                        stmt2.setString(2, "maria@zmail.com.br");
                        stmt2.setLong(3, idPessoa);
                        stmt2.executeUpdate();
                    }
                    try (PreparedStatement stmt3 = conn.prepareStatement(
                            "INSERT INTO CONTATO (tipo, valor, idpessoa) " // espaco
                            + "VALUES (?,?,?)")) {
                        // Telefone
                        stmt3.setInt(1, 2);
                        stmt3.setString(2, "(11) 98765-4321");
                        stmt3.setLong(3, idPessoa);
                        stmt3.executeUpdate();
                    }

                    // Efetivar todas as operações no BD
                    conn.commit();
                }

            } catch (SQLException e) {
                // Em caso de erro, volta para situação inicial
                conn.rollback();
                throw e;
            }
        }
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        try {
            agenda.incluir();
            List<Pessoa> lista = agenda.listar();
            for (Pessoa p : lista) {
                System.out.println(p.getId() + ", " + p.getNome() + ", " + p.getDtNascimento());
            }
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
