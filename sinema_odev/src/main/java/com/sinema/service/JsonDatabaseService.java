package com.sinema.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sinema.entity.Film;
import com.sinema.entity.Musteri;
import com.sinema.entity.Salon;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Bu sınıf, basitçe JSON dosyalarına yazma ve okuma işlemleri yapar.
 * Ayrı ayrı Musteri.json, Film.json, Salon.json dosyalarını yönetebilir.
 */
public class JsonDatabaseService {

    private static final String MUSTERI_FILE = "Musteri.json";
    private static final String FILM_FILE    = "Film.json";
    private static final String SALON_FILE   = "Salon.json";

    private Gson gson;

    public JsonDatabaseService() {
        // Pretty printing ile güzel formatlı JSON yazmak için
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // =========== MÜŞTERİLER =============

    public void musteriKaydet(List<Musteri> musteriList) {
        try (FileWriter writer = new FileWriter(MUSTERI_FILE)) {
            gson.toJson(musteriList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Musteri> musteriOku() {
        List<Musteri> musteriler = new ArrayList<>();
        try (FileReader reader = new FileReader(MUSTERI_FILE)) {
            // JSON'dan List<Musteri> olarak parse et
            Musteri[] arr = gson.fromJson(reader, Musteri[].class);
            if (arr != null) {
                for (Musteri m : arr) {
                    musteriler.add(m);
                }
            }
        } catch (IOException e) {
            // Dosya yoksa ilk okumada hata alabiliriz, önemli değil
        }
        return musteriler;
    }

    // =========== FİLMLER =============

    public void filmKaydet(List<Film> filmList) {
        try (FileWriter writer = new FileWriter(FILM_FILE)) {
            gson.toJson(filmList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Film> filmOku() {
        List<Film> filmler = new ArrayList<>();
        try (FileReader reader = new FileReader(FILM_FILE)) {
            Film[] arr = gson.fromJson(reader, Film[].class);
            if (arr != null) {
                for (Film f : arr) {
                    filmler.add(f);
                }
            }
        } catch (IOException e) {
            // Dosya yoksa ilk okumada hata alabiliriz, önemli değil
        }
        return filmler;
    }

    // =========== SALONLAR =============

    public void salonKaydet(List<Salon> salonList) {
        try (FileWriter writer = new FileWriter(SALON_FILE)) {
            gson.toJson(salonList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Salon> salonOku() {
        List<Salon> salonlar = new ArrayList<>();
        try (FileReader reader = new FileReader(SALON_FILE)) {
            Salon[] arr = gson.fromJson(reader, Salon[].class);
            if (arr != null) {
                for (Salon s : arr) {
                    salonlar.add(s);
                }
            }
        } catch (IOException e) {
            // Dosya yoksa ilk okumada hata alabiliriz, önemli değil
        }
        return salonlar;
    }
}
