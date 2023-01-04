package cucumberTests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import cucumberTests.data.User;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import static com.epam.jdi.light.elements.init.UIFactory.*;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features"
    , glue = {"com.epam.jdi.bdd", "cucumberTests"}
    , plugin = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
//    , tags = {"@names"}
)
public class TestRunner {
    @Before
    public static void setUp() {
        WebPage.openUrl("https://jdi-testing.github.io/jdi-light/");
        $("img#user-icon").click();
        new Form<User>().submit(new User().set(u -> { u.name = "Roman"; u.password = "Jdi1234"; }));
    }
    @After
    public static void shutDown() {
        WebDriverFactory.quit();
    }
}