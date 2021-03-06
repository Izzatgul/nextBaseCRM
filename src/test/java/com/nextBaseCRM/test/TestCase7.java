package com.nextBaseCRM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestCase7 {

    public static void main(String[] args) throws InterruptedException {

        //  Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://login2.nextbasecrm.com/");

        // Verify title equals:
        // Expected: Authorization
        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Landing page title verification PASSED!");
        } else {
            System.err.println("Landing page title verification FAILED!");
            System.out.println("Expected title = " + expectedTitle);
            System.out.println("Actual title = " + actualTitle);
        }

        // TC #2. Enter positive user name and negative user name.
        // TC #3. Enter positive user password and negative user password.

        /*
        Usernames:
    helpdesk39@cybertekschool.com
    helpdesk40@cybertekschool.com
    marketing39@cybertekschool.com
    marketing40@cybertekschool.com
    hr39@cybertekschool.com
    hr40@cybertekschool.com
    Password:
    UserUser
         */
        ArrayList<String> usernamesPositive = new ArrayList<String>(Arrays.asList("helpdesk39@cybertekschool.com",
                "helpdesk40@cybertekschool.com",
                "marketing39@cybertekschool.com",
                "marketing40@cybertekschool.com",
                "hr39@cybertekschool.com",
                "hr40@cybertekschool.com"));

        String password = "UserUser";


        for (String each : usernamesPositive) {
            // type User name
            driver.findElement(By.name("USER_LOGIN")).sendKeys(each);
            // type Password
            driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);

            //====================================================================================

            // TC #4 Click login button
            driver.findElement(By.className("login-btn")).click();


            WebElement like = driver.findElement(By.xpath("//a[.='Like']"));

            if (like.isDisplayed()) {
                System.out.println("Users can see like button");
            } else {
                System.out.println("Users can not see like button");
            }

            Thread.sleep(10000);

            WebElement follow = driver.findElement(By.xpath("//a[.='Follow']"));
            System.out.println(follow.getText());
            follow.click();
            Thread.sleep(10000);


            if (follow.isDisplayed()) {
                System.out.println("Users can see follow button");
            } else {
                System.out.println("Users can not see follow button");
            }

            WebElement unFollow = driver.findElement(By.xpath("//a[.='Unfollow']"));


            if (unFollow.isDisplayed()) {
                System.out.println("Users can see Unfollow button");
            } else {
                System.out.println("Users can not see Unfollow button");
            }

        }

        WebElement eyeButton = driver.findElement(By.xpath("//span[@id='feed-post-contentview-cnt-wrap-BLOG_POST-3004']"));
        eyeButton.click();
        Thread.sleep(3000);

        if (eyeButton.isDisplayed()){
            System.out.println("Users can see the list of people");
        }else {
            System.out.println("Users can not see the list of people");
        }



    }
}

