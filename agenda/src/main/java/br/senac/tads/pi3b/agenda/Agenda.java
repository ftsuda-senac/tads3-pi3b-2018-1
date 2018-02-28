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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void incluir(Pessoa p, String email, String telefone) throws ClassNotFoundException, SQLException {

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO PESSOA (nome, dtnascimento) VALUES (?,?)")) {
            stmt.setString(1, p.getNome());
            stmt.setDate(2, new java.sql.Date(p.getDtNascimento().getTime()));

            int status = stmt.executeUpdate();
            System.out.println("Status: " + status);
        }
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        try {
            try (Scanner in = new Scanner(System.in)) {
                System.out.println("Digite o nome:");
                String nome = in.nextLine();
                System.out.println("Digite a data de nascimento no formato dd/MM/yyyy:");
                String strData = in.nextLine();
                System.out.println("Digite o email:");
                String email = in.nextLine();
                System.out.println("Digite o telefone no formato (99) 99999-9999:");
                String telefone = in.nextLine();
                
                DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                Date dtNascimento = null;
                try {
                    dtNascimento = formatador.parse(strData);
                } catch (ParseException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
                Pessoa p = new Pessoa();
                p.setNome(nome);
                p.setDtNascimento(dtNascimento);
                agenda.incluir(p, email, telefone);
            }
            
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
