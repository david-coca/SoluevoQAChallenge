package map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static commons.BaseWeb.getDriver;

public class FormMap {

    public FormMap() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(name = "customFields.nome_do_requisitante")
    public WebElement campoNome;

    @FindBy(name = "customFields.email")
    public WebElement campoSenha;

    @FindBy(className = "pp-select")
    public WebElement cmbCriticality;

    @FindBy(name = "customFields.descreva_o_motivo_pelo_qual_bug_considerado_top_priority")
    public WebElement fieldReasonTopPriority;

    @FindBy(name = "customFields.qual_o_bug")
    public WebElement fieldBug;

    @FindBy(name = "customFields.descreva_o_bug")
    public WebElement fieldDescripitonBug;

    @FindBy(xpath = "//*[@id='dropzone-fake-pipe-field-publicForm-customFields_anexar_prints_do_bug-input']")
    public WebElement uploadArq;

    @FindBy(className = "pp-btn")
    public WebElement btnSubmt;

    @FindBy(className = "pp-new-public-form-success-message")
    public WebElement MsgSucess;
}
