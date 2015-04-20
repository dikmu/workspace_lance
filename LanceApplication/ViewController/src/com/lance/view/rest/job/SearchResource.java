package com.lance.view.rest.job;

import com.lance.model.LanceRestAMImpl;
import com.lance.model.user.vo.UUserVOImpl;
import com.lance.model.user.vo.UUserVORowImpl;
import com.lance.model.vo.JobCategoryVOImpl;
import com.lance.model.vo.JobCategoryVORowImpl;
import com.lance.model.vo.JobSubCategoryVOImpl;
import com.lance.model.vo.PostJobsVOImpl;
import com.lance.model.vo.PostJobsVORowImpl;
import com.lance.model.vo.SkillsVOImpl;
import com.lance.view.rest.location.CountryResource;
import com.lance.view.util.LUtil;

import com.zngh.platform.front.core.view.BaseRestResource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import oracle.jbo.RowSetIterator;

import org.apache.commons.lang.StringUtils;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * URL分批查询规则
 * 例如
 * GET http://localhost:7101/lance/res/search/postJob/latest?limit=5&start=1
 * start:1和start=0时都从第一条开始返回
 * limit=5&start=1 不传此参数时，默认返回1~25条
 *
 * http://localhost:7101/lance/res/search/postJob/latest 返回最近25条
 * http://localhost:7101/lance/res/search/postJob/latest?limit=5&start=10 从第10条开始，返回5条
 *
 * 为空时返回
 * {
      "count" : 0,
      "data" : [
      ]
   }
 *
 */
@Path("search")
public class SearchResource extends BaseRestResource {
    public static int DEFAULT_LIMIT = 25;


    public static final String[] POST_JOB_VO_ATTR_ALL = {
        "Uuid", "AllowSearchEngines", "Attach", "Brief", "DurationMax", "DurationMin", "FixedLocation", "FixedPayMax",
        "FixedPayMin", "HourlyPayMax", "HourlyPayMin", "JobVisibility", "LocationDesc", "Name", "Postform",
        "SpecificSkillA", "SpecificSkillB", "SpecificSkillC", "SpecificSkillD", "SpecificSkillE", "SpecificSkillF",
        "SpecificSkillG", "Status", "StatusDesc", "WeeklyHours", "WorkCategory", "WorkSubcategory", "PostJobDateStart",
        "PostJobDateEnd", "LocationRegion", "LocationCountry", "LocationProvince", "LocationCity", "IndexSkills",
        "IndexLocation", "IndexWorkCategorys", "SignBy", "CreateBy", "CreateOn", "ModifyBy", "ModifyOn", "Version",
        "CreateByName", "BriefShort"
    };

    /**
     * 字段同PostJobs
     */
    public static final String[] POST_JOB_SEARCH_FIELD = {
        "Uuid", "BriefShort", "DurationMax", "DurationMin", "FixedLocation", "FixedPayMax", "FixedPayMin",
        "HourlyPayMax", "HourlyPayMin", "LocationDesc", "Name", "Postform", "SpecificSkillA", "SpecificSkillB",
        "SpecificSkillC", "SpecificSkillD", "SpecificSkillE", "SpecificSkillF", "SpecificSkillG", "WeeklyHours",
        "WorkCategory", "WorkSubcategory", "PostJobDateStart", "PostJobDateEnd", "IndexSkills", "IndexLocation",
        "IndexWorkCategorys", "SignBy", "CreateBy", "CreateOn", "ModifyBy", "ModifyOn", "Version", "CreateByName"
    };

