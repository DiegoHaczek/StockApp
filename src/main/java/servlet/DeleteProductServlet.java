package servlet;

import dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import persistence.DbClient;

import java.io.IOException;

@WebServlet(name = "deleteProduct", value = "/delete-product")
public class DeleteProductServlet extends HttpServlet {

    private final ProductDao productDao = new ProductDao(new DbClient());


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("user-id");

        int productId = Integer.parseInt(request.getParameter("product-id"));
        productDao.delete(productId);

        session.setAttribute("user-products",productDao.getAllByUser(userId));
        response.sendRedirect("index.jsp");

    }
}