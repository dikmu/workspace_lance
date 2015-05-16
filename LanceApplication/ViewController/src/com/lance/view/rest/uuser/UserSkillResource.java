package com.lance.view.rest.uuser;

import com.lance.model.LanceRestAMImpl;
import com.lance.model.user.vo.UUserVORowImpl;
import com.lance.model.user.vo.UserSkillVOImpl;
import com.lance.model.user.vo.UserSkillVORowImpl;

import com.zngh.platform.front.core.view.BaseRestResource;
import com.zngh.platform.front.core.view.RestUtil;

import com.lance.view.util.LUtil;
import com.lance.view.util.RestSecurityUtil;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import oracle.adf.share.ADFContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jbo.server.RowImpl;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.commons.lang.StringUtils;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * 对Skill的技能提供
 * 1.批量增加
 * 2.单个删除
 * 3.重排序 修改ShowOrder
 * 4.查询
 * 技能重复输入时不提示错误，后台将忽略重复的添加
 * 无法删除验证过的Skill，只能隐藏
 * 不提供修改功能
 *
 *
 * 字段说明：
 * Name技能名
 * Tested技能是否经过系统认证（忽略）todo（认证系统）
 * Display是否显示，0不显示，1显示
 * ShowOrder排序，执行新增操作时
 * MasterLevel 同Tested，忽略
 */
@Path("user/skill")
@SuppressWarnings("oracle.jdeveloper.java.semantic-warning")
public class UserSkillResource extends BaseRestResource {
    public static final String[] ATTR_ALL = {
        "Uuid", "UserName", "Name", "Tested", "Display", "ShowOrder", "MasterLevel", "CreateBy", "CreateOn", "ModifyBy",
        "ModifyOn", "Version"
    };

    public static final String[] ATTR_CREATE = { "Name", "Tested", "Display", "ShowOrder", "MasterLevel" };

    public static final String[] ATTR_UPDATE = { "Name", "Tested", "Display", "ShowOrder", "MasterLevel" };

    public static final String[] ATTR_SORT_GET = {
        "Uuid", "Name", "Display", "ShowOrder", "MasterLevel"
    };
    
    @SuppressWarnings("oracle.jdeveloper.java.array-field-access")
    public static final String[] ATTR_GET = {
        "Uuid", "UserName", "Name", "Display", "ShowOrder", "MasterLevel", "CreateBy", "CreateOn", "ModifyBy",
        "ModifyOn", "Version"
    };

    public UserSkillResource() {
    }

    /**
     *
     * 单个删除
     * POST http://localhost:7101/lance/res/user/skill/delete/{lancerId}/{lancerSkillId}
     *
     * example
     * POST http://localhost:7101/lance/res/user/skill/delete/muhongdi/594f2c55bd5749eabaf93f74b6c5a364
     * return ok
     *
     * @param lancerId
     * @param skillId
     * @return ok
     * @throws JSONException
     */
    @POST
    @Path("delete/{userName}/{skillId}")
    public String deleteLancerSkill(@PathParam("userName") String userName,
                                    @PathParam("skillId") String skillId) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        //find and set current parent row
        UUserVORowImpl userr = LUtil.getUUserByName(userName, am);

        UserSkillVOImpl vo = am.getUserSkill1();
        Row row = vo.findByKey(new Key(new Object[] { skillId }), 1)[0];
        if (!RestSecurityUtil.isOwner(row)) {
            return "msg:没有足够的权限删除此用户数据";
        }
        vo.setCurrentRow(row);

