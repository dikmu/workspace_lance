package com.lance.view.rest.uuser;

import com.lance.model.LanceRestAMImpl;
import com.lance.model.user.vo.UUserVOImpl;
import com.lance.model.user.vo.UUserVORowImpl;
import com.lance.model.user.vo.UserEducationVOImpl;
import com.lance.model.user.vo.UserRoleGrantsVOImpl;
import com.lance.model.user.vo.UserRoleGrantsVORowImpl;
import com.lance.model.util.ConstantUtil;
import com.lance.model.vo.RegEmailChkVOImpl;
import com.lance.model.vo.RegEmailChkVORowImpl;
import com.lance.model.vo.RetrievePasswordVOImpl;
import com.lance.model.vo.RetrievePasswordVORowImpl;
import com.lance.view.rest.email.SendActivateMail;
import com.lance.view.util.LUtil;

import com.lance.view.util.RestSecurityUtil;

import com.zngh.platform.front.core.model.BaseViewObjectImpl;
import com.zngh.platform.front.core.model.util.UUIDGenerator;
import com.zngh.platform.front.core.view.BaseRestResource;

import java.io.UnsupportedEncodingException;

import java.text.SimpleDateFormat;

import javax.mail.MessagingException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import oracle.adf.share.ADFContext;

import oracle.jbo.AttributeDef;
import oracle.jbo.LocaleContext;
import oracle.jbo.Row;
import oracle.jbo.domain.ClobDomain;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.commons.lang.StringUtils;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


/**
    UserName,Precision:50,JavaType:java.lang.String
    TrueName,Precision:50,JavaType:java.lang.String
    DisplayName,Precision:50,JavaType:java.lang.String
    Email,Precision:100,JavaType:java.lang.String
    Password,Precision:100,JavaType:java.lang.String
    Img,Precision:900,JavaType:java.lang.String
    Country,Precision:32,JavaType:java.lang.String
    CompanyId,Precision:32,JavaType:java.lang.String
    PhoneNumber,Precision:20,JavaType:java.lang.String
    Attach,Precision:200,JavaType:java.lang.String
    JobTitle,Precision:20,JavaType:java.lang.String
    Video,Precision:200,JavaType:java.lang.String
    Description,Precision:0,JavaType:oracle.jbo.domain.ClobDomain
    WebsiteUrl,Precision:500,JavaType:java.lang.String
    ImNumberA,Precision:50,JavaType:java.lang.String
    ImTypeA,Precision:20,JavaType:java.lang.String
    ImNumberB,Precision:50,JavaType:java.lang.String
    ImTypeB,Precision:20,JavaType:java.lang.String
    ImNumberC,Precision:50,JavaType:java.lang.String
    ImTypeC,Precision:20,JavaType:java.lang.String
    LocationA,Precision:32,JavaType:java.lang.String 这里有变更
    LocationB,Precision:32,JavaType:java.lang.String 这里有变更
    Tagline,Precision:150,JavaType:java.lang.String
    HourlyRate,Precision:0,JavaType:java.math.BigDecimal Lancer提出的每小时价格，例如100
    ChargeRate,Precision:0,JavaType:java.math.BigDecimal 网站会向客户提出的价格，例如100.13
    Overview,Precision:3000,JavaType:java.lang.String  简历上的简短描述
    ServiceDescription,Precision:0,JavaType:oracle.jbo.domain.ClobDomain  服务描述 长度不能大于8000
    PaymentTerms,Precision:0,JavaType:oracle.jbo.domain.ClobDomain  支付方式描述 长度不能大于4000
    Keywords,Precision:1500,JavaType:java.lang.String
    AddressDisplay,Precision:10,JavaType:java.lang.String
    ContactInfo,Precision:10,JavaType:java.lang.String
    CreateBy,Precision:32,JavaType:java.lang.String
    CreateOn,Precision:0,JavaType:oracle.jbo.domain.Date
    ModifyBy,Precision:32,JavaType:java.lang.String
    ModifyOn,Precision:0,JavaType:oracle.jbo.domain.Date
    Version,Precision:0,JavaType:java.math.BigDecimal
    LastLoginTime,Precision:0,JavaType:oracle.jbo.domain.Date
    CompanyName,Precision:255,JavaType:java.lang.String
    CanBeSearch,Precision:0,JavaType:java.math.BigDecimal  是否可被搜索到（隐私）
    DefaultRole,Precision:20,JavaType:java.lang.String    默认角色（用于跳转到相应主页）  client,lancer,contract

    地址ID示例
     北京：1 0 1 1
     沈阳：1 0 6 39
     上海：1 0 9 75
 */
