package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty:STDOUT",
                "html:report",
                "json:target/cucumber.json",
                "usage:target/cucumber-usage.json",
                "junit:target/cucumber-results.xml",
        },
        features = "./src/test/resources/features",
        glue = {"stepDefinition", "commons"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
)
public class RunnerTest {

}