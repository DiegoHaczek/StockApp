package servlet;

import dao.ProductDao;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;
import persistence.DbClient;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "addProduct", value = "/add-product")
public class AddProductServlet extends HttpServlet {

    private final ProductDao productDao = new ProductDao(new DbClient());


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("user-id");

        Product product = new Product();
        product.setUserId(userId);
        product.setBrand(request.getParameter("brand"));
        product.setCategory(request.getParameter("category"));
        product.setName(request.getParameter("name"));
        product.setStock(Integer.valueOf(request.getParameter("stock")));
        product.setPrice((BigDecimal.valueOf(Long.parseLong(request.getParameter("price")))));

        productDao.save(product);

        session.setAttribute("user-products",productDao.getAllByUser(userId));
        //System.out.println(product);
        response.sendRedirect("index.jsp");

    }
}
