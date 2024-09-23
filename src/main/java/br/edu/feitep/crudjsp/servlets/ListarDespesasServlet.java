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
import java.util.List;

/**
 * @author allan
 * @Date: 15/09/2024
 */

@WebServlet("/listarDespesas")
public class ListarDespesasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DespesaDAO dao = new DespesaDAO(ConnectionFactory.getConnection());
        List<Despesa> despesas = dao.findAll();
        request.setAttribute("despesas", despesas);

        String statusReq = (String) request.getAttribute("status");
        if(statusReq == null){
            request.setAttribute("status", "");
        }

        request.getRequestDispatcher("listar-despesas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}