<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.senac.tads.pi3b.agendaweb.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
  List<Pessoa> valores = new ArrayList<Pessoa>();
  Pessoa p1 = new Pessoa(1L, "Fulano da Silva", "20/03/1999");
  valores.add(p1);
  Pessoa p2 = new Pessoa(2L, "Ciclana de Souza", "09/12/2001");
  valores.add(p2);
  Pessoa p3 = new Pessoa(3L, "Ze da Silva", "14/10/2002");
  valores.add(p3);
  request.setAttribute("val", valores);
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Dados da pessoa</h1>
    <ul>
      <c:forEach items="${val}" var="p">
	<li>
	  <h2><c:out value="${p.nome}" /></h2>
	  <p><fmt:formatDate value="${p.dtNascimento}" pattern="dd/MM/yyyy" /></p>
	</li>
      </c:forEach>
    </ul>
  </body>
</html>
