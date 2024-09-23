<%@ page import="br.com.codandosimples.model.Despesa" %>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.feitep.crudjsp.utils.DespesaUtils" %>

<%
    String mensagem = "";
    String status = (String) request.getAttribute("status");
    String role = (String) session.getAttribute("role");

    switch(status) {
        case "sucesso":
            mensagem = "<div class=\"alert alert-success mt-3\">Ação executada com sucesso!</div>";
            break;
        case "erro":
            mensagem =  "<div class=\"alert alert-danger\">" +
                        "   Erro ao processar o processo!" +
                        "   <br />" +
                        "   Verifique o log para mais informações!" +
                        "</div>";
            break;
        case "sucesso-exclusao":
            mensagem = "<div class=\"alert alert-success mt-3\">Exclusão executada com sucesso!</div>";
            break;
        case "erro-exclusao":
            mensagem = "<div class=\"alert alert-danger mt-3\">Um erro foi detectado, verifique o log para mais informações!</div>";
            break;
    }

    String conteudo = "";
    List<Despesa> despesas = (List<Despesa>) request.getAttribute("despesas");

    if(!despesas.isEmpty()) {
        for(Despesa despesa : despesas) {
            conteudo += "<tr>" +
                        "   <td>" + despesa.getId() + "</td>" +
                        "   <td>" + despesa.getDescricao() + "</td>" +
                        "   <td>" + DespesaUtils.formatarData(despesa.getData()) + "</td>" +
                        "   <td>" + despesa.getValor() + "</td>" +
                        "   <td>" + despesa.getCategoria() + "</td>" +
                        "   <td> " +
                        "       <a class=\"mt-3\" href=\"alterarDespesa?id=" + despesa.getId() + "\">" +
                        "           <button type=\"button\" class=\"btn btn-default\">" +
                        "               <i class=\"bi bi-gear-fill\"></i>\n" +
                        "           </button>\n" +
                        "       </a>";

            if(role.equals("ADMIN")) {
                conteudo += "       <a class=\"mt-3\" href=\"excluirDespesa?id=" + despesa.getId() + "\">" +
                            "           <button type=\"button\" class=\"btn btn-default\">" +
                            "               <i class=\"bi bi-trash-fill\"></i>\n" +
                            "           </button>\n" +
                            "       </a>";
            }

            conteudo += "   </td>" +
                        "</tr>";
        }
    } else {
        conteudo =  "<tr>" +
                    "   <td colspan=\"6\" class=\"text-center\">\n" +
                    "       Nenhuma vaga encontrada!" +
                    "   </td>" +
                    "</tr>";
    }
%>

<main>
    <%= mensagem %>

    <section>
        <a class="mt-3" href="adicionarDespesa">
            <button type="button" class="btn btn-primary">Adicionar Despesas</button>
        </a>
        <a class="mt-3" href="/crud-jsp">
            <button type="button" class="btn btn-danger">Voltar</button>
        </a>
    </section>

    <section>
        <table class="table bg-light mt-3">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Data</th>
                    <th>Valor</th>
                    <th>Categoria</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <%= conteudo %>
            </tbody>
        </table>
    </section>
</main>