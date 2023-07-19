package controller.AuthController;

import dao.UserDao;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;


@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {

    @Inject
    private UserDao userDao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(userDao.existsByEmail(request.getParameter("email"))){
            request.setAttribute("errorMessage","Already exists a user with the selected email");
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request,response);
        }

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(name,surname,email,password);

        userDao.save(user);

        System.out.println(user);


        response.sendRedirect("login.jsp");
    }


}
