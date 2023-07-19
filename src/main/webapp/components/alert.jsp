<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty requestScope['errorMessage']}">
    <div class="alert alert-danger fixed-bottom w-75 m-auto" id="alert" style="bottom:-3em">
        <strong>Error:</strong> ${requestScope['errorMessage']}
    </div>
</c:if>

