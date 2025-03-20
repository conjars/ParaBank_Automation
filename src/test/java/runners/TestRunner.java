package runners;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/feature/GoogleDoodle.feature",
        glue = {"stepDefinitions", "hooks"},
        plugin = { 
        		"pretty", 
        		//"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",},
        		"html:target/cucumber-report.html"},
        monochrome = true, tags="@color"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
