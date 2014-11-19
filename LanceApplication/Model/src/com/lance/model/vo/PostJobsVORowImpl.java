package com.lance.model.vo;

import com.zngh.platform.front.core.model.BaseEntityImpl;
import com.zngh.platform.front.core.model.BaseViewRowImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Oct 18 22:54:03 CST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PostJobsVORowImpl extends BaseViewRowImpl {


    public static final int ENTITY_POSTJOBSEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Uuid,
        AllowSearchEngines,
        Attach,
        Brief,
        DayPayMax,
        DayPayMin,
        DurationMax,
        DurationMin,
        FixedLocation,
        FixedPayMax,
        FixedPayMin,
        HourlyPayMax,
        HourlyPayMin,
        JobVisibility,
        LocationDesc,
        LocationId,
        Name,
        Postform,
        Skills,
        SpecificSkillA,
        SpecificSkillB,
        SpecificSkillC,
        SpecificSkillD,
        SpecificSkillE,
        SpecificSkillF,
        SpecificSkillG,
        Status,
        WeeklyHours,
        WorkCategory,
        WorkSubcategory,
        PostJobDateStart,
        PostJobDateEnd,
        LocationCity,
        LocationCountry,
        LocationProvince,
        ModifiedBy,
        ModifiedOn,
        CreateBy,
        CreateOn,
        Version,
        CreateByName,
        PostJobDiscuss,
        ClientUserVO1;
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
    public static final int ALLOWSEARCHENGINES = AttributesEnum.AllowSearchEngines.index();
    public static final int ATTACH = AttributesEnum.Attach.index();
    public static final int BRIEF = AttributesEnum.Brief.index();
    public static final int DAYPAYMAX = AttributesEnum.DayPayMax.index();
    public static final int DAYPAYMIN = AttributesEnum.DayPayMin.index();
    public static final int DURATIONMAX = AttributesEnum.DurationMax.index();
    public static final int DURATIONMIN = AttributesEnum.DurationMin.index();
    public static final int FIXEDLOCATION = AttributesEnum.FixedLocation.index();
    public static final int FIXEDPAYMAX = AttributesEnum.FixedPayMax.index();
    public static final int FIXEDPAYMIN = AttributesEnum.FixedPayMin.index();
    public static final int HOURLYPAYMAX = AttributesEnum.HourlyPayMax.index();
    public static final int HOURLYPAYMIN = AttributesEnum.HourlyPayMin.index();
    public static final int JOBVISIBILITY = AttributesEnum.JobVisibility.index();
    public static final int LOCATIONDESC = AttributesEnum.LocationDesc.index();
    public static final int LOCATIONID = AttributesEnum.LocationId.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int POSTFORM = AttributesEnum.Postform.index();
    public static final int SKILLS = AttributesEnum.Skills.index();
    public static final int SPECIFICSKILLA = AttributesEnum.SpecificSkillA.index();
    public static final int SPECIFICSKILLB = AttributesEnum.SpecificSkillB.index();
    public static final int SPECIFICSKILLC = AttributesEnum.SpecificSkillC.index();
    public static final int SPECIFICSKILLD = AttributesEnum.SpecificSkillD.index();
    public static final int SPECIFICSKILLE = AttributesEnum.SpecificSkillE.index();
    public static final int SPECIFICSKILLF = AttributesEnum.SpecificSkillF.index();
    public static final int SPECIFICSKILLG = AttributesEnum.SpecificSkillG.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int WEEKLYHOURS = AttributesEnum.WeeklyHours.index();
    public static final int WORKCATEGORY = AttributesEnum.WorkCategory.index();
    public static final int WORKSUBCATEGORY = AttributesEnum.WorkSubcategory.index();
    public static final int POSTJOBDATESTART = AttributesEnum.PostJobDateStart.index();
    public static final int POSTJOBDATEEND = AttributesEnum.PostJobDateEnd.index();
    public static final int LOCATIONCITY = AttributesEnum.LocationCity.index();
    public static final int LOCATIONCOUNTRY = AttributesEnum.LocationCountry.index();
    public static final int LOCATIONPROVINCE = AttributesEnum.LocationProvince.index();
    public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
    public static final int MODIFIEDON = AttributesEnum.ModifiedOn.index();
    public static final int CREATEBY = AttributesEnum.CreateBy.index();
    public static final int CREATEON = AttributesEnum.CreateOn.index();
    public static final int VERSION = AttributesEnum.Version.index();
    public static final int CREATEBYNAME = AttributesEnum.CreateByName.index();
    public static final int POSTJOBDISCUSS = AttributesEnum.PostJobDiscuss.index();
    public static final int CLIENTUSERVO1 = AttributesEnum.ClientUserVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PostJobsVORowImpl() {
    }

    /**
     * Gets PostJobsEO entity object.
     * @return the PostJobsEO
     */
    public BaseEntityImpl getPostJobsEO() {
        return (BaseEntityImpl) getEntity(ENTITY_POSTJOBSEO);
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
     * Gets the attribute value for ALLOW_SEARCH_ENGINES using the alias name AllowSearchEngines.
     * @return the ALLOW_SEARCH_ENGINES
     */
    public Integer getAllowSearchEngines() {
        return (Integer) getAttributeInternal(ALLOWSEARCHENGINES);
    }

    /**
     * Sets <code>value</code> as attribute value for ALLOW_SEARCH_ENGINES using the alias name AllowSearchEngines.
     * @param value value to set the ALLOW_SEARCH_ENGINES
     */
    public void setAllowSearchEngines(Integer value) {
        setAttributeInternal(ALLOWSEARCHENGINES, value);
    }

    /**
     * Gets the attribute value for ATTACH using the alias name Attach.
     * @return the ATTACH
     */
    public String getAttach() {
        return (String) getAttributeInternal(ATTACH);
    }

    /**
     * Sets <code>value</code> as attribute value for ATTACH using the alias name Attach.
     * @param value value to set the ATTACH
     */
    public void setAttach(String value) {
        setAttributeInternal(ATTACH, value);
    }

    /**
     * Gets the attribute value for BRIEF using the alias name Brief.
     * @return the BRIEF
     */
    public String getBrief() {
        return (String) getAttributeInternal(BRIEF);
    }

    /**
     * Sets <code>value</code> as attribute value for BRIEF using the alias name Brief.
     * @param value value to set the BRIEF
     */
    public void setBrief(String value) {
        setAttributeInternal(BRIEF, value);
    }

    /**
     * Gets the attribute value for DAY_PAY_MAX using the alias name DayPayMax.
     * @return the DAY_PAY_MAX
     */
    public BigDecimal getDayPayMax() {
        return (BigDecimal) getAttributeInternal(DAYPAYMAX);
    }

    /**
     * Sets <code>value</code> as attribute value for DAY_PAY_MAX using the alias name DayPayMax.
     * @param value value to set the DAY_PAY_MAX
     */
    public void setDayPayMax(BigDecimal value) {
        setAttributeInternal(DAYPAYMAX, value);
    }

    /**
     * Gets the attribute value for DAY_PAY_MIN using the alias name DayPayMin.
     * @return the DAY_PAY_MIN
     */
    public BigDecimal getDayPayMin() {
        return (BigDecimal) getAttributeInternal(DAYPAYMIN);
    }

    /**
     * Sets <code>value</code> as attribute value for DAY_PAY_MIN using the alias name DayPayMin.
     * @param value value to set the DAY_PAY_MIN
     */
    public void setDayPayMin(BigDecimal value) {
        setAttributeInternal(DAYPAYMIN, value);
    }

    /**
     * Gets the attribute value for DURATION_MAX using the alias name DurationMax.
     * @return the DURATION_MAX
     */
    public BigDecimal getDurationMax() {
        return (BigDecimal) getAttributeInternal(DURATIONMAX);
    }

    /**
     * Sets <code>value</code> as attribute value for DURATION_MAX using the alias name DurationMax.
     * @param value value to set the DURATION_MAX
     */
    public void setDurationMax(BigDecimal value) {
        setAttributeInternal(DURATIONMAX, value);
    }

    /**
     * Gets the attribute value for DURATION_MIN using the alias name DurationMin.
     * @return the DURATION_MIN
     */
    public BigDecimal getDurationMin() {
        return (BigDecimal) getAttributeInternal(DURATIONMIN);
    }

    /**
     * Sets <code>value</code> as attribute value for DURATION_MIN using the alias name DurationMin.
     * @param value value to set the DURATION_MIN
     */
    public void setDurationMin(BigDecimal value) {
        setAttributeInternal(DURATIONMIN, value);
    }

    /**
     * Gets the attribute value for FIXED_LOCATION using the alias name FixedLocation.
     * @return the FIXED_LOCATION
     */
    public Integer getFixedLocation() {
        return (Integer) getAttributeInternal(FIXEDLOCATION);
    }

    /**
     * Sets <code>value</code> as attribute value for FIXED_LOCATION using the alias name FixedLocation.
     * @param value value to set the FIXED_LOCATION
     */
    public void setFixedLocation(Integer value) {
        setAttributeInternal(FIXEDLOCATION, value);
    }

    /**
     * Gets the attribute value for FIXED_PAY_MAX using the alias name FixedPayMax.
     * @return the FIXED_PAY_MAX
     */
    public BigDecimal getFixedPayMax() {
        return (BigDecimal) getAttributeInternal(FIXEDPAYMAX);
    }

    /**
     * Sets <code>value</code> as attribute value for FIXED_PAY_MAX using the alias name FixedPayMax.
     * @param value value to set the FIXED_PAY_MAX
     */
    public void setFixedPayMax(BigDecimal value) {
        setAttributeInternal(FIXEDPAYMAX, value);
    }

    /**
     * Gets the attribute value for FIXED_PAY_MIN using the alias name FixedPayMin.
     * @return the FIXED_PAY_MIN
     */
    public BigDecimal getFixedPayMin() {
        return (BigDecimal) getAttributeInternal(FIXEDPAYMIN);
    }

    /**
     * Sets <code>value</code> as attribute value for FIXED_PAY_MIN using the alias name FixedPayMin.
     * @param value value to set the FIXED_PAY_MIN
     */
    public void setFixedPayMin(BigDecimal value) {
        setAttributeInternal(FIXEDPAYMIN, value);
    }

    /**
     * Gets the attribute value for HOURLY_PAY_MAX using the alias name HourlyPayMax.
     * @return the HOURLY_PAY_MAX
     */
    public BigDecimal getHourlyPayMax() {
        return (BigDecimal) getAttributeInternal(HOURLYPAYMAX);
    }

    /**
     * Sets <code>value</code> as attribute value for HOURLY_PAY_MAX using the alias name HourlyPayMax.
     * @param value value to set the HOURLY_PAY_MAX
     */
    public void setHourlyPayMax(BigDecimal value) {
        setAttributeInternal(HOURLYPAYMAX, value);
    }

    /**
     * Gets the attribute value for HOURLY_PAY_MIN using the alias name HourlyPayMin.
     * @return the HOURLY_PAY_MIN
     */
    public BigDecimal getHourlyPayMin() {
        return (BigDecimal) getAttributeInternal(HOURLYPAYMIN);
    }

    /**
     * Sets <code>value</code> as attribute value for HOURLY_PAY_MIN using the alias name HourlyPayMin.
     * @param value value to set the HOURLY_PAY_MIN
     */
    public void setHourlyPayMin(BigDecimal value) {
        setAttributeInternal(HOURLYPAYMIN, value);
    }

    /**
     * Gets the attribute value for JOB_VISIBILITY using the alias name JobVisibility.
     * @return the JOB_VISIBILITY
     */
    public Integer getJobVisibility() {
        return (Integer) getAttributeInternal(JOBVISIBILITY);
    }

    /**
     * Sets <code>value</code> as attribute value for JOB_VISIBILITY using the alias name JobVisibility.
     * @param value value to set the JOB_VISIBILITY
     */
    public void setJobVisibility(Integer value) {
        setAttributeInternal(JOBVISIBILITY, value);
    }

    /**
     * Gets the attribute value for LOCATION_DESC using the alias name LocationDesc.
     * @return the LOCATION_DESC
     */
    public String getLocationDesc() {
        return (String) getAttributeInternal(LOCATIONDESC);
    }

    /**
     * Sets <code>value</code> as attribute value for LOCATION_DESC using the alias name LocationDesc.
     * @param value value to set the LOCATION_DESC
     */
    public void setLocationDesc(String value) {
        setAttributeInternal(LOCATIONDESC, value);
    }

    /**
     * Gets the attribute value for LOCATION_ID using the alias name LocationId.
     * @return the LOCATION_ID
     */
    public String getLocationId() {
        return (String) getAttributeInternal(LOCATIONID);
    }

    /**
     * Sets <code>value</code> as attribute value for LOCATION_ID using the alias name LocationId.
     * @param value value to set the LOCATION_ID
     */
    public void setLocationId(String value) {
        setAttributeInternal(LOCATIONID, value);
    }

    /**
     * Gets the attribute value for NAME using the alias name Name.
     * @return the NAME
     */
    public String getName() {
        return (String) getAttributeInternal(NAME);
    }

    /**
     * Sets <code>value</code> as attribute value for NAME using the alias name Name.
     * @param value value to set the NAME
     */
    public void setName(String value) {
        setAttributeInternal(NAME, value);
    }

    /**
     * Gets the attribute value for POSTFORM using the alias name Postform.
     * @return the POSTFORM
     */
    public Integer getPostform() {
        return (Integer) getAttributeInternal(POSTFORM);
    }

    /**
     * Sets <code>value</code> as attribute value for POSTFORM using the alias name Postform.
     * @param value value to set the POSTFORM
     */
    public void setPostform(Integer value) {
        setAttributeInternal(POSTFORM, value);
    }

    /**
     * Gets the attribute value for SKILLS using the alias name Skills.
     * @return the SKILLS
     */
    public String getSkills() {
        return (String) getAttributeInternal(SKILLS);
    }

    /**
     * Sets <code>value</code> as attribute value for SKILLS using the alias name Skills.
     * @param value value to set the SKILLS
     */
    public void setSkills(String value) {
        setAttributeInternal(SKILLS, value);
    }

    /**
     * Gets the attribute value for SPECIFIC_SKILL_A using the alias name SpecificSkillA.
     * @return the SPECIFIC_SKILL_A
     */
    public String getSpecificSkillA() {
        return (String) getAttributeInternal(SPECIFICSKILLA);
    }

    /**
     * Sets <code>value</code> as attribute value for SPECIFIC_SKILL_A using the alias name SpecificSkillA.
     * @param value value to set the SPECIFIC_SKILL_A
     */
    public void setSpecificSkillA(String value) {
        setAttributeInternal(SPECIFICSKILLA, value);
    }

    /**
     * Gets the attribute value for SPECIFIC_SKILL_B using the alias name SpecificSkillB.
     * @return the SPECIFIC_SKILL_B
     */
    public String getSpecificSkillB() {
        return (String) getAttributeInternal(SPECIFICSKILLB);
    }

    /**
     * Sets <code>value</code> as attribute value for SPECIFIC_SKILL_B using the alias name SpecificSkillB.
     * @param value value to set the SPECIFIC_SKILL_B
     */
    public void setSpecificSkillB(String value) {
        setAttributeInternal(SPECIFICSKILLB, value);
    }

    /**
     * Gets the attribute value for SPECIFIC_SKILL_C using the alias name SpecificSkillC.
     * @return the SPECIFIC_SKILL_C
     */
    public String getSpecificSkillC() {
        return (String) getAttributeInternal(SPECIFICSKILLC);
    }

    /**
     * Sets <code>value</code> as attribute value for SPECIFIC_SKILL_C using the alias name SpecificSkillC.
     * @param value value to set the SPECIFIC_SKILL_C
     */
    public void setSpecificSkillC(String value) {
        setAttributeInternal(SPECIFICSKILLC, value);
    }

    /**
     * Gets the attribute value for SPECIFIC_SKILL_D using the alias name SpecificSkillD.
     * @return the SPECIFIC_SKILL_D
     */
    public String getSpecificSkillD() {
        return (String) getAttributeInternal(SPECIFICSKILLD);
    }

    /**
     * Sets <code>value</code> as attribute value for SPECIFIC_SKILL_D using the alias name SpecificSkillD.
     * @param value value to set the SPECIFIC_SKILL_D
     */
    public void setSpecificSkillD(String value) {
        setAttributeInternal(SPECIFICSKILLD, value);
    }

    /**
     * Gets the attribute value for SPECIFIC_SKILL_E using the alias name SpecificSkillE.
     * @return the SPECIFIC_SKILL_E
     */
    public String getSpecificSkillE() {
        return (String) getAttributeInternal(SPECIFICSKILLE);
    }

    /**
     * Sets <code>value</code> as attribute value for SPECIFIC_SKILL_E using the alias name SpecificSkillE.
     * @param value value to set the SPECIFIC_SKILL_E
     */
    public void setSpecificSkillE(String value) {
        setAttributeInternal(SPECIFICSKILLE, value);
    }

    /**
     * Gets the attribute value for SPECIFIC_SKILL_F using the alias name SpecificSkillF.
     * @return the SPECIFIC_SKILL_F
     */
    public String getSpecificSkillF() {
        return (String) getAttributeInternal(SPECIFICSKILLF);
    }

    /**
     * Sets <code>value</code> as attribute value for SPECIFIC_SKILL_F using the alias name SpecificSkillF.
     * @param value value to set the SPECIFIC_SKILL_F
     */
    public void setSpecificSkillF(String value) {
        setAttributeInternal(SPECIFICSKILLF, value);
    }

    /**
     * Gets the attribute value for SPECIFIC_SKILL_G using the alias name SpecificSkillG.
     * @return the SPECIFIC_SKILL_G
     */
    public String getSpecificSkillG() {
        return (String) getAttributeInternal(SPECIFICSKILLG);
    }

    /**
     * Sets <code>value</code> as attribute value for SPECIFIC_SKILL_G using the alias name SpecificSkillG.
     * @param value value to set the SPECIFIC_SKILL_G
     */
    public void setSpecificSkillG(String value) {
        setAttributeInternal(SPECIFICSKILLG, value);
    }

    /**
     * Gets the attribute value for STATUS using the alias name Status.
     * @return the STATUS
     */
    public Integer getStatus() {
        return (Integer) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for STATUS using the alias name Status.
     * @param value value to set the STATUS
     */
    public void setStatus(Integer value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for WEEKLY_HOURS using the alias name WeeklyHours.
     * @return the WEEKLY_HOURS
     */
    public Integer getWeeklyHours() {
        return (Integer) getAttributeInternal(WEEKLYHOURS);
    }

    /**
     * Sets <code>value</code> as attribute value for WEEKLY_HOURS using the alias name WeeklyHours.
     * @param value value to set the WEEKLY_HOURS
     */
    public void setWeeklyHours(Integer value) {
        setAttributeInternal(WEEKLYHOURS, value);
    }

    /**
     * Gets the attribute value for WORK_CATEGORY using the alias name WorkCategory.
     * @return the WORK_CATEGORY
     */
    public String getWorkCategory() {
        return (String) getAttributeInternal(WORKCATEGORY);
    }

    /**
     * Sets <code>value</code> as attribute value for WORK_CATEGORY using the alias name WorkCategory.
     * @param value value to set the WORK_CATEGORY
     */
    public void setWorkCategory(String value) {
        setAttributeInternal(WORKCATEGORY, value);
    }

    /**
     * Gets the attribute value for WORK_SUBCATEGORY using the alias name WorkSubcategory.
     * @return the WORK_SUBCATEGORY
     */
    public String getWorkSubcategory() {
        return (String) getAttributeInternal(WORKSUBCATEGORY);
    }

    /**
     * Sets <code>value</code> as attribute value for WORK_SUBCATEGORY using the alias name WorkSubcategory.
     * @param value value to set the WORK_SUBCATEGORY
     */
    public void setWorkSubcategory(String value) {
        setAttributeInternal(WORKSUBCATEGORY, value);
    }

    /**
     * Gets the attribute value for POST_JOB_DATE_START using the alias name PostJobDateStart.
     * @return the POST_JOB_DATE_START
     */
    public Date getPostJobDateStart() {
        return (Date) getAttributeInternal(POSTJOBDATESTART);
    }

    /**
     * Sets <code>value</code> as attribute value for POST_JOB_DATE_START using the alias name PostJobDateStart.
     * @param value value to set the POST_JOB_DATE_START
     */
    public void setPostJobDateStart(Date value) {
        setAttributeInternal(POSTJOBDATESTART, value);
    }

    /**
     * Gets the attribute value for POST_JOB_DATE_END using the alias name PostJobDateEnd.
     * @return the POST_JOB_DATE_END
     */
    public Date getPostJobDateEnd() {
        return (Date) getAttributeInternal(POSTJOBDATEEND);
    }

    /**
     * Sets <code>value</code> as attribute value for POST_JOB_DATE_END using the alias name PostJobDateEnd.
     * @param value value to set the POST_JOB_DATE_END
     */
    public void setPostJobDateEnd(Date value) {
        setAttributeInternal(POSTJOBDATEEND, value);
    }

    /**
     * Gets the attribute value for LOCATION_CITY using the alias name LocationCity.
     * @return the LOCATION_CITY
     */
    public String getLocationCity() {
        return (String) getAttributeInternal(LOCATIONCITY);
    }

    /**
     * Sets <code>value</code> as attribute value for LOCATION_CITY using the alias name LocationCity.
     * @param value value to set the LOCATION_CITY
     */
    public void setLocationCity(String value) {
        setAttributeInternal(LOCATIONCITY, value);
    }

    /**
     * Gets the attribute value for LOCATION_COUNTRY using the alias name LocationCountry.
     * @return the LOCATION_COUNTRY
     */
    public String getLocationCountry() {
        return (String) getAttributeInternal(LOCATIONCOUNTRY);
    }

    /**
     * Sets <code>value</code> as attribute value for LOCATION_COUNTRY using the alias name LocationCountry.
     * @param value value to set the LOCATION_COUNTRY
     */
    public void setLocationCountry(String value) {
        setAttributeInternal(LOCATIONCOUNTRY, value);
    }

    /**
     * Gets the attribute value for LOCATION_PROVINCE using the alias name LocationProvince.
     * @return the LOCATION_PROVINCE
     */
    public String getLocationProvince() {
        return (String) getAttributeInternal(LOCATIONPROVINCE);
    }

    /**
     * Sets <code>value</code> as attribute value for LOCATION_PROVINCE using the alias name LocationProvince.
     * @param value value to set the LOCATION_PROVINCE
     */
    public void setLocationProvince(String value) {
        setAttributeInternal(LOCATIONPROVINCE, value);
    }

    /**
     * Gets the attribute value for MODIFIED_BY using the alias name ModifiedBy.
     * @return the MODIFIED_BY
     */
    public String getModifiedBy() {
        return (String) getAttributeInternal(MODIFIEDBY);
    }

    /**
     * Gets the attribute value for MODIFIED_ON using the alias name ModifiedOn.
     * @return the MODIFIED_ON
     */
    public Timestamp getModifiedOn() {
        return (Timestamp) getAttributeInternal(MODIFIEDON);
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
     * Gets the attribute value for VERSION using the alias name Version.
     * @return the VERSION
     */
    public Number getVersion() {
        return (Number) getAttributeInternal(VERSION);
    }


    /**
     * Gets the attribute value for the calculated attribute CreateByName.
     * @return the CreateByName
     */
    public String getCreateByName() {
        return (String) getAttributeInternal(CREATEBYNAME);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link PostJobDiscuss.
     */
    public RowIterator getPostJobDiscuss() {
        return (RowIterator) getAttributeInternal(POSTJOBDISCUSS);
    }

    /**
     * Gets the view accessor <code>RowSet</code> ClientUserVO1.
     */
    public RowSet getClientUserVO1() {
        return (RowSet) getAttributeInternal(CLIENTUSERVO1);
    }
}

