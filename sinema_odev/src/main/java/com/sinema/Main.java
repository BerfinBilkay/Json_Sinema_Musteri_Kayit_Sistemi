package com.sinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sinema.entity.Film;
import com.sinema.entity.Musteri;
import com.sinema.entity.Salon;
import com.sinema.service.JsonDatabaseService;

public class Main {
// Mevcut kayıtları tutmak için listeler
    private static List<Musteri> musteriler = new ArrayList<>();
    private static List<Film> filmler = new ArrayList<>();
    private static List<Salon> salonlar = new ArrayList<>();

    // JSON servisimiz
    private static JsonDatabaseService dbService = new JsonDatabaseService();

    public static void main(String[] args) {
        // Önce JSON dosyalarında varsa kayıtları okuyup hafızaya alalım
        musteriler = dbService.musteriOku();
        filmler = dbService.filmOku();
        salonlar = dbService.salonOku();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SİNEMA KAYIT SİSTEMİ ===");
            System.out.println("1 - Yeni Müşteri Ekle");
            System.out.println("2 - Yeni Film Ekle");
            System.out.println("3 - Yeni Salon Ekle");
            System.out.println("4 - Salona Müşteri Kaydı Yap (Bilet Satışı)");
            System.out.println("5 - Tüm Müşterileri Listele");
            System.out.println("6 - Tüm Filmleri Listele");
            System.out.println("7 - Tüm Salonları Listele");
            System.out.println("8 - Bir Salonun Müşterilerini Listele");
            System.out.println("9 - Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // buffer temizleme

            switch (secim) {
                case 1:
                    musteriEkle(scanner);
                    break;
                case 2:
                    filmEkle(scanner);
                    break;
                case 3:
                    salonEkle(scanner);
                    break;
                case 4:
                    salonaMusteriEkle(scanner);
                    break;
                case 5:
                    musterileriListele();
                    break;
                case 6:
                    filmleriListele();
                    break;
                case 7:
                    salonlariListele();
                    break;
                case 8:
                    salonMusteriListele(scanner);
                    break;
                case 9:
                    System.out.println("Programdan çıkılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
                    break;
            }
        }
    }

    private static void musteriEkle(Scanner scanner) {
        System.out.print("Müşteri Adı: ");
        String ad = scanner.nextLine();
        System.out.print("Müşteri Email: ");
        String email = scanner.nextLine();

        // ID'yi basitçe liste boyutuna göre verebiliriz ya da
        // var olan en son ID'ye +1 şeklinde de verebilirsiniz.
        Musteri musteri = new Musteri(musteriler.size() + 1, ad, email);
        musteriler.add(musteri);

        // JSON dosyasına kaydet
        dbService.musteriKaydet(musteriler);

        System.out.println("Müşteri eklendi.");
    }

    private static void filmEkle(Scanner scanner) {
        System.out.print("Film Adı: ");
        String ad = scanner.nextLine();
        System.out.print("Film Türü: ");
        String tur = scanner.nextLine();
        System.out.print("Film Süresi (dk): ");
        int sure = scanner.nextInt();
        scanner.nextLine();

        Film film = new Film(filmler.size() + 1, ad, tur, sure);
        filmler.add(film);

        // JSON dosyasına kaydet
        dbService.filmKaydet(filmler);

        System.out.println("Film eklendi.");
    }

    private static void salonEkle(Scanner scanner) {
        System.out.print("Salon Adı: ");
        String ad = scanner.nextLine();

        // Mevcut filmleri listeleyip hangi filmi atayacağımızı sorabiliriz.
        System.out.println("Mevcut Filmler:");
        for (Film f : filmler) {
            System.out.println(f.getFilmId() + " - " + f.getAd());
        }
        System.out.print("Salon için film ID seçiniz (yoksa 0 giriniz): ");
        int filmId = scanner.nextInt();
        scanner.nextLine();

        Film secilenFilm = null;
        if (filmId != 0) {
            for (Film f : filmler) {
                if (f.getFilmId() == filmId) {
                    secilenFilm = f;
                    break;
                }
            }
        }

        Salon salon = new Salon(salonlar.size() + 1, ad, secilenFilm);
        salonlar.add(salon);

        // JSON dosyasına kaydet
        dbService.salonKaydet(salonlar);

        System.out.println("Salon eklendi.");
    }

    private static void salonaMusteriEkle(Scanner scanner) {
        // Salonu seçelim
        System.out.println("Mevcut Salonlar:");
        for (Salon s : salonlar) {
            System.out.println(s.getId() + " - " + s.getAd());
        }
        System.out.print("Müşteri eklemek istediğiniz salonun ID'si: ");
        int salonId = scanner.nextInt();
        scanner.nextLine();

        Salon secilenSalon = null;
        for (Salon s : salonlar) {
            if (s.getId() == salonId) {
                secilenSalon = s;
                break;
            }
        }
        if (secilenSalon == null) {
            System.out.println("Salon bulunamadı!");
            return;
        }

        // Müşteri’yi seçelim
        System.out.println("Mevcut Müşteriler:");
        for (Musteri m : musteriler) {
            System.out.println(m.getId() + " - " + m.getAd());
        }
        System.out.print("Salona eklemek istediğiniz müşteri ID'si: ");
        int musteriId = scanner.nextInt();
        scanner.nextLine();

        Musteri secilenMusteri = null;
        for (Musteri m : musteriler) {
            if (m.getId() == musteriId) {
                secilenMusteri = m;
                break;
            }
        }
        if (secilenMusteri == null) {
            System.out.println("Müşteri bulunamadı!");
            return;
        }

        // Salona müşteriyi ekle
        secilenSalon.musteriEkle(secilenMusteri);

        // Salonu tekrar kaydetmek gerekiyor; listede güncel
        // halini korumak için tüm salonları JSON’a yazıyoruz
        dbService.salonKaydet(salonlar);

        System.out.println("Müşteri salona eklendi.");
    }

    private static void musterileriListele() {
        System.out.println("\n--- TÜM MÜŞTERİLER ---");
        for (Musteri m : musteriler) {
            m.bilgiGoster(); // Override edilmiş metodu çağırıyor
        }
    }

    private static void filmleriListele() {
        System.out.println("\n--- TÜM FİLMLER ---");
        for (Film f : filmler) {
            f.bilgiGoster();
        }
    }

    private static void salonlariListele() {
        System.out.println("\n--- TÜM SALONLAR ---");
        for (Salon s : salonlar) {
            s.bilgiGoster();
        }
    }

    private static void salonMusteriListele(Scanner scanner) {
        System.out.println("Mevcut Salonlar:");
        for (Salon s : salonlar) {
            System.out.println(s.getId() + " - " + s.getAd());
        }
        System.out.print("Müşterilerini listelemek istediğiniz salonun ID'si: ");
        int salonId = scanner.nextInt();
        scanner.nextLine();

        Salon secilenSalon = null;
        for (Salon s : salonlar) {
            if (s.getId() == salonId) {
                secilenSalon = s;
                break;
            }
        }
        if (secilenSalon == null) {
            System.out.println("Salon bulunamadı!");
            return;
        }

        System.out.println("\nSalon: " + secilenSalon.getAd());
        if (secilenSalon.getFilm() != null) {
            System.out.println("Gösterimdeki Film: " + secilenSalon.getFilm().getAd());
        }
        System.out.println("Müşteri Listesi:");
        for (Musteri m : secilenSalon.getMusteriler()) {
            System.out.println(" - " + m.getAd() + " (" + m.getEmail() + ")");
        }
    }
}