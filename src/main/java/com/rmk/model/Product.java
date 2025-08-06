package com.rmk.model;

//import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by RashMin on 03-11-2016.
 */
@Entity
@Table(name="product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String sku;
    String name;
    int rating;
    double price;
    @Column(name="instock")
    boolean inStock;
    int qty;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalogid",nullable = false)
    Catalog catalog;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return sku != null ? sku.equals(product.sku) : product.sku == null;
    }

    @Override
    public int hashCode() {
        return sku != null ? sku.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", inStock=" + inStock +
                ", qty=" + qty +
                ", catalog=" + catalog.getCatalogId() +
                '}';
    }
}
