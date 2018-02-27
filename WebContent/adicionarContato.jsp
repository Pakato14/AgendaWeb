<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="CSS/estilo.css" type="text/css">
		<title>Agenda UTD</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<div id="container">
		
			<section>
				<h3>Contato</h3>
				<h5>Preencha os campos abaixo:</h5>
				<form action="adicionaContato" method="post">
					<p>
						<label for="nome">Nome Completo:</label>
						<input type="text" name="nome">
					</p>
					<p>
						<label for="email">E-mail:</label>
						<input type="email" name="email">
					</p>
					<p>
						<label for="phone">Telefone:</label>
						<input type="tel" name="phone">
					</p>
					<p>
						<label for="start">Data Nascimento:</label>
						<input type="text" name="date">
					</p>
					<p>
						<label for="location">Cidade:</label>
						<input list="location" name="cidade">
						<datalist id="location">
          					<option value="Aquiraz"></option>
            				<option value="Caucaia"></option>
            				<option value="Eusébio"></option>
            				<option value="Fortaleza"></option>
            				<option value="Maracanaúº"></option>
            				<option value="Maranguape"></option>
          				</datalist>
        			</p>
        			<p>
        				<input type="submit" value="Salvar contato">
       				</p>
						
				</form>
			</section>
		</div>
		<div style="clear:both"></div>
		<c:import url="rodape.jsp" />	
	</body>
</html>