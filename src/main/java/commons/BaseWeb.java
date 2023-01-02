package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BaseWeb {

    //Variavel WEBDRIVER GLOBAL
    static WebDriver driver;
    //CONSTRUTOR QUE RECEBE DE VOLTA O DRIVER
    public static WebDriver getDriver(){
        return driver;
    }
    public static WebDriver getDriver(String browser) {

        if (driver !=  null) {
            driver.quit();
        }

        switch (browser) {
            case "chrome":
                System.out.println("Browser Aberto com Sucesso");
                ChromeOptions options = new ChromeOptions();
                options.addArguments(Arrays.asList(
                        "disable-infobars", "ignore-certificate-errors",
                        "start-maximized"));
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "chrome-ci":
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--headless");
                driver = new ChromeDriver(option);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions op = new FirefoxOptions();
                op.addPreference(FirefoxDriver.MARIONETTE, true);
                driver = new FirefoxDriver(op);
                driver.manage().window().maximize();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                OperaOptions opc = new OperaOptions();
                opc.addArguments(Arrays.asList(
                        "disable-infobars", "ignore-certificate-errors",
                        "start-maximized"));
                driver = new OperaDriver(opc);
                break;
            case "edge":
                throw new IllegalArgumentException("Edge ainda nao suportado");
            default:
                throw new IllegalArgumentException("Navegador não encontrado! Passe um navegador existente: chrome, forefox ou edge.");
        }

        if(driver != null){
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }
}
