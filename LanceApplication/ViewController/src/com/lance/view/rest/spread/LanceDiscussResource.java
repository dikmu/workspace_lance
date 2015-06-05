package com.lance.view.rest.spread;

import com.lance.model.LanceRestAMImpl;
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
import oracle.jbo.server.RowImpl;
import oracle.jbo.server.ViewObjectImpl;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * 资源代码模版
 *
 * 文本替换示例
 * LanceDiscuss ：LanceDiscuss
 * LanceDiscussId ： LanceDiscussId
 * 模版 ： 公司
 *
 *
 *
 */
@Path("lance/discuss")
public class LanceDiscussResource extends BaseRestResource {

    public LanceDiscussResource() {
    }

    //------------------------------implements below--------------------------

    public final ADFLogger LOGGER = ADFLogger.createADFLogger(LanceDiscussResource.class);

    /**
        Uuid,Precision:32,JavaType:java.lang.String
        Content,Precision:2000,JavaType:java.lang.String
        Type,Precision:20,JavaType:java.lang.String
        Urgent,Precision:20,JavaType:java.lang.String
        PageUrl,Precision:1000,JavaType:java.lang.String
        Contact,Precision:60,JavaType:java.lang.String
        CreateBy,Precision:60,JavaType:java.lang.String
        CreateOn,Precision:0,JavaType:java.sql.Timestamp
        ModifyBy,Precision:60,JavaType:java.lang.String
        ModifyOn,Precision:0,JavaType:java.sql.Timestamp
        Version,Precision:0,JavaType:java.math.BigDecimal
     */
    public static final String[] ATTR_ALL = {
        "Uuid", "Content", "Type", "Urgent", "PageUrl", "Contact", "CreateBy", "CreateOn", "ModifyBy", "ModifyOn",
        "Version"
    };

    public static final String[] ATTR_GET = ATTR_ALL;

    public static final String[] ATTR_UPDATE = { "Content", "Type", "Urgent", "PageUrl", "Contact" };

    public static final String[] ATTR_CREATE = { "Content", "Type", "Urgent", "PageUrl", "Contact" };

    public static final boolean CAN_DELETE = true;


    public ViewObjectImpl getLanceDiscussFromAM(LanceRestAMImpl am) {
        return am.getLanceDiscuss1();
    }

    public Row findLanceDiscussById(String id, ViewObjectImpl vo, LanceRestAMImpl am) {
        vo.setApplyViewCriteriaName("FindByUuidVC");
        vo.ensureVariableManager().setVariableValue("pUuid", id);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("FindByUuidVC");
        return vo.first();
    }

    public String returnParamAfterCreate(Row row) {
        return (String) row.getAttribute("Uuid");
    }

    //------------------------------以下是标准代码--------------------------
    
    @GET
    @Path("all/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONArray findAllLanceDiscuss(@PathParam("status") String status) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        ViewObjectImpl vo = getLanceDiscussFromAM(am);
        vo.setApplyViewCriteriaName("FindByStatusVC");
        vo.ensureVariableManager().setVariableValue("pStatus", status);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("FindByStatusVC");
        return this.convertVoToJsonArray(vo, this.ATTR_GET);
    }

    /**
     * 根据ID查询模版
     * @param lanceDiscussId
     * @return
     * @throws JSONException
     */
    @GET
    @Path("{lanceDiscussId}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getLanceDiscussById(@PathParam("lanceDiscussId") String lanceDiscussId) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        ViewObjectImpl vo = getLanceDiscussFromAM(am);
        Row row = findLanceDiscussById(lanceDiscussId, vo, am);

        if (row == null) {
            String msg = "模版（" + lanceDiscussId + "）对应的记录不存在或已被删除";
            JSONObject res = new JSONObject();
            res.put("msg", msg);
            return res;
        }

        return RestUtil.convertRowToJsonObject(vo, row, this.ATTR_GET);
    }


    /**
     * 更新
     * @param lanceDiscussId
     * @param json
     * @return
     * @throws JSONException
     */
    @POST
    @Path("update/{lanceDiscussId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateLanceDiscuss(@PathParam("lanceDiscussId") String lanceDiscussId,
                                     JSONObject json) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        ViewObjectImpl vo = getLanceDiscussFromAM(am);
        Row row = findLanceDiscussById(lanceDiscussId, vo, am);

        if (row == null) {
            LOGGER.log(LOGGER.NOTIFICATION, findCurrentUserName() + "尝试修改模版" + lanceDiscussId + "但此记录不存在");
            return "msg:can't find LanceDiscuss by id " + lanceDiscussId;
        }
        if (!RestSecurityUtil.isOwner(row)) {
            String msg = "您没有修改此记录的权限";
            return "msg:" + msg;
        }

        RestUtil.copyJsonObjectToRow(json, vo, row, this.ATTR_UPDATE);
        am.getDBTransaction().commit();

        LOGGER.log(LOGGER.NOTIFICATION,
                   findCurrentUserName() + "修改模版(" + lanceDiscussId + ") 为：" +
                   RestUtil.convertRowToJsonObject(vo, row, this.ATTR_ALL));
        return "ok";
    }

    /**
     * 创建
     * @param json
     * @return
     * @throws JSONException
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createLanceDiscuss(JSONObject json) throws JSONException {
        LOGGER.log(LOGGER.NOTIFICATION, "create LanceDiscuss");
        LanceRestAMImpl am = LUtil.findLanceAM();
        ViewObjectImpl vo = getLanceDiscussFromAM(am);
        RowImpl row = LUtil.createInsertRow(vo);
        RestUtil.copyJsonObjectToRow(json, vo, row, this.ATTR_CREATE);
        LOGGER.log(LOGGER.TRACE, "copyJsonObjectToRow :" + this.ATTR_CREATE);
        String cm = am.commit();
        if (!"ok".equals(cm)) {
            return "error:" + cm;
        }
        String res = returnParamAfterCreate(row);
        LOGGER.log(LOGGER.NOTIFICATION, "LanceDiscuss created by return :" + res);
        return res;
    }

    /**
     * 删除
     * @param lanceDiscussId
     * @return
     * @throws JSONException
     */
    @POST
    @Path("delete/{lanceDiscussId}")
    public String deleteLanceDiscuss(@PathParam("lanceDiscussId") String lanceDiscussId) throws JSONException {
        if (!CAN_DELETE) {
            return "msg:此类记录无法被删除";
        }

        LanceRestAMImpl am = LUtil.findLanceAM();
        ViewObjectImpl vo = getLanceDiscussFromAM(am);
        Row row = findLanceDiscussById(lanceDiscussId, vo, am);
        if (row != null) {
            //权限判断
            if (!RestSecurityUtil.isOwner(row)) {
                String msg = findCurrentUserName() + "无删除模版" + lanceDiscussId + "的权限";
                LOGGER.log(LOGGER.WARNING, msg);
                return "msg:" + msg;
            }

            vo.setCurrentRow(row);
            vo.removeCurrentRow();
            am.getDBTransaction().commit();
            LOGGER.log(LOGGER.NOTIFICATION, findCurrentUserName() + "删除了模版" + lanceDiscussId);
        } else {
            LOGGER.log(LOGGER.NOTIFICATION, findCurrentUserName() + "尝试删除模版" + lanceDiscussId + "但此记录不存在");
        }
        return "ok";
    }


}
