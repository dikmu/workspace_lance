package com.lance.model.vo;

import com.zngh.platform.front.core.model.BaseViewObjectImpl;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon May 04 09:21:59 CST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class UserLicenseVOImpl extends BaseViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public UserLicenseVOImpl() {
    }

    /**
     * Returns the variable value for puser.
     * @return variable value for puser
     */
    public String getpuser() {
        return (String) ensureVariableManager().getVariableValue("puser");
    }

    /**
     * Sets <code>value</code> for variable puser.
     * @param value value to bind as puser
     */
    public void setpuser(String value) {
        ensureVariableManager().setVariableValue("puser", value);
    }
}
