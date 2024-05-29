package by.javaguru.git.mergeexperience;

import by.javaguru.git.mergeexperience.topics.Module1Topics;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebServlet("/description/*")
public class DescriptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isStub = true;
        Optional<String> orderParam = Optional.ofNullable(req.getParameter("order"));
        Optional<String> moduleParam = Optional.ofNullable(req.getParameter("module"));
        if (orderParam.isPresent() && moduleParam.isPresent()) {
            final int order = Integer.parseInt(orderParam.get());
            final int module = Integer.parseInt(moduleParam.get());
            Optional<Module1Topics> foundModule = Arrays.stream(Module1Topics.values()).filter(module1Topics -> module1Topics.getOrder() == order).findFirst();
            if (order > 0 && module == 1  && foundModule.isPresent()) {
                isStub = false;
                req.setAttribute("desc", foundModule.get().getDesc());
                req.setAttribute("title", foundModule.get().getTopic());
                req.getRequestDispatcher("/WEB-INF/jsp/description.jsp").forward(req, resp);
            }
        }

        if (isStub) {
            req.getRequestDispatcher("/WEB-INF/jsp/stub.jsp").forward(req, resp);
        }

    }
}
