package com.lance.model.vo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Feb 12 09:54:16 CST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class JobCategoryVORowImpl extends ViewRowImpl {
    public static final int ENTITY_JOBCATEGORYEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Uuid,
        NameEn,
        NameCn,
        Display,
        CreateBy,
        CreateOn,
        ModifyBy,
        ModifyOn,
        Version,
        JobTemplate,
        JobSubCategory;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int UUID = AttributesEnum.Uuid.index();
    public static final int NAMEEN = AttributesEnum.NameEn.index();
    public static final int NAMECN = AttributesEnum.NameCn.index();
    public static final int DISPLAY = AttributesEnum.Display.index();
    public static final int CREATEBY = AttributesEnum.CreateBy.index();
    public static final int CREATEON = AttributesEnum.CreateOn.index();
    public static final int MODIFYBY = AttributesEnum.ModifyBy.index();
    public static final int MODIFYON = AttributesEnum.ModifyOn.index();
    public static final int VERSION = AttributesEnum.Version.index();
    public static final int JOBTEMPLATE = AttributesEnum.JobTemplate.index();
    public static final int JOBSUBCATEGORY = AttributesEnum.JobSubCategory.index();

    /**
     * This is the default constructor (do not remove).
     */
    public JobCategoryVORowImpl() {
    }

    /**
     * Gets JobCategoryEO entity object.
     * @return the JobCategoryEO
     */
    public EntityImpl getJobCategoryEO() {
        return (EntityImpl) getEntity(ENTITY_JOBCATEGORYEO);
    }

    /**
     * Gets the attribute value for UUID using the alias name Uuid.
     * @return the UUID
     */
    public String getUuid() {
        return (String) getAttributeInternal(UUID);
    }

    /**
     * Sets <code>value</code> as attribute value for UUID using the alias name Uuid.
     * @param value value to set the UUID
     */
    public void setUuid(String value) {
        setAttributeInternal(UUID, value);
    }

    /**
     * Gets the attribute value for NAME_EN using the alias name NameEn.
     * @return the NAME_EN
     */
    public String getNameEn() {
        return (String) getAttributeInternal(NAMEEN);
    }

    /**
     * Sets <code>value</code> as attribute value for NAME_EN using the alias name NameEn.
     * @param value value to set the NAME_EN
     */
    public void setNameEn(String value) {
        setAttributeInternal(NAMEEN, value);
    }

    /**
     * Gets the attribute value for NAME_CN using the alias name NameCn.
     * @return the NAME_CN
     */
    public String getNameCn() {
        return (String) getAttributeInternal(NAMECN);
    }

    /**
     * Sets <code>value</code> as attribute value for NAME_CN using the alias name NameCn.
     * @param value value to set the NAME_CN
     */
    public void setNameCn(String value) {
        setAttributeInternal(NAMECN, value);
    }

    /**
     * Gets the attribute value for DISPLAY using the alias name Display.
     * @return the DISPLAY
     */
    public String getDisplay() {
        return (String) getAttributeInternal(DISPLAY);
    }

    /**
     * Sets <code>value</code> as attribute value for DISPLAY using the alias name Display.
     * @param value value to set the DISPLAY
     */
    public void setDisplay(String value) {
        setAttributeInternal(DISPLAY, value);
    }

    /**
     * Gets the attribute value for CREATE_BY using the alias name CreateBy.
     * @return the CREATE_BY
     */
    public String getCreateBy() {
        return (String) getAttributeInternal(CREATEBY);
    }

    /**
     * Gets the attribute value for CREATE_ON using the alias name CreateOn.
     * @return the CREATE_ON
     */
    public Timestamp getCreateOn() {
        return (Timestamp) getAttributeInternal(CREATEON);
    }

    /**
     * Gets the attribute value for MODIFY_BY using the alias name ModifyBy.
     * @return the MODIFY_BY
     */
    public String getModifyBy() {
        return (String) getAttributeInternal(MODIFYBY);
    }

    /**
     * Gets the attribute value for MODIFY_ON using the alias name ModifyOn.
     * @return the MODIFY_ON
     */
    public Timestamp getModifyOn() {
        return (Timestamp) getAttributeInternal(MODIFYON);
    }

    /**
     * Gets the attribute value for VERSION using the alias name Version.
     * @return the VERSION
     */
    public BigDecimal getVersion() {
        return (BigDecimal) getAttributeInternal(VERSION);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link JobTemplate.
     */
    public RowIterator getJobTemplate() {
        return (RowIterator) getAttributeInternal(JOBTEMPLATE);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link JobSubCategory.
     */
    public RowIterator getJobSubCategory() {
        return (RowIterator) getAttributeInternal(JOBSUBCATEGORY);
    }
}

