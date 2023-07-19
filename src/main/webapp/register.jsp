<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="head.jsp"/>
<body>
    <jsp:include page="header.jsp"/>

    <div class="container">

        <div class="card mt-5 w-50 m-auto">
            <div class="card-body">
                <h4 class="card-title mb-4">Register</h4>
                <form novalidate action="register" method="POST" >

                    <div class="form-floating mt-3">
                        <input type="text" id="name" name="name" class="form-control" placeholder="Place password here" required>
                        <label for="name" class="form-label">Name</label>
                        <div class="invalid-feedback">Name is required</div>
                    </div>

                    <div class="form-floating mt-3">
                        <input type="text" id="surname" name="surname" class="form-control" placeholder="Place password here" required>
                        <label for="surname" class="form-label">Surname</label>
                        <div class="invalid-feedback">Surname is required</div>
                    </div>

                    <div class="form-floating mt-3">
                        <input type="email" id="email" name="email" class="form-control" placeholder="Place email here" required>
                        <label for="email" class="form-label">Email</label>
                        <div class="invalid-feedback">Invalid Email</div>
                    </div>

                    <div class="form-floating mt-3">
                        <input type="password" id="password"  name="password"class="form-control" placeholder="Place password here" required minlength="8">
                        <label for="password" class="form-label">Password</label>
                        <div class="invalid-feedback">Password minimum length is 8 characters</div>
                    </div>

                    <div class="form-floating mt-3">
                        <input type="password" id="password2" name="password2" class="form-control" placeholder="Place password here" required minlength="8">
                        <label for="password2" class="form-label">Repeat Password</label>
                        <div class="invalid-feedback">Password minimum length is 8 characters</div>
                    </div>

                    <div class="d-flex flex-column">
                        <button class="btn btn-primary mt-4 mb-2">Create Account</button>
                    </div>
                </form>
                <a href="login.jsp"><button class="btn btn-success mt-3">Go Back</button></a>

            </div>
        </div>

    </div>

<jsp:include page="alert.jsp"/>

<script src="static/scripts/animateAlarm.js"></script>
<script src="static/scripts/validFormInputs.js"></script>

</body>
</html>