    public static final String[] ATTR_SEARCH_LANCER = {"UserName", "TrueName", "DisplayName", "Email", "Img", "Country", "CompanyId", "PhoneNumber", "Attach", "JobTitle", "Video", "Description", "WebsiteUrl", "ImNumberA", "ImTypeA", "ImNumberB", "ImTypeB", "ImNumberC", "ImTypeC", "LocationA", "LocationARegion", "LocationAProvince", "LocationACity", "LocationACountry", "LocationADetail", "LocationAIndex", "LocationB", "LocationBRegion", "LocationBProvince", "LocationBCountry", "LocationBCity", "LocationBDetail", "HourlyRate", "ChargeRate", "Overview", "ServiceDescription", "PaymentTerms", "Keywords", "AddressDisplay", "ContactInfo", "IdentityType", "IdentityNo", "Rank", "RankDesc", "CompanyName"};

    public static final String[] ATTR_SEARCH_LANCER_NAME = { "UserName", "DisplayName" };

    public SearchResource() {
    }

    /**
     * 搜索近期发布的招聘信息
     * GET http://localhost:7101/lance/res/search/postJob/latest?limit=5&start=1
     * @param
     * start:1和start=0时都从第一条开始返回
     * limit=5&start=1 不传此参数时，默认返回1~25条
     *
     * http://localhost:7101/lance/res/search/postJob/latest 返回最近25条
     * http://localhost:7101/lance/res/search/postJob/latest?limit=5&start=10 从第10条开始，返回5条
     *
     * 返回结果为空时返回
     *
     * {
            "count" : 0,
            "data" : [
            ]
        }


     * {
    "count" : 5,
    "data" : [
        {
            "Uuid" : "test9",
            "Brief" : "工作说明9",
            "Durationlx" : 9,
            "DurationMin" : 100,
            "FixedLocation" : 1,
            "FixedPayMax" : 200,
            "FixedPayMin" : 100,
            "HourlyPayMax" : 200,
            "HourlyPayMin" : 100,
            "Name" : "工作测试9",
            "Postform" : 1,
            "SpecificSkillA" : "DHTML",
            "SpecificSkillB" : "DOS",
            "SpecificSkillC" : "XML",
            "SpecificSkillD" : "JAVA",
            "SpecificSkillE" : "BPM",
            "Status" : 1,
            "WeeklyHours" : 100,
            "WorkCategory" : "10183",
            "WorkSubcategory" : "14174"
        },
        {
            "Uuid" : "test10",
            "Brief" : "工作说明10",
            "DurationMax" : 9,
            "DurationMin" : 100,
            "FixedLocation" : 1,
            "FixedPayMax" : 200,
            "FixedPayMin" : 100,
            "HourlyPayMax" : 200,
            "HourlyPayMin" : 100,
            "Name" : "工作测试10",
            "Postform" : 1,
            "SpecificSkillA" : "DHTML",
            "SpecificSkillB" : "DOS",
            "SpecificSkillC" : "XML",
            "SpecificSkillD" : "JAVA",
            "SpecificSkillE" : "BPM",
            "Status" : 1,
            "WeeklyHours" : 100,
            "WorkCategory" : "10183",
            "WorkSubcategory" : "14174"
        }
    ......
     ]
     *
     * @return
     */
    //    @GET
    //    @Path("postJob/latest")
    //    public JSONObject getLatestPosted() throws JSONException {
    //        LanceRestAMImpl am = LUtil.findLanceAM();
    //        PostJobsVVOImpl vvo = am.getPostJobsV1();
    //        vvo.setApplyViewCriteriaName("FindPostedVC");
    //        vvo.executeQuery();
    //        vvo.removeApplyViewCriteriaName("FindPostedVC");
    //        JSONObject data = this.packViewObject(vvo, null, null, POST_JOB_SEARCH_FIELD);
    //        return data;
    //    }

