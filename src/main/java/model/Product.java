package model;

import java.math.BigDecimal;

public class Product {

    private int id;
    private int userId;
    private String category;
    private String brand;
    private String name;
    private Integer stock;
    private BigDecimal price;

    public Product(){};
    public Product(int id, int userId, String category,
                   String brand, String name, Integer stock, BigDecimal price) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.brand = brand;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Product(int userId, String category,
                   String brand, String name, Integer stock, BigDecimal price) {
        this.userId = userId;
        this.category = category;
        this.brand = brand;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", userId=" + userId +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
