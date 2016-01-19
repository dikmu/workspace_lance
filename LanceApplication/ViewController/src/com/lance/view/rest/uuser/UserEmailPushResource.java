package com.lance.view.rest.uuser;

import com.lance.model.LanceRestAMImpl;
import com.lance.model.user.vo.UUserVORowImpl;
import com.lance.model.vo.UserEmailPushVOImpl;
import com.lance.model.vo.UserEmailPushVORowImpl;
import com.lance.view.util.LUtil;
import com.lance.view.util.RestSecurityUtil;

import com.zngh.platform.front.core.view.BaseRestResource;
import com.zngh.platform.front.core.view.RestUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import oracle.adf.share.logging.ADFLogger;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * 资源代码邮件订阅
 *
 * 文本替换示例
 * emailPush ：Company
 * emailPushId ： companyId
 * 邮件订阅 ： 公司
 *
 *
 *
 */
@Path("userEmailPush")
public class UserEmailPushResource extends BaseRestResource {

    /**
        Uuid,Precision:32,JavaType:java.lang.String
        UserName,Precision:60,JavaType:java.lang.String
        UserRole,Precision:20,JavaType:java.lang.String
        SubscribeWord,Precision:20,JavaType:java.lang.String
        SubscribeType,Precision:6,JavaType:java.lang.String
        SubscribeUpdate,Precision:20,JavaType:java.lang.String
        Frequency,Precision:20,JavaType:java.lang.String
        CreateBy,Precision:60,JavaType:java.lang.String
        CreateOn,Precision:0,JavaType:java.sql.Timestamp
        ModifyBy,Precision:60,JavaType:java.lang.String
        ModifyOn,Precision:0,JavaType:java.sql.Timestamp
        Version,Precision:0,JavaType:java.math.BigDecimal
     */

    public UserEmailPushResource() {
    }

    //------------------------------implements below--------------------------

    public final ADFLogger LOGGER = ADFLogger.createADFLogger(UserEmailPushResource.class);

    public static final String[] ATTR_ALL = {
        "Uuid", "UserName", "UserRole", "SubscribeWord", "SubscribeUpdate", "Frequency", "CreateBy", "CreateOn",
        "ModifyBy", "ModifyOn", "Version"
    };


    public static final String[] ATTR_GET = ATTR_ALL;

    public static final String[] ATTR_UPDATE = { "SubscribeWord", "SubscribeUpdate", "Frequency" };

    public static final String[] ATTR_CREATE = { };

    public static final boolean CAN_DELETE = true;


    public ViewObjectImpl getEmailPushFromAM(LanceRestAMImpl am) {
        return am.getUserEmailPush1();
    }

    public Row findEmailPushByUserName(String id, ViewObjectImpl vo, LanceRestAMImpl am) {
        if (am.getUUser1().getCurrentRow() != null &&
            id.equals(am.getUUser1().getCurrentRow().getAttribute("UserName"))) {
        } else {
            LUtil.getUUserByName(id, am);
        }
        return (Row) am.getUserEmailPush1().first();
    }

    public String returnParamAfterCreate(Row row) {
        return (String) row.getAttribute("Uuid");
    }

    /**
     * merge 邮件订阅
     * @param emailPushId
     * @param json
     * @return
     * @throws JSONException
     */
    @POST
    @Path("merge/{userName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String mergeEmailPushById(@PathParam("userName") String userName, JSONObject json) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        ViewObjectImpl vo = getEmailPushFromAM(am);
        UserEmailPushVORowImpl row = (UserEmailPushVORowImpl) findEmailPushByUserName(userName, vo, am);
        if (row == null) {
            LOGGER.log(LOGGER.TRACE, "UserEmailPush row not exists,start create new row");
            row = (UserEmailPushVORowImpl) LUtil.createInsertRow(vo);
            RestUtil.copyJsonObjectToRow(json, vo, row, this.ATTR_CREATE);
            //
            UUserVORowImpl user = LUtil.getUUserByName(userName, am);
            String defaultRole = user.getDefaultRole();
            row.setAttribute("UserRole", defaultRole);
            row.setAttribute("UserName", userName);
            //            if("lancer".equals(defaultRole)){
            //                //强制Lancer订阅新Job信息
            //                row.setSubscribeType("Job");
            //            }else if("client".equals(defaultRole)){
            //                //强制Client订阅Lancer技能信息
            //                row.setSubscribeType("Lancer");
            //            }
            //
            LOGGER.log(LOGGER.TRACE, "copyJsonObjectToRow :" + this.ATTR_CREATE);
        } else {
            RestUtil.copyJsonObjectToRow(json, vo, row, this.ATTR_UPDATE);
            LOGGER.log(LOGGER.NOTIFICATION,
                       findCurrentUserName() + "修改UserEmailPush(userName:" + userName + ") 为：" +
                       RestUtil.convertRowToJsonObject(vo, row, this.ATTR_ALL));
        }
        am.getDBTransaction().commit();
        return "ok";
    }


