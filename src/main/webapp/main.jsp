<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
<body>
<jsp:include page="header.jsp"/>

<div class="container">

  <table class="table table-striped table-hover mt-3">
    <thead>
    <tr>
      <th>Id</th>
      <th>Category</th>
      <th>Brand</th>
      <th>Name</th>
      <th>Stock</th>
      <th>Price</th>
      <th>Actions</th>
    </tr>
    </thead>

    <tbody style="line-height: 2.5em;">

    <% List<Product> products = (List<Product>) request.getSession().getAttribute("user-products");
        if(!Objects.isNull(products)) {
        for(Product product : products){ %>
          <tr>
            <td><%=product.getId()%></td>
            <td><%=product.getCategory()%></td>
            <td><%=product.getBrand()%></td>
            <td><%=product.getName()%></td>
            <td><%=product.getStock()%></td>
            <td><%=product.getPrice()%></td>
            <td style="width: 9em">
              <button class="btn btn-primary" data-bs-toggle="modal"
                      data-bs-target="#edit-modal"
                      data-product-id="<%=product.getId()%>"
                      data-product-category="<%=product.getCategory()%>"
                      data-product-brand="<%=product.getBrand()%>"
                      data-product-name="<%=product.getName()%>"
                      data-product-stock="<%=product.getStock()%>"
                      data-product-price="<%=product.getPrice()%>"
              >Edit</button>
              <form class="d-inline" action="delete-product" method="post">
                <input type="hidden" name="product-id" value="<%=product.getId()%>">
                <button type="submit" class="btn btn-danger">Drop</button>
              </form>
            </td>
          </tr>

       <%}}%>
    </tbody>
  </table>
  <button class="btn btn-success" data-bs-toggle="modal"
          data-bs-target="#modal">Add Product</button>

  <jsp:include page="editProduct.jsp"/>
  <jsp:include page="addProduct.jsp"/>

</div>

<jsp:include page="alert.jsp"/>

<script src="static/scripts/animateAlarm.js"></script>
<script src="static/scripts/populateEditForm.js"></script>
<script src="static/scripts/validFormInputs.js"></script>

</body>
</html>
