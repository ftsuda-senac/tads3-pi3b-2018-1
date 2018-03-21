<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  String mensagem = "Primeiro exemplo JSP";
  request.setAttribute("msg", mensagem);
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Exemplo JSP + EL + JSTL</h1>
    <hr />
    <c:forEach begin="1" end="100" varStatus="status">
      <h1><c:out value="${msg}" /> <c:out value="${status.index}" /></h1>
    </c:forEach>
  </body>
</html>
