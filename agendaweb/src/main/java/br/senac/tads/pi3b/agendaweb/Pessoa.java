/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.agendaweb;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author fernando.tsuda
 */
public class Pessoa {
    
    private long id;
    
    private String nome;
    
    private Date dtNascimento;
    
    private String email;
    
    private String telefone;
    
    private int sexo;
    
    public Pessoa() {
      
    }
    
    public Pessoa(long id, String nome, String dtNascStr) {
      DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
      this.id = id;
      this.nome = nome;
      try {
	this.dtNascimento = formatador.parse(dtNascStr);
      } catch (ParseException e) {
	
      }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

  public String getEmail() {
    return email;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public int getSexo() {
    return sexo;
  }

  public void setSexo(int sexo) {
    this.sexo = sexo;
  }
    
}
