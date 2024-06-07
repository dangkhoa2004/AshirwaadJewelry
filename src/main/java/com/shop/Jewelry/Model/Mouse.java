/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shop.Jewelry.Model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import jakarta.persistence.*;

/**
 * @author 04dkh
 */
@Entity
@Table(name = "Mouse")
public class Mouse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 50)
    public int id;

    @Column(name = "name", length = 255)
    public String name;

    @Column(name = "description", length = 255)
    public String description;

    @Column(name = "price")
    public double price;

    @Column(name = "saleprice")
    public double saleprice;

    @OneToMany(mappedBy = "mouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Imageurl> imageUrl;

    public Mouse() {
    }

    public Mouse(int id, String name, String description, double price, double saleprice, List<Imageurl> imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.saleprice = saleprice;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public List<Imageurl> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<Imageurl> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String formatPrice(double price) {
        NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        return formatter.format(price) + "₫";
    }

    public String getFormattedPrice() {
        return formatPrice(price);
    }

    public String getFormattedSalePrice() {
        return formatPrice(saleprice);
    }

}
