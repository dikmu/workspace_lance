package com.lance.model.vo;

import com.zngh.platform.front.core.model.BaseViewObjectImpl;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Feb 13 16:35:58 CST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ContractVOImpl extends BaseViewObjectImpl {
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

    /**
     * Returns the variable value for pCreator.
     * @return variable value for pCreator
     */
    public String getpCreator() {
        return (String) ensureVariableManager().getVariableValue("pCreator");
    }

    /**
     * Sets <code>value</code> for variable pCreator.
     * @param value value to bind as pCreator
     */
    public void setpCreator(String value) {
        ensureVariableManager().setVariableValue("pCreator", value);
    }
}

