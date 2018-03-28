<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>AgendaWeb</h1>
    <div>
      <ul>
	<c:forEach items="${pessoas}" var="p">
	  <li>
	    <h2><c:out value="${p.nome}" /></h2>
	    <p>Data de nascimento: <fmt:formatDate value="${p.dtNascimento}" pattern="dd/MM/yyyy" /></p>
	  </li>
	</c:forEach>
      </ul>
    </div>
  </body>
</html>
