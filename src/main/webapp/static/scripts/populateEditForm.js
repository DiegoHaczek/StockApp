$(document).ready(function() {
    $("#edit-modal").on("show.bs.modal", function(event) {
        let button = $(event.relatedTarget),
            productId = button.data("product-id"),
            category = button.data("product-category"),
            brand = button.data("product-brand"),
            name = button.data("product-name"),
            stock = button.data("product-stock"),
            price = button.data("product-price");

        $("#edit-id").val(productId);
        $("#edit-category").val(category);
        $("#edit-brand").val(brand);
        $("#edit-name").val(name);
        $("#edit-stock").val(stock);
        $("#edit-price").val(price);
    });
});