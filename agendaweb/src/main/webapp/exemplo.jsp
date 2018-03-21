<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  String mensagem = "Primeiro exemplo JSP";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Exemplo JSP + Scriptlet</h1>
    <hr />
    <%
      for (int i = 1; i <= 100; i++) {
    %>
    <h1><%= mensagem%> <%= i%></h1>
    <%
      }
    %>
  </body>
</html>
