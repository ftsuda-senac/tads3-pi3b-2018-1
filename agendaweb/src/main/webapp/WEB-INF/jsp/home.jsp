<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Página principal</h1>
    <h2>Bem vindo <c:out value="${sessionScope.usuario.nomeCompleto}" /></h2>
    <h3>Hash BCrypt gerado: <c:out value="${sessionScope.usuario.hashSenha}" /></h3>

    <c:if test="${sessionScope.usuario.verificarPapel('FODON')
		  || sessionScope.usuario.verificarPapel('GOD')}">
	  <a href="${pageContext.request.contextPath}/protegido/chernobyl">Ver plano chernobyl</a>
    </c:if>
	  
    <c:if test="${sessionScope.usuario.verificarPapel('GOD')}">
      <h3>Ligar</h3>
    </c:if>
  </body>
</html>
