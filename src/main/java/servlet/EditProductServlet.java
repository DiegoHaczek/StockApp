package servlet;


import dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;
import persistence.DbClient;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "editProduct", value = "/edit-product")
public class EditProductServlet extends HttpServlet {

    private final ProductDao productDao = new ProductDao(new DbClient());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("user-id");

        Product product = new Product();
        product.setId(Integer.parseInt(request.getParameter("id")));
        product.setBrand(request.getParameter("brand"));
        product.setCategory(request.getParameter("category"));
        product.setName(request.getParameter("name"));
        product.setStock(Integer.valueOf(request.getParameter("stock")));
        product.setPrice((BigDecimal.valueOf(Long.parseLong(request.getParameter("price")))));

        productDao.edit(product);

        session.setAttribute("user-products",productDao.getAllByUser(userId));
        response.sendRedirect("index.jsp");

    }

}
