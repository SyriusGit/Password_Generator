import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Teste {

    private AndroidDriver<MobileElement> driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("avd", "Pixel_2_API_28");
        capabilities.setCapability("app", "C:\\Users\\User.190024NOTE\\Documents\\appsParaTeste\\alura_esporte.apk");
        capabilities.setCapability("appPackage", "br.com.alura.aluraesporte");
        capabilities.setCapability("appActivity", "br.com.alura.aluraesporte.ui.activity.MainActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("ensureWebviewsHavePages", true);
        capabilities.setCapability("nativeWebScreenshot", true);
        capabilities.setCapability("newCommandTimeout", 3600);
        capabilities.setCapability("connectHardwareKeyboard", true);

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @RepeatedTest(10) // Repete o teste 10 vezes
    public void sampleTest() {
        MobileElement el1 = driver.findElementById("br.com.alura.aluraesporte:id/input_usuario");
        el1.sendKeys("admin");
        MobileElement el2 = driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        el2.sendKeys("admin");
        MobileElement el3 = driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");
        el3.click();
        MobileElement el4 = driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        el4.click();
        MobileElement el5 = driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        el5.sendKeys("Henri");
        MobileElement el6 = driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        el6.sendKeys("admin");
        MobileElement el7 = driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        el7.sendKeys("admin");
        MobileElement el8 = driver.findElementByXPath("(//android.widget.ImageButton[@content-desc=\"Show password\"])[2]");
        el8.click();
        MobileElement el9 = driver.findElementByXPath("(//android.widget.ImageButton[@content-desc=\"Show password\"])[1]");
        el9.click();
        MobileElement el10 = driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        el10.click();
        MobileElement el11 = driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");
        el11.click();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
