package com.sinema.entity;

public class Film {
    private int filmId;
    private String ad;       // Film Adı
    private String tur;      // Tür (Aksiyon, Komedi, Dram vb.)
    private int sure;        // Süre (dk)

    public Film() {
    }

    public Film(int filmId, String ad, String tur, int sure) {
        this.filmId = filmId;
        this.ad = ad;
        this.tur = tur;
        this.sure = sure;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public int getSure() {
        return sure;
    }

    public void setSure(int sure) {
        this.sure = sure;
    }

    // Filmin temel bilgisini göstermek için
    public void bilgiGoster() {
        System.out.println("Film Bilgisi => ID: " + getFilmId() 
            + ", Ad: " + getAd() 
            + ", Tür: " + getTur() 
            + ", Süre(dk): " + getSure());
    }
}
