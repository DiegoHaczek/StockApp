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
    <tr>
      <td>101</td>
      <td>Ropa Deportiva</td>
      <td>Nike</td>
      <td>Zapatillas Shox</td>
      <td>87</td>
      <td>$1500</td>
      <td>
        <button class="btn btn-primary">Edit</button>
        <button class="btn btn-danger">Drop</button>
      </td>
    </tr>
    <tr>
      <td>102</td>
      <td>Ropa Deportiva</td>
      <td>Adidas</td>
      <td>Zapatillas Superstar</td>
      <td>103</td>
      <td>$1300</td>
      <td>
        <button class="btn btn-primary">Edit</button>
        <button class="btn btn-danger">Drop</button>
      </td>
    </tr>
    <tr>
      <td>103</td>
      <td>Ropa Urbana</td>
      <td>Levis</td>
      <td>Jean 505</td>
      <td>32</td>
      <td>$2000</td>
      <td>
        <button class="btn btn-primary">Edit</button>
        <button class="btn btn-danger">Drop</button>
      </td>
    </tr>
    <tr>
      <td>104</td>
      <td>Accesorios</td>
      <td>Lacoste</td>
      <td>Gorro Lana</td>
      <td>23</td>
      <td>$500</td>
      <td>
        <button class="btn btn-primary">Edit</button>
        <button class="btn btn-danger">Drop</button>
      </td>
    </tr>
    </tbody>
  </table>
  <button class="btn btn-success">Add Product</button>

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
