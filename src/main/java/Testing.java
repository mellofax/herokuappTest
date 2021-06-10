import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Testing {
    @Test
    public void testMySite(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("file:///C:/users/Nikita/Desktop/Test/src/name.html");
        driver.findElementByTagName("input").sendKeys("534536");
        System.out.println(driver.findElementByTagName("p").getText());
        System.out.println(driver.findElementByTagName("select").getText());
    }

    @Test
    public void a() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com");
        driver.findElementByXPath("//a[contains(@href, '/add_remove_elements/')]").click();
        for(int i = 0; i < 2; i++) {
            driver.findElementByXPath("//button[text()='Add Element']").click();
        }
        driver.findElementByXPath("//button[text()='Delete']").click();
        System.out.println("Всего кнопок: " + driver.findElementsByXPath("//button[text()='Delete']").size());
        driver.close();
    }

    @Test
    public void b() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com");
        driver.findElementByXPath("//a[contains(@href, '/checkboxes')]").click();
        List<WebElement> list = driver.findElementsByCssSelector("[type=checkbox]");
        for(int i = 0; i< list.size(); i++)
        {
            if(list.get(i).isSelected())
                list.get(i).click();
            else
                list.get(i).click();
        }
        for(int i = 0; i< list.size(); i++)
        {
            if(list.get(i).isSelected())
                System.out.println("checkbox" + (i+1) + " Выбран");
            else
                System.out.println("checkbox" + (i+1) + " Не выбран");
        }
    }

    @Test
    public void c() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com");
        driver.findElementByXPath("//a[contains(@href, '/dropdown')]").click();
        List<WebElement> list = driver.findElementsByTagName("option");
        System.out.println("Всего элементов Dropdown: " + list.size());
        for(int i = 0; i < list.size(); i ++)
        {
            if(list.get(i).isSelected())
            {
                System.out.println("Элемент под номером" + (i+1) + " Выбран");
            }
            else
            {
                System.out.println("Элемент под номером" + (i+1) + " Не выбран");
            }
        }
        for(int i = 1; i < list.size(); i++)
        {
            list.get(i).click();
            if(list.get(i).isSelected())
            {
                System.out.println("Элемент под номером" + (i+1) + " Был Выбран");
            }
            Thread.sleep(2000);
        }

    }

    @Test
    public void d() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com");
        driver.findElementByXPath("//a[contains(@href, '/inputs')]").click();
        driver.findElementByTagName("input").sendKeys("534536");
        if(driver.findElementByTagName("input").getText().equals(""))
        {
            System.out.println("Числа успешно добавлены");
        }
    } //UnWork <input>

    @Test
    public void e(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");
        String link1 = "//table//tr[";
        String link2 = "]//td[";
        for(int i = 0; i < 3; i++)
        {
            String link = link1 + (i+1) + link2 + (i+2) + "]";
            System.out.println(driver.findElementByXPath(link).getText());
        }
        driver.close();
    }

    @Test
    public void f(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/typos");
        List<WebElement> list = driver.findElementsByTagName("p");
        String text = list.get(1).getText();
        StringBuilder string = new StringBuilder(text);
        if(string.codePointAt(text.length() - 3) == 39)
        {
            System.out.println("Орфографисеских ошибок нет");
        }
        else
        {
            System.out.println("Есть ошибка");
        }

    }

    @Test
    public void g() {

    }

    @Test
    public void h(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElementByXPath("//a[contains(@href, '/notification_message')]").click();
        System.out.println(driver.findElementById("flash").getText());
        if(driver.findElementById("flash").getText().equals("Action successful"))
            System.out.println("Успешно");
        else //if(driver.findElementById("flash").getText().equals("Action unsuccesful, please try again" + "\r\n×"))
            System.out.println("Не Успешно");
    }
}
