<%
    final String STATUS = (String) request.getAttribute("status");
    String mensagem = "";

    if(STATUS.equals("erro-login")) {
        mensagem = "<div class=\"alert alert-danger\">Nome de usuário ou senha inválido!</div>";
    }
%>

<%@ include file="includes/header.jsp" %>

<div class="alert alert-success">Efetue seu login!</div>
<%= mensagem %>

<%@ include file="includes/cadastro-login-form.jsp" %>
<%@ include file="includes/footer.jsp" %>