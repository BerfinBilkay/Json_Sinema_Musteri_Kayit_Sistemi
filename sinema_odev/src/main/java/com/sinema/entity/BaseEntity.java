package com.sinema.entity;

public abstract class BaseEntity {
    private int id;
    private String ad;  // Ortak bir özellik: ad

    public BaseEntity() {
    }

    public BaseEntity(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    // Polymorphism (çok biçimlilik) için temel bir metot
    public void bilgiGoster() {
        System.out.println("BaseEntity: " + getAd());
    }
}
