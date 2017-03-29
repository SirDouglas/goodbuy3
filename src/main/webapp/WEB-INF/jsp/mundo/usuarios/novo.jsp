<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"  src="<c:url value="/js/jquery-3.1.1.js"/>"> </script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.validade.min.js"/>"></script>
<link type="text/css"  href="<c:url value="/css/james.css"/>" rel="stylesheet" />
<link type="text/css"  href="<c:url value="/css/jquery-autocomplete.css"/>" rel="stylesheet" />
<link type="text/css" href="<c:url value="/css/jquery-ui.css"/>" rel="stylesheet" />
<link type="text/css"  href="<c:url value="/css/jquery-ui.theme.css"/>" rel="stylesheet" />
<link href="<c:url value="/goodbuy.css"/>" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>       
<form id="usuariosForm" action="<c:url value="/usuario"/>" method="POST"> 
<fieldset>
<legend>Criar novo usuário</legend>

<label for="nome">Nome:</label>
<input id="nome" class="required" type="text" name="usuario.nome" value="${usuario.nome}"/>
<label for="login">Login: </label>
<input id="login" class="required" type="text" name="usuario.login" value="${usuario.login}" />
<label for="senha">Senha:</label>
<input id="senha" class="required" type="password" name="usuario.senha" />
<label for="confirmacao">Confirme a senha:</label>
<input id="confirmarcao" equalTo="senha" type="password" />
<button type="submit">Enviar</button>
</fieldset>
</form>
<script type="text/javascript">
$('#usuariosForm').validate();
</script>
</body>
</html>