package commons;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static commons.BaseWeb.getDriver;


public class SeleniumRobot {

    public static void clickElement(WebElement element) {
        System.out.println("##################################");
        try {
            System.out.println("Vai clicar no elemento: " + element);
            element.click();
            System.out.println("Clicou no elemento: " + element);
        } catch (Exception error){
            System.out.println("********** Aconteceu um erro ao tentar clicar no elemento: " + element);
            System.out.println(error);
        }
        System.out.println("##################################");
    }

    public static void fillField(WebElement element, String value) {
        System.out.println("##################################");
        try {
            System.out.println("Vai preencher o campo: " + element);
            Actions actions = new Actions(getDriver());
            actions.click(element);
            actions.sendKeys(value).build().perform();
        } catch (Exception error){
            System.out.println("********** Aconteceu um erro ao tentar preencher o campo: " + element);
            System.out.println(error);
        }
        System.out.println("##################################");
    }
    public static void selectByindex(WebElement listId, String value){
        System.out.println("##################################");
        try {
            System.out.println("Vai selecionar: " + listId);
            Select select = new Select(listId);
            select.selectByValue(value);
        } catch (Exception error){
            System.out.println("********** Aconteceu um erro ao tentar preencher o campo: " + listId);
            System.out.println(error);
        }
        System.out.println("##################################");

    }
}
