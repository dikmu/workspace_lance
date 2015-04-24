package com.lance.view.rest.uuser;

import com.lance.model.LanceRestAMImpl;
import com.lance.model.user.vo.UUserVOImpl;
import com.lance.view.util.LUtil;
import com.lance.view.util.RestSecurityUtil;

import com.zngh.platform.front.core.view.BaseRestResource;
import com.zngh.platform.front.core.view.RestUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import oracle.adf.share.logging.ADFLogger;

import oracle.jbo.Row;
import oracle.jbo.server.RowImpl;
import oracle.jbo.server.ViewObjectImpl;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * 资源代码通知
 *
 * 文本替换示例
 * UserNotification ：Company
 * UserNotificationId ： companyId
 * 通知 ： 公司
 *
 *
 *
 */
@Path("user/notification")
public class UserNotificationResource extends BaseRestResource {

    /**
        Uuid,Precision:32,JavaType:java.lang.String
        Title,Precision:20,JavaType:java.lang.String
        Content,Precision:1000,JavaType:java.lang.String
        UserName,Precision:60,JavaType:java.lang.String
        Type,Precision:20,JavaType:java.lang.String
        Read,Precision:20,JavaType:java.lang.String
        CreateBy,Precision:60,JavaType:java.lang.String
        CreateOn,Precision:0,JavaType:java.sql.Timestamp
        ModifyBy,Precision:60,JavaType:java.lang.String
        ModifyOn,Precision:0,JavaType:java.sql.Timestamp
        Version,Precision:0,JavaType:java.math.BigDecimal
     */

    //------------------------------implements below--------------------------

    public final ADFLogger LOGGER = ADFLogger.createADFLogger(UserNotificationResource.class);

    public static final String[] ATTR_ALL = {
        "Uuid", "Title", "Content", "UserName", "Type", "Read", "CreateBy", "CreateOn", "ModifyBy", "ModifyOn",
        "Version"
    };

    public static final String[] ATTR_GET = {
        "Uuid", "Title", "Content", "UserName", "Type", "Read", "CreateBy", "CreateOn", "ModifyBy", "ModifyOn",
        "Version"
    };

    public static final String[] ATTR_UPDATE = { "Title", "Content", "Type", "Read" };

    public static final String[] ATTR_CREATE = { "Title", "Content", "Type" };

    public static final boolean CAN_DELETE = true;


    public ViewObjectImpl getUserNotificationFromAM(LanceRestAMImpl am) {
        return am.getUserNotification1();
    }

    public Row findUserNotificationById(String id, ViewObjectImpl vo, LanceRestAMImpl am) {
        vo.setApplyViewCriteriaName("FindByUuidVC");
        vo.ensureVariableManager().setVariableValue("pUuid", id);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("FindByUuidVC");
        return vo.first();
    }

    public String returnParamAfterCreate(Row row) {
        return (String) row.getAttribute("Uuid");
    }

    public void findCurrentUserRow(String userName, LanceRestAMImpl am) {
        UUserVOImpl vo = am.getUUser1();
        if (vo.getCurrentRow() != null && vo.getCurrentRow().getAttribute("UserName").equals(userName)) {
            return;
        }
        vo.setApplyViewCriteriaName("FindByUserNameVC");
        vo.setpUserName(userName);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("FindByUserNameVC");
        vo.setCurrentRow(vo.first());
        System.out.println(vo.first().getAttribute("UserName"));
    }

    //------------------------------以下是标准代码--------------------------

    //    /**
    //     * 根据ID查询通知
    //     * @param userNotificationId
    //     * @return
    //     * @throws JSONException
    //     */
    //    @GET
    //    @Path("{userNotificationId}")
    //    @Produces(MediaType.APPLICATION_JSON)
    //    public JSONObject getUserNotificationById(@PathParam("userNotificationId") String userNotificationId) throws JSONException {
    //        LanceRestAMImpl am = LUtil.findLanceAM();
    //        ViewObjectImpl vo = getUserNotificationFromAM(am);
    //        Row row = findUserNotificationById(userNotificationId, vo, am);
    //
    //        if (row == null) {
    //            String msg = "通知（" + userNotificationId + "）对应的记录不存在或已被删除";
    //            JSONObject res = new JSONObject();
    //            res.put("msg", msg);
    //            return res;
    //        }
    //
    //        return RestUtil.convertRowToJsonObject(vo, row, this.ATTR_GET);
    //    }


