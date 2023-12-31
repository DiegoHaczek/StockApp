<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="components/head.jspf"/>
<body>
<jsp:include page="components/header.jspf"/>

<div class="container">
    <div class="card mt-5 w-50 m-auto">
        <div class="card-body">
            <h4 class="card-title mb-4">Log In</h4>
            <form novalidate action="login" method="POST">
                <div class="form-floating mt-3">
                    <input type="text" id="email" name="email" class="form-control" placeholder="Place email here" required>
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

<jsp:include page="components/alert.jsp"/>

<script src="static/scripts/animateAlarm.js"></script>
<script src="static/scripts/validFormInputs.js"></script>

</body>
</html>
