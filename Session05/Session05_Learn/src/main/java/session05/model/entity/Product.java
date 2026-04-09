package session05.model.entity;

import java.sql.Date;

public class Product {
    private int proId;
    private String proName;
    private String producer;
    private int yearMarking;
    private Date expireDate;
    private Double price;

    public Product() {
    }

    public Product(int proId, String proName, String producer, int yearMarking, Date expireDate, Double price) {
        this.proId = proId;
        this.proName = proName;
        this.producer = producer;
        this.yearMarking = yearMarking;
        this.expireDate = expireDate;
        this.price = price;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
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

    public int getYearMarking() {
        return yearMarking;
    }

    public void setYearMarking(int yearMarking) {
        this.yearMarking = yearMarking;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
