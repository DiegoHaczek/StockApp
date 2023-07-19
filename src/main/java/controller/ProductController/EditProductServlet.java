package controller.ProductController;


import dao.ProductDao;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "editProduct", value = "/edit-product")
public class EditProductServlet extends HttpServlet {

    @Inject
    private ProductDao productDao;

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
