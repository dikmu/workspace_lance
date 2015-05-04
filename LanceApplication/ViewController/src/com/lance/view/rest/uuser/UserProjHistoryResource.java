package com.lance.view.rest.uuser;

import com.lance.model.LanceRestAMImpl;
import com.lance.model.vo.UserLicenseVOImpl;
import com.lance.model.vo.UserProjectHistoryVOImpl;
import com.lance.view.util.LUtil;

import com.zngh.platform.front.core.view.BaseRestResource;
import com.zngh.platform.front.core.view.RestUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import oracle.jbo.Row;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
@Path("user/proj")
public class UserProjHistoryResource extends BaseRestResource {
    public static final String[] ATTR_ALL = {"Uuid", "UserName", "Name", "Title", "Content", "StartDate", "EndDate", "ProjectAddress", "Status", "CreateBy", "CreateOn", "ModifyBy", "ModifyOn", "Version"};
    public static final String[] ATTR_CREATE = {"UserName", "Name", "Title", "Content", "StartDate", "EndDate", "ProjectAddress", "Status"};
    public UserProjHistoryResource() {
        super();
    }
    
    private String createProjHistoryFn(JSONObject json, LanceRestAMImpl am) throws JSONException {
        UserProjectHistoryVOImpl vo = am.getUserProjectHistory1();
        Row row = LUtil.createInsertRow(vo);
        RestUtil.copyJsonObjectToRow(json, vo, row, ATTR_CREATE);
        row.setAttribute("UserName", this.findCurrentUserName());
        return (String) row.getAttribute("Uuid");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String createProjHistory(JSONObject json) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        String msg = createProjHistoryFn(json, am);
        if(!"ok".equals(am.commit())){
            msg = "msg:创建历史项目失败!";
        }
        return msg;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("update/{uuid}")
    public String updateProjHistory(@PathParam("uuid") String uuid,JSONObject json) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        UserProjectHistoryVOImpl vo = am.getUserProjectHistory1();
        Row row = LUtil.getByKey(vo, uuid); 
        if (row == null) {
            return "msg:记录不存在或已删除";
        }
        RestUtil.copyJsonObjectToRow(json, vo, row, this.ATTR_CREATE);
        am.getDBTransaction().commit();
        return "ok";
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("delete/{uuid}")
    public String deleteProjHistory(@PathParam("uuid") String uuid){
        LanceRestAMImpl am = LUtil.findLanceAM();
        UserProjectHistoryVOImpl vo = am.getUserProjectHistory1();
        Row row = LUtil.getByKey(vo, uuid);
        if (row == null) {
            return "msg:记录不存在或已删除";
        }
        row.remove();
        am.getDBTransaction().commit();
        return "ok";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all/{userName}")
    public JSONArray findUserAllProjHistory(@PathParam("userName") String userName) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        UserProjectHistoryVOImpl vo = am.getUserProjectHistory1();
        vo.setApplyViewCriteriaName("findUserProjHistoryVC");
        vo.setpuser(userName);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("findUserProjHistoryVC");
        return this.convertVoToJsonArray(vo, this.ATTR_ALL);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{uuid}")
    public JSONObject findProjHistory(@PathParam("uuid")String uuid) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        JSONObject json = null;
        UserProjectHistoryVOImpl vo = am.getUserProjectHistory1();
        Row row = LUtil.getByKey(vo, uuid);
        if (row == null) {
            json = new JSONObject();
            json.put("error", "该记录不存在");
        }else{
            json = this.convertRowToJsonObject(vo,row,this.ATTR_ALL);
        }
        return json;
    }
}
