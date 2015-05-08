package com.lance.view.rest.uuser;

import com.lance.model.LanceRestAMImpl;
import com.lance.model.vo.UserCompanyHistoryVOImpl;
import com.lance.model.vo.UserLicenseVOImpl;
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

import oracle.jbo.Row;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
@Path("user/license")
public class UserLicenseResource extends BaseRestResource {
    public static final String[] ATTR_ALL = {"Uuid", "UserName", "Name", "RegOrganization", "Content", "RegNumber", "RegAddress", "StartDate", "EndDate", "Status", "CreateBy", "CreateOn", "ModifyBy", "ModifyOn", "Version"};
    public static final String[] ATTR_CREATE ={"UserName", "Name", "RegOrganization", "Content", "RegNumber", "RegAddress", "StartDate", "EndDate", "Status"};
    public UserLicenseResource() {
        super();
    }
    
    private String createLicenseHistoryFn(JSONObject json, LanceRestAMImpl am) throws JSONException {
        UserLicenseVOImpl vo = am.getUserLicense1();
        Row row = LUtil.createInsertRow(vo);
        RestUtil.copyJsonObjectToRow(json, vo, row, ATTR_CREATE);
        row.setAttribute("UserName", this.findCurrentUserName());
        return (String) row.getAttribute("Uuid");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createLiceenseHistory(JSONObject json) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        String msg = createLicenseHistoryFn(json, am);
        if(!"ok".equals(am.commit())){
            msg = "msg:创建认证信息失败!";
        }
        return msg;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update/{uuid}")
    public String updateUserLicenseHistory(@PathParam("uuid") String uuid,JSONObject json) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        UserLicenseVOImpl vo = am.getUserLicense1();
        Row row = LUtil.getByKey(vo, uuid); 
        if (row == null) {
            return "msg:记录不存在或已删除";
        }
        if(!RestSecurityUtil.isOwner(row)){
            String msg="您没有修改此记录的权限";
            return "msg:"+msg;
        }
        RestUtil.copyJsonObjectToRow(json, vo, row, this.ATTR_CREATE);
        am.getDBTransaction().commit();
        return "ok";
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("delete/{uuid}")
    public String deleteUserLicenseHistory(@PathParam("uuid") String uuid){
        LanceRestAMImpl am = LUtil.findLanceAM();
        UserLicenseVOImpl vo = am.getUserLicense1();
        Row row = LUtil.getByKey(vo, uuid);
        if (row == null) {
            return "msg:记录不存在或已删除";
        }
        if(!RestSecurityUtil.isOwner(row)){
            String msg="您没有删除此记录的权限";
            return "msg:"+msg;
        }
        row.remove();
        am.getDBTransaction().commit();
        return "ok";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all/{userName}")
    public JSONArray findUserAllLicenseHistory(@PathParam("userName")String userName) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        UserLicenseVOImpl vo = am.getUserLicense1();
        vo.setApplyViewCriteriaName("findUserLicenseVC");
        vo.setpuser(userName);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("findUserLicenseVC");
        return this.convertVoToJsonArray(vo, this.ATTR_ALL);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{uuid}")
    public JSONObject findLicenseHistory(@PathParam("uuid")String uuid) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        JSONObject json = null;
        UserLicenseVOImpl vo = am.getUserLicense1();
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
