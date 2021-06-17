package newproject;
//Automated Functional test case scripts in Selenium - Running in headless mode as no display on linux box.

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class PG1 {
        
    public static void main(String[] args) {

      ChromeOptions options = new ChromeOptions();
        
      options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
      options.addArguments("--no-sandbox"); // Bypass OS security model
      
      // declaration and instantiation of objects/variables
      System.setProperty("webdriver.gecko.driver","chromedriver");
      WebDriver driver = new ChromeDriver(options);
      
      // Test Case Vairables
       String baseUrl = "http://34.87.187.29:8000/hello.html";
       String expectedCol = "You clicked green";
       String actualCol = "";
      
      //launch chrome and direct it to the base URL
        driver.get(baseUrl);
        // get the actual value of col
        actualCol = driver.findElement(By.id("col")).getText();

      // print the result
      if (actualCol.contentEquals(expectedCol)){
            System.out.println("Test Passed!");
      } else {
            System.out.println("Test Failed");
      }
    
      // close chrome
      driver.close();
  }
}
