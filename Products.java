package sample;


import java.io.Serializable;

public class Products implements Serializable {
    private Integer idproducts;
    private String name;
    private String quality;
    private String date;
    private double price;
    private double weight;

    public Products() {
    }

    public Products(Integer idproducts, String name, String quality, String date, double price, double weight) {
        this.idproducts = idproducts;
        this.name = name;
        this.quality = quality;
        this.date = date;
        this.price = price;
        this.weight = weight;
    }

    public Products(String name, double price, double weight) {
        this.name=name;
        this.price = price;
        this.weight = weight;
    }

    public Products(String name, String quality, String date, double price, double weight) {
        this.name = name;
        this.quality = quality;
        this.date = date;
        this.price = price;
        this.weight = weight;
    }


    public Integer getIdproducts() {
        return idproducts;
    }

    public void setIdproducts(Integer idproducts) {
        this.idproducts = idproducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}