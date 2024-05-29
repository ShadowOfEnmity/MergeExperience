package by.javaguru.git.mergeexperience;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/module2")
public class Module2Servlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Модуль 2";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<span>");
        out.println("<a href='"+request.getContextPath()+"/module1"+"'/><-Предыдущий модуль</a>");
        out.println("</span>");
        out.println("<span>");
        out.println("<a style='padding-left: 10%;' href='"+getServletContext().getContextPath()+"/module3"+"'/>Последующий модуль-></a>");
        out.println("</span>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}