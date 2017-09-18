package no.hib.dat104;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "webshop",
            description = "Hovedside for webshop",
            urlPatterns = "/webshop")
public class Webshop extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession s = request.getSession(false);
        if (s == null) {
            response.sendRedirect("login?invalidPassword");
        }
        Cart cart = (Cart) s.getAttribute("cart");

        if (!request.getParameter("searchField").isEmpty()) {
            cart.addItem(new Item(request.getParameter("searchField")));
        }

        response.sendRedirect("webshop");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession s = request.getSession(false);
        Cart cart = (Cart) s.getAttribute("cart");



        response.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("       <h1>Min handleliste</h1>");
        out.println("<form action=\"\" method=\"post\">");
        out.println("       <input type=\"submit\" value=\"Legg til\" name=\"add\" />");
        out.println("       <input type=\"text\" name=\"searchField\" /></br>");
        out.println("</form>");

        for (int i=0; i<cart.getItems().size();i++) {
            out.println("<form action=\"remove?item="+ i + "\" method=\"post\">");
            out.println("       <input type=\"submit\" value=\"Slett\" />");
            out.println(        cart.getItems().get(i).getName() + "</br>");
            out.println("</form>");

        }

    }
}
