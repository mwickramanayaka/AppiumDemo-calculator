package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {

	//WebDriver driver;
	static AppiumDriver<MobileElement> driver;
	//AndroidDriver driver;

	public static void main(String[] args) {

		try {
			openCalculator();
			

		}catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}

	}

	public static void openCalculator() throws MalformedURLException {


		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "emulator-5554");
		//cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");

		cap.setCapability("platformVersion", "9.0");

		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", ".Calculator");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,cap);

		System.out.println("Application Startrd");

		MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_5");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_0");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("plus");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_0");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("equals");
		el8.click();

		Assert.assertEquals(driver.findElementById("com.android.calculator2:id/result").getText(),"70");

		System.out.println("Test is successfull");
	}

}
