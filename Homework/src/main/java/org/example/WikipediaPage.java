package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * trang web cần kiểm thử
 * cung cấp các hành động liên quan đến giao diện trang
 * tách biệt logic kiểm thử và logic giao diện
 */

public class WikipediaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By searchInput = By.name("search");
    private By wikimediaLogo = By.cssSelector("img[alt='Wikimedia Foundation']");
    private By wikiLogo = By.className("mw-logo");

    public WikipediaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToWikipedia() {
        driver.get("https://www.wikipedia.org");
    }

    public void searchFor(String text) {
        WebElement searchBox = wait.until(
                ExpectedConditions.elementToBeClickable(searchInput)
        );
        searchBox.clear();
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);

        // Đợi trang load xong
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }

    public void scrollToBottomAndClickWikimediaLogo() {
        // Scroll xuống cuối trang
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Đợi và click vào logo Wikimedia
        WebElement logo = wait.until(
                ExpectedConditions.elementToBeClickable(wikimediaLogo)
        );
        logo.click();
    }

    public void clickWikiLogo() {
        WebElement logo = wait.until(
                ExpectedConditions.elementToBeClickable(wikiLogo)
        );
        logo.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}