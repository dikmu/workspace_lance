package com.lance.model.vo;

import com.zngh.platform.front.core.model.BaseViewObjectImpl;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Apr 30 16:05:43 CST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class UserCompanyHistoryVOImpl extends BaseViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public UserCompanyHistoryVOImpl() {
    }

    /**
     * Returns the variable value for uname.
     * @return variable value for uname
     */
    public String getuname() {
        return (String) ensureVariableManager().getVariableValue("uname");
    }

    /**
     * Sets <code>value</code> for variable uname.
     * @param value value to bind as uname
     */
    public void setuname(String value) {
        ensureVariableManager().setVariableValue("uname", value);
    }
}
