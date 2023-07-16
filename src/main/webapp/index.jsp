<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <div class="card mt-5 w-50 m-auto">
        <div class="card-body">
            <h4 class="card-title mb-4">Log In</h4>
            <form novalidate action="login" method="POST">
                <div class="form-floating mt-3">
                    <input type="email" id="email" name="email" class="form-control" placeholder="Place email here" required>
                    <label for="email" class="form-label">Email</label>
                    <div class="invalid-feedback">Email is not valid</div>
                </div>

                <div class="form-floating mt-3">
                    <input type="password" id="password" name="password" class="form-control" placeholder="Place password here" required>
                    <label for="password" class="form-label">Password</label>
                    <div class="invalid-feedback">Password is required</div>

                </div>
                <div class="d-flex flex-column">
                    <button class="btn btn-primary mt-3 ">Submit</button>
                    <span class="p-2 mt-3 m-auto">Not registered? <a href="register.jsp">Create an account</a></span>
                </div>
            </form>
        </div>
    </div>
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