    //    /**
    //     * 更新
    //     * @param UserNotificationId
    //     * @param json
    //     * @return
    //     * @throws JSONException
    //     */
    //    @POST
    //    @Path("update/{UserNotificationId}")
    //    @Consumes(MediaType.APPLICATION_JSON)
    //    public String updateUserNotification(@PathParam("UserNotificationId") String UserNotificationId, JSONObject json) throws JSONException {
    //        LanceRestAMImpl am = LUtil.findLanceAM();
    //        ViewObjectImpl vo = getUserNotificationFromAM(am);
    //        Row row = findUserNotificationById(UserNotificationId, vo, am);
    //
    //        if (row == null) {
    //            LOGGER.log(LOGGER.NOTIFICATION, findCurrentUserName() + "尝试修改通知" + UserNotificationId + "但此记录不存在");
    //            return "msg:can't find UserNotification by id " + UserNotificationId;
    //        }
    //        if(!RestSecurityUtil.isOwner(row)){
    //            String msg="您没有修改此记录的权限";
    //            return "msg:"+msg;
    //        }
    //
    //        RestUtil.copyJsonObjectToRow(json, vo, row, this.ATTR_UPDATE);
    //        am.getDBTransaction().commit();
    //
    //        LOGGER.log(LOGGER.NOTIFICATION,
    //                   findCurrentUserName() + "修改通知(" + UserNotificationId + ") 为：" +
    //                   RestUtil.convertRowToJsonObject(vo, row, this.ATTR_ALL));
    //        return "ok";
    //    }

    /**
     * 创建通知
     * @param json
     * @return
     * @throws JSONException
     */
    @POST
    @Path("{userName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createUserNotification(JSONObject json) throws JSONException {
        LOGGER.log(LOGGER.NOTIFICATION, "create UserNotification");
        String userName = this.findCurrentUserName();
        LanceRestAMImpl am = LUtil.findLanceAM();
        findCurrentUserRow(userName, am);
        ViewObjectImpl vo = getUserNotificationFromAM(am);
        RowImpl row = LUtil.createInsertRow(vo);
        RestUtil.copyJsonObjectToRow(json, vo, row, this.ATTR_CREATE);
        LOGGER.log(LOGGER.TRACE, "copyJsonObjectToRow :" + this.ATTR_CREATE);
        String cm = am.commit();
        if (!"ok".equals(cm)) {
            return "error:" + cm;
        }
        String res = returnParamAfterCreate(row);
        LOGGER.log(LOGGER.NOTIFICATION, "UserNotification created by return :" + res);
        return res;
    }

    /**
     * 删除
     * @param UserNotificationId
     * @return
     * @throws JSONException
     */
    @POST
    @Path("delete/{UserNotificationId}")
    public String deleteUserNotification(@PathParam("UserNotificationId")
                                         String UserNotificationId) throws JSONException {
        String userName = this.findCurrentUserName();
        if (!CAN_DELETE) {
            return "msg:此类记录无法被删除";
        }

        LanceRestAMImpl am = LUtil.findLanceAM();
        findCurrentUserRow(userName, am);
        ViewObjectImpl vo = getUserNotificationFromAM(am);
        Row row = findUserNotificationById(UserNotificationId, vo, am);
        if (row != null) {
            //权限判断
            if (!RestSecurityUtil.isOwner(row)) {
                String msg = findCurrentUserName() + "无删除通知" + UserNotificationId + "的权限";
                LOGGER.log(LOGGER.WARNING, msg);
                return "msg:" + msg;
            }

            vo.setCurrentRow(row);
            vo.removeCurrentRow();
            am.getDBTransaction().commit();
            LOGGER.log(LOGGER.NOTIFICATION, findCurrentUserName() + "删除了通知" + UserNotificationId);
        } else {
            LOGGER.log(LOGGER.NOTIFICATION, findCurrentUserName() + "尝试删除通知" + UserNotificationId + "但此记录不存在");
        }
        return "ok";
    }

    /**
     * 根据用户名获取当前用户的消息数量
     * 使用Ajax方式，未来可能改成长连接方式
     * @param userName
     * @return
     */
    @GET
    @Path("count/unread")
    public String findNotificationCount() {
        String userName = this.findCurrentUserName();
        return findNotificationCountFn(userName);
    }

    private String findNotificationCountFn(String userName) {
        LanceRestAMImpl am = LUtil.findLanceAM();
        findCurrentUserRow(userName, am);
        ViewObjectImpl vo = am.getUserNotificationUnread();
        String count = "" + vo.getRowCount();
        return count;
    }

    /**
     * 获取当前登录用户的所有消息
     * @return
     * @throws JSONException
     */
    @GET
    @Path("all")
    public JSONArray findAllNoftification() throws JSONException {
        String userName = this.findCurrentUserName();
        LanceRestAMImpl am = LUtil.findLanceAM();
        findCurrentUserRow(userName, am);
        ViewObjectImpl vo = getUserNotificationFromAM(am);
        vo.executeQuery();
        return this.convertVoToJsonArray(vo, ATTR_GET);
    }

}
