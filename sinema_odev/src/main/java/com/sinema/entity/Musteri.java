package com.sinema.entity;

import com.sinema.interfaces.IKayit;

public class Musteri extends BaseEntity implements IKayit {

    private String email; // Musteri’ye özel ek özellikler

    public Musteri() {
    }

    public Musteri(int id, String ad, String email) {
        super(id, ad);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Polymorphism - BaseEntity'deki bilgiGoster metodunu override edelim
    @Override
    public void bilgiGoster() {
        System.out.println("Müşteri Bilgisi => ID: " + getId() + ", Ad: " + getAd() + ", Email: " + getEmail());
    }

    @Override
    public void kayitEkle() {
        System.out.println("Müşteri kaydı eklendi: " + getAd());
    }

    @Override
    public void kayitListele() {
        System.out.println("Müşteri listelendi: " + getAd());
    }


    
}