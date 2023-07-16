<div class="modal fade" id="modal">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="card-title">Add product</h4>
                <button class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">

                <form novalidate action="add-product" method="POST" class="m-3" id="form">

                    <!--<input type="hidden" id="id" name="id" value="<%=session.getAttribute("user-id")%>">-->

                    <div class="form-floating mt-2">
                        <input type="text" id="category" class="form-control" name="category" placeholder="Place category here" required>
                        <label for="category" class="form-label">Category</label>
                        <div class="invalid-feedback">Category is required</div>
                    </div>

                    <div class="form-floating mt-3">
                        <input type="text" id="brand" class="form-control" name="brand" placeholder="Place brand here" required>
                        <label for="brand" class="form-label">Brand</label>
                        <div class="invalid-feedback">Brand is required</div>
                    </div>

                    <div class="form-floating mt-3">
                        <input type="text" id="name" class="form-control" name="name" placeholder="Place name here" required>
                        <label for="name" class="form-label">Name</label>
                        <div class="invalid-feedback">Name is required</div>
                    </div>

                    <div class="form-floating mt-3">
                        <input type="number" id="stock" class="form-control" name="stock" placeholder="Place stock here" required>
                        <label for="stock" class="form-label">Stock</label>
                        <div class="invalid-feedback">Stock is required</div>
                    </div>

                    <div class="form-floating mt-3">
                        <input type="number" id="price" class="form-control" name="price" placeholder="Place price here" required>
                        <label for="price" class="form-label">Price</label>
                        <div class="invalid-feedback">Price is required</div>
                    </div>

                    <div class="d-flex flex-column">
                        <button class="btn btn-primary mt-4 mb-2" type="submit">Add new product</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>