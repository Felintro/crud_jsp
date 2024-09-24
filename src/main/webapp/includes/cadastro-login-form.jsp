<%
    final String ACTION = (String) request.getAttribute("action");
    String btSubmit = "";
    String btCancel = "";
    String classBtCancel = "";
    String hrefBtCancel = "";

    if(ACTION.equals("login")) {
        btSubmit = "Conectar";
        btCancel = "Cadastrar";
        classBtCancel = "btn btn-primary";
        hrefBtCancel = "cadastrarUsuario";
    } else if(ACTION.equals("cadastrarUsuario")) {
        btSubmit = "Enviar";
        btCancel = "Voltar";
        classBtCancel = "btn btn-danger";
        hrefBtCancel = "login";
    }
%>

<form action="<%= ACTION %>" method="post">
    <div class="form-group">
        <label>Nome de usuário:</label>
        <input type="text" class="form-control" name="username" required>
    </div>
    <div class="form-group">
        <label>Senha:</label>
        <input type="password" class="form-control" name="password" required>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-success"><%= btSubmit %></button>
        <a href="<%= hrefBtCancel %>">
            <button type="button" class="<%= classBtCancel %>"><%= btCancel %></button>
        </a>
    </div>
</form>