    //------------------------------以下是标准代码--------------------------

    /**
     * 根据ID查询邮件订阅
     * @param emailPushId
     * @return
     * @throws JSONException
     */
    @GET
    @Path("{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getEmailPushById(@PathParam("userName") String userName) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        ViewObjectImpl vo = getEmailPushFromAM(am);
        Row row = findEmailPushByUserName(userName, vo, am);
        if (row == null) {
            String msg = "对应的记录不存在或已被删除";
            JSONObject res = new JSONObject();
            res.put("msg", msg);
            return res;
        }
        return RestUtil.convertRowToJsonObject(vo, row, this.ATTR_GET);
    }


    //    /**
    //     * 更新
    //     * @param emailPushId
    //     * @param json
    //     * @return
    //     * @throws JSONException
    //     */
    //    @POST
    //    @Path("update/{emailPushId}")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    public String updateEmailPush(@PathParam("emailPushId") String emailPushId, JSONObject json) throws JSONException {
    //        LanceRestAMImpl am = LUtil.findLanceAM();
    //        ViewObjectImpl vo = getEmailPushFromAM(am);
    //        Row row = findEmailPushByUserName(emailPushId, vo, am);
    //
    //        if (row == null) {
    //            LOGGER.log(LOGGER.NOTIFICATION, findCurrentUserName() + "尝试修改邮件订阅" + emailPushId + "但此记录不存在");
    //            return "msg:can't find emailPush by id " + emailPushId;
    //        }
    //        if (!RestSecurityUtil.isOwner(row)) {
    //            String msg = "您没有修改此记录的权限";
    //            return "msg:" + msg;
    //        }
    //
    //        RestUtil.copyJsonObjectToRow(json, vo, row, this.ATTR_UPDATE);
    //        am.getDBTransaction().commit();
    //
    //        LOGGER.log(LOGGER.NOTIFICATION,
    //                   findCurrentUserName() + "修改邮件订阅(" + emailPushId + ") 为：" +
    //                   RestUtil.convertRowToJsonObject(vo, row, this.ATTR_ALL));
    //        return "ok";
    //    }
    //
    //    /**
    //     * 创建
    //     * @param json
    //     * @return
    //     * @throws JSONException
    //     */
    //    @POST
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    public String createEmailPush(JSONObject json) throws JSONException {
    //        LOGGER.log(LOGGER.NOTIFICATION, "create emailPush");
    //        LanceRestAMImpl am = LUtil.findLanceAM();
    //        ViewObjectImpl vo = getEmailPushFromAM(am);
    //        RowImpl row = LUtil.createInsertRow(vo);
    //        RestUtil.copyJsonObjectToRow(json, vo, row, this.ATTR_CREATE);
    //        LOGGER.log(LOGGER.TRACE, "copyJsonObjectToRow :" + this.ATTR_CREATE);
    //        String cm = am.commit();
    //        if (!"ok".equals(cm)) {
    //            return "error:" + cm;
    //        }
    //        String res = returnParamAfterCreate(row);
    //        LOGGER.log(LOGGER.NOTIFICATION, "emailPush created by return :" + res);
    //        return res;
    //    }

    /**
     * 删除
     * @param emailPushId
     * @return
     * @throws JSONException
     */
    @POST
    @Path("delete/{userName}")
    public String deleteEmailPush(@PathParam("userName") String userName) throws JSONException {
        if (!CAN_DELETE) {
            return "msg:此类记录无法被删除";
        }

        LanceRestAMImpl am = LUtil.findLanceAM();
        ViewObjectImpl vo = getEmailPushFromAM(am);
        Row row = findEmailPushByUserName(userName, vo, am);
        System.out.println(1);

        if (row != null) {
            System.out.println(2);
            //权限判断
            if (!RestSecurityUtil.isOwner(row)) {
                String msg = findCurrentUserName() + "无删除邮件订阅（userName：" + userName + "）的权限";
                LOGGER.log(LOGGER.WARNING, msg);
                return "msg:" + msg;
            }
            System.out.println(3);
            vo.setCurrentRow(row);
            vo.removeCurrentRow();
            am.getDBTransaction().commit();
            LOGGER.log(LOGGER.NOTIFICATION, findCurrentUserName() + "删除了邮件订阅" + userName);
        } else {
            System.out.println("4");
            LOGGER.log(LOGGER.NOTIFICATION, findCurrentUserName() + "尝试删除邮件订阅" + userName + "但此记录不存在");
        }
        return "ok";
    }


}
