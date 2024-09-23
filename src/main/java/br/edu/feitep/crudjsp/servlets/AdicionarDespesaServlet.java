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
 * @Date: 12/09/2024
 */

@WebServlet("/adicionarDespesa")
public class AdicionarDespesaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Despesa despesa = DespesaUtils.converteRequestEmDespesa(request);
            DespesaDAO dao = new DespesaDAO(ConnectionFactory.getConnection());
            dao.save(despesa);

            request.setAttribute("status", "sucesso");
            request.getRequestDispatcher("/listarDespesas").forward(request, response);
        } catch(Exception e) {
            System.out.println("Um erro foi detectado!\n");
            e.printStackTrace();
            request.setAttribute("status", "erro");
            request.getRequestDispatcher("/listarDespesas").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("action", "adicionarDespesa");
        request.setAttribute("botaoSubmit", "Enviar");
        request.getRequestDispatcher("/adicionar-despesa.jsp").forward(request, response);
    }
}