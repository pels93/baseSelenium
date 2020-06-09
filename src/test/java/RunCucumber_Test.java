import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/features/"},
        strict = true,
        plugin = {"pretty", "summary",
                "junit:target/report_cucumber/xml_reports/cucumber.xml",
                "html:target/report_cucumber/html_reports",
                "json:target/report_cucumber/json-reports/cucumber.json"
        },
        tags = {"not @web"},
        //tags = {"not @mobile"},
        //tags = {"@google"},
        glue = {"steps", "driver"})

public class RunCucumber_Test {

}
