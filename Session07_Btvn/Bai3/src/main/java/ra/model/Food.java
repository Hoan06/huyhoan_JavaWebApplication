package ra.model;

import org.springframework.web.multipart.MultipartFile;

public class Food {
    private String name;
    private String category;
    private double price;
    private int quantity;
    private MultipartFile imagePath;

    public Food() {}

    public Food(String name, String category, double price, int quantity, MultipartFile imagePath) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = imagePath;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public MultipartFile getImagePath() { return imagePath; }
    public void setImagePath(MultipartFile imagePath) { this.imagePath = imagePath; }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
