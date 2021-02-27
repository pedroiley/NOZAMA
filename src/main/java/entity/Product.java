package entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import Enum.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "products", name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_Id")
    private int productId;

    @Column(name = "category_Id")
    private Type categoryId;

    @Column(name = "price")
    private int price;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private int amount;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    public Product(String name, int price, Type categoryId, int amount) {

        this.categoryId = categoryId;
        this.price = price;
        this.name = name;
        this.amount = amount;
    }
    public void setProductValues(String name, int price, Type type, int amount) {

        this.categoryId = type;
        this.price = price;
        this.name = name;
        this.amount = amount;
    }
    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setId(int id) {
        this.productId = id;
    }

    public Type getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Type categoryId) {
        this.categoryId = categoryId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdated() {
        return updatedAt;
    }

    public void setLastUpdated(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", type=" + categoryId +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
