package com.lance.model.eo;

import com.zngh.platform.front.core.model.BaseEntityImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.ClobDomain;
import oracle.jbo.server.EntityDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Mar 16 15:46:46 CST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ContractReportEOImpl extends BaseEntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Uuid,
        ProjectId,
        ContractId,
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
        StatusName,
        Contract,
        FinPayBill;
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
    public static final int PROJECTID = AttributesEnum.ProjectId.index();
    public static final int CONTRACTID = AttributesEnum.ContractId.index();
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
    public static final int STATUSNAME = AttributesEnum.StatusName.index();
    public static final int CONTRACT = AttributesEnum.Contract.index();
    public static final int FINPAYBILL = AttributesEnum.FinPayBill.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ContractReportEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("com.lance.model.eo.ContractReportEO");
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
     * Gets the attribute value for ProjectId, using the alias name ProjectId.
     * @return the value of ProjectId
     */
    public String getProjectId() {
        return (String) getAttributeInternal(PROJECTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProjectId.
     * @param value value to set the ProjectId
     */
    public void setProjectId(String value) {
        setAttributeInternal(PROJECTID, value);
    }

    /**
     * Gets the attribute value for ContractId, using the alias name ContractId.
     * @return the value of ContractId
     */
    public String getContractId() {
        return (String) getAttributeInternal(CONTRACTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ContractId.
     * @param value value to set the ContractId
     */
    public void setContractId(String value) {
        setAttributeInternal(CONTRACTID, value);
    }

    /**
     * Gets the attribute value for DateRecord, using the alias name DateRecord.
     * @return the value of DateRecord
     */
    public Timestamp getDateRecord() {
        return (Timestamp) getAttributeInternal(DATERECORD);
    }

    /**
     * Sets <code>value</code> as the attribute value for DateRecord.
     * @param value value to set the DateRecord
     */
    public void setDateRecord(Timestamp value) {
        setAttributeInternal(DATERECORD, value);
    }

    /**
     * Gets the attribute value for WorkContent, using the alias name WorkContent.
     * @return the value of WorkContent
     */
    public ClobDomain getWorkContent() {
        return (ClobDomain) getAttributeInternal(WORKCONTENT);
    }

    /**
     * Sets <code>value</code> as the attribute value for WorkContent.
     * @param value value to set the WorkContent
     */
    public void setWorkContent(ClobDomain value) {
        setAttributeInternal(WORKCONTENT, value);
    }

    /**
     * Gets the attribute value for WorkHours, using the alias name WorkHours.
     * @return the value of WorkHours
     */
    public BigDecimal getWorkHours() {
        return (BigDecimal) getAttributeInternal(WORKHOURS);
    }

    /**
     * Sets <code>value</code> as the attribute value for WorkHours.
     * @param value value to set the WorkHours
     */
    public void setWorkHours(BigDecimal value) {
        setAttributeInternal(WORKHOURS, value);
    }

    /**
     * Gets the attribute value for WorkRemark, using the alias name WorkRemark.
     * @return the value of WorkRemark
     */
    public String getWorkRemark() {
        return (String) getAttributeInternal(WORKREMARK);
    }

    /**
     * Sets <code>value</code> as the attribute value for WorkRemark.
     * @param value value to set the WorkRemark
     */
    public void setWorkRemark(String value) {
        setAttributeInternal(WORKREMARK, value);
    }

    /**
     * Gets the attribute value for Status, using the alias name Status.
     * @return the value of Status
     */
    public String getStatus() {
        return (String) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Status.
     * @param value value to set the Status
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for StatusRemark, using the alias name StatusRemark.
     * @return the value of StatusRemark
     */
    public String getStatusRemark() {
        return (String) getAttributeInternal(STATUSREMARK);
    }

    /**
     * Sets <code>value</code> as the attribute value for StatusRemark.
     * @param value value to set the StatusRemark
     */
    public void setStatusRemark(String value) {
        setAttributeInternal(STATUSREMARK, value);
    }

    /**
     * Gets the attribute value for PayBillNumber, using the alias name PayBillNumber.
     * @return the value of PayBillNumber
     */
    public String getPayBillNumber() {
        return (String) getAttributeInternal(PAYBILLNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for PayBillNumber.
     * @param value value to set the PayBillNumber
     */
    public void setPayBillNumber(String value) {
        setAttributeInternal(PAYBILLNUMBER, value);
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
     * Sets <code>value</code> as the attribute value for Version.
     * @param value value to set the Version
     */
    public void setVersion(BigDecimal value) {
        setAttributeInternal(VERSION, value);
    }

    /**
     * Gets the attribute value for StatusName, using the alias name StatusName.
     * @return the value of StatusName
     */
    public String getStatusName() {
        return (String) getAttributeInternal(STATUSNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for StatusName.
     * @param value value to set the StatusName
     */
    public void setStatusName(String value) {
        setAttributeInternal(STATUSNAME, value);
    }

    /**
     * @return the associated entity ContractEOImpl.
     */
    public ContractEOImpl getContract() {
        return (ContractEOImpl) getAttributeInternal(CONTRACT);
    }

    /**
     * Sets <code>value</code> as the associated entity ContractEOImpl.
     */
    public void setContract(ContractEOImpl value) {
        setAttributeInternal(CONTRACT, value);
    }

    /**
     * @return the associated entity com.zngh.platform.front.core.model.BaseEntityImpl.
     */
    public BaseEntityImpl getFinPayBill() {
        return (BaseEntityImpl) getAttributeInternal(FINPAYBILL);
    }

    /**
     * Sets <code>value</code> as the associated entity com.zngh.platform.front.core.model.BaseEntityImpl.
     */
    public void setFinPayBill(BaseEntityImpl value) {
        setAttributeInternal(FINPAYBILL, value);
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
}

