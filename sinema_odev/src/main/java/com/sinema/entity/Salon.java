package com.sinema.entity;

import com.sinema.interfaces.IKayit;
import java.util.ArrayList;
import java.util.List;

public class Salon extends BaseEntity implements IKayit {

    // Bu salonda gösterilen film
    private Film film; 
    
    // Filme kayıtlı müşteriler listesi
    private List<Musteri> musteriler;

    public Salon() {
        // Listeyi null olmasın diye direkt initialize edebiliriz
        musteriler = new ArrayList<>();
    }

    public Salon(int id, String ad, Film film) {
        super(id, ad);
        this.film = film;
        this.musteriler = new ArrayList<>();
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public List<Musteri> getMusteriler() {
        return musteriler;
    }

    public void setMusteriler(List<Musteri> musteriler) {
        this.musteriler = musteriler;
    }

    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
    }

    // Polymorphism - BaseEntity'deki bilgiGoster metodunu override edelim
    @Override
    public void bilgiGoster() {
        System.out.println("Salon Bilgisi => ID: " + getId() + ", Ad: " + getAd());
        if (film != null) {
            System.out.println("Gösterimdeki Film: " + film.getAd());
        }
        System.out.println("Kayıtlı Müşteri Sayısı: " + musteriler.size());
    }

    // IKayit interface metotları
    @Override
    public void kayitEkle() {
        System.out.println("Salon kaydı eklendi: " + getAd());
    }

    @Override
    public void kayitListele() {
        System.out.println("Salon listelendi: " + getAd());
    }
}
