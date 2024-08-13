package org.demo.greeneats.model;


import jakarta.persistence.*;

@Entity
public class Hamburguer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;
    private Double price;

    private Boolean status;

    public Hamburguer() {
    }

    public Hamburguer(Long id, String name, String description, Double price, Boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
