package cucumberTests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import cucumberTests.data.User;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.epam.jdi.light.elements.init.UIFactory.*;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features"
    , glue = {"com.epam.jdi.bdd", "cucumberTests"}
//    , tags = {"@names"}
)
public class TestRunner {
    @BeforeClass
    public static void setUp() {
        WebPage.openUrl("https://jdi-testing.github.io/jdi-light/");
        $("img#user-icon").click();
        new Form<User>().submit(new User().set(u -> { u.name = "Roman"; u.password = "Jdi1234"; }));
    }
    @AfterClass
    public static void shutDown() {
        WebDriverFactory.quit();
    }
}