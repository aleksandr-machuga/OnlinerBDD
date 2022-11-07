package by.it_academy.cucumber.hook;

import by.it_academy.cucumber.driver.DriverConfigurator;
import io.cucumber.java.Before;

public class DriverHook {
    @Before
    public void setup() {
        DriverConfigurator.setUpDriver();
    }
}
