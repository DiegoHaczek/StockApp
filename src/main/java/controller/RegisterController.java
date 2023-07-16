package controller;

//import dao.UserDao;
import dao.UserDao;
import db.DbClient;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;


@WebServlet(name = "register", value = "/register")
public class RegisterController extends HttpServlet {

    private final UserDao userDao = new UserDao(new DbClient());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        userDao.existsByEmail(request.getParameter("email"));

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(name,surname,email,password);

        userDao.save(user);

        System.out.println(user);


        response.sendRedirect("index.jsp");
        //HttpSession session = request.getSession();
        //session.setAttribute("userList", );

    }


}
