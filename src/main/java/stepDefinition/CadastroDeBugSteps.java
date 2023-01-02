package stepDefinition;

import com.github.javafaker.Faker;
import commons.SeleniumRobot;
import commons.Utils;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;
import page.FormPage;

public class CadastroDeBugSteps {

    FormPage formPage = new FormPage();
    Faker faker = new Faker();

    @Severity(SeverityLevel.NORMAL)
    @E("^preencho todos os campos obrigatórios$")
    public void preencho_todos_os_campos_obrigatórios() {
        SeleniumRobot.fillField(formPage.getFieldName(), faker.name().firstName());
        SeleniumRobot.fillField(formPage.getFieldEmail(), faker.internet().emailAddress());
        SeleniumRobot.selectByindex(formPage.getCmbCriticality(),"Top Priority");
        SeleniumRobot.fillField(formPage.getFieldReasonTopPriority(), "O bug tem alto impacto no funcionamento da aplição");
        SeleniumRobot.fillField(formPage.getFieldBug(), "Erro no Cadastro de Bug");
        SeleniumRobot.fillField(formPage.getFieldDescripitonBug(), "Ao tentar cadastrar um erro a aplição nao apresenta a mensagem de confirmacao");
        Utils.screensot("evidencia");
    }

    @Quando("^anexar a evidencia$")
    public void anexar_a_evidencia() {
        SeleniumRobot.clickElement(formPage.getUploadArq());
        Utils.uploadFile(System.getProperty("user.dir")+"\\target\\screenshots\\evidencia.jpg");
    }

    @E("^clicar em Submit$")
    public void clicar_em_Submit() throws InterruptedException {
        SeleniumRobot.clickElement(formPage.getBtnSubmt());
        Thread.sleep(10000); //THREAD SLEEP INSERIDO PARA INTERACAO MANUAL DEVIDO AO CAPTCHA
    }

    @Então("^vejo mensagem de usuário cadastrado com sucesso$")
    public void vejo_mensagem_de_usuário_cadastrado_com_sucesso() {
        Assert.assertEquals("Você brilhou! Obrigado pela participação do nosso processo de seleção de QA.", formPage.getMsgSucess().getText());
    }
}
