package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * kịch bản kiểm thử thực tế
 */

public class WikipediaTest extends BaseTest {

    @Test
    @DisplayName("Scenario 1: Tìm kiếm 'information technology'")
    public void testBasicSearch() {
        WikipediaPage wikiPage = new WikipediaPage(driver);
        wikiPage.navigateToWikipedia();
        wikiPage.searchFor("information technology");
        assertTrue(wikiPage.getCurrentUrl().contains("Information_technology"),
                "URL không chứa từ khóa tìm kiếm");
    }

    @Test
    @DisplayName("Scenario 2: Click vào logo Wikimedia Foundation")
    public void testClickWikimediaLogo() {
        WikipediaPage wikiPage = new WikipediaPage(driver);
        wikiPage.navigateToWikipedia();
        wikiPage.searchFor("information technology");
        wikiPage.scrollToBottomAndClickWikimediaLogo();
        assertTrue(wikiPage.getCurrentUrl().contains("wikimediafoundation.org"),
                "Không chuyển được đến trang Wikimedia Foundation");
    }

    @Test
    @DisplayName("Scenario 3: Click vào logo Wikipedia")
    public void testClickWikiLogo() {
        WikipediaPage wikiPage = new WikipediaPage(driver);
        wikiPage.navigateToWikipedia();
        wikiPage.searchFor("information technology");
        wikiPage.clickWikiLogo();
        assertTrue(wikiPage.getCurrentUrl().contains("wikipedia.org"),
                "Không quay về được trang chủ");
    }
}