package servlet;

//import dao.UserDao;
import dao.ProductDao;
import dao.UserDao;
import jakarta.servlet.http.HttpSession;
import persistence.DbClient;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    private final UserDao userDao = new UserDao(new DbClient());
    private final ProductDao productDao = new ProductDao(new DbClient());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(!userDao.existsByEmail(request.getParameter("email"))){
            refreshPageWithErrorMessage(request, response, "Account doesn't exists");
        }
        User user = userDao.findByEmail(request.getParameter("email"));

        if (!Objects.equals(user.getPassword(), request.getParameter("password"))) {
            refreshPageWithErrorMessage(request, response, "Wrong Password");
        }

        HttpSession session = request.getSession();
        session.setAttribute("user-products",productDao.getAll());

        response.sendRedirect("main.jsp");
    }

    private static void refreshPageWithErrorMessage(HttpServletRequest request, HttpServletResponse response, String errorMessage)
            throws ServletException, IOException {
        request.setAttribute("errorMessage", errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
