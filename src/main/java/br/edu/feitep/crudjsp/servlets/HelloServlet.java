package br.edu.feitep.crudjsp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("   <body>");
        out.println("       <h1>" + "Hello World!" + "</h1>");
        out.println("       <h1>" + "Método Service()" + "</h1>");
        out.println("       <a href=\"/crud-jsp\">Voltar</a>");
        out.println("   </body>");
        out.println("</html>");
    }

}