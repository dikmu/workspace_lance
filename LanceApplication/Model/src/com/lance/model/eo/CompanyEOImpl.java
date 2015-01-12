package com.lance.model.eo;

import com.zngh.platform.front.core.model.BaseEntityImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.EntityDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Nov 30 15:05:26 CST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CompanyEOImpl extends BaseEntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Uuid,
        Name,
        EnterpriseProperty,
        EmployeeNumberGrade,
        FoundYear,
        AboutCompany,
        ServiceDesc,
        Location,
        Video,
        Logo,
        CreateBy,
        CreateOn,
        ModifyBy,
        ModifyOn,
        Version;
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
    public static final int NAME = AttributesEnum.Name.index();
    public static final int ENTERPRISEPROPERTY = AttributesEnum.EnterpriseProperty.index();
    public static final int EMPLOYEENUMBERGRADE = AttributesEnum.EmployeeNumberGrade.index();
    public static final int FOUNDYEAR = AttributesEnum.FoundYear.index();
    public static final int ABOUTCOMPANY = AttributesEnum.AboutCompany.index();
    public static final int SERVICEDESC = AttributesEnum.ServiceDesc.index();
    public static final int LOCATION = AttributesEnum.Location.index();
    public static final int VIDEO = AttributesEnum.Video.index();
    public static final int LOGO = AttributesEnum.Logo.index();
    public static final int CREATEBY = AttributesEnum.CreateBy.index();
    public static final int CREATEON = AttributesEnum.CreateOn.index();
    public static final int MODIFYBY = AttributesEnum.ModifyBy.index();
    public static final int MODIFYON = AttributesEnum.ModifyOn.index();
    public static final int VERSION = AttributesEnum.Version.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CompanyEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("com.lance.model.eo.CompanyEO");
    }


    /**
     * Gets the attribute value for Uuid, using the alias name Uuid.
     * @return the value of Uuid
     */
    public String getUuid() {
        return (String) getAttributeInternal(UUID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Uuid.
     * @param value value to set the Uuid
     */
    public void setUuid(String value) {
        setAttributeInternal(UUID, value);
    }

    /**
     * Gets the attribute value for Name, using the alias name Name.
     * @return the value of Name
     */
    public String getName() {
        return (String) getAttributeInternal(NAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for Name.
     * @param value value to set the Name
     */
    public void setName(String value) {
        setAttributeInternal(NAME, value);
    }

    /**
     * Gets the attribute value for EnterpriseProperty, using the alias name EnterpriseProperty.
     * @return the value of EnterpriseProperty
     */
    public String getEnterpriseProperty() {
        return (String) getAttributeInternal(ENTERPRISEPROPERTY);
    }

    /**
     * Sets <code>value</code> as the attribute value for EnterpriseProperty.
     * @param value value to set the EnterpriseProperty
     */
    public void setEnterpriseProperty(String value) {
        setAttributeInternal(ENTERPRISEPROPERTY, value);
    }

    /**
     * Gets the attribute value for EmployeeNumberGrade, using the alias name EmployeeNumberGrade.
     * @return the value of EmployeeNumberGrade
     */
    public Number getEmployeeNumberGrade() {
        return (Number) getAttributeInternal(EMPLOYEENUMBERGRADE);
    }

    /**
     * Sets <code>value</code> as the attribute value for EmployeeNumberGrade.
     * @param value value to set the EmployeeNumberGrade
     */
    public void setEmployeeNumberGrade(Number value) {
        setAttributeInternal(EMPLOYEENUMBERGRADE, value);
    }

    /**
     * Gets the attribute value for FoundYear, using the alias name FoundYear.
     * @return the value of FoundYear
     */
    public Date getFoundYear() {
        return (Date) getAttributeInternal(FOUNDYEAR);
    }

    /**
     * Sets <code>value</code> as the attribute value for FoundYear.
     * @param value value to set the FoundYear
     */
    public void setFoundYear(Date value) {
        setAttributeInternal(FOUNDYEAR, value);
    }

    /**
     * Gets the attribute value for AboutCompany, using the alias name AboutCompany.
     * @return the value of AboutCompany
     */
    public String getAboutCompany() {
        return (String) getAttributeInternal(ABOUTCOMPANY);
    }

    /**
     * Sets <code>value</code> as the attribute value for AboutCompany.
     * @param value value to set the AboutCompany
     */
    public void setAboutCompany(String value) {
        setAttributeInternal(ABOUTCOMPANY, value);
    }

    /**
     * Gets the attribute value for ServiceDesc, using the alias name ServiceDesc.
     * @return the value of ServiceDesc
     */
    public String getServiceDesc() {
        return (String) getAttributeInternal(SERVICEDESC);
    }

    /**
     * Sets <code>value</code> as the attribute value for ServiceDesc.
     * @param value value to set the ServiceDesc
     */
    public void setServiceDesc(String value) {
        setAttributeInternal(SERVICEDESC, value);
    }

    /**
     * Gets the attribute value for Location, using the alias name Location.
     * @return the value of Location
     */
    public String getLocation() {
        return (String) getAttributeInternal(LOCATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for Location.
     * @param value value to set the Location
     */
    public void setLocation(String value) {
        setAttributeInternal(LOCATION, value);
    }

    /**
     * Gets the attribute value for Video, using the alias name Video.
     * @return the value of Video
     */
    public String getVideo() {
        return (String) getAttributeInternal(VIDEO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Video.
     * @param value value to set the Video
     */
    public void setVideo(String value) {
        setAttributeInternal(VIDEO, value);
    }

    /**
     * Gets the attribute value for Logo, using the alias name Logo.
     * @return the value of Logo
     */
    public String getLogo() {
        return (String) getAttributeInternal(LOGO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Logo.
     * @param value value to set the Logo
     */
    public void setLogo(String value) {
        setAttributeInternal(LOGO, value);
    }

    /**
     * Gets the attribute value for CreateBy, using the alias name CreateBy.
     * @return the value of CreateBy
     */
    public String getCreateBy() {
        return (String) getAttributeInternal(CREATEBY);
    }

    /**
     * Gets the attribute value for CreateOn, using the alias name CreateOn.
     * @return the value of CreateOn
     */
    public Timestamp getCreateOn() {
        return (Timestamp) getAttributeInternal(CREATEON);
    }

    /**
     * Gets the attribute value for ModifyBy, using the alias name ModifyBy.
     * @return the value of ModifyBy
     */
    public String getModifyBy() {
        return (String) getAttributeInternal(MODIFYBY);
    }

    /**
     * Gets the attribute value for ModifyOn, using the alias name ModifyOn.
     * @return the value of ModifyOn
     */
    public Timestamp getModifyOn() {
        return (Timestamp) getAttributeInternal(MODIFYON);
    }

    /**
     * Gets the attribute value for Version, using the alias name Version.
     * @return the value of Version
     */
    public BigDecimal getVersion() {
        return (BigDecimal) getAttributeInternal(VERSION);
    }


    /**
     * @param uuid key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(String uuid) {
        return new Key(new Object[] { uuid });
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }
}
