package br.edu.feitep.crudjsp.servlets;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.infra.ConnectionFactory;
import br.com.codandosimples.model.Despesa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author allan
 * @Date: 21/09/2024
 */

@WebServlet("/excluirDespesa")
public class ExcluirDespesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.valueOf(request.getParameter("id"));
            DespesaDAO dao = new DespesaDAO(ConnectionFactory.getConnection());
            Despesa despesa = dao.findById(id).get();

            request.setAttribute("despesa", despesa);
            request.setAttribute("action", "excluirDespesa");
            request.setAttribute("botaoSubmit", "Confirmar");
            request.getRequestDispatcher("excluir-despesa.jsp").forward(request, response);

        } catch(Exception e) {
            System.out.println("Erro ao carregar página de exclusão!");
            e.printStackTrace();

            request.setAttribute("status", "erro-exclusao");
            request.getRequestDispatcher("/listarDespesas").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.valueOf(request.getParameter("id"));
            DespesaDAO dao = new DespesaDAO(ConnectionFactory.getConnection());
            dao.delete(id);
            request.setAttribute("status", "sucesso-exclusao");
        } catch(Exception e) {
            System.out.println("Erro ao excluir a despesa!");
            e.printStackTrace();
            request.setAttribute("status", "erro-exclusao");
        } finally {
            request.getRequestDispatcher("/listarDespesas").forward(request, response);
        }
    }
}