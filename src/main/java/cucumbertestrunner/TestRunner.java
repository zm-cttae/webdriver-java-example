package cucumbertestrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = ".\\src\\main\\java\\featurefiles"
	,tags = "@RegisterSmokeTest"
	,glue = {"stepdefinitionfiles"}
)
public class TestRunner {

}