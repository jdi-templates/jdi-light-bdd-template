package cucumberTests;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features"
    , glue = {"com.epam.jdi.bdd", "cucumberTests"}
    , plugin = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
//    , tags = {"@names"}
)
public class TestRunner {

}