@Path("user")
public class UserResource extends BaseRestResource {
    /**
     * UserName 唯一用户名，登录名，ID
     * TrueName 真实姓名
     * DisplayName 显示名，类似网名
     * Email 邮箱，唯一
     * Password 今后在前端做加密 todo
     * Img 头像链接
     * AddressDisplay 地址显示级别
     *      all:Display all address fields
     *      city:Display only city, state, and zip
     *      no:No contact fields
     * ContactInfo 联系信息显示级别
     *      all:All contact fields
     *      noName:Only non-name fields (email, phone, fax, website)
     *      no:No contact fields
     *
     */
    public static final String[] ATTR_ALL = {
        "UserName", "TrueName", "DisplayName", "Email", "Password", "Img", "Country", "CompanyId", "PhoneNumber",
        "Attach", "JobTitle", "Video", "Description", "WebsiteUrl", "ImNumberA", "ImTypeA", "ImNumberB", "ImTypeB",
        "ImNumberC", "ImTypeC", "LocationARegion", "LocationACountry", "LocationAProvince", "LocationACity",
        "LocationADetail", "LocationBRegion", "LocationBCountry", "LocationBProvince", "LocationBCity",
        "LocationBDetail", "Tagline", "HourlyRate", "ChargeRate", "Overview", "ServiceDescription", "PaymentTerms",
        "Keywords", "AddressDisplay", "ContactInfo", "CreateBy", "CreateOn", "ModifyBy", "ModifyOn", "Version",
        "LastLoginTime", "CompanyName", "CanBeSearch", "DefaultRole","Referrer"
    };


    //todo 完善字段

    /**
     * DefaultRole:默认角色，可输入：client,lancer 
     */
    public static final String[] ATTR_CREATE = {
        "UserName", "TrueName", "DisplayName", "Email", "Password", "Img", "Country", "CompanyId", "PhoneNumber",
        "Attach", "JobTitle", "Video", "Description", "WebsiteUrl", "ImNumberA", "ImTypeA", "ImNumberB", "ImTypeB",
        "ImNumberC", "ImTypeC", "LocationARegion", "LocationACountry", "LocationAProvince", "LocationACity",
        "LocationADetail", "LocationBRegion", "LocationBCountry", "LocationBProvince", "LocationBCity",
        "LocationBDetail", "Tagline", "HourlyRate", "ChargeRate", "Overview", "ServiceDescription", "PaymentTerms",
        "Keywords", "AddressDisplay", "ContactInfo", "CompanyName", "CanBeSearch", "DefaultRole","Referrer"
    };

    public static final String[] ATTR_UPDATE = {
        "DisplayName", "Email", "Password", "Img", "Country", "CompanyId", "PhoneNumber", "Attach", "JobTitle", "Video",
        "Description", "WebsiteUrl", "ImNumberA", "ImTypeA", "ImNumberB", "ImTypeB", "ImNumberC", "ImTypeC",
        "LocationARegion", "LocationACountry", "LocationAProvince", "LocationACity", "LocationADetail",
        "LocationBRegion", "LocationBCountry", "LocationBProvince", "LocationBCity", "LocationBDetail", "Tagline",
        "HourlyRate", "ChargeRate", "Overview", "ServiceDescription", "PaymentTerms", "Keywords", "AddressDisplay",
        "ContactInfo", "LastLoginTime", "CompanyName", "CanBeSearch", "DefaultRole","Referrer"
    };

