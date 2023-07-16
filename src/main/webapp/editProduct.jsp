<div class="modal fade" id="edit-modal">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="card-title">Edit product</h4>
        <button class="btn-close" data-bs-dismiss="modal"></button>
      </div>
      <div class="modal-body">

        <form novalidate method="POST" action="edit-product">

          <input type="hidden" id="edit-id" name="id">

          <div class="form-floating mt-3">
            <input type="text" id="edit-category" class="form-control" name="category" placeholder="Place category here" required>
            <label for="edit-category" class="form-label">Category</label>
          </div>

          <div class="form-floating mt-3">
            <input type="text" id="edit-brand" class="form-control" name="brand" placeholder="Place brand here" required>
            <label for="edit-brand" class="form-label">Brand</label>
          </div>

          <div class="form-floating mt-3">
            <input type="text" id="edit-name" class="form-control" name="name" placeholder="Place name here" required>
            <label for="edit-name" class="form-label">Name</label>
          </div>

          <div class="form-floating mt-3">
            <input type="number" id="edit-stock" class="form-control" name="stock" placeholder="Place stock here" required>
            <label for="edit-stock" class="form-label">Stock</label>
          </div>

          <div class="form-floating mt-3">
            <input type="number" id="edit-price" class="form-control" name="price" placeholder="Place price here" required>
            <label for="edit-price" class="form-label">Price</label>
          </div>

          <div class="d-flex flex-column">
            <button class="btn btn-primary mt-4 mb-2 ">Edit product</button>
          </div>
        </form>

      </div>

    </div>
  </div>
</div>