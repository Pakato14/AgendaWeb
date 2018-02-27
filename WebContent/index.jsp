<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/estilo.css" type="text/css">
<title>Bem vindo!!!</title>
</head>
<body>
<c:import url="cabecalho.jsp" />
<%-- comentário em JSP aqui: nossa primeira página JSP --%>
<div id="container">
<section>
<%
String mensagem = "Bem vindo ao sistema de agenda da UTD";
%>
<% out.println(mensagem); %>
<br />
<%
String desenvolvido = "Desenvolvido por Daniel Araújo";
%>
<%= desenvolvido %>

</section>
</div>
<div style="clear:both"></div>
<c:import url="rodape.jsp" />
</body>
</html>