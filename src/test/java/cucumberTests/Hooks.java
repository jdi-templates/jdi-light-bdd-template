package cucumberTests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import cucumberTests.data.User;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import static com.epam.jdi.light.elements.init.UIFactory.$;

public class Hooks {
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
