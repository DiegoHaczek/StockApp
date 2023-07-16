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
            <td>
              <button class="btn btn-primary">Edit</button>
              <button class="btn btn-danger">Drop</button>
            </td>
          </tr>

       <%}}%>
    </tbody>
  </table>
  <button class="btn btn-success" data-bs-toggle="modal"
          data-bs-target="#modal">Add Product</button>

  <jsp:include page="addProduct.jsp"/>

</div>

<jsp:include page="alert.jsp"/>

<script>
  if (!$("#alert").hasClass("")){
    $("#alert").animate({bottom:"5%"},{duration:800}).delay(1000).animate({bottom:"-8%"},{duration:800});
  }
</script>

<script src="static/scripts/validFormInputs.js"></script>

</body>
</html>
