import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class saucedemoTEST {
    @Test
    public void Test(){
        List<String> name = new ArrayList<>();
        List<String> price = new ArrayList<>();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.findElementById("user-name").sendKeys("standard_user");
        driver.findElementById("password").sendKeys("secret_sauce");
        driver.findElementById("login-button").click();
        List<WebElement> list = driver.findElementsByClassName("inventory_item");
        for(int i = 0; i < 3; i ++)
        {
            name.add(list.get(i+1).findElement(new By.ByClassName("inventory_item_name")).getText());
            price.add(list.get(i+1).findElement(new By.ByClassName("inventory_item_price")).getText());
            list.get(i+1).findElement(new By.ByTagName("Button")).click();
        }
        list.clear();
        driver.findElementByClassName("shopping_cart_link").click();
        list = driver.findElementsByClassName("cart_item");
        for(int i = 0; i < list.size(); i ++)
        {
            Assert.assertEquals(name.get(i),list.get(i).findElement(new By.ByClassName("inventory_item_name")).getText(), "Название не совпало");
            Assert.assertEquals(price.get(i),list.get(i).findElement(new By.ByClassName("inventory_item_price")).getText(), "Цена не совпала");
        }
        driver.close();
    }
}
