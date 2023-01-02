package page;

import map.FormMap;
import org.openqa.selenium.WebElement;

public class FormPage extends FormMap {
    public WebElement getFieldName() {
        return campoNome;
    }
    public WebElement getFieldEmail() {
        return campoSenha;
    }
    public WebElement getCmbCriticality() {
        return cmbCriticality;
    }
    public WebElement getFieldReasonTopPriority() {
        return fieldReasonTopPriority;
    }
    public WebElement getFieldBug() {
        return fieldBug;
    }
    public WebElement getFieldDescripitonBug() {
        return fieldDescripitonBug;
    }

    public WebElement getBtnSubmt() {
        return btnSubmt;
    }

    public WebElement getMsgSucess() {
        return MsgSucess;
    }

    public WebElement getUploadArq(){
        return uploadArq;
    }
}
