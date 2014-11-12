package com.lance.model.vo;

import com.zngh.platform.front.core.model.BaseEntityImpl;
import com.zngh.platform.front.core.model.BaseViewRowImpl;

import java.math.BigDecimal;

import oracle.jbo.RowIterator;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Nov 12 14:02:28 CST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LocationProvinceVORowImpl extends BaseViewRowImpl {
    public static final int ENTITY_LOCATIONPROVINCEEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Uuid,
        ProvinceCode,
        ProvinceName,
        ShowOrder,
        LocationCity;
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
    public static final int PROVINCECODE = AttributesEnum.ProvinceCode.index();
    public static final int PROVINCENAME = AttributesEnum.ProvinceName.index();
    public static final int SHOWORDER = AttributesEnum.ShowOrder.index();
    public static final int LOCATIONCITY = AttributesEnum.LocationCity.index();

    /**
     * This is the default constructor (do not remove).
     */
    public LocationProvinceVORowImpl() {
    }

    /**
     * Gets LocationProvinceEO entity object.
     * @return the LocationProvinceEO
     */
    public BaseEntityImpl getLocationProvinceEO() {
        return (BaseEntityImpl) getEntity(ENTITY_LOCATIONPROVINCEEO);
    }

    /**
     * Gets the attribute value for UUID using the alias name Uuid.
     * @return the UUID
     */
    public BigDecimal getUuid() {
        return (BigDecimal) getAttributeInternal(UUID);
    }

    /**
     * Sets <code>value</code> as attribute value for UUID using the alias name Uuid.
     * @param value value to set the UUID
     */
    public void setUuid(BigDecimal value) {
        setAttributeInternal(UUID, value);
    }

    /**
     * Gets the attribute value for PROVINCE_CODE using the alias name ProvinceCode.
     * @return the PROVINCE_CODE
     */
    public String getProvinceCode() {
        return (String) getAttributeInternal(PROVINCECODE);
    }

    /**
     * Sets <code>value</code> as attribute value for PROVINCE_CODE using the alias name ProvinceCode.
     * @param value value to set the PROVINCE_CODE
     */
    public void setProvinceCode(String value) {
        setAttributeInternal(PROVINCECODE, value);
    }

    /**
     * Gets the attribute value for PROVINCE_NAME using the alias name ProvinceName.
     * @return the PROVINCE_NAME
     */
    public String getProvinceName() {
        return (String) getAttributeInternal(PROVINCENAME);
    }

    /**
     * Sets <code>value</code> as attribute value for PROVINCE_NAME using the alias name ProvinceName.
     * @param value value to set the PROVINCE_NAME
     */
    public void setProvinceName(String value) {
        setAttributeInternal(PROVINCENAME, value);
    }

    /**
     * Gets the attribute value for SHOW_ORDER using the alias name ShowOrder.
     * @return the SHOW_ORDER
     */
    public BigDecimal getShowOrder() {
        return (BigDecimal) getAttributeInternal(SHOWORDER);
    }

    /**
     * Sets <code>value</code> as attribute value for SHOW_ORDER using the alias name ShowOrder.
     * @param value value to set the SHOW_ORDER
     */
    public void setShowOrder(BigDecimal value) {
        setAttributeInternal(SHOWORDER, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link LocationCity.
     */
    public RowIterator getLocationCity() {
        return (RowIterator) getAttributeInternal(LOCATIONCITY);
    }
}

