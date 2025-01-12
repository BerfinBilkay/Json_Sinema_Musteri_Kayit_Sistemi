# Öğrenci ve Öğretim Görevlisi Yönetim Sistemi

## 📚 Proje Açıklaması

Sinema Kayıt Sistemi, sinema salonları, filmler ve müşteriler arasında etkileşim sağlayan basit bir Java tabanlı uygulamadır. Bu sistem, salon yönetimi, bilet satışı ve müşteri kayıt işlemlerini kolaylaştırmak için tasarlanmıştır. Uygulama, JSON dosyaları aracılığıyla verileri depolar ve yönetir, böylece veritabanı gereksinimini ortadan kaldırır.

## 🚀 Özellikler

- **Müşteri Yönetimi:** Yeni müşteriler ekleyebilir, mevcut müşterileri listeleyebilir ve müşterilerin bilgilerini görüntüleyebilirsiniz.
- **Film Yönetimi:** Yeni filmler ekleyebilir, mevcut filmleri listeleyebilir ve film detaylarını görüntüleyebilirsiniz.
- **Salon Yönetimi:** Yeni salonlar ekleyebilir, mevcut salonları listeleyebilir ve salonlarda gösterilen filmleri görüntüleyebilirsiniz.
- **Bilet Satışı:** Müşterileri salonlara ekleyerek bilet satışı yapabilirsiniz.
- **Veri Saklama:** Tüm veriler JSON dosyalarında saklanır, böylece verilerinizi kolayca yedekleyebilir ve yönetebilirsiniz.

## 🛠 Teknolojiler

- **Java 17:** Uygulamanın temel programlama dili.
- **Maven:** Proje yönetimi ve bağımlılık yönetimi için.
- **Gson:** JSON verilerini işlemek için.

## 📦 Kurulum

### 1. Gereksinimler

- [Java JDK 17]([https://dotnet.microsoft.com/download](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)) (versiyon 17)
- [Maven]([https://dotnet.microsoft.com/download](https://maven.apache.org/install.html)) ()

### 2. Projeyi Klonlama

```bash
git clone https://github.com/kullanici-adiniz/sinema_odev.git
cd sinema_odev
```

### Kullanım

Uygulama başlatıldığında, aşağıdaki menü seçeneklerini göreceksiniz:

### Yeni Müşteri Ekle:

Müşteri adı ve email adresi girilir.
Müşteri verisi JSON dosyasına kaydedilir.

### Yeni Film Ekle:

Film adı, türü ve süresi girilir.
Film verisi JSON dosyasına kaydedilir.

### Yeni Salon Ekle:

Salon adı ve gösterilecek film seçilir.
Salon verisi JSON dosyasına kaydedilir.

### Bilet Satışı:

Salon ve müşteri seçilerek müşteriler salona eklenir.
Güncellenen salon verisi JSON dosyasına kaydedilir.