        vo.removeCurrentRow();
        updateSkillIndex(vo, userr);
        am.getDBTransaction().commit();
        return "ok";
    }
    
    private void updateSkillIndex(UserSkillVOImpl vo,UUserVORowImpl userr){
        vo.setRangeSize(-1);
        StringBuffer skills = new StringBuffer();
        for(Row row : vo.getAllRowsInRange()){
            UserSkillVORowImpl r = (UserSkillVORowImpl)row;
            if(StringUtils.isNotBlank(r.getName())){
                skills.append(r.getName()).append(";");
            }
        }
        userr.setIndexSkill(skills.toString());
        userr.updateSearchIndex();
    }

    /**
     * 单个新增
     * @param userName
     * @param json
     * @return
     * @throws JSONException
     */
    @POST
    @Path("{userName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createUserSkill(@PathParam("userName") String userName, JSONObject json) throws JSONException {
        LOGGER.log(LOGGER.NOTIFICATION, "createUserSkill");
        LanceRestAMImpl am = LUtil.findLanceAM();
        UUserVORowImpl userr = LUtil.getUUserByName(userName, am);
        UserSkillVOImpl vo = am.getUserSkill1();
        vo.setRangeSize(-1);
        if(vo.getRowCount()>=50){
            return "msg:技能不能大于50个";
        }
        UserSkillVORowImpl row = (UserSkillVORowImpl) LUtil.createInsertRow(vo);
        RestUtil.copyJsonObjectToRow(json, vo, row, this.ATTR_CREATE);
        updateSkillIndex(vo, userr);
        String cm = am.commit();
        if (!"ok".equals(cm)) {
            return "error:"+cm;
        }
        LOGGER.log(LOGGER.TRACE, "copyJsonObjectToRow :" + this.ATTR_CREATE);
        String res = row.getUuid();
        LOGGER.log(LOGGER.NOTIFICATION, "createUserSkill by return :" + res);
        return res;
    }

    /**
     *
     * 批量为User添加Skill
     * todo 忽略重复名称（基于前台实现，需先确认此接口可用）
     * POST http://localhost:7101/lance/res/user/lancer/skill/batch/{userName}
     *
     * example
     * POST http://localhost:7101/lance/res/user/lancer/skill/batch/muhongdi
     * [
            {
                "Name" : "XML"
            },
            {
                "Name" : "CSS"
            }
        ]
     *
     *
     * @param lancerId
     * @param JSONArray
     * @return  ok
     * @throws JSONException
     *
     */
    @POST
    @Path("batch/{userName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createLancerSkills(@PathParam("userName") String userName, JSONArray jarray) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        String res = createMultiUserSkillsFn(userName, jarray, am);
        am.getDBTransaction().commit();
        return res;
    }

    public String createMultiUserSkillsFn(String userName, JSONArray jarray, LanceRestAMImpl am) throws JSONException {
        //find and set current parent row
        UUserVORowImpl userr = LUtil.getUUserByName(userName, am);
        List list = new ArrayList();

        UserSkillVOImpl vo = am.getUserSkill1();
        vo.setRangeSize(-1);
        if (vo.getRowCount() > 50) {
            return "msg:技能不能大于50个";
        }
        JSONObject json;
        Row row;
        for (int i = 0; i < jarray.length(); i++) {
            json = jarray.getJSONObject(i);
            if (list.indexOf(json.getString("Name")) != -1) {
                //repeated
                continue;
            }
            row = LUtil.createInsertRow(vo);
            RestUtil.copyJsonObjectToRow(json, vo, row, this.ATTR_CREATE);
        }
        updateSkillIndex(vo, userr);
        return "ok";
    }

    /**
     * 根据UserName获取属于该User的Skills
     *
     * GET http://localhost:7101/lance/res/user/skill/all/{userName}
     *
     * example
     * GET http://localhost:7101/lance/res/user/skill/all/muhongdi
     *
     * [
        {
            "Name" : "html",
            "Display" : 1,
            "ShowOrder" : 1,
            "MasterLevel" : 0,
            "Uuid" : "1",
            "ResumeId" : "1"
        }
       ]
     *
     * @param lancerId
     * @return JSONArray
     * @throws JSONException
     *
     */
    @GET
    @Path("all/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONArray findAllUserSkills(@PathParam("userName") String userName) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        return findUserSkillsFn(userName, am);
    }

    public JSONArray findLancerSkills4CurUser() throws JSONException {
        String n = this.findCurrentUserName();
        return findAllUserSkills(n);
    }


    public JSONArray findUserSkillsFn(String userName, LanceRestAMImpl am) throws JSONException {
        LUtil.getUUserByName(userName, am);

        UserSkillVOImpl vo = am.getUserSkill1();
        if (vo.getRowCount() == 0) {
            return new JSONArray();
        }
        return this.convertVoToJsonArray(vo, this.ATTR_SORT_GET);
    }

}
