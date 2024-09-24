package br.edu.feitep.crudjsp.servlets;

import br.com.codandosimples.dao.UsuarioDAO;
import br.com.codandosimples.infra.ConnectionFactory;
import br.com.codandosimples.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author allan
 * @Date: 22/09/2024
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("action", "login");
        request.setAttribute("status", "ok");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDAO dao = new UsuarioDAO(ConnectionFactory.getConnection());

        String username = request.getParameter("username");
        String passwordKey = request.getParameter("password");

        User user = dao.findByUsernameAndPassword(username, passwordKey);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole().toString());
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("status", "erro-login");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}