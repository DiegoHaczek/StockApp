<% if (request.getAttribute("errorMessage") != null) { %>
<div class="alert alert-danger fixed-bottom w-75 m-auto" id="alert" style="bottom:-3em">
    <strong>Error:</strong> <%= request.getAttribute("errorMessage") %>
</div>
<% } %>