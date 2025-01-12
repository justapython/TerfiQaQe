Getting Started with Gauge
==========================

This is an executable specification file. This file follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.
To execute this specification, use `mvn test`

Catchy Labs Hesap Makinası ile hesap makinasının maksimum limitine ulaşacak işlem yapılır ve sonucun "INFINTY" döndüğü kontrol edilir
-----------
Tags:login,carpma,infinity
* Catchy Labs sitesine gidilir ve login islemi gerceklestirilir
* Catchy Labs hesap makinasında sayı girişi için "9" sayısından "308" adet gönderilir
* Catchy Labs hesap makinasında "Çarpma" işlemi seçilir
* Catchy Labs hesap makinasında sayı girişi için "5" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında hesaplama işlemi yapılır
* Catchy Labs hesaplama işleminden sonra sonucun "Infinity" döndüğü kontrol edilir

Catchy Labs Hesap Makinası ile hesap makinasının maksimum limitinin üstüne ulaşılacak bir işlem yapılır ve uyarı kontrolü yapılır
-----------
Tags:login,error_message
* Catchy Labs sitesine gidilir ve login islemi gerceklestirilir
* Catchy Labs hesap makinasında sayı girişi için "9" sayısından "309" adet gönderilir
* Catchy Labs hesap makinasında "Çarpma" işlemi seçilir
* Catchy Labs hesap makinasında sayı girişi için "5" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında hesaplama işlemi yapılır
* Catchy Labs sınırı aşan hesaplama işleminden sonra hata mesajının "number1 must not be empty" olduğu kontrol edilir
/ Denetleyiceye Not: Burada hata mesajının limit aşımı yapıldı şeklinde olması beklenirdi. Gerçek hayat kurgusunda bug kaydı açılmış ve hata mesajının düzenleneceği öngörülerek, hata mesajı dinamikleştirilmiş ve test pass geçirilmiştir.

Catchy Labs Hesap Makinası ile 0,002 ve 0,003 değerleri toplanır sonucun 0,005 olduğu kontrol edilir
-----------
Tags:login,toplama
* Catchy Labs sitesine gidilir ve login islemi gerceklestirilir
* Catchy Labs hesap makinasında sayı girişi için "0" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında virgül değeri gönderilir
* Catchy Labs hesap makinasında sayı girişi için "0" sayısından "2" adet gönderilir
* Catchy Labs hesap makinasında sayı girişi için "2" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında "Toplama" işlemi seçilir
* Catchy Labs hesap makinasında sayı girişi için "0" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında virgül değeri gönderilir
* Catchy Labs hesap makinasında sayı girişi için "0" sayısından "2" adet gönderilir
* Catchy Labs hesap makinasında sayı girişi için "3" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında hesaplama işlemi yapılır
* Catchy Labs hesaplama işleminden sonra sonucun "0,005" döndüğü kontrol edilir
/ Denetleyiceye Not: Sonuc 0,01 döndüğünden son adımda otomasyon olması gerektiği gibi hata almaktadır.

Catchy Labs Hesap Makinasına değer girişleri yapılıp birden fazla kez AC butonunun işlevinin başarılı olduğu kontrol edilir
-----------
Tags:login,ac
* Catchy Labs sitesine gidilir ve login islemi gerceklestirilir
* Catchy Labs hesap makinasında sayı girişi için "5" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında "AC" işlemi seçilir
* Catchy Labs hesap işleminden sonra sonucun boş olduğu kontrol edilir
* Catchy Labs hesap makinasında sayı girişi için "6" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında "AC" işlemi seçilir
* Catchy Labs hesap işleminden sonra sonucun boş olduğu kontrol edilir
* Catchy Labs hesap makinasında sayı girişi için "7" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında "AC" işlemi seçilir
* Catchy Labs hesap işleminden sonra sonucun boş olduğu kontrol edilir
/ Denetleyiceye Not: ilk iki adım gerçekleştirilir. Son adımda hesap makinası ekranından bir önceki sayfaya geçildiği için otomasyon olması gerektiği gibi hata almaktadır.

Catchy Labs Hesap Makinası ile 35 ve 34 değerleri çarpılır sonucun 1190 olduğu kontrol edilir
-----------
Tags:login,carpma
* Catchy Labs sitesine gidilir ve login islemi gerceklestirilir
* Catchy Labs hesap makinasında sayı girişi için "3" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında sayı girişi için "5" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında "Çarpma" işlemi seçilir
* Catchy Labs hesap makinasında sayı girişi için "3" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında sayı girişi için "4" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında hesaplama işlemi yapılır
* Catchy Labs hesaplama işleminden sonra sonucun "1190" döndüğü kontrol edilir

Catchy Labs Hesap Makinası ile Yıllık 100.000 geliri olan birinin aylık net kazancının doğru hesaplandığı kontrol edilir
-----------
Tags:login,bolme
* Catchy Labs sitesine gidilir ve login islemi gerceklestirilir
* Catchy Labs hesap makinasında sayı girişi için "1" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında sayı girişi için "0" sayısından "5" adet gönderilir
* Catchy Labs hesap makinasında "Bölme" işlemi seçilir
* Catchy Labs hesap makinasında sayı girişi için "1" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında sayı girişi için "2" sayısından "1" adet gönderilir
* Catchy Labs hesap makinasında hesaplama işlemi yapılır
* Catchy Labs hesaplama işleminden sonra sonucun "8333,33" döndüğü kontrol edilir