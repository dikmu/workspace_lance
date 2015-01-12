package com.lance.model.user.vo;

import com.zngh.platform.front.core.model.BaseEntityImpl;
import com.zngh.platform.front.core.model.BaseViewRowImpl;

import java.math.BigDecimal;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.NClobDomain;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Dec 13 15:14:50 CST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class UserLocationListVORowImpl extends BaseViewRowImpl {

    public static final int ENTITY_USERLOCATIONLISTEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Uuid,
        RegionId,
        CountryId,
        ProvinceId,
        CityId,
        AreaId,
        CurrentIn,
        Telphone,
        FaxNumber,
        ZipCode,
        DetailLoc,
        CreateBy,
        CreateOn,
        ModifyBy,
        ModifyOn,
        Version,
        UserName;
        static AttributesEnum[] vals = null;
        ;
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
    public static final int REGIONID = AttributesEnum.RegionId.index();
    public static final int COUNTRYID = AttributesEnum.CountryId.index();
    public static final int PROVINCEID = AttributesEnum.ProvinceId.index();
    public static final int CITYID = AttributesEnum.CityId.index();
    public static final int AREAID = AttributesEnum.AreaId.index();
    public static final int CURRENTIN = AttributesEnum.CurrentIn.index();
    public static final int TELPHONE = AttributesEnum.Telphone.index();
    public static final int FAXNUMBER = AttributesEnum.FaxNumber.index();
    public static final int ZIPCODE = AttributesEnum.ZipCode.index();
    public static final int DETAILLOC = AttributesEnum.DetailLoc.index();
    public static final int CREATEBY = AttributesEnum.CreateBy.index();
    public static final int CREATEON = AttributesEnum.CreateOn.index();
    public static final int MODIFYBY = AttributesEnum.ModifyBy.index();
    public static final int MODIFYON = AttributesEnum.ModifyOn.index();
    public static final int VERSION = AttributesEnum.Version.index();
    public static final int USERNAME = AttributesEnum.UserName.index();

    /**
     * This is the default constructor (do not remove).
     */
    public UserLocationListVORowImpl() {
    }

    /**
     * Gets UserLocationListEO entity object.
     * @return the UserLocationListEO
     */
    public BaseEntityImpl getUserLocationListEO() {
        return (BaseEntityImpl) getEntity(ENTITY_USERLOCATIONLISTEO);
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
     * Gets the attribute value for REGION_ID using the alias name RegionId.
     * @return the REGION_ID
     */
    public String getRegionId() {
        return (String) getAttributeInternal(REGIONID);
    }

    /**
     * Sets <code>value</code> as attribute value for REGION_ID using the alias name RegionId.
     * @param value value to set the REGION_ID
     */
    public void setRegionId(String value) {
        setAttributeInternal(REGIONID, value);
    }

    /**
     * Gets the attribute value for COUNTRY_ID using the alias name CountryId.
     * @return the COUNTRY_ID
     */
    public String getCountryId() {
        return (String) getAttributeInternal(COUNTRYID);
    }

    /**
     * Sets <code>value</code> as attribute value for COUNTRY_ID using the alias name CountryId.
     * @param value value to set the COUNTRY_ID
     */
    public void setCountryId(String value) {
        setAttributeInternal(COUNTRYID, value);
    }

    /**
     * Gets the attribute value for PROVINCE_ID using the alias name ProvinceId.
     * @return the PROVINCE_ID
     */
    public String getProvinceId() {
        return (String) getAttributeInternal(PROVINCEID);
    }

    /**
     * Sets <code>value</code> as attribute value for PROVINCE_ID using the alias name ProvinceId.
     * @param value value to set the PROVINCE_ID
     */
    public void setProvinceId(String value) {
        setAttributeInternal(PROVINCEID, value);
    }

    /**
     * Gets the attribute value for CITY_ID using the alias name CityId.
     * @return the CITY_ID
     */
    public String getCityId() {
        return (String) getAttributeInternal(CITYID);
    }

    /**
     * Sets <code>value</code> as attribute value for CITY_ID using the alias name CityId.
     * @param value value to set the CITY_ID
     */
    public void setCityId(String value) {
        setAttributeInternal(CITYID, value);
    }

    /**
     * Gets the attribute value for AREA_ID using the alias name AreaId.
     * @return the AREA_ID
     */
    public String getAreaId() {
        return (String) getAttributeInternal(AREAID);
    }

    /**
     * Sets <code>value</code> as attribute value for AREA_ID using the alias name AreaId.
     * @param value value to set the AREA_ID
     */
    public void setAreaId(String value) {
        setAttributeInternal(AREAID, value);
    }

    /**
     * Gets the attribute value for CURRENT_IN using the alias name CurrentIn.
     * @return the CURRENT_IN
     */
    public oracle.jbo.domain.Number getCurrentIn() {
        return (oracle.jbo.domain.Number) getAttributeInternal(CURRENTIN);
    }

    /**
     * Sets <code>value</code> as attribute value for CURRENT_IN using the alias name CurrentIn.
     * @param value value to set the CURRENT_IN
     */
    public void setCurrentIn(oracle.jbo.domain.Number value) {
        setAttributeInternal(CURRENTIN, value);
    }


    /**
     * Gets the attribute value for TELPHONE using the alias name Telphone.
     * @return the TELPHONE
     */
    public String getTelphone() {
        return (String) getAttributeInternal(TELPHONE);
    }

    /**
     * Sets <code>value</code> as attribute value for TELPHONE using the alias name Telphone.
     * @param value value to set the TELPHONE
     */
    public void setTelphone(String value) {
        setAttributeInternal(TELPHONE, value);
    }

    /**
     * Gets the attribute value for FAX_NUMBER using the alias name FaxNumber.
     * @return the FAX_NUMBER
     */
    public String getFaxNumber() {
        return (String) getAttributeInternal(FAXNUMBER);
    }

    /**
     * Sets <code>value</code> as attribute value for FAX_NUMBER using the alias name FaxNumber.
     * @param value value to set the FAX_NUMBER
     */
    public void setFaxNumber(String value) {
        setAttributeInternal(FAXNUMBER, value);
    }

    /**
     * Gets the attribute value for ZIP_CODE using the alias name ZipCode.
     * @return the ZIP_CODE
     */
    public String getZipCode() {
        return (String) getAttributeInternal(ZIPCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for ZIP_CODE using the alias name ZipCode.
     * @param value value to set the ZIP_CODE
     */
    public void setZipCode(String value) {
        setAttributeInternal(ZIPCODE, value);
    }

    /**
     * Gets the attribute value for DETAIL_LOC using the alias name DetailLoc.
     * @return the DETAIL_LOC
     */
    public String getDetailLoc() {
        return (String) getAttributeInternal(DETAILLOC);
    }

    /**
     * Sets <code>value</code> as attribute value for DETAIL_LOC using the alias name DetailLoc.
     * @param value value to set the DETAIL_LOC
     */
    public void setDetailLoc(String value) {
        setAttributeInternal(DETAILLOC, value);
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
    public Date getCreateOn() {
        return (Date) getAttributeInternal(CREATEON);
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
    public Date getModifyOn() {
        return (Date) getAttributeInternal(MODIFYON);
    }


    /**
     * Gets the attribute value for VERSION using the alias name Version.
     * @return the VERSION
     */
    public BigDecimal getVersion() {
        return (BigDecimal) getAttributeInternal(VERSION);
    }


    /**
     * Gets the attribute value for USER_NAME using the alias name UserName.
     * @return the USER_NAME
     */
    public String getUserName() {
        return (String) getAttributeInternal(USERNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for USER_NAME using the alias name UserName.
     * @param value value to set the USER_NAME
     */
    public void setUserName(String value) {
        setAttributeInternal(USERNAME, value);
    }
}
