package com.barclays.movies.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebNavigationStepDefinitions {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
//      WebDriverManager.firefoxdriver().setup();
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

    @Given("I have a browser open")
    public void i_have_a_browser_open() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
        System.out.println("Web navigation when step ran");
    }

    @Then("I am on the {string} page")
    public void i_am_on_the_page(String title) {
        System.out.println("Web navigation then step ran");
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains(title));
    }

    @And("I enter {string} in the ISBN Box")
    public void i_enter_in_the_isbn_box(String isbn) throws InterruptedException {
        WebElement isbnField = driver.findElement(By.name("isbn"));
        isbnField.clear();
        isbnField.sendKeys(isbn);
        Thread.sleep(250);
    }

    @And("I enter {string} in the title box")
    public void i_enter_in_the_title_box(String movieTitle) {
        WebElement titlefield = driver.findElement(By.name("title"));
        titlefield.clear();
        titlefield.sendKeys(movieTitle);
    }

    @And("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String type) {
        Select movieTypeSelectMenu = new Select(driver.findElement(By.id("movieType")));
        movieTypeSelectMenu.selectByVisibleText(type);
    }

    @And("I click submit")
    public void i_click_submit() {
        driver.findElement(By.id("submit")).click();
    }

    @Then("I see that {string} was successfully added")
    public void i_see_that_was_successfully_added(String movieName) throws IOException {
        String message = driver.findElement(By.id("success")).getText();
        takeScreenShot("Success ");
        assertTrue(message.contains(movieName));
    }

    @Then("I see that an error message containing {string}")
    public void i_see_that_an_error_message_containing(String title) throws IOException {
    WebElement errorMessageDiv = driver.findElement(By.id("movie.errors"));
    String  errorMessage = errorMessageDiv.getText();
    takeScreenShot("Error ");
    assertTrue(errorMessage.contains(title));
    }

    public void takeScreenShot(String status) throws IOException {
        //Change the WebDriver into something that can take screen shots
        TakesScreenshot screenshot = ((TakesScreenshot) driver);

        //Take the screen shot
        //Tell Selenium (TakesScreenshot object) what you want to output
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        LocalDateTime dateTime = LocalDateTime.now();
        String fileName = dateTime.toString();
        fileName = fileName.substring(0,20);
        fileName = fileName.replace(":", "-");
        fileName = fileName.replace(".", "-");
        fileName = status + fileName;

        //Build a path to where you want the file stored
        //Create an empty file and store it in that location
        String pathAndFileName = "C://Screenshots/" + fileName +".png";
        File destFile = new File("C://Screenshots/" + fileName +".png");

        //Copy the screenshot file into the empty file you just created file
        FileUtils.copyFile(srcFile, destFile);
    }
}


