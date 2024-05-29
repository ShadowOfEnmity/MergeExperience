package by.javaguru.git.mergeexperience;


import by.javaguru.git.mergeexperience.topics.Module3Topics;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/module3")
public class Module3Servlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Модуль 3";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<table>");
        for (Module3Topics value : Module3Topics.values())
            out.println("<tr><td>"
                    + value.getOrder() + "</td><td>"
                    + value.getTopic() + "</td><td>"
                    + value.getDesc()
                    + "</td><td>"
                    +"<a href='"+getServletContext().getContextPath()+"/description/?module=3&order="+value.getOrder()+"'>Подробнее</a>"
                    + "</td></tr>");

        out.println("</table>");
        out.println("<span>");
        out.println("<a href='"+getServletContext().getContextPath()+"/module2"+"'/><-Предыдущий модуль</a>");
        out.println("</span>");
        out.println("<span>");
        out.println("<a style='padding-left: 10%;' href='"+getServletContext().getContextPath()+"/module4"+"'/>Последующий модуль-></a>");
        out.println("</span>");

        out.println("</body></html>");
    }

    public void destroy() {
    }
}