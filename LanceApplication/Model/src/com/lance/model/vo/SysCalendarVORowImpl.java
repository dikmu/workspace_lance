package com.lance.model.vo;

import com.zngh.platform.front.core.model.BaseEntityImpl;
import com.zngh.platform.front.core.model.BaseViewRowImpl;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Mar 04 15:36:25 CST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SysCalendarVORowImpl extends BaseViewRowImpl {


    public static final int ENTITY_SYSCALENDAREO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Day,
        DateType,
        Description,
        SysDateRec,
        ShowOrder,
        LookupsVVO1;
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


    public static final int DAY = AttributesEnum.Day.index();
    public static final int DATETYPE = AttributesEnum.DateType.index();
    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int SYSDATEREC = AttributesEnum.SysDateRec.index();
    public static final int SHOWORDER = AttributesEnum.ShowOrder.index();
    public static final int LOOKUPSVVO1 = AttributesEnum.LookupsVVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SysCalendarVORowImpl() {
    }

    /**
     * Gets SysCalendarEO entity object.
     * @return the SysCalendarEO
     */
    public BaseEntityImpl getSysCalendarEO() {
        return (BaseEntityImpl) getEntity(ENTITY_SYSCALENDAREO);
    }

    /**
     * Gets the attribute value for DAY using the alias name Day.
     * @return the DAY
     */
    public Integer getDay() {
        return (Integer) getAttributeInternal(DAY);
    }

    /**
     * Sets <code>value</code> as attribute value for DAY using the alias name Day.
     * @param value value to set the DAY
     */
    public void setDay(Integer value) {
        setAttributeInternal(DAY, value);
    }

    /**
     * Gets the attribute value for DATE_TYPE using the alias name DateType.
     * @return the DATE_TYPE
     */
    public String getDateType() {
        return (String) getAttributeInternal(DATETYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for DATE_TYPE using the alias name DateType.
     * @param value value to set the DATE_TYPE
     */
    public void setDateType(String value) {
        setAttributeInternal(DATETYPE, value);
    }

    /**
     * Gets the attribute value for DESCRIPTION using the alias name Description.
     * @return the DESCRIPTION
     */
    public String getDescription() {
        return (String) getAttributeInternal(DESCRIPTION);
    }

    /**
     * Sets <code>value</code> as attribute value for DESCRIPTION using the alias name Description.
     * @param value value to set the DESCRIPTION
     */
    public void setDescription(String value) {
        setAttributeInternal(DESCRIPTION, value);
    }

    /**
     * Gets the attribute value for SYS_DATE_REC using the alias name SysDateRec.
     * @return the SYS_DATE_REC
     */
    public String getSysDateRec() {
        return (String) getAttributeInternal(SYSDATEREC);
    }

    /**
     * Sets <code>value</code> as attribute value for SYS_DATE_REC using the alias name SysDateRec.
     * @param value value to set the SYS_DATE_REC
     */
    public void setSysDateRec(String value) {
        setAttributeInternal(SYSDATEREC, value);
    }

    /**
     * Gets the attribute value for SHOW_ORDER using the alias name ShowOrder.
     * @return the SHOW_ORDER
     */
    public Long getShowOrder() {
        return (Long) getAttributeInternal(SHOWORDER);
    }

    /**
     * Sets <code>value</code> as attribute value for SHOW_ORDER using the alias name ShowOrder.
     * @param value value to set the SHOW_ORDER
     */
    public void setShowOrder(Long value) {
        setAttributeInternal(SHOWORDER, value);
    }


    /**
     * Gets the view accessor <code>RowSet</code> LookupsVVO1.
     */
    public RowSet getLookupsVVO1() {
        return (RowSet) getAttributeInternal(LOOKUPSVVO1);
    }
}

