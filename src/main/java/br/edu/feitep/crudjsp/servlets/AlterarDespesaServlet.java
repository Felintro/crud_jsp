package br.edu.feitep.crudjsp.servlets;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.infra.ConnectionFactory;
import br.com.codandosimples.model.Despesa;
import br.edu.feitep.crudjsp.utils.DespesaUtils;
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

@WebServlet("/alterarDespesa")
public class AlterarDespesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        DespesaDAO dao = new DespesaDAO(ConnectionFactory.getConnection());
        Despesa despesa = dao.findById(id).get();

        request.setAttribute("botaoSubmit", "Salvar");
        request.setAttribute("despesa", despesa);
        request.setAttribute("action", "alterarDespesa");
        request.getRequestDispatcher("alterar-despesa.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Long id = Long.valueOf(request.getParameter("id"));
            Despesa despesa = DespesaUtils.converteRequestEmDespesa(request);
            despesa.setId(id);

            DespesaDAO dao = new DespesaDAO(ConnectionFactory.getConnection());
            dao.update(despesa);

            request.setAttribute("status", "sucesso");
            request.getRequestDispatcher("/listarDespesas").forward(request, response);

        } catch(Exception e) {
            System.out.println("Erro ao alterar a despesa!\nVerifique o log para mais informações!");
            e.printStackTrace();
            request.setAttribute("status", "erro");
            request.getRequestDispatcher("/listarDespesas").forward(request, response);
        }
    }
}