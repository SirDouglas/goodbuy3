<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"  src="<c:url value="/js/jquery-3.1.1.js"/>"> </script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/additional-methods.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-1.3.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.validate.min.js"/>"></script>
<link type="text/css" href="<c:url value="/css/jquery-ui.css"/>" rel="stylesheet" />
<link type="text/css"  href="<c:url value="/css/jquery-ui.theme.css"/>" rel="stylesheet" />
<link type="text/css"  href="<c:url value="/css/james.css"/>" rel="stylesheet" />
<link type="text/css"  href="<c:url value="/css/jquery-autocomplete.css"/>" rel="stylesheet" />
<link href="<c:url value="/goodbuy.css"/>" rel="stylesheet" type="text/css" media="screen" />
<title>Adicionar Produto</title>
</head>
<body>
<h3>Adicionar Produto</h3>
<form id="produtosForm"  action="<c:url value="/produtos"/>" method="post">
<fieldset>
<label for="nome">Nome:</label>
<input id="nome" class="required" minlength="3"  type="text" name="produto.nome" value="${produto.nome}"/>

<label for="descricao">Descrição:</label>
<textarea id="descricao" class="required" maxlength="40" minlength="10" name="produto.descricao">${produto.descricao}</textarea>
 
 <label for="preco">Preço:</label>
 <input id="preco"  class="required" type="text"  name="produto.preco" value="${produto.preco}" />

<button type="submit">Enviar</button>
</fieldset>
</form>
<script type="text/javascript">
jQuery.extend(jQuery.validator.messages, {
required: "Este campo é requerido",
min:  jQuery.validator.format("Este campo tem que ter valor maior que {0}"),
minlength: jQuery.validator.format("Este campo tem quer ter {0} caracteres"),
maxlength:  jQuery.validator.format( "Este campo pode ter no máximo {0}")
	
});
$( '#produtosForm' ).validate({
rules: {
	"produto.preco": {
min: 0.0,
required: true,
number: true

}
}
});
</script>
</body>
</html>