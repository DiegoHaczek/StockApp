package controller.AuthController;

import dao.ProductDao;
import dao.UserDao;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.util.Objects;


@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    @Inject
    private UserDao userDao;
    @Inject
    private ProductDao productDao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(!userDao.existsByEmail(request.getParameter("email"))){
            refreshPageWithErrorMessage(request, response, "Account doesn't exists");
            return;
        }
        User user = userDao.findByEmail(request.getParameter("email"));

        if (!Objects.equals(user.getPassword(), request.getParameter("password"))) {
            refreshPageWithErrorMessage(request, response, "Wrong Password");
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("user-id",user.getId());
        session.setAttribute("user-products",productDao.getAllByUser(user.getId()));
        response.sendRedirect("index.jsp");
    }

    private static void refreshPageWithErrorMessage(HttpServletRequest request, HttpServletResponse response, String errorMessage)
            throws ServletException, IOException {
        request.setAttribute("errorMessage", errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
}
