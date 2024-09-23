<%@ page import="br.com.codandosimples.model.Despesa" %>
<%@ page import="br.edu.feitep.crudjsp.utils.DespesaUtils" %>

<%
    String action = request.getAttribute("action").toString();
    Despesa despesa = (Despesa) request.getAttribute("despesa");
    final String BOTAO_SUBMIT = request.getAttribute("botaoSubmit").toString();
    final String BOTAO_VOLTAR = action.equals("excluirDespesa") ? "Cancelar" : "Voltar";
    final String ATTR_DISABLED = action.equals("excluirDespesa") ? "disabled" : "";

    final String CLASSE_BOTAO_SUBMIT = action.equals("excluirDespesa") ? "btn btn-danger" : "btn btn-success";
    final String CLASSE_BOTAO_VOLTAR = action.equals("excluirDespesa") ? "btn btn-success" : "btn btn-primary";
%>

<div>
    <form action="<%= action %>" method="post">
        <% if(!action.equals("adicionarDespesa")) { %>
        <div class="form-group">
            <label>ID:</label>
            <input type="hidden" name="id" value="<%= despesa != null ? despesa.getId() : "" %>">
            <input type="text" disabled class="form-control" name="idVisual" value="<%= despesa != null ? despesa.getId() : "" %>">
        </div>
        <% } %>
        <div class="form-group">
            <label>Descrição:</label>
            <input type="text" <%= ATTR_DISABLED %> class="form-control" name="descricao" value="<%= despesa != null ? despesa.getDescricao() : "" %>">
        </div>
        <div class="form-group">
            <label>Data:</label>
            <input type="text" <%= ATTR_DISABLED %> class="form-control" name="data" value="<%= despesa != null ? DespesaUtils.formatarData(despesa.getData()) : "" %>">
        </div>
        <div class="form-group">
            <label>Valor:</label>
            <input type="text" <%= ATTR_DISABLED %> class="form-control" name="valor" value="<%= despesa != null ? despesa.getValor() : "" %>">
        </div>
        <div class="form-group">
            <label>Categoria:</label>
            <input type="text" <%= ATTR_DISABLED %> class="form-control" name="categoria" value="<%= despesa != null ? despesa.getCategoria() : "" %>">
        </div>
        <div class="form-group">
            <button type="submit" class="<%= CLASSE_BOTAO_SUBMIT %>"><%= BOTAO_SUBMIT %></button>
            <a href="listarDespesas">
                <button type="button" class="<%= CLASSE_BOTAO_VOLTAR %>"><%= BOTAO_VOLTAR %></button>
            </a>
        </div>
    </form>
</div>