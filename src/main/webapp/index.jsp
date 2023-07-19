<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <c:forEach var="product" items="${sessionScope['user-products']}">
      <tr>
        <td>${product.id}</td>
        <td>${product.category}</td>
        <td>${product.brand}</td>
        <td>${product.name}</td>
        <td>${product.stock}</td>
        <td>$ ${product.price}</td>
        <td style="width: 9em">
          <button class="btn btn-primary" data-bs-toggle="modal"
                  data-bs-target="#edit-modal"
                  data-product-id="${product.id}"
                  data-product-category="${product.category}"
                  data-product-brand="${product.brand}"
                  data-product-name="${product.name}"
                  data-product-stock="${product.stock}"
                  data-product-price="${product.price}"
          >Edit</button>
          <form class="d-inline" action="delete-product" method="post">
            <input type="hidden" name="product-id" value="${product.id}">
            <button type="submit" class="btn btn-danger">Drop</button>
          </form>
        </td>
      </tr>
    </c:forEach>


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
