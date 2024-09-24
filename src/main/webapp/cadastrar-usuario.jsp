<%
    String mensagem = "";
    final boolean USUARIO_ENCONTRADO = (boolean) request.getAttribute("usuarioEncontrado");

    if(USUARIO_ENCONTRADO) {
        mensagem = "<div class=\"alert alert-danger\">O usuário já existe!</div>";
    }
%>

<%@ include file="includes/header.jsp" %>

<div class="alert alert-success">Efetue seu cadastro!</div>
<%= mensagem %>

<%@ include file="includes/cadastro-login-form.jsp" %>
<%@ include file="includes/footer.jsp" %>
