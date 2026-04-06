package session02.model;

import java.time.LocalDate;

public class Product {
    private String proId;
    private String proName;
    private String producer;
    private Integer yearMarking;
    private LocalDate expiryDate;
    private double price;

    public Product() {
    }

    public Product(String proId, String proName, String producer, Integer yearMarking, LocalDate expiryDate, double price) {
        this.proId = proId;
        this.proName = proName;
        this.producer = producer;
        this.yearMarking = yearMarking;
        this.expiryDate = expiryDate;
        this.price = price;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getYearMarking() {
        return yearMarking;
    }

    public void setYearMarking(Integer yearMarking) {
        this.yearMarking = yearMarking;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
