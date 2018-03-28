<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Formulário pessoa</h1>
    <div>
      <form action="${pageContext.request.contextPath}/cadastro-pessoa"
	    method="post">
	<div>
	  Nome: <input type="text" name="nome" />
	</div>
	<div>
	  Data nascimento: <input type="text" name="nascimento"/>
	</div>
	<button type="submit">Enviar</button>
      </form>
    </div>
  </body>
</html>
