package com.lance.view.bean;

import com.zngh.platform.front.core.view.BaseManagedBean;

import javax.faces.application.FacesMessage;

import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.event.DialogEvent;

public class SkillBean extends BaseManagedBean {
    
    private RichSelectBooleanCheckbox agreementChk1;
    private RichSelectBooleanCheckbox agreementChk2;
    private RichSelectBooleanCheckbox agreementChk3;

    public String agreeAgreement_action() {
        if (agreementChk1.getValue().equals(true) && agreementChk2.getValue().equals(true) &&
            agreementChk3.getValue().equals(true) && agreementChk4.getValue().equals(true)) {
            return "next";
        } else {
            this.showFacesMessage(FacesMessage.SEVERITY_WARN, null, "请勾选所有须知事项", "消息");
            return null;
        }
    }
    
    public void setAgreementChk1(RichSelectBooleanCheckbox agreementChk1) {
        this.agreementChk1 = agreementChk1;
    }

    public RichSelectBooleanCheckbox getAgreementChk1() {
        return agreementChk1;
    }

    public void setAgreementChk2(RichSelectBooleanCheckbox agreementChk2) {
        this.agreementChk2 = agreementChk2;
    }

    public RichSelectBooleanCheckbox getAgreementChk2() {
        return agreementChk2;
    }

    public void setAgreementChk3(RichSelectBooleanCheckbox agreementChk3) {
        this.agreementChk3 = agreementChk3;
    }

    public RichSelectBooleanCheckbox getAgreementChk3() {
        return agreementChk3;
    }

    public void setAgreementChk4(RichSelectBooleanCheckbox agreementChk4) {
        this.agreementChk4 = agreementChk4;
    }

    public RichSelectBooleanCheckbox getAgreementChk4() {
        return agreementChk4;
    }
    private RichSelectBooleanCheckbox agreementChk4;
    
    public SkillBean() {
        super();
    }

    public void submitSkillEdit(DialogEvent dialogEvent) {
        // Add event code here...
    }
}
