/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.agendaweb;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author fernando.tsuda
 */
public class UsuarioSistemaService {

  private static final Map<String, UsuarioSistema> USUARIOS_CADASTRADOS
	  = new LinkedHashMap<>();

  static {
    USUARIOS_CADASTRADOS.put("denver", new UsuarioSistema("denver",
	    "Ricardo Ramos", "abcd1234",
	    Arrays.asList(new Papel("PEAO"))));
    USUARIOS_CADASTRADOS.put("tokio", new UsuarioSistema("tokio",
	    "Silene Oliveira", "abcd1234",
	    Arrays.asList(new Papel("PEAO"))));
    USUARIOS_CADASTRADOS.put("berlin", new UsuarioSistema("berlin",
	    "Andres de Fonollosa", "abcd1234",
	    Arrays.asList(new Papel("PEAO"), new Papel("FODON"))));
    USUARIOS_CADASTRADOS.put("professor", new UsuarioSistema("professor",
	    "Sergio Marquina", "abcd1234",
	    Arrays.asList(new Papel("PEAO"), new Papel("GOD"))));
  }
  
  public UsuarioSistema buscarPorUsername(String username) {
    return USUARIOS_CADASTRADOS.get(username);
  }
}
