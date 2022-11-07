package by.it_academy.cucumber.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;

public class HomePage {
    private static final String BASE_URL = "https://www.onliner.by/";
    private static final int ASSERTION_TIMEOUT = 3;
    private static final String HREF_ATTRIBUTE = "href";
    private static final String PRICE_REGEX = ".*price.*";
    private static final String CITY_REGEX = "(.*city.*|.*bounds.*)";
    private static final String ROOMS_REGEX = ".*rooms.*";
    private static final String BRAND_REGEX = "(.*price.*|.*car.*|.*nds.*|.*city.*|.*review.*)";
    private final ElementsCollection categories = $$("a.b-main-navigation__link");
    private final SelenideElement submenu = $("div.b-main-navigation__dropdown_visible");
    private final ElementsCollection subcategories =
            $$("div.b-main-navigation__dropdown_visible a.b-main-navigation__dropdown-advert-link");

    public void openBaseUrl() {
        open(BASE_URL);
    }

    public void hoverOnCategory(String category) {
        categories.findBy(text(category)).hover();
    }

    public void verifySubmenuDisplayed() {
        submenu.shouldBe(visible, ofSeconds(ASSERTION_TIMEOUT));
    }

    public void verifyPriceGroupExists() {
        subcategories.filter(attributeMatching(HREF_ATTRIBUTE, PRICE_REGEX))
                .shouldHave(sizeGreaterThan(0), ofSeconds(ASSERTION_TIMEOUT));
    }

    public void verifyCityGroupExists() {
        subcategories.filter(attributeMatching(HREF_ATTRIBUTE, CITY_REGEX))
                .shouldHave(sizeGreaterThan(0), ofSeconds(ASSERTION_TIMEOUT));
    }

    public void verifyRoomsGroupExists() {
        subcategories.filter(attributeMatching(HREF_ATTRIBUTE, ROOMS_REGEX))
                .shouldHave(sizeGreaterThan(0), ofSeconds(ASSERTION_TIMEOUT));
    }

    public void verifyBrandGroupExists() {
        subcategories.filter(not(attributeMatching(HREF_ATTRIBUTE, BRAND_REGEX)))
                .shouldHave(sizeGreaterThan(0), ofSeconds(ASSERTION_TIMEOUT));
    }
}
