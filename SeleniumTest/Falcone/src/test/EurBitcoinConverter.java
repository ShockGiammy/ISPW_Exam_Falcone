package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EurBitcoinConverter {
	
	private boolean condition = false;

	@Test
    public void test() {
        
    	System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https://it.coinmill.com/BTC_EUR.html";
        driver.get(baseUrl);
        
        WebElement textbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/form/table[1]/tbody/tr[2]/td[2]/div/input"));
        textbox.clear();
        textbox.sendKeys("2000");
        textbox.sendKeys(Keys.ENTER);
        String bitcoinValue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/form/table[1]/tbody/tr[2]/td[1]/div/input")).getAttribute("value");  
        System.out.println(bitcoinValue);
        if (Float.parseFloat(bitcoinValue) <= 0.3) {   //true if value <= 0.3 bitcoin, else false
        	condition = true;
        }
        assertTrue(condition);
        driver.close();
	}
}