    public static final String[] ATTR_GET = {
        "UserName", "TrueName", "DisplayName", "Email", "Img", "Country", "CompanyId", "PhoneNumber", "Attach",
        "JobTitle", "Video", "Description", "WebsiteUrl", "ImNumberA", "ImTypeA", "ImNumberB", "ImTypeB", "ImNumberC",
        "ImTypeC", "LocationARegion", "LocationACountry", "LocationAProvince", "LocationACity", "LocationADetail",
        "LocationBRegion", "LocationBCountry", "LocationBProvince", "LocationBCity", "LocationBDetail",
        "LocationAIndex", "LocationBIndex", "Tagline", "HourlyRate", "ChargeRate", "Overview", "ServiceDescription",
        "PaymentTerms", "Keywords", "AddressDisplay", "ContactInfo", "CreateBy", "CreateOn", "ModifyBy", "ModifyOn",
        "Version", "LastLoginTime", "CompanyName", "CanBeSearch", "DefaultRole","Referrer"
    };

    public static final String[] ATTR_GET_A = {
        "UserName", "Email", "DisplayName", "Country", "TrueName", "CompanyId", "CompanyName", "LocationAIndex",
        "LocationBIndex", "PhoneNumber", "WebsiteUrl", "ImNumberA", "ImNumberB", "ImNumberC", "ImTypeA", "ImTypeB",
        "ImTypeC"
    };

    public UserResource() {
    }


