package driver;

import driver.utilsSelectDriver.utilsSelectDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class StartTypeDriver {

    private utilsSelectDriver utilsSelectDriver;

    @Before
    public void driverInit() {
        utilsSelectDriver = new utilsSelectDriver();
    }

    @After
    public void close(Scenario scenario) {
        utilsSelectDriver.ScenarioFailed(scenario);
        utilsSelectDriver.ScenarioEnd();
    }

}



