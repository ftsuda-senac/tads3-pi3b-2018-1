/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.agendaweb;

import java.io.Serializable;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author fernando.tsuda
 */
public class UsuarioSistema implements Serializable {

  private String username;

  private String nomeCompleto;

  private String hashSenha;

  private List<Papel> papeis;

  public UsuarioSistema() {
  }

  public UsuarioSistema(String username, String nomeCompleto, String senhaAberta, List<Papel> papeis) {
    this.username = username;
    this.nomeCompleto = nomeCompleto;
    setSenha(senhaAberta);
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

  public String getHashSenha() {
    return hashSenha;
  }

  public void setHashSenha(String senha) {
    this.hashSenha = senha;
  }
  
  public void setSenha(String senhaAberta) {
    this.hashSenha = BCrypt.hashpw(senhaAberta, BCrypt.gensalt());
  }

  public List<Papel> getPapeis() {
    return papeis;
  }

  public void setPapeis(List<Papel> papeis) {
    this.papeis = papeis;
  }
  
  public boolean validarSenha(String senhaAberta) {
    return BCrypt.checkpw(senhaAberta, hashSenha);
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