    /**
     * 用户注册
     * todo 验证码 记录ip
     *
     *
     * @param json
     * @return
     * @throws JSONException
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createNewUser(JSONObject json) throws JSONException {
        String vcode = (String)this.request.getSession().getAttribute("verifyCode");
        if(!(json.has("vcode") && json.getString("vcode").equalsIgnoreCase(vcode))){
            return "err:vcode"; //返回新增记录的ID
        }
        
        System.out.println("createNewUser");
        System.out.println(json);
        LanceRestAMImpl am = LUtil.findLanceAM();
        UUserVOImpl vo = am.getUUser1();
        UUserVORowImpl row = (UUserVORowImpl) LUtil.createInsertRow(vo);

        for (String attr : ATTR_CREATE) {
            if ("CompanyName".equals(attr) && json.has("CompanyName")) {
                //如果存在CompanyName，则执行merge操作
                String companyId = new CompanyResource().mergeCompanyByName(json.getString("CompanyName"));
                row.setAttribute("CompanyId", companyId);
                continue;
            } else if ("LocationA,LocationB".indexOf(attr) != -1) {
                continue;
            } else if ("DefaultRole".equals(attr)) {
                continue;
            } else if (json.has(attr)) {
                row.setAttribute(attr, json.get(attr));
            }
        }

        //提取地址信息
        if (json.has("create(LocationA)")) {
            String loc_id =
                new UserLocationListResource().createLocationFn(json.getString("UserName"),
                                                                json.getJSONObject("create(LocationA)"), am);
            row.setAttribute("LocationA", loc_id);
        }
        if (json.has("create(LocationB)")) {
            String loc_id =
                new UserLocationListResource().createLocationFn(json.getString("UserName"),
                                                                json.getJSONObject("create(LocationB)"), am);
            row.setAttribute("LocationB", loc_id);
        }

        //授权角色
        if ("client,lancer,contract".indexOf(json.getString("DefaultRole")) != -1) {
            UserRoleGrantsVOImpl grantsVo = am.getUserRoleGrants1();
            UserRoleGrantsVORowImpl grantsRow = (UserRoleGrantsVORowImpl) grantsVo.createRow();
            grantsRow.setUserName(json.getString("UserName"));
            //DefaultRole只允许设置基础角色
            grantsRow.setRoleName(json.getString("DefaultRole"));
            grantsVo.insertRow(grantsRow);
            row.setAttribute("DefaultRole", json.getString("DefaultRole"));
        }

        //发送激活注册邮件
        RegEmailChkVOImpl regEmailChkVO = am.getRegEmailChk1();
        SendActivateMail sendActivateMail = new SendActivateMail();
        String uuid = UUIDGenerator.getUuid();
        String userName = json.getString("UserName");
        String email = json.getString("Email");
        RegEmailChkVORowImpl regEmailChkRow = (RegEmailChkVORowImpl) regEmailChkVO.createRow();
        regEmailChkRow.setUuid(uuid);
        regEmailChkRow.setUserName(userName);
        try {
            sendActivateMail.sendActivateEmail(email, uuid, userName);
        } catch (Exception e) {
        } 
        regEmailChkVO.insertRow(regEmailChkRow);
        row.updateSearchIndex();

        String cm = am.commit();
        if (!"ok".equals(cm)) {
            //将用户添加到分布式缓存
            new CacheResource().cacheSingleUser(row);
            
            return cm;
        }
        System.out.println("返回新增记录的ID " + json.getString("UserName"));
        sendMsg(userName);
        return json.getString("UserName"); //返回新增记录的ID
    }
    
    private void sendMsg(String uname) throws JSONException {
        UserNotificationResource unr = new UserNotificationResource();
        JSONObject json = new JSONObject();
        json.put("Title", "注册成功提醒");
        json.put("Content", "欢迎来到驻才网，驻才网是专门为中小型企业和自由职业者搭建的一款信息交流平台！");
        json.put("Type", "通知");
        json.put("UserName", uname);
        unr.sendUserNotification(json);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{userName}")
    public JSONObject findUserById(@PathParam("userName") String userName) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        return findUserByNameInJsonFn(userName, am);
    }


    public static JSONObject findUserByNameInJsonFn(String userName, LanceRestAMImpl am) throws JSONException {
        UUserVORowImpl row = LUtil.getUUserByName(userName, am);
        JSONObject data = new JSONObject();

        if (row == null) {
            JSONObject res = new JSONObject();
            res.put("err", "找不到用户:" + userName);
            return res;
        }

        JSONObject json = convertRowToJsonObject(am.getUUser1(), row, ATTR_GET);
        data.put("User", json);

        //处理位置信息
        if (json.has("LocationA") || json.has("LocationB")) {
            UserLocationListResource loc = new UserLocationListResource();
            if (json.has("LocationA")) {
                data.put("LocationA", loc.findLocation(userName, json.getString("LocationA")));
            }

            if (json.has("LocationB")) {
                data.put("LocationB", loc.findLocation(userName, json.getString("LocationB")));
            }
        }

        //获取当前用户Education
        data.put("Education", new UserEducationResource().findAllUserEducation(userName));
        //获取当前用户Skill
        data.put("Skill", new UserSkillResource().findAllUserSkills(userName));
        //        //获取当前用户LocationList
        //        data.put("LocationList", new UserLocationListResource().findAllLocation(userName));

        return data;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{userName}/simple")
    public JSONObject findSimpleUserByName(@PathParam("userName") String userName) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        return findSimpleUserByNameInJsonFn(userName, am);
    }

    public static JSONObject findSimpleUserByNameInJsonFn(String userName, LanceRestAMImpl am) throws JSONException {
        UUserVORowImpl row = LUtil.getUUserByName(userName, am);
        if (row == null) {
            JSONObject res = new JSONObject();
            res.put("err", "找不到用户:" + userName);
            return res;
        }
        return convertRowToJsonObject(am.getUUser1(), row, ATTR_GET_A);
    }

    //    public static UUserVORowImpl findUserByNameFn(String userName, LanceRestAMImpl am) {
    //        UUserVOImpl vo = am.getUUser1();
    //        vo.setApplyViewCriteriaName("FindByUserNameVC");
    //        vo.setpUserName(userName);
    //        vo.executeQuery();
    //        vo.setApplyViewCriteriaName(null);
    //        return (UUserVORowImpl) vo.first();
    //    }

    @POST
    @Path("delete/{userName}")
    public String deleteUser(@PathParam("userName") String userName) {
        LanceRestAMImpl am = LUtil.findLanceAM();
        UUserVOImpl vo = am.getUUser1();

        UUserVORowImpl row = LUtil.getUUserByName(userName, am);
        if (row == null) {
            return "error:找不到用户:" + userName;
        }
        vo.removeCurrentRow();

        am.getDBTransaction().commit();
        return "ok";
    }

    /**
     * 更新用户信息
     *
     * 关于公司
     * User更换公司：先调用CompanyResource的mergeByName接口获取公司ID，再将公司ID传入
     * 单纯修改公司信息（公司名、公司描述等）：调用CompanyResource的update/{companyId}接口
     *
     * 删除公司
     * {
     * CompanyId:""
     * }
     * 不处理公司，保持原状可以不传CompanyId
     *
     *
     * 关于地址
     * 创建用户时会默认生成两个地址ID，对应空地址（常驻地址）。
     * User修改常住地址时，先创建地址记录，然后设置常住地址ID
     *
     *
     * @param userName
     * @param json
     * @return
     * @throws JSONException
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update/{userName}")
    public String updateUser(@PathParam("userName") String userName, JSONObject json) throws JSONException {
        System.out.println("updateUser " + userName);
        System.out.println(json);
        LanceRestAMImpl am = LUtil.findLanceAM();
        ViewObjectImpl vo = am.getUUser1();
        UUserVORowImpl row = LUtil.getUUserByName(userName, am);
        if (row == null) {
            return "msg:找不到用户:" + userName;
        }

        if (!isOwner(row)) {
            return "msg:没有足够的权限修改此用户";
        }
        copyJsonObjectToRow(json, vo, row, ATTR_UPDATE);
        row.updateSearchIndex();
        am.getDBTransaction().commit();
        System.out.println("row changed");
        return "ok";
    }
    
    public boolean isOwner(Row row) {
        String curUser = ADFContext.getCurrent().getSecurityContext().getUserName();
        String creator = (String) row.getAttribute("UserName");
        if (creator.equals(curUser)) {
            return true;
        }
        return false;
    }

    /**
     * 检查用户UserName是否已存在
     *
     * GET http://localhost:7101/lance/res/user/check/userName/{userName}
     *
     * @param userName
     * @return true:用户已存在，不能继续。false：用户不存在，可以继续
     * @throws JSONException
     */
    @GET
    @Path("exist/userName/{userName}")
    @Produces(MediaType.TEXT_PLAIN)
    public String existUserName(@PathParam("userName") String userName) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        Row row = LUtil.getUUserByName(userName, am);

