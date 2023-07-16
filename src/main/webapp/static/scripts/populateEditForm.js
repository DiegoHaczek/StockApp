$(document).ready(function() {
    $("#edit-modal").on("show.bs.modal", function(event) {
        var button = $(event.relatedTarget);
        var productId = button.data("product-id");
        var category = button.data("product-category");
        var brand = button.data("product-brand");
        var name = button.data("product-name");
        var stock = button.data("product-stock");
        var price = button.data("product-price");

        $("#edit-category").val(category);
        $("#edit-brand").val(brand);
        $("#edit-name").val(name);
        $("#edit-stock").val(stock);
        $("#edit-price").val(price);
    });
});