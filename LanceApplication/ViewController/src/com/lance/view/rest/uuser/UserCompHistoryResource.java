package com.lance.view.rest.uuser;

import com.lance.model.LanceRestAMImpl;
import com.lance.model.user.vo.UserLocationListVOImpl;
import com.lance.model.vo.UserCompanyHistoryVOImpl;
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

import oracle.jbo.server.ViewObjectImpl;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("user/comp")
public class UserCompHistoryResource extends BaseRestResource {
    public static final String[] ATTR_ALL = {"Uuid", "UserName", "Name", "Title", "WorkArea", "Content", "StartDate", "EndDate", "Status", "CreateBy", "CreateOn", "ModifyBy", "ModifyOn", "Version"};
    public static final String[] ATTR_CREATE ={"UserName","Name", "Title", "WorkArea", "Content", "StartDate", "EndDate", "Status"};
    public UserCompHistoryResource() {
        super();
    }
    
    private String createCompHistoryFn(JSONObject json, LanceRestAMImpl am) throws JSONException {
        UserCompanyHistoryVOImpl vo = am.getUserCompanyHistory1();
        Row row = LUtil.createInsertRow(vo);
        RestUtil.copyJsonObjectToRow(json, vo, row, ATTR_CREATE);
        row.setAttribute("UserName", this.findCurrentUserName());
        return (String) row.getAttribute("Uuid");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createUserCompHistory(JSONObject json) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        String msg = createCompHistoryFn(json, am);
        if(!"ok".equals(am.commit())){
            msg = "msg:创建历史公司失败!";
        }
        return msg;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update/{uid}")
    public String updateUserCompHistory(@PathParam("uid") String uid,JSONObject json) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        UserCompanyHistoryVOImpl vo = am.getUserCompanyHistory1();
        Row row = LUtil.getByKey(vo, uid); 
        if (row == null) {
            return "msg:记录不存在或已删除";
        }
        RestUtil.copyJsonObjectToRow(json, vo, row, this.ATTR_CREATE);
        am.getDBTransaction().commit();
        return "ok";
    }

    @POST
    @Path("delete/{uid}")
    public String deleteUserCompHistory(@PathParam("uid") String uid){
        LanceRestAMImpl am = LUtil.findLanceAM();
        UserCompanyHistoryVOImpl vo = am.getUserCompanyHistory1();
        Row row = LUtil.getByKey(vo, uid);
        if (row == null) {
            return "msg:记录不存在或已删除";
        }
        row.remove();
        am.getDBTransaction().commit();
        return "ok";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all/{username}")
    public JSONArray findUserAllCompHistory(@PathParam("username")String username) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        UserCompanyHistoryVOImpl vo = am.getUserCompanyHistory1();
        vo.setApplyViewCriteriaName("findUserCompHistoryVC");
        vo.setuname(username);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("findUserCompHistoryVC");
        return this.convertVoToJsonArray(vo, this.ATTR_ALL);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{uuid}")
    public JSONObject findCompHistory(@PathParam("uuid")String uuid) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        JSONObject json = null;
        UserCompanyHistoryVOImpl vo = am.getUserCompanyHistory1();
        Row row = LUtil.getByKey(vo, uuid);
        if (row == null) {
            json = new JSONObject();
            json.put("error", "该记录不存在!");
        }else{
            json = this.convertRowToJsonObject(vo,row,this.ATTR_ALL);
        }
        return json;
    }
}
