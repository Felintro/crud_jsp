<%



%>

<div>
    <form action="cadastrarUsuario" method="post">
        <div class="form-group">
            <label>Nome de usuário:</label>
            <input type="text" class="form-control" name="username">
        </div>
        <div class="form-group">
            <label>Senha:</label>
            <input type="password" class="form-control" name="password_key">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success">Enviar</button>
            <a href="login">
                <button type="button" class="btn btn-danger">Voltar</button>
            </a>
        </div>
    </form>
</div>