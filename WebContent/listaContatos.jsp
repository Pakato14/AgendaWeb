<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/estilo.css" type="text/css">
<title>Tabela de Contatos</title>
</head>
<body>
<c:import url="cabecalho.jsp" />

<div id="container">
<section>
<table>
<tr>
<td>Id</td>
<td>Nome</td>
<td>Email</td>
<td>Telefone</td>
<td>Data de Nascimento</td>
<td>Cidade</td>
</tr>
<c:forEach var="contato" items="${contatos}">
<tr>
<td>${contato.id}</td>
<td>${contato.nome}</td>
<td><a href="mailto:${contato.email}">${contato.email}</td>
<td><c:if test="${empty contato.telefone}">
	Não Informado
	</c:if>
	<c:if test="${not empty contato.telefone}">
	${contato.telefone}
	</c:if>
</td>
<td><fmt:formatDate value="${contato.dataNascimento.time}"
pattern="dd/MM/yyyy" /></td>
<td>${contato.cidade}</td>
<td><a href="mvc?logica=RemoveContato&id=${contato.id}">Remover</a>
</td>
</tr>
</c:forEach>
</table>
</section>
</div>
<div style="clear:both"></div>
<c:import url="rodape.jsp" />
</body>
</html>