        if (row == null) {
            return "false";
        } else {
            System.out.println(row.getAttribute("UserName"));
            return "true";
        }
    }

    /**
     * 检查Email是否已存在
     *
     * GET http://localhost:7101/lance/res/user/exist/email/{email}
     *
     * @param userName
     * @return true:email已存在，不能继续。false：email不存在，可以继续
     * @throws JSONException
     */
    @GET
    @Path("exist/email/{email}")
    @Produces(MediaType.TEXT_PLAIN)
    public String existEmail(@PathParam("email") String email) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        UUserVOImpl vo = am.getUUser1();
        vo.setApplyViewCriteriaName("FindByEmailVC");
        vo.setpEmail(email);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("FindByEmailVC");
        if (vo.getRowCount() > 0) {
            return "true"; //用户已注册
        }
        return "false"; //用户不存在
    }
    
    @GET
    @Path("check/{vcode}")
    @Produces(MediaType.TEXT_PLAIN)
    public String checkVcode(@PathParam("vcode") String vcode) throws JSONException {
        String _vcode = (String)this.request.getSession().getAttribute("verifyCode");
        if(vcode.equalsIgnoreCase(_vcode)){
            return "true"; 
        } 
        return "false"; 
    }
     
    @GET
    @Path("errInp/count")
    @Produces(MediaType.TEXT_PLAIN)
    public String codeInpCount() {
        int c = 0;
        if (this.request.getSession().getAttribute(ConstantUtil.ERR_INP_COUNT) != null) {
            c = Integer.parseInt(this.request.getSession().getAttribute(ConstantUtil.ERR_INP_COUNT).toString());
        }
        if(c >= 3){
            return "inp:code";
        }
        return "";
    }
    
    @GET
    @Path("status")
    @Produces(MediaType.TEXT_PLAIN)
    public String checkUserStatus(){
        LanceRestAMImpl am = LUtil.findLanceAM();
        UUserVORowImpl row = LUtil.getUUserByName(this.findCurrentUserName(), am);
        return row.getStatus();
    }
    
    @GET
    @Path("exist/{uname}/{vcode}")
    @Produces(MediaType.TEXT_PLAIN)
    public String checkUserIsExist(@PathParam("uname") String uname,@PathParam("vcode") String vcode){
        String _vcode = (String)this.request.getSession().getAttribute("verifyCode");
        if(!vcode.equalsIgnoreCase(_vcode)){
            return "err:验证码错误"; 
        } 
        LanceRestAMImpl am = LUtil.findLanceAM();
        UUserVOImpl vo = am.getUUser1();
        vo.setApplyViewCriteriaName("findByEmailOrNameVC");
        vo.setpEmail(uname);
        vo.setpUserName(uname);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("findByEmailOrNameVC");
        if(vo.first() != null){
            UUserVORowImpl ur = (UUserVORowImpl)vo.first();
            String email = ur.getEmail();
            try {
                SendActivateMail sendActivateMail = new SendActivateMail();
                //创建查找密码记录
                String uuid = createRetrieveLog(am, ur.getUserName());
                StringBuffer sb = new StringBuffer("<b>尊敬的"+ur.getUserName()+"，您好:</b><br/>");
                sb.append("您在驻才网（www.zhucai.me）点击了“忘记密码”按钮，故系统自动为您发送了这封邮件。您可以点击以下链接修改您的密码:<br/>");
                sb.append("<a href="+ConstantUtil.ROOT_HTTP_URL+"/password/retrieve?uid="+uuid+">");
                sb.append(ConstantUtil.ROOT_HTTP_URL+"/password/retrieve?uid="+uuid);
                sb.append("</a><br/>");
                sb.append("此链接有效期为两个小时，请在两小时内点击链接进行修改。如果您不需要修改密码，或者您从未点击过“忘记密码”按钮，请忽略本邮件。");
                sendActivateMail.sendEmail(email, "忘记密码提示(www.zhucai.me)", sb.toString());
                am.commit();
            } catch (UnsupportedEncodingException uee) {
                // TODO: Add catch code
                uee.printStackTrace();
            } catch (MessagingException me) {
                // TODO: Add catch code
                me.printStackTrace();
            }
            return (email.substring(0,1)+"*****"+email.substring(email.indexOf("@")-1,email.indexOf("@"))+email.substring(email.indexOf("@"),email.length()));
        }
        return "err:账户名不存在，请检查你的账户名!";
    }
    
    private String createRetrieveLog(LanceRestAMImpl am,String uname){
        RetrievePasswordVOImpl vo = am.getRetrievePassword1();
        RetrievePasswordVORowImpl row = (RetrievePasswordVORowImpl)vo.createRow();
        row.setAttribute("UserName",uname);
        vo.insertRow(row);
       return row.getUuid();
    }
    
    public RetrievePasswordVORowImpl checkRetriveLog(String uuid){
        LanceRestAMImpl am = LUtil.findLanceAM();
        RetrievePasswordVOImpl vo = am.getRetrievePassword1();
        vo.setApplyViewCriteriaName("findRetrievePasswordVC");
        vo.setpuid(uuid);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("findRetrievePasswordVC");
        if(vo.first() != null){
            return (RetrievePasswordVORowImpl)vo.first();
        }
       return null;
    }
    
    @POST
    @Path("reset/password")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String resetPassWord(JSONObject json) throws JSONException {
        String u_key = (String)this.request.getSession().getAttribute("u-key");
        if(!json.has("u-key") || !json.getString("u-key").equalsIgnoreCase(u_key)){
            return "err:无法正常修改密码!";
        }
        LanceRestAMImpl am = LUtil.findLanceAM();
        UUserVORowImpl row = LUtil.getUUserByName(json.getString("uname"), am);
        row.setPassword(json.getString("password"));
        if("ok".equals(am.commit())){
            return "ok";
        }
        return "err:修改密码失败";
    }
    
    @POST
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(@QueryParam("st")String st,String str,String str2) throws JSONException {
       return "success:st:"+st+"--str--:"+str+"--str2--:"+str2;
    }
}
