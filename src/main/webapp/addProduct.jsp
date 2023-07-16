<div class="modal fade" id="modal">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="card-title">Add product</h4>
                <button class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">

                <form novalidate action="" class="m-3">

                    <div class="form-floating mt-2">
                        <input type="text" id="category" class="form-control" placeholder="Place category here" required>
                        <label for="category" class="form-label">Category</label>
                    </div>

                    <div class="form-floating mt-3">
                        <input type="text" id="brand" class="form-control" placeholder="Place password here" required>
                        <label for="brand" class="form-label">Brand</label>
                    </div>

                    <div class="form-floating mt-3">
                        <input type="text" id="name" class="form-control" placeholder="Place email here" required>
                        <label for="name" class="form-label">Name</label>
                    </div>

                    <div class="form-floating mt-3">
                        <input type="number" id="stock" class="form-control" placeholder="Place password here" minlength="8">
                        <label for="stock" class="form-label">Stock</label>
                    </div>

                    <div class="form-floating mt-3">
                        <input type="number" id="price" class="form-control" placeholder="Place password here" minlength="8">
                        <label for="price" class="form-label">Price</label>
                    </div>

                    <div class="d-flex flex-column">
                        <button class="btn btn-primary mt-4 mb-2 ">Add new product</button>
                    </div>
                </form>

            </div>

        </div>
    </div>
</div>