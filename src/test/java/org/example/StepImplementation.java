package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation {

        /**
         * Json dosyasından element döndürme için kullanılan method.
         */
        private By getBy(String key) {
            try {
                // Dosya (json) okuma
                JsonObject jsonObject = JsonParser.parseReader(new FileReader("src/test/resources/elements.json")).getAsJsonObject();
                if (!jsonObject.has(key)) {
                    throw new IllegalArgumentException("Json dosyasında element bulunamadı element = " + key);
                }

                JsonObject elementData = jsonObject.getAsJsonObject(key);
                String locatorType = elementData.get("locatorType").getAsString();
                String value = elementData.get("value").getAsString();

                // Elemente göre by objesi olusutrma islemi
                switch (locatorType.toLowerCase()) {
                    case "id":
                        return By.id(value);
                    case "linktext":
                        return By.linkText(value);
                    case "css":
                        return By.cssSelector(value);
                    case "xpath":
                        return By.xpath(value);
                    default:
                        throw new IllegalArgumentException("Geçersiz bir locator tipi = : " + locatorType);
                }
            } catch (IOException e) {
                throw new RuntimeException("Json dosyasi okumasi basarisiz oldu = " + e.getMessage());
            }
        }

    @Step("URL adresine gidilir <url>")
    public void goToURL(String url) {
        Driver.webDriver.get(url); // Url parametresi alinir
        try {
            assertThat(Driver.webDriver.getCurrentUrl()).isEqualTo(url);
            System.out.println("Yönlendirme yapilan URL = " + url + " successfully.");
        } catch (AssertionError e) {
            System.out.println("Yönlendirme yapilamadi URL = " + url);
            throw e;
        }
    }
    @Step("<key> elementinin tıklanabilir olduğu kontrol edilir <timeout>")
    public void waitUntilElementClickable(String key, int timeout) {
        // element tıklanabilir mi diye kontrol saglanir. Maksimum timeout belirlenir.
        By locator = getBy(key); // elementi bulmak için key değeri kullanılır
        WebDriverWait wait = new WebDriverWait(Driver.webDriver, Duration.ofSeconds(timeout));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            assertThat(element).isNotNull();
            System.out.println("Element " + key + " tıklanabilir durumda."); // maks timeouttan önce tıklanabilir olduğu görüntülenirse mesaj basılır
        } catch (AssertionError e) {
            System.out.println("Element " + key + " tıklanabilir durumda değil, beklenen sure = " + timeout + " saniye.");
            throw e;
        }
    }
    @Step("<key> elementin görünür olduğu kontrol edilir <timeout>")
    public void waitUntilElementVisible(String key, int timeout) {
        // element görünür mü diye kontrol saglanir. Maksimum timeout belirlenir.
        By locator = getBy(key);
        WebDriverWait wait = new WebDriverWait(Driver.webDriver, Duration.ofSeconds(timeout));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            assertThat(element).isNotNull();
            System.out.println("Element key degeri = " + key + " gorunur.");
        } catch (AssertionError e) {
            System.out.println("Element key degeri = " + key + " gorunur degil, beklenen sure = " + timeout + " saniye.");
            throw e;
        }
    }

    @Step("<key> elementin görünür olmadığı kontrol edilir <timeout>")
    public void waitUntilElementNotVisible(String key, int timeout) {
        // Elementin görünür olmadığı kontrol edilir. Maksimum timeout belirlenir.
        By locator = getBy(key);
        WebDriverWait wait = new WebDriverWait(Driver.webDriver, Duration.ofSeconds(timeout));
        try {
            boolean isInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            assertThat(isInvisible).isTrue();
            System.out.println("Element key degeri = " + key + " görünür değil.");
        } catch (AssertionError e) {
            System.out.println("Element key degeri = " + key + " hala görünür, beklenen süre = " + timeout + " saniye.");
            throw e;
        }
    }

    @Step("<key> elementine tıklanır")
    public void clickElement(String key) { // elemente tıklama işlemi gerçekleştirilir.
        By locator = getBy(key);
        WebElement element = Driver.webDriver.findElement(locator);
        try {
            assertThat(element.isDisplayed()).isTrue();
            element.click();
            System.out.println("Elemente basariyla tiklandi. Key degeri= " + key);
        } catch (AssertionError e) {
            System.out.println("Elemente tiklama basarisiz oldu. Key degeri= " + key);
            throw e;
        }
    }
    @Step("<key> elementine <text> değeri yazılır")
    public void sendTextToElement(String key, String text) {
        // key parametresine text değeri gönderilir
        By locator = getBy(key);
        WebElement element = Driver.webDriver.findElement(locator);

        try {
            element.sendKeys(text); // Belirlenen text değeri elemente gönderilir
            assertThat(element.getAttribute("value")).isEqualTo(text); // Text gönderiminin doğru olup olmadığının kontrolü
            System.out.println("Text basariyla gonderildi element = " + key);
        } catch (Exception e) {
            System.out.println("Text gonderilemedi element = " + key);
            throw e;
        }
    }
    @Step("<key> elementine <count> kadar tıklanır")
    public void clickElementMultipleTimes(String key, int count) {
        By locator = getBy(key);
        WebElement element = Driver.webDriver.findElement(locator);

        try {
            for (int i = 0; i < count; i++) {
                element.click();
                System.out.println("Clicked on element: " + key + " - Click #" + (i + 1));
            }
            assertThat(element.isDisplayed()).isTrue(); // Elementin görünür olduğunu kontrol ediyoruz
            System.out.println("Tiklama islemi gerceklesirildi " + count + " times.");
        } catch (Exception e) {
            System.out.println("Tiklama islemi gerceklestirilemedi = " + key);
            throw e;
        }
    }
    @Step("<key> elementinin text değeri <text> değerini içeriyor mu kontrol et")
    public void isElementTextContains(String key, String text) {
        By locator = getBy(key);
        WebElement element = Driver.webDriver.findElement(locator);

        try {
            String elementText = element.getText(); // Elementin text değeri alınır
            assertThat(elementText).contains(text); // Text değeri kontrol edilir
            System.out.println("Element istenilen text değerini iceriyor, elementin text degeri = " + text);
        } catch (Exception e) {
            System.out.println("Element istenilen text değerini icermiyor, text degeri =  " + text);
            throw e;
        }
    }

}

