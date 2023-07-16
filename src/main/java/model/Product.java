package model;

public class Product {

    private Long id;
    private Long userId;
    private String category;
    private String brand;
    private String name;
    private Integer stock;
    private double price;

    public Product(Long id, Long userId, String category,
                   String brand, String name, Integer stock, double price) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.brand = brand;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Product(Long userId, String category,
                   String brand, String name, Integer stock, double price) {
        this.userId = userId;
        this.category = category;
        this.brand = brand;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
