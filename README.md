# TerfiQaQe Projesi

Bu proje, Terfi projem olarak hazırlanmış olup, web ve mobil platformlarla uyumlu, esnek ve ölçeklenebilir bir otomasyon çözümüdür.

## İçindekiler
- [Özellikler](#özellikler)
- [Kurulum](#kurulum)
- [Kullanım](#kullanım)
- [Bağımlılıklar](#bağımlılıklar)
- [Test Otomasyonu](#test-otomasyonu)
- [Spec ve Concept Esnekliği](#spec-ve-concept-esnekligi)
- [Katkıda Bulunma](#katkıda-bulunma)
- [Lisans](#lisans)
- [İletişim](#iletişim)

## Özellikler
- **Çalışan Yönetimi**: Çalışan bilgilerini ekleme, güncelleme ve silme işlemleri.
- **Terfi Kriterleri**: Terfi kriterlerini tanımlama ve düzenleme.
- **Performans Değerlendirmesi**: Çalışanların performans değerlendirmelerini kaydetme ve izleme.
- **Terfi Süreci İzleme**: Terfi süreçlerini izleme ve yönetme.
- **Platform Uyumluluğu**: Web ve mobil cihazlarla uyumlu responsive tasarım.
- **Test Otomasyonu**: Gauge ve Selenium ile kapsamlı test otomasyonu desteği.

## Kurulum
### Depoyu Klonlayın:
```bash
git clone https://github.com/justapython/TerfiQaQe.git
```

### Proje Dizini:
```bash
cd TerfiQaQe
```

### Bağımlılıkları Yükleyin:
```bash
mvn clean install
```

### Veritabanı Yapılandırması:
`application.properties` dosyasında veritabanı bağlantı ayarlarınızı yapın ve gerekli tabloları oluşturun.

## Kullanım
### Uygulamayı Başlatın:
```bash
mvn spring-boot:run
```

### Tarayıcıdan Erişin:
[http://localhost:8080](http://localhost:8080) adresine giderek uygulamayı kullanmaya başlayabilirsiniz.

## Bağımlılıklar
Proje, aşağıdaki ana bağımlılıkları içermektedir:

- **Spring Boot Web Starter**: Version 2.5.4
- **Spring Boot Data JPA**: Version 2.5.4
- **MySQL Connector**: Version 8.0.26
- **Selenium WebDriver**: Version 4.18.1
- **JUnit**: Version 4.13.2
- **Gauge Java Library**: Version 1.5.0
- **Log4j**: Version 1.2.17
- **Allure JUnit4**: Version 2.14.0
- **AspectJ Weaver**: Version 1.9.21
- **Maven Surefire Plugin**: Version 3.2.5
- **RestAssured**: Version 4.5.1
- **Apache POI**: Version 5.2.4

Bu bağımlılıklar ve sürümleri, `pom.xml` dosyasından da kontrol edilebilir.

## Test Otomasyonu
TerfiQaQe, test otomasyonu için **Gauge** ve **Selenium** kullanmaktadır. Bu sayede, web ve mobil uygulamalar için otomatik test senaryoları oluşturulabilir.

## Spec ve Concept Esnekliği
- **Gauge**: Test senaryolarını `.spec` dosyalarında tanımlar ve tekrar kullanılabilir adımları `.cpt` uzantılı concept dosyalarında saklar. Bu yapı, testlerin modüler ve esnek olmasını sağlar.
- **Element ve Dinamik Bekleme Süreleri**: Testlerde kullanılan elementler, JSON dosyasından alınır. Bu yapı, elementlerin ve işlemlerin her bir test durumuna göre dinamik bir şekilde yönetilmesini sağlar.

  ### Cross-Platform Desteği

TerfiQaQe, hem Web hem de MobilWeb platformlarında uyumlu bir şekilde çalışacak şekilde tasarlanmıştır. Bu sayede, web tarayıcıları ve mobil cihazlar arasında kesintisiz test senaryoları oluşturulabilir.

- **Web Platformu**: Proje, Chrome, Firefox ve Edge gibi yaygın masaüstü tarayıcıları üzerinde test senaryolarını başarıyla çalıştırabilir. Testler, tarayıcılar arası uyumluluğu test etmek amacıyla farklı browser özellikleriyle yapılabilir.

- **MobilWeb Platformu**: Web sürümünün yanı sıra, mobil cihazlar üzerinde de testler yapılabilir. Hem Android hem de iOS cihazlarında tarayıcı otomasyonu sağlanarak mobil kullanıcı deneyimi de test edilir.

- **Çoklu Tarayıcı Desteği**: TerfiQaQe, aşağıdaki tarayıcılar için tam destek sunar:
    - Google Chrome
    - Mozilla Firefox
    - Microsoft Edge

Her bir tarayıcı için uyumlu sürümlerle testlerinizi çalıştırabilir ve platformlar arası geçişler ile kullanıcı deneyimini analiz edebilirsiniz.


### Spec Dosyaları
Test senaryolarının tanımlandığı dosyalardır.
```gauge
#login
Senaryo: Geçerli kullanıcı ile giriş yapma
  Adım 1: Kullanıcı giriş sayfasına gider
  Adım 2: Geçerli kullanıcı bilgilerini girer
  Adım 3: Giriş butonuna tıklar
  Adım 4: Dinamik bekleme süresi ile öğe kontrol edilir
```

### Concept Dosyaları
Tekrar eden adımların tanımlandığı ve yeniden kullanılabildiği dosyalardır. Bu sayede, aynı adımlar farklı senaryolarda tekrar kullanılabilir.
```gauge
# Kullanıcı giriş sayfasına gider
* Kullanıcı tarayıcıyı açar
* URL'yi giriş sayfası ile ayarlar
* Dinamik bekleme süresiyle öğe kontrol edilir
```

## Katkıda Bulunma
1. Projeyi Forklayın.
2. Yeni Bir Dal Oluşturun:
   ```bash
   git checkout -b yeni-ozellik
   ```
3. Değişikliklerinizi Yapın ve Commit Edin:
   ```bash
   git commit -m 'Yeni özellik eklendi'
   ```
4. Dalınıza Push Yapın:
   ```bash
   git push origin yeni-ozellik
   ```
5. Bir Pull Request Oluşturun.

## Lisans
Bu proje **MIT Lisansı** ile lisanslanmıştır.

## İletişim
Herhangi bir sorunuz veya öneriniz için lütfen **justapython** ile iletişime geçin.
