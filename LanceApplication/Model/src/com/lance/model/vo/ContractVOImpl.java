package com.lance.model.vo;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Feb 13 16:35:58 CST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ContractVOImpl extends com.zngh.platform.front.core.model.BaseViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public ContractVOImpl() {
    }

    /**
     * Returns the variable value for pUuid.
     * @return variable value for pUuid
     */
    public String getpUuid() {
        return (String) ensureVariableManager().getVariableValue("pUuid");
    }

    /**
     * Sets <code>value</code> for variable pUuid.
     * @param value value to bind as pUuid
     */
    public void setpUuid(String value) {
        ensureVariableManager().setVariableValue("pUuid", value);
    }
}
