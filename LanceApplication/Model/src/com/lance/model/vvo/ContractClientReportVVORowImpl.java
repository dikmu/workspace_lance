package com.lance.model.vvo;

import com.zngh.platform.front.core.model.BaseViewRowImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.domain.ClobDomain;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Mar 30 11:25:14 CST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ContractClientReportVVORowImpl extends BaseViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Day,
        SysDateRec,
        Description,
        Uuid,
        ProjectId,
        ContractId,
        StatusName,
        Address,
        DateRecord,
        WorkContent,
        WorkHours,
        WorkRemark,
        Status,
        StatusRemark,
        PayBillNumber,
        CreateBy,
        CreateOn,
        ModifyBy,
        ModifyOn,
        Version,
        Role;
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
    public static final int DAY = AttributesEnum.Day.index();
    public static final int SYSDATEREC = AttributesEnum.SysDateRec.index();
    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int UUID = AttributesEnum.Uuid.index();
    public static final int PROJECTID = AttributesEnum.ProjectId.index();
    public static final int CONTRACTID = AttributesEnum.ContractId.index();
    public static final int STATUSNAME = AttributesEnum.StatusName.index();
    public static final int ADDRESS = AttributesEnum.Address.index();
    public static final int DATERECORD = AttributesEnum.DateRecord.index();
    public static final int WORKCONTENT = AttributesEnum.WorkContent.index();
    public static final int WORKHOURS = AttributesEnum.WorkHours.index();
    public static final int WORKREMARK = AttributesEnum.WorkRemark.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int STATUSREMARK = AttributesEnum.StatusRemark.index();
    public static final int PAYBILLNUMBER = AttributesEnum.PayBillNumber.index();
    public static final int CREATEBY = AttributesEnum.CreateBy.index();
    public static final int CREATEON = AttributesEnum.CreateOn.index();
    public static final int MODIFYBY = AttributesEnum.ModifyBy.index();
    public static final int MODIFYON = AttributesEnum.ModifyOn.index();
    public static final int VERSION = AttributesEnum.Version.index();
    public static final int ROLE = AttributesEnum.Role.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ContractClientReportVVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute Day.
     * @return the Day
     */
    public BigDecimal getDay() {
        return (BigDecimal) getAttributeInternal(DAY);
    }

    /**
     * Gets the attribute value for the calculated attribute SysDateRec.
     * @return the SysDateRec
     */
    public String getSysDateRec() {
        return (String) getAttributeInternal(SYSDATEREC);
    }

    /**
     * Gets the attribute value for the calculated attribute Description.
     * @return the Description
     */
    public String getDescription() {
        return (String) getAttributeInternal(DESCRIPTION);
    }

    /**
     * Gets the attribute value for the calculated attribute Uuid.
     * @return the Uuid
     */
    public String getUuid() {
        return (String) getAttributeInternal(UUID);
    }

    /**
     * Gets the attribute value for the calculated attribute ProjectId.
     * @return the ProjectId
     */
    public String getProjectId() {
        return (String) getAttributeInternal(PROJECTID);
    }

    /**
     * Gets the attribute value for the calculated attribute ContractId.
     * @return the ContractId
     */
    public String getContractId() {
        return (String) getAttributeInternal(CONTRACTID);
    }

    /**
     * Gets the attribute value for the calculated attribute StatusName.
     * @return the StatusName
     */
    public String getStatusName() {
        return (String) getAttributeInternal(STATUSNAME);
    }

    /**
     * Gets the attribute value for the calculated attribute Address.
     * @return the Address
     */
    public String getAddress() {
        return (String) getAttributeInternal(ADDRESS);
    }

    /**
     * Gets the attribute value for the calculated attribute DateRecord.
     * @return the DateRecord
     */
    public Timestamp getDateRecord() {
        return (Timestamp) getAttributeInternal(DATERECORD);
    }

    /**
     * Gets the attribute value for the calculated attribute WorkContent.
     * @return the WorkContent
     */
    public ClobDomain getWorkContent() {
        return (ClobDomain) getAttributeInternal(WORKCONTENT);
    }

    /**
     * Gets the attribute value for the calculated attribute WorkHours.
     * @return the WorkHours
     */
    public BigDecimal getWorkHours() {
        return (BigDecimal) getAttributeInternal(WORKHOURS);
    }

    /**
     * Gets the attribute value for the calculated attribute WorkRemark.
     * @return the WorkRemark
     */
    public String getWorkRemark() {
        return (String) getAttributeInternal(WORKREMARK);
    }

    /**
     * Gets the attribute value for the calculated attribute Status.
     * @return the Status
     */
    public String getStatus() {
        return (String) getAttributeInternal(STATUS);
    }

    /**
     * Gets the attribute value for the calculated attribute StatusRemark.
     * @return the StatusRemark
     */
    public String getStatusRemark() {
        return (String) getAttributeInternal(STATUSREMARK);
    }

    /**
     * Gets the attribute value for the calculated attribute PayBillNumber.
     * @return the PayBillNumber
     */
    public String getPayBillNumber() {
        return (String) getAttributeInternal(PAYBILLNUMBER);
    }

    /**
     * Gets the attribute value for the calculated attribute CreateBy.
     * @return the CreateBy
     */
    public String getCreateBy() {
        return (String) getAttributeInternal(CREATEBY);
    }

    /**
     * Gets the attribute value for the calculated attribute CreateOn.
     * @return the CreateOn
     */
    public Timestamp getCreateOn() {
        return (Timestamp) getAttributeInternal(CREATEON);
    }

    /**
     * Gets the attribute value for the calculated attribute ModifyBy.
     * @return the ModifyBy
     */
    public String getModifyBy() {
        return (String) getAttributeInternal(MODIFYBY);
    }

    /**
     * Gets the attribute value for the calculated attribute ModifyOn.
     * @return the ModifyOn
     */
    public Timestamp getModifyOn() {
        return (Timestamp) getAttributeInternal(MODIFYON);
    }

    /**
     * Gets the attribute value for the calculated attribute Version.
     * @return the Version
     */
    public BigDecimal getVersion() {
        return (BigDecimal) getAttributeInternal(VERSION);
    }

    /**
     * Gets the attribute value for the calculated attribute Roles.
     * @return the Roles
     */
    public String getRole() {
        return "client";
    }
}

