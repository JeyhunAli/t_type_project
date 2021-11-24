package basepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
	static WebDriver driver;
	
	
	@Test
	public void  testnumber_1() throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		By search = By.name("q");
		By suggestionList = By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']//span");
		googleSearchSelect(search, suggestionList, "selenium webdriver", "selenium webdriver download");

		driver.quit();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void googleSearchSelect(By search, By suggestion, String searchKey, String value)
			throws InterruptedException {

		getElement(search).sendKeys(searchKey);
		Thread.sleep(2000);
		List<WebElement> suggList = getElements(suggestion);
		System.out.println(suggList.size());

		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}
	
	
	
	@Test
	public static void totalImages() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		
		
		//total links on the page, and print its text and href value
				List<WebElement> linksList = driver.findElements(By.tagName("a"));
				System.out.println("total links: " + linksList.size());
				
//				for(WebElement e : linksList) {
//					String hrefVal = e.getAttribute("href");
//					String text = e.getText();
//					System.out.println(hrefVal + ":" + text);
//				}
				
				driver.quit();
		
	}
	
	
	
	
	
	
	
	
	
	
	

}

	
	


