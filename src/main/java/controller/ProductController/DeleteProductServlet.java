package controller.ProductController;

import dao.ProductDao;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "deleteProduct", value = "/delete-product")
public class DeleteProductServlet extends HttpServlet {

    @Inject
    private ProductDao productDao;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("user-id");

        int productId = Integer.parseInt(request.getParameter("product-id"));
        productDao.delete(productId);

        session.setAttribute("user-products",productDao.getAllByUser(userId));
        response.sendRedirect("index.jsp");

    }
}