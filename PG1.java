package newproject;
//Automated Functional test case scripts in Selenium - Running in headless mode as no display on linux box.
// Modififed for firefox as can't get chrome working

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.JavascriptExecutor;		

public class PG1 {
        
    public static void main(String[] args) {

//      ChromeOptions options = new ChromeOptions();
        
//      options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//      options.addArguments("--no-sandbox"); // Bypass OS security model
      
      // declaration and instantiation of objects/variables
//      System.setProperty("webdriver.gecko.driver","chromedriver");
 FirefoxBinary firefoxBinary = new FirefoxBinary();
 firefoxBinary.addCommandLineOptions("--headless");
 firefoxBinary.addCommandLineOptions("--no-sandbox");
 System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
 FirefoxOptions firefoxOptions = new FirefoxOptions();
 firefoxOptions.setBinary(firefoxBinary);
 FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
            
 //           WebDriver driver = new ChromeDriver(options);
            
            
      
      // Test Case Vairables
       String baseUrl = "http://34.87.187.29:8000/hello.html";
       String expectedCol = "You clicked green";
       String actualCol = "Default Value";
      
       JavascriptExecutor executor = (JavascriptExecutor)driver;
             
      //launch chrome and direct it to the base URL
        driver.get(baseUrl);
            
      //Click the green button.
      //driver.findElement(By.id("grnBtn")).click();
        
        // Assume driver is a valid WebDriver instance that
        // has been properly instantiated elsewhere.
        WebElement element = driver.findElement(By.name("grnBtn"));    
       // executor.executeScript("arguments[0].click();", element);
            executor.executeScript("document.getElementById('grnBtn').click();");
            
      System.out.println("Before reading - actualCol is: " + actualCol);
                       
        // get the actual value of col
      //actualCol = driver.findElement(By.id("col")).getText();
     actualCol =  executor.executeScript("document.getElementById('col').value").toString(); 
      //actualCol = ((JavascriptExecutor)driver).executeScript("document.getElementById('col').value").toString();
            
     // WebElement myElem = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("col")));
     //       System.out.println("got this far");
     //   String value = ((JavascriptExecutor)driver).executeScript("document.getElementById('col').value").toString();
            
      System.out.println("actualCol is: " + actualCol);

      // print the result
      if (actualCol.contentEquals(expectedCol)){
            System.out.println("Test Passed!");
      } else {
            System.out.println("Test Failed");
      }
    
      // close chrome / firefox browser
      driver.close();
  }
}
