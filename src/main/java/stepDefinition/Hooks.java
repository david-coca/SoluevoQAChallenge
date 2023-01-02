package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static commons.BaseWeb.getDriver;

public class Hooks {

    @Dado("^que estou na tela do formulãrio$")
    public void que_estou_na_tela_do_formulãrio(){
        String browser = System.getProperty("browser");
        getDriver("chrome").get("https://app.pipefy.com/public/form/_Lid-wF_");
    }

    @After
    public void teardown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            if(scenario.isFailed()){
                scenario.log("Cenario não executado");
                TakesScreenshot ts = (TakesScreenshot) getDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().quit();
    }
}
