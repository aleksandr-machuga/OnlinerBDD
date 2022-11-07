package by.it_academy.cucumber.steps;

import by.it_academy.cucumber.page.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

    private HomePage homePage = new HomePage();

    @Given("the user opens Onliner website")
    public void openOnlinerWebsite() {
        homePage.openBaseUrl();
    }

    @When("the user hovers menu category {string}")
    public void hoverMenuCategory(String category) {
        homePage.hoverOnCategory(category);
    }

    @Then("the user sees submenu")
    public void checkSubmenuOpened() {
        homePage.verifySubmenuDisplayed();
    }

    @Then("^submenu has (price|brand|city|rooms) group$")
    public void checkSubmenuGrouping(String group) {
        switch (group) {
            case "price" -> homePage.verifyPriceGroupExists();
            case "city" -> homePage.verifyCityGroupExists();
            case "brand" -> homePage.verifyBrandGroupExists();
            case "rooms" -> homePage.verifyRoomsGroupExists();
            default -> System.out.println("Check is not implemented");
        }
    }
}
