<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"  src="<c:url value="/js/jquery-3.1.1.js"/>"> </script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>
<link type="text/css" href="<c:url value="/css/jquery-ui.css"/>" rel="stylesheet" />
<link type="text/css"  href="<c:url value="/css/jquery-ui.theme.css"/>" rel="stylesheet" />
<link type="text/css"  href="<c:url value="/css/james.css"/>" rel="stylesheet" />
<link type="text/css"  href="<c:url value="/css/jquery-autocomplete.css"/>" rel="stylesheet" />
<link href="<c:url value="/goodbuy.css"/>" rel="stylesheet" type="text/css" media="screen" />
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Nome</th>
<th>Descricao</th>
<th>Preço</th>
<th>Alterar </th>
<th>Remover</th>
<th>Comprar</th> 
</tr>
<c:forEach items="${produtoList}" var="produto">
<tr>
<td>${produto.nome}</td>
<td>${produto.descricao}</td>
<td>${produto.preco}</td>
<c:if test="${usuarioWeb.logado }">
<td><a href="<c:url value="/produtos/${produto.id}"/>"> Alterar</a> </td>
<td>
<form action="<c:url value="/produtos/${produto.id}"/>" method="POST"> 
<button class="link" name="_method" value="DELETE">
Remover
</button>
</form>
</c:if>
<td>
<form action="<c:url value="/carrinho"/>" method="POST">
<input type="hidden" name="item.produto.id" value="${produto.id}" />  
<input class="qtde" name="item.quantidade" value="1" />
<button type="submit">Comprar</button>

 </form>


</td>
</tr>
</c:forEach>
</table>
</body>
</html>