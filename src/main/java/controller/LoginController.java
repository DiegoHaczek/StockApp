package controller;

//import dao.UserDao;
import dao.UserDao;
import db.DbClient;
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
public class LoginController extends HttpServlet {

    private final UserDao userDao = new UserDao(new DbClient());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    userDao.existsByEmail(request.getParameter("email"));
    User user = userDao.findByEmail(request.getParameter("email"));

    if (!Objects.equals(user.getPassword(), request.getParameter("password"))) {
        request.setAttribute("errorMessage","Incorrect Password");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }

    RequestDispatcher dispatcher = request.getRequestDispatcher("showProducts.jsp");
    dispatcher.forward(request,response);
    }
}
