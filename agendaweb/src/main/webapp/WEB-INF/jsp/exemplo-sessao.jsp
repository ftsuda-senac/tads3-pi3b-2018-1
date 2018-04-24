<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Exemplo sessão</h1>
    <form action="${pageContext.request.contextPath}/exemplo-sessao" method="post">
      <div>
	<label>Digite um nome:</label>
	<input type="text" name="nome" />
      </div>
      <button>Adicionar</button>
    </form>
    <c:if test="${not empty nomes}">
      <h2>Nomes digitados:</h2>
      <ul>
	<c:forEach items="${nomes}" var="nome">
	  <li><c:out value="${nome}" /></li>
	  </c:forEach>
      </ul>
    </c:if>

  </body>
</html>
