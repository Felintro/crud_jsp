package br.edu.feitep.crudjsp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author allan
 * @Date: 22/09/2024
 */

@WebServlet("/cadastrarUsuario")
public class CadastrarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/cadastrar-usuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getAttribute("username");
        String password = (String) request.getAttribute("password_key");
        request.getRequestDispatcher("/listarDespesas").forward(request, response);
    }
}