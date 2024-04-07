
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

public class tests {
    AndroidDriver<AndroidElement> driver = null;
    public void initialize(){

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("deviceName","Pixel 8 Pro API 30");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/epo/IdeaProjects/LesMob/src/main/resources/cal.apk");
    capabilities.setCapability("ensureWebviewsHavePages", true);
    capabilities.setCapability("nativeWebScreenshot", true);
    capabilities.setCapability("newCommandTimeout", 3600);
    capabilities.setCapability("connectHardwareKeyboard", true);



    try {
        driver = new AndroidDriver<>(new URL ("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    } catch (MalformedURLException e) {
        System.out.println(e.getMessage());
    }

    }

    @Test
    public void checkCalculate() {
        initialize();
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementById("com.google.android.calculator:id/op_add").click();
        driver.findElementById("com.google.android.calculator:id/digit_8").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        AndroidElement resultElement = driver.findElementById("com.google.android.calculator:id/result_final");
        String result = resultElement.getText();
        assertEquals("13", result);
        driver.findElementById("com.google.android.calculator:id/digit_7").click();
        driver.findElementById("com.google.android.calculator:id/op_sub").click();
        driver.findElementById("com.google.android.calculator:id/digit_3").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        AndroidElement resultElement1 = driver.findElementById("com.google.android.calculator:id/result_final");
        String result1 = resultElement.getText();
        assertEquals("4", result1);
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/op_mul").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        AndroidElement resultElement2 = driver.findElementById("com.google.android.calculator:id/result_final");
        String result2 = resultElement.getText();
        assertEquals("12", result2);
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/op_div").click();
        driver.findElementById("com.google.android.calculator:id/digit_8").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        AndroidElement resultElement3 = driver.findElementById("com.google.android.calculator:id/result_final");
        String result3 = resultElement.getText();
        assertEquals("7", result3);

    }
 }
