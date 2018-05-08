/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.agendaweb;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author fernando.tsuda
 */
public class UsuarioSistema implements Serializable {

  private String username;

  private String nomeCompleto;

  private String senha;

  private List<Papel> papeis;

  public UsuarioSistema() {
  }

  public UsuarioSistema(String username, String nomeCompleto, String senha, List<Papel> papeis) {
    this.username = username;
    this.nomeCompleto = nomeCompleto;
    this.senha = senha;
    this.papeis = papeis;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public List<Papel> getPapeis() {
    return papeis;
  }

  public void setPapeis(List<Papel> papeis) {
    this.papeis = papeis;
  }
  
  public boolean validarSenha(String senha) {
    return this.senha.equals(senha);
  }
  
  public boolean verificarPapel(String nomePapel) {
    for (Papel p : papeis) {
      if (p.getNome().equals(nomePapel)) {
	return true;
      }
    }
    return false;
  }

}
