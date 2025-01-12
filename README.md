# Sinema Kayıt Sistemi

![Java](https://img.shields.io/badge/Java-17-orange.svg)
![Maven](https://img.shields.io/badge/Maven-3.8.5-blue.svg)
![Gson](https://img.shields.io/badge/Gson-2.9.0-green.svg)

## Proje Açıklaması

Sinema Kayıt Sistemi, sinema salonları, filmler ve müşterilerle ilgili temel kayıt işlemlerini gerçekleştiren konsol tabanlı bir Java uygulamasıdır. Bu sistem, kullanıcıya çeşitli işlemler yapma imkanı sunar ve verileri JSON dosyalarında saklayarak kalıcı depolama sağlar.

## Özellikler

- **Müşteri Yönetimi:** Yeni müşteriler ekleyebilir, mevcut müşterileri listeleyebilirsiniz.
- **Film Yönetimi:** Yeni filmler ekleyebilir, mevcut filmleri listeleyebilirsiniz.
- **Salon Yönetimi:** Yeni salonlar ekleyebilir, mevcut salonları listeleyebilirsiniz.
- **Bilet Satışı:** Müşterileri salonlara kaydedebilir ve salonlardaki müşterileri görüntüleyebilirsiniz.
- **Veri Saklama:** Tüm veriler JSON dosyalarında saklanır ve uygulama yeniden başlatıldığında veriler geri yüklenir.

## Kullanılan Teknolojiler

- **Java 17:** Uygulamanın temel programlama dili.
- **Maven:** Proje yönetimi ve bağımlılık yönetimi için.
- **Gson:** JSON verilerini işlemek için kullanılan kütüphane.

## Kurulum

### Gereksinimler

- **Java JDK 17:** [İndirmek için tıklayın](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **Maven:** [İndirmek için tıklayın](https://maven.apache.org/download.cgi)
- **Git:** [İndirmek için tıklayın](https://git-scm.com/downloads)

### Adımlar

1. **Depoyu Klonlayın**

   ```bash
   git clone https://github.com/kullanici_adiniz/sinema_odev.git
   cd sinema_odev
```

### Kullanım
Uygulamayı çalıştırdığınızda aşağıdaki menü ile karşılaşacaksınız:

```
=== SİNEMA KAYIT SİSTEMİ ===
1 - Yeni Müşteri Ekle
2 - Yeni Film Ekle
3 - Yeni Salon Ekle
4 - Salona Müşteri Kaydı Yap (Bilet Satışı)
5 - Tüm Müşterileri Listele
6 - Tüm Filmleri Listele
7 - Tüm Salonları Listele
8 - Bir Salonun Müşterilerini Listele
9 - Çıkış
Seçiminiz:
```

Her bir seçenek, ilgili işlemi gerçekleştirmek için sizi yönlendirecektir. Örneğin, "1 - Yeni Müşteri Ekle" seçeneğini seçerek yeni bir müşteri ekleyebilirsiniz.

### Proje Yapısı

```
sinema_odev/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── sinema/
│   │   │           ├── entity/
│   │   │           │   ├── BaseEntity.java
│   │   │           │   ├── Film.java
│   │   │           │   ├── Musteri.java
│   │   │           │   └── Salon.java
│   │   │           ├── interfaces/
│   │   │           │   └── IKayit.java
│   │   │           ├── service/
│   │   │           │   └── JsonDatabaseService.java
│   │   │           └── Main.java
│   │   └── resources/
│   └── test/
```
