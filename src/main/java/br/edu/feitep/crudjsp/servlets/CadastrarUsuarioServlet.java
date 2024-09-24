package br.edu.feitep.crudjsp.servlets;

import br.com.codandosimples.dao.UsuarioDAO;
import br.com.codandosimples.infra.ConnectionFactory;
import br.com.codandosimples.model.Role;
import br.com.codandosimples.model.User;
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
        request.setAttribute("action", "cadastrarUsuario");
        request.setAttribute("usuarioEncontrado", false);
        request.getRequestDispatcher("/cadastrar-usuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsuarioDAO dao = new UsuarioDAO(ConnectionFactory.getConnection());

        if(dao.existsByUsername(username)) {
            request.setAttribute("usuarioEncontrado", true);
            request.getRequestDispatcher("/cadastrarUsuario").forward(request, response);
            return;
        }

        User user = new User(username, password, Role.USER);
        dao.save(user);

        request.setAttribute("action", "login");
        response.sendRedirect("login");
    }
}