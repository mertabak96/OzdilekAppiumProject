import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest {

    Logger logger = LogManager.getLogger(BasePage.class);


    @Step("<int> saniye kadar bekle")
    public void waitForsecond(int s) throws InterruptedException {
        Thread.sleep(1000 * s);
    }

    @Step("<id> elemetin sayfada gorunur olduğunu kontrol et ve tıkla")
    public void findByelementEndclick(String id) {
        MobileElement element = appiumDriver.findElement(By.id(id));
        if (element.isDisplayed()) {
            element.click();
        } else {
            com.thoughtworks.gauge.Logger.info("Kontrol edilen element Görünür olmadı");

        }
    }

    @Step("id <id> li elementi bul ve <text> alanını kontrol et")
    public void textIdAreacontrol(String id, String text) {
        Assert.assertTrue("Bu element text değerini içermiyor..", appiumDriver.findElement(By.id(id)).getText().contains(text));
        com.thoughtworks.gauge.Logger.info("Element goruntulendi");
    }

    @Step("xpath <xpath> li elementi bul ve <text> alanını kontrol et")
    public void textXpathAreacontrol(String xpath, String text) {
        Assert.assertTrue("Bu element text değerini içermiyor..", appiumDriver.findElement(By.xpath(xpath)).getText().contains(text));
        com.thoughtworks.gauge.Logger.info("Element goruntulendi");
    }

    @Step("Sayfayı en aşağıya doğru iki kez kaydır")


    public void scrollForwardBottom() throws InterruptedException {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int xBasla = (int) (dimension.width * 0.3);
        int yBasla = (int) (dimension.height * 0.9);
        Thread.sleep(200);
        int xDur = (int) (dimension.width * 0.5);
        int yDur = (int) (dimension.height * 0.1);
        Thread.sleep(200);
        for (int i = 0;i < 2;i++) {
            TouchAction Action =
                    new TouchAction((PerformsTouchActions) appiumDriver)
                            .press(PointOption.point(xBasla, yBasla))
                            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                            .moveTo(PointOption.point(xDur, yDur))
                            .release().perform();

        }
    }

    @Step("Xpath <xpath> li elementi bul ve tıkla")
    public void clickByxpath(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
    }



    @Step("Rastgele ürün seçilir..")
    public void RandomSec() {
        Random random = new Random();
        List<MobileElement> randomUrun = appiumDriver.findElements(By.xpath("//*[@resource-id='com.ozdilek.ozdilekteyim:id/imageView']"));
        MobileElement element = randomUrun.get(random.nextInt(randomUrun.size()));
        element.click();

    }


    @Step("Id <id> li elementi bul ve tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }

    @Step("Id <id> li elementi bul ve <text> değerini gir")
    public void sendKeybyId(String id, String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        com.thoughtworks.gauge.Logger.info(text + " "+ "id li alana yazildi");

}

@Step("Id <id> li elementi bul")
    public void findElementArea(String id) {
        appiumDriver.findElement(By.id(id));
        com.thoughtworks.gauge.Logger.info("id li alan bulundu");


}
    }


