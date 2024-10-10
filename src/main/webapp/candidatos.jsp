<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Candidato"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Candidato> lista = (ArrayList<Candidato>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Candidatos</title>
<link type="text/css" rel="stylesheet" href="./styles/index.css">
</head>
<body>
	<h1>Lista de Candidatos</h1>
	<a href="novocandidato.html"><button>Novo candidato</button></a>
	<table id="tabela">
		<thead>
			<tr>
				<th>id</th>
				<th>nome</th>
				<th>sexo</th>
				<th>Data de Nascimento</th>
				<th>Cargo Pretendido</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<% for(int i = 0; i<lista.size(); i++){ %>
				<tr>
					<td><%=lista.get(i).getCodigo() %></td>
					<td><%=lista.get(i).getNome() %></td>
					<td><%=lista.get(i).getSexo() %></td>
					<td><%=lista.get(i).getData_nasc() %></td>
					<td><%=lista.get(i).getCargo_pretendido() %></td>
					<td><%=lista.get(i).getTexto_curriculo() %></td>
					<td><a href="javascript: confirmDelete(<%=lista.get(i).getCodigo() %>)"><button class="delete">Deletar</button></a></td>
					
				</tr>
			<% } %>
		</tbody>
	</table>
	<script src="scripts/confirmDelete.js"></script>
</body>
</html>