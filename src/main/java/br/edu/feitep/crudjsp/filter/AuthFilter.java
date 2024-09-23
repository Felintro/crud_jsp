package br.edu.feitep.crudjsp.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author allan
 * @Date: 22/09/2024
 */

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        boolean isLoggedIn = session != null && session.getAttribute("username") != null;

        String uri = req.getRequestURI();
        boolean isLoginPage = uri.endsWith("login.jsp") || uri.endsWith("login");
        boolean isRegisterPage = uri.endsWith("cadastrar-usuario.jsp") || uri.endsWith("cadastrarUsuario");

        String role = (String) session.getAttribute("role");
        boolean hasNoPermission = uri.contains("/excluirDespesa") && !role.equals("ADMIN");

        if(isLoggedIn || isLoginPage || isRegisterPage) {
            if(hasNoPermission) {
                res.sendRedirect("forbidden.jsp");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            res.sendRedirect("login");
        }
    }
}