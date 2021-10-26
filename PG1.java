package newproject;
//Automated Functional test case scripts in Selenium - Running in headless mode as no display on linux box.
// Modififed for firefox as can't get chrome working

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.JavascriptExecutor;		

public class PG1 {
        
    public static void main(String[] args) {
      
        // declaration and instantiation of objects/variables
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        firefoxBinary.addCommandLineOptions("--no-sandbox");
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
            
        // Test Case Vairables
        String baseUrl = "http://35.240.184.179/:8000/hello.html";
        String expectedCol = "You clicked green";
        String expectedCol2 = "You clicked red";
        String actualCol = "Default Value";
      
        JavascriptExecutor executor = (JavascriptExecutor)driver;
             
        //launch chrome and direct it to the base URL
        driver.get(baseUrl);
            
         
            
        // FIRST TEST CLICK ON GREEN   
        System.out.println("RUNNING TEST 1: Click on Green");
            
       // Assume driver is a valid WebDriver instance that
       // has been properly instantiated elsewhere.
        WebElement element = driver.findElement(By.name("grnBtn"));    
        executor.executeScript("document.getElementById('grnBtn').click();");
                             
        // get the actual value of col
        actualCol = driver.findElement(By.id("col")).getAttribute("value");
                  
        System.out.println("actualCol is: '" + actualCol + "'");
        System.out.println("colour is: '" + driver.findElement(By.id("col")).getCssValue("background-color") + "'");

        // print the result
        if (actualCol.contentEquals(expectedCol)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
    
        // SECOND TEST CLICK ON GREEN   
        System.out.println("RUNNING TEST 2: Click on Red");
            
       // Assume driver is a valid WebDriver instance that
       // has been properly instantiated elsewhere.
        WebElement element2 = driver.findElement(By.name("redBtn"));    
            executor.executeScript("document.getElementById('redBtn').click();");
                             
        // get the actual value of col                
        actualCol = driver.findElement(By.id("col")).getAttribute("value");
           
      System.out.println("actualCol is: '" + actualCol + "'");
      System.out.println("colour is: '" + driver.findElement(By.id("col")).getCssValue("background-color") + "'");
     
      // print the result
      if (actualCol.contentEquals(expectedCol2)){
            System.out.println("Test Passed!");
      } else {
            System.out.println("Test Failed");
      }            
            
      // close chrome / firefox browser
      driver.close();
  }
}
