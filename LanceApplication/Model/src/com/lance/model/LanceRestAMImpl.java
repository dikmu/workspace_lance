package com.lance.model;

import com.lance.model.vo.ClientUserVOImpl;
import com.lance.model.vo.CompanyVOImpl;
import com.lance.model.vo.LancerResumeVOImpl;
import com.lance.model.vo.LancerVOImpl;
import com.lance.model.vo.LoginUserVOImpl;

import com.lance.model.vo.SpreadHeardFromVOImpl;
import com.lance.model.vvo.LocationCountryVVOImpl;

import com.zngh.platform.front.core.model.BaseApplicationModuleImpl;

import com.zngh.platform.front.core.model.BaseViewObjectImpl;

import oracle.jbo.server.ViewLinkImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Sep 27 21:29:14 CST 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LanceRestAMImpl extends BaseApplicationModuleImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public LanceRestAMImpl() {
    }

    /**
     * Container's getter for Lancer1.
     * @return Lancer1
     */
    public LancerVOImpl getLancer1() {
        return (LancerVOImpl) findViewObject("Lancer1");
    }

    /**
     * Container's getter for ClientUser1.
     * @return ClientUser1
     */
    public ClientUserVOImpl getClientUser1() {
        return (ClientUserVOImpl) findViewObject("ClientUser1");
    }


    /**
     * Container's getter for LoginUser1.
     * @return LoginUser1
     */
    public LoginUserVOImpl getLoginUser1() {
        return (LoginUserVOImpl) findViewObject("LoginUser1");
    }

    /**
     * Container's getter for Company1.
     * @return Company1
     */
    public CompanyVOImpl getCompany1() {
        return (CompanyVOImpl) findViewObject("Company1");
    }

    /**
     * Container's getter for LocationCountryV2.
     * @return LocationCountryV2
     */
    public LocationCountryVVOImpl getLocationCountryV2() {
        return (LocationCountryVVOImpl) findViewObject("LocationCountryV2");
    }

    /**
     * Container's getter for SpreadHeardFrom1.
     * @return SpreadHeardFrom1
     */
    public SpreadHeardFromVOImpl getSpreadHeardFrom1() {
        return (SpreadHeardFromVOImpl) findViewObject("SpreadHeardFrom1");
    }

    /**
     * Container's getter for LancerResume1.
     * @return LancerResume1
     */
    public LancerResumeVOImpl getLancerResume1() {
        return (LancerResumeVOImpl) findViewObject("LancerResume1");
    }


    /**
     * Container's getter for LancerSkill1.
     * @return LancerSkill1
     */
    public BaseViewObjectImpl getLancerSkill1() {
        return (BaseViewObjectImpl) findViewObject("LancerSkill1");
    }

    /**
     * Container's getter for LancerResume_SkillVL1.
     * @return LancerResume_SkillVL1
     */
    public ViewLinkImpl getLancerResume_SkillVL1() {
        return (ViewLinkImpl) findViewLink("LancerResume_SkillVL1");
    }

    /**
     * Container's getter for LancerEducation1.
     * @return LancerEducation1
     */
    public BaseViewObjectImpl getLancerEducation1() {
        return (BaseViewObjectImpl) findViewObject("LancerEducation1");
    }

    /**
     * Container's getter for LancerResume_EducationVL1.
     * @return LancerResume_EducationVL1
     */
    public ViewLinkImpl getLancerResume_EducationVL1() {
        return (ViewLinkImpl) findViewLink("LancerResume_EducationVL1");
    }
}