    @GET
    @Path("postJob/latest")
    public JSONObject searchLatestPosted() throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        PostJobsVOImpl vo = am.getPostJobs1();
        vo.setApplyViewCriteriaName("FindPostedVC");
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("FindPostedVC");
        JSONObject data = this.packViewObject(vo, null, null, POST_JOB_SEARCH_FIELD);
        return data;
    }
    
    private void nextPage(int curPage){
        if(curPage == 1){
            this.start =0;
        }else {
            this.start = ((curPage-1) * this.limit)+1;    
        }
    }

    /**
     * 重新建立索引字段
     * @return
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("postJob/reIndex")
    public String reIndexPostJob() {
        LanceRestAMImpl am = LUtil.findLanceAM();
        PostJobsVOImpl vo = am.getPostJobs1();
        vo.executeQuery();
        PostJobsVORowImpl row;
        RowSetIterator it = vo.createRowSetIterator(null);
        while (it.hasNext()) {
            row = (PostJobsVORowImpl) it.next();
            row.updateSearchIndex();
        }
        it.closeRowSetIterator();
        am.getDBTransaction().commit();
        return "ok";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("user/reIndex")
    public String reIndexUser() {
        LanceRestAMImpl am = LUtil.findLanceAM();
        UUserVOImpl vo = am.getUUser1();
        vo.executeQuery();
        UUserVORowImpl row;
        RowSetIterator it = vo.createRowSetIterator(null);
        while (it.hasNext()) {
            row = (UUserVORowImpl) it.next();
            row.updateSearchIndex();
        }
        it.closeRowSetIterator();
        am.getDBTransaction().commit();
        return "ok";
    }


    /**
     * 根据关键词查询  
     * 关键词：工作名，简介，技能，地点，分类
     * 只搜索：STATUS = 'posted' AND JOB_VISIBILITY = 'public'
     *
     * http://localhost:7101/lance/res/search/postJob/keyword/{keyword}?city=beijing
     *
     * http://localhost:7101/lance/res/search/postJob/keyword/说明
     * http://localhost:7101/lance/res/search/postJob/keyword/XML
     *
     * @param keyword
     * @return
     * @throws JSONException
     */
    @GET
    @Path("jobs")
    public JSONObject searchJobs(@MatrixParam("keyword") String keyword,@MatrixParam("category") String category,@MatrixParam("subcategory") String subcategory
                                 ,@MatrixParam("postform") String postform,@MatrixParam("country") String country,@MatrixParam("skill") String skill,
                                 @MatrixParam("budget")String budget,@MatrixParam("hourlyPay")String hourlyPay,@MatrixParam("postedDate")String postedDate,@MatrixParam("timeLeft")String timeLeft
                                 ,@MatrixParam("pageNum") String pageNum) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        PostJobsVOImpl vo = am.getPostJobs1();
         StringBuffer sb = new StringBuffer(" STATUS = 'posted' AND JOB_VISIBILITY = 'public' ");
         if(keyword != null){
            String[] sps = splitKeyword(keyword); //根据空格分隔
            for (String sp : sps) {
                sb.append(" AND INSTR(upper(INDEX_ALL_META_INFO),'"+sp.toUpperCase()+"') > 0 ");
            }
         }
         if(category != null){
            //工作分类大类查询
            sb.append(" AND INSTR(upper(INDEX_WORK_CATEGORYS),'"+category.toUpperCase()+"') > 0 ");
         }
        if(subcategory != null){
            //工作分类小类查询
            String[] scts = subcategory.split(",");
            for (String sct : scts) {
                sb.append(" AND INSTR(upper(INDEX_WORK_CATEGORYS),'"+sct.toUpperCase()+"') > 0 ");
            }
        }
        if(postform != null){
           //工作类型查询 hourly时薪/fixed固定价格
           sb.append(" AND POSTFORM = '"+postform+"' ");
         }
        if(country != null){
           String[] locs = country.split(">");
           for (String loc : locs) {
               sb.append(" AND INSTR(upper(INDEX_LOCATION),'"+loc.toUpperCase()+"') > 0 ");
           }
        }
       if(skill != null){
           //技能
           String[] skills = skill.split(",");
           for (String s : skills) {
               sb.append(" AND INSTR(upper(INDEX_SKILLS),'"+s.toUpperCase()+"') > 0 ");
           }
        }
        if(budget != null){
            //固定价格预算
           String[] bgs = budget.split(",");
           if(bgs.length == 1){
               sb.append(" AND FIXED_PAY_MIN >= "+bgs[0]);
           }else if(bgs.length == 2){
               sb.append(" AND FIXED_PAY_MIN >= "+bgs[0]+" and FIXED_PAY_MAX <= "+bgs[1]);
           }
        }
        if(hourlyPay != null){
            //小时工资
            String[] hps = hourlyPay.split(",");
            if(hps.length == 1){
               sb.append(" AND HOURLY_PAY_MIN >= "+hps[0]);
            }else if(hps.length == 2){
               sb.append(" AND HOURLY_PAY_MIN >= "+hps[0]+" and HOURLY_PAY_MAX <= "+hps[1]);
            }
        }
        if(postedDate != null){
            sb.append(" AND CREATE_ON >= (TRUNC(SYSDATE) - "+postedDate+")");
        }
        if(timeLeft != null){
            sb.append(" AND POST_JOB_DATE_END <= (TRUNC(SYSDATE) - "+timeLeft+")");
        }
        vo.setWhereClause(null);
        vo.setWhereClause(sb.toString());
        vo.executeQuery();        //estimated
        if(pageNum != null){
            this.estimated="Y";
            this.nextPage(Integer.parseInt(pageNum));
        }
        return this.packViewObject(vo, null, null, POST_JOB_SEARCH_FIELD);
    }


    /**
     * 寻找Lancer
     * 模糊查询，开头匹配UserName（输入2个字符后开始查询）
     *
     * 返回UserName，（返回UserName同Uuid）
     * @param keyword
     * @return
     * @throws JSONException
     */
    @GET
    @Path("lancer/nameStartWith/{keyword}")
    public JSONObject searchLancer4Name(@PathParam("keyword") String keyword) throws JSONException {
        if (keyword.length() < 2) {
            JSONObject res = new JSONObject();
            res.put("msg", "输入2个字符后开始查询");
            return res;
        }
        LanceRestAMImpl am = LUtil.findLanceAM();
        UUserVOImpl vo = am.getUUser1();
        vo.setApplyViewCriteriaName("FindByNameVC");
        vo.setpUserName(keyword);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("FindByNameVC");
        return this.packViewObject(vo, null, null, ATTR_SEARCH_LANCER_NAME);
    }


    /**
     * 2015年1月13日更新
     * 待实现
     *
     * 根据Overview，Tagline，Keyword,skill查询UUser
     * 适用于Client根据技术查找UUser
     *
     * 模糊查询（关键字查询）
     * GET http://localhost:7101/lance/res/search/userByKeyword/{userType}/{keyword}?category={category}
     * start:1和start=0时都从第一条开始返回
     * limit=5&start=1 不传此参数时，默认返回1~25条
     *
     * userType:lancer/contract/client列出对应类型的人员,如果为空则列出所有类型人员
     * keyword：关键词，支持空格逗号分隔
     *
     * 其它查询条件（用问号表达式方式）
     * category:工作大类，例10183 （IT & Programming）
     * country：国家ID
     * province:省ID
     * city:城市ID
     * skill:技能，多个用空格分隔
     * HourlyRateMin：最小时薪
     * HourlyRateMax：最大时薪
     *
     * 优先级：svip>vip>普通
     * keyword>Tagline>skill>Overview
     * 识别地理位置
     *
     * 示例URL  GET http://localhost:7101/lance/res/search/userByKeyword/lancer/Test%20overview?city=1&category=10183&skill=xml%20html
     * %20是空格
     *
     * 例子：
     * 查询 Test overview
     * GET http://localhost:7101/lance/res/search/userByKeyword/lancer/Test%20overview
     *
     * 返回前25条
     {
         "count" : 4,
         "data" : [
             {
                 "Uuid" : "c0d5b7a060b6448fa8bb68a3c1b3ee28",
                 "ChargeRate" : 102.13,
                 "HourlyRate" : 101,
                 "Overview" : "这是overview",
                 "Tagline" : "这是tagLine",
                 "UserAccountType" : 1,
                 "UserCountry" : "44",
                 "UserDisplayName" : "天涯月",
                 "UserLocationA" : {
                 },
                 "UserLocationB" : {
                     "CountryId" : "44",
                     "ProvinceId" : "1",
                     "CityId" : "1",
                     "CountryName" : "中国",
                     "ProvinceName" : "北京市",
                     "CityName" : "北京市"
                 }
             },
             {
                 "Uuid" : "531ca069aa0e41aea7c114cf11cb7be6",
                 "ChargeRate" : 102.13,
                 "HourlyRate" : 101,
                 "Overview" : "这是overview",
                 "Tagline" : "这是tagLine",
                 "UserAccountType" : 1,
                 "UserCountry" : "44",
                 "UserDisplayName" : "天涯月",
                 "UserLocationA" : {
                 },
                 "UserLocationB" : {
                     "CountryId" : "44",
                     "ProvinceId" : "1",
                     "CityId" : "1",
                     "CountryName" : "中国",
                     "ProvinceName" : "北京市",
                     "CityName" : "北京市"
                 }
             },
             {
                 "Uuid" : "ce5e37bdc4fe4608a971d0b58637b6cf",
                 "ChargeRate" : 102.13,
                 "HourlyRate" : 101,
                 "Overview" : "这是overview",
                 "Tagline" : "这是tagLine",
                 "UserAccountType" : 1,
                 "UserCountry" : "44",
                 "UserDisplayName" : "天涯月",
                 "UserLocationA" : {
                 },
                 "UserLocationB" : {
                     "CountryId" : "44",
                     "ProvinceId" : "1",
                     "CityId" : "1",
                     "CountryName" : "中国",
                     "ProvinceName" : "北京市",
                     "CityName" : "北京市"
                 }
             },
             {
                 "Uuid" : "e735964d8dc84cc087e8b607b92b4594",
                 "ChargeRate" : 102.13,
                 "HourlyRate" : 101,
                 "Overview" : "这是overview",
                 "Tagline" : "这是tagLine",
                 "UserAccountType" : 1,
                 "UserCountry" : "44",
                 "UserDisplayName" : "天涯月",
                 "UserLocationA" : {
                 },
                 "UserLocationB" : {
                     "CountryId" : "44",
                     "ProvinceId" : "1",
                     "CityId" : "1",
                     "CountryName" : "中国",
                     "ProvinceName" : "北京市",
                     "CityName" : "北京市"
                 }
             }
         ]
     }
     *
     * @param keyword
     * @return
     * @throws JSONException
     */
    @GET
    @Path("contractors")
    public JSONObject searchLancer4Job(@MatrixParam("keyword") String keyword,@MatrixParam("userType") String userType,@MatrixParam("country") String country,@MatrixParam("skill") String skill
                                       ,@MatrixParam("budget")String budget,@MatrixParam("hourlyPay")String hourlyPay,@MatrixParam("pageNum") String pageNum) throws JSONException {
//        if (StringUtils.isNotBlank(userType) && "lancer,company,client".indexOf(userType) != -1) {
//        } else {
//            throw new RuntimeException("User Type is undefined");
//        }
        LanceRestAMImpl am = LUtil.findLanceAM();
        UUserVOImpl vo = am.getUUser1();

        //查询算法
        StringBuilder sb = new StringBuilder();
        sb.append("STATUS = 'active'");
        if(keyword != null){
            String[] sps = this.splitKeyword(keyword); //根据空格分隔
            for (String sp : sps) {
                sb.append(" AND INSTR(upper(INDEX_ALL),'"+sp.toUpperCase()+"') > 0");
            }
        }
        if (StringUtils.isNotBlank(userType)) {
            sb.append(" AND upper(DEFAULT_ROLE) = '" + userType.toUpperCase() + "' ");
        }
       if(country != null){
           String[] locs = country.split(">");
           for (String loc : locs) {
               sb.append(" AND (INSTR(upper(LOCATION_A_INDEX),'"+loc.toUpperCase()+"') > 0 OR INSTR(upper(LOCATION_B_INDEX),'"+loc.toUpperCase()+"') > 0) ");
           }
       }
       if(skill != null){
            //技能
            String[] skills = skill.split(",");
            for (String s : skills) {
                sb.append(" AND INSTR(upper(INDEX_SKILL),'"+s.toUpperCase()+"') > 0 ");
            }
        }
       if(budget != null){
            //固定价格预算
           String[] bgs = budget.split(",");
           if(bgs.length == 1){
               sb.append(" AND CHARGE_RATE >= "+bgs[0]);
           }else if(bgs.length == 2){
               sb.append(" AND CHARGE_RATE >= "+bgs[0]+" and CHARGE_RATE <= "+bgs[1]);
           }
        }
       if(hourlyPay != null){
            //小时工资
            String[] hps = hourlyPay.split(",");
            if(hps.length == 1){
               sb.append(" AND HOURLY_RATE >= "+hps[0]);
            }else if(hps.length == 2){
               sb.append(" AND HOURLY_RATE >= "+hps[0]+" and HOURLY_RATE <= "+hps[1]);
            }
        }
        vo.setWhereClause(null);
        vo.setWhereClause(sb.toString());
        vo.executeQuery();
        if(pageNum != null){
            this.estimated="Y";
            this.nextPage(Integer.parseInt(pageNum));
        }
        return this.packViewObject(vo, null, null, ATTR_SEARCH_LANCER);
    }
    
    /**
     *获取工作分类大类
     * @return
     * @throws JSONException
     */
    @GET
    @Path("/JobCat")
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONArray getJobCategory() throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        JobCategoryVOImpl vo1 = am.getJobCategory1();
        String[] attrs = {"Uuid","NameEn","NameCn"};
       return this.convertVoToJsonArray(vo1, attrs);
    }
    
    /**
     *根据工作分类(大类)，查找工作分类(小类)
     * @param pid
     * @return
     * @throws JSONException
     */
    @GET
    @Path("{catid}/JobScat")
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONArray getJobSubCategory(@PathParam("catid")String catid) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        JobSubCategoryVOImpl vo = am.getJobSubCategory2();
        vo.setApplyViewCriteriaName("findByCatId");
        vo.setcid(catid);
        vo.setOrderByClause("NAME,NAME_CN");
        String[] attrs = {"Uuid","Name","NameCn"};
       return this.convertVoToJsonArray(vo, attrs);
    }
    
    @GET
    @Path("skills")
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONArray getSkills() throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        SkillsVOImpl vo = am.getSkills1();
        vo.setWhereClause(null);
        vo.setOrderByClause("Name");
        vo.executeQuery();
        String[] attrs = {"Uuid","Name","NameCn"};
       return this.convertVoToJsonArray(vo, attrs);
    } 
    
    @GET
    @Path("left/datas")
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONObject getleftDatas() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("cateory", getJobCategory());
        json.put("skills", getSkills());
        json.put("country", new CountryResource().getAllCountry());
       return json;
    }

    /**
     * 将各种分隔符格式化为标准空格分隔的关键词,并进行split操作
     * @param keyword
     * @return
     */
    public String[] splitKeyword(String keyword) {
        keyword = keyword.trim().replaceAll(",", " ").replaceAll("，", " ").replaceAll("\\+", " ");
        return keyword.split(" ");
    }

    public static void main(String[] args) {
        String a = "aa,bb，cc+dd";
        a = a.trim().replaceAll(",", " ").replaceAll("，", " ").replaceAll("\\+", " ");
        System.out.println(a);
    }

}
