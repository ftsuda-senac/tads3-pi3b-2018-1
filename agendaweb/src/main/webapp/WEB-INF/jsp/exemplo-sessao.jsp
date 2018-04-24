<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>xemplo sessão</title>
  </head>
  <body>
    <h1>Exemplo sessão</h1>
    <h2>JSESSIONID=<c:out value="${pageContext.request.session.id}" /></h2>
    <form action="${pageContext.request.contextPath}/exemplo-sessao" method="post">
      <div>
	<label>Digite um nome:</label>
	<input type="text" name="nome" />
      </div>
      <button>Adicionar</button>
    </form>
    <c:if test="${not empty sessionScope.nomes}">
      <h2>Nomes digitados:</h2>
      <ul>
	<c:forEach items="${sessionScope.nomes}" var="nome">
	  <li><c:out value="${nome}" /></li>
	</c:forEach>
      </ul>
    </c:if>

  </body>
</html>
