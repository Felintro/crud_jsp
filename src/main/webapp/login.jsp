<%@ include file="includes/header.jsp" %>

<%
    String mensagem = "<div class=\"alert alert-success\">Efetue seu login!</div>";
    String status = (String) request.getAttribute("status");
    if(status.equals("erro-login")) {
        mensagem = "<div class=\"alert alert-danger\">Nome de usuário ou senha inválido!</div>";
    }

%>

<%= mensagem %>

<form action="login" method="post">
    <div class="form-group">
        <label>Nome de usuário:</label>
        <input type="text" class="form-control" name="username" required>
    </div>
    <div class="form-group">
        <label>Senha:</label>
        <input type="password" class="form-control" name="password" required>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-success">Conectar</button>
        <a href="cadastrarUsuario">
            <button type="button" class="btn btn-primary">Cadastrar</button>
        </a>
    </div>
</form>

<%@ include file="includes/footer.jsp" %>