package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://formy-project.herokuapp.com/form";
        driver.get(url);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement userName = driver.findElement(By.xpath("//*[@id='first-name']"));
        userName.sendKeys(new CharSequence[]{"Dwi Febrian"});
        System.out.println("input first name");
        driver.findElement(By.id("last-name")).sendKeys(new CharSequence[]{"Ramadhan"});
        System.out.println("input last name");
        driver.findElement(By.id("job-title")).sendKeys(new CharSequence[]{"Software Quality Assurance"});
        System.out.println("input job title");

        WebElement radiobutton1 = driver.findElement(By.id("radio-button-1"));
        js.executeScript("arguments[0].click();", new Object[]{radiobutton1});
        System.out.println("Yes Radio Clicked use JavascriptExecutor");

        WebElement checkbox1 = driver.findElement(By.id("checkbox-1"));
        checkbox1.click();


        Select color = new Select(driver.findElement(By.id("select-menu")));
        color.selectByIndex(1);

        WebElement date = driver.findElement(By.xpath("//*[@id='datepicker']"));
        date.sendKeys(new CharSequence[]{"10/27/2022"});
        System.out.println("date");

        driver.findElement(By.id("submit")).click();
        System.out.println("button submit clicked");
        driver.quit();
    }

}
