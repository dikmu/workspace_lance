package com.lance.view.rest.job;

import com.lance.model.LanceRestAMImpl;
import com.lance.model.vo.PostJobDiscussVOImpl;
import com.lance.model.vo.PostJobDiscussVORowImpl;
import com.lance.model.vo.PostJobsVOImpl;
import com.lance.model.vo.PostJobsVORowImpl;
import com.lance.view.util.LUtil;

import com.zngh.platform.front.core.view.BaseRestResource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import oracle.jbo.Row;

import oracle.jbo.RowSetIterator;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("postJob")
public class PostJobResource extends BaseRestResource {

    /**
     *   PostJobVO 字段说明
         Uuid,Precision:32,JavaType:java.lang.String
         Attach,Precision:2000,JavaType:java.lang.String  附件的链接
         Brief,Precision:2100,JavaType:java.lang.String  描述
         DurationMax,Precision:0,JavaType:java.math.BigDecimal 项目周期最少（周），月要换算成周（4周一个月），稍后决定时可以为空
         DurationMin,Precision:0,JavaType:java.math.BigDecimal 项目周期最多（周）
         FixedLocation,Precision:20,JavaType:java.lang.String  固定地点项目（Y/N）
         FixedPayMax,Precision:0,JavaType:java.math.BigDecimal 固定价格项目：预算最多价格
         FixedPayMin,Precision:0,JavaType:java.math.BigDecimal
         HourlyPayMax,Precision:0,JavaType:java.math.BigDecimal 按时间计费项目：最大多少钱/小时
         HourlyPayMin,Precision:0,JavaType:java.math.BigDecimal 时薪。记录hourly rate的范围。稍后决定时可以为空。必须大于等于10，最大值不能小于最小值。错误提示不需要链接，直接提示如下信息即可
     * 根据2014年8月；均为最低档标准，最低工资不能低于9.9元每小时。即不能少于10元。
         JobVisibility,Precision:20,JavaType:java.lang.String  隐私协议，此消息是否可被搜索：public(可被搜索到)/private（只用于发布给指定人员）
         AllowSearchEngines,Precision:20,JavaType:java.lang.String 是否允许此信息出现在百度、谷歌等搜索引擎上，Y/N利用搜索引擎推广
         LocationDesc,Precision:1200,JavaType:java.lang.String 地点描述
         Name,Precision:60,JavaType:java.lang.String 工作名
         Postform,Precision:20,JavaType:java.lang.String 支付方式：hourly（时薪）/fixed（固定价格）
         SpecificSkillA,Precision:32,JavaType:java.lang.String  特殊技能需求，外键，连接到技能ID。
         SpecificSkillB,Precision:32,JavaType:java.lang.String
         SpecificSkillC,Precision:32,JavaType:java.lang.String
         SpecificSkillD,Precision:32,JavaType:java.lang.String
         SpecificSkillE,Precision:32,JavaType:java.lang.String
         SpecificSkillF,Precision:32,JavaType:java.lang.String
         SpecificSkillG,Precision:32,JavaType:java.lang.String
         Status,Precision:20,JavaType:java.lang.String   draft:草稿，posted：发布，deleted：删除
         WeeklyHours,Precision:0,JavaType:oracle.jbo.domain.Number   每周工作时间：>1
         WorkCategory,Precision:32,JavaType:java.lang.String  工作大类，从JobTemplate接口获取。存储ID
         WorkSubcategory,Precision:32,JavaType:java.lang.String 工作详细类别，从JobTemplate接口获取。存储ID
         PostJobDateStart,Precision:0,JavaType:oracle.jbo.domain.Date  信息发布有效期(年月日)，不可大于90天。UI建议采用elance的形式，立即生效时需要设置开始时间为当前天
         PostJobDateEnd,Precision:0,JavaType:oracle.jbo.domain.Date
         LocationCity,Precision:32,JavaType:java.lang.String  地点，城市ID
         LocationCountry,Precision:32,JavaType:java.lang.String
         LocationProvince,Precision:32,JavaType:java.lang.String
         CreateBy,Precision:60,JavaType:java.lang.String
         CreateOn,Precision:0,JavaType:java.sql.Timestamp
         ModifyBy,Precision:60,JavaType:java.lang.String
         ModifyOn,Precision:0,JavaType:java.sql.Timestamp
         Version,Precision:0,JavaType:oracle.jbo.domain.Number
         CreateByName,Precision:50,JavaType:java.lang.String  发布人显示名
     */
    public static final String[] POST_JOB_VO_ATTR_ALL = {
        "Uuid", "AllowSearchEngines", "Attach", "Brief", "DurationMax", "DurationMin", "FixedLocation", "FixedPayMax",
        "FixedPayMin", "HourlyPayMax", "HourlyPayMin", "JobVisibility", "LocationDesc", "Name", "Postform",
        "SpecificSkillA", "SpecificSkillB", "SpecificSkillC", "SpecificSkillD", "SpecificSkillE", "SpecificSkillF",
        "SpecificSkillG", "Status", "WeeklyHours", "WorkCategory", "WorkSubcategory", "PostJobDateStart",
        "PostJobDateEnd", "LocationCity", "LocationCountry", "LocationProvince", "CreateBy", "CreateOn", "ModifyBy",
        "ModifyOn", "Version", "CreateByName"
    };

    public static final String[] POST_JOB_VO_ATTR_GET = POST_JOB_VO_ATTR_ALL;

    public static final String[] POST_JOB_VO_ATTR_SORT_GET = {
        "Uuid", "Brief", "DurationMax", "DurationMin", "FixedLocation", "FixedPayMax", "FixedPayMin", "HourlyPayMax",
        "HourlyPayMin", "JobVisibility", "LocationDesc", "Name", "Postform", "SpecificSkillA", "SpecificSkillB",
        "SpecificSkillC", "SpecificSkillD", "SpecificSkillE", "SpecificSkillF", "SpecificSkillG", "Status",
        "WeeklyHours", "WorkCategory", "WorkSubcategory", "PostJobDateStart", "PostJobDateEnd", "LocationCity",
        "LocationCountry", "LocationProvince", "CreateBy", "CreateOn", "ModifyBy", "ModifyOn", "Version", "CreateByName"
    };

    public static final String[] POST_JOB_VO_ATTR_UPDATE = {
        "AllowSearchEngines", "Attach", "Brief", "DurationMax", "DurationMin", "FixedLocation", "FixedPayMax",
        "FixedPayMin", "HourlyPayMax", "HourlyPayMin", "JobVisibility", "LocationDesc", "Name", "Postform",
        "SpecificSkillA", "SpecificSkillB", "SpecificSkillC", "SpecificSkillD", "SpecificSkillE", "SpecificSkillF",
        "SpecificSkillG", "Status", "WeeklyHours", "WorkCategory", "WorkSubcategory", "PostJobDateStart",
        "PostJobDateEnd", "LocationCity", "LocationCountry", "LocationProvince"
    };

    /**
     * 发布工作时，不可为空的字段（不限于以下字段）
     * 保存草稿时，不验证非空字段
     */
    public static final String[] POST_JOB_VO_ATTR_REQUIRED = {
        "Name", "Brief", "WorkCategory", "WorkSubcategory", "Postform", "Status", "PostJobDateStart", "PostJobDateEnd"
    };

    /**
     * POST_JOB_DISCUSS_VO
     *
        Uuid,Precision:32,JavaType:java.lang.String
        PostJobId,Precision:32,JavaType:java.lang.String
        ParentDiscussId,Precision:32,JavaType:java.lang.String 基于某一条评论/申请的回复
        Content,Precision:2100,JavaType:java.lang.String 正文、附加描述
        IsApply,Precision:1,JavaType:java.lang.String  申请：Y 讨论：N
        SignBy,Precision:20,JavaType:java.lang.String  合同签署方：self/company
        Postform,Precision:20,JavaType:java.lang.String hourly时薪/fixed固定价格/空
        HourlyPay,Precision:0,JavaType:java.math.BigDecimal 报价：时薪
        FixedPayMax,Precision:0,JavaType:java.math.BigDecimal 固定价格（最大）
        FixedPayMin,Precision:0,JavaType:java.math.BigDecimal 固定价格（最小）
        WeeklyHours,Precision:0,JavaType:oracle.jbo.domain.Number 每周工作时间
        EnteryDate,Precision:0,JavaType:oracle.jbo.domain.Date 可进入时间/空（稍后确定）
        CreateByName,Precision:255,JavaType:java.lang.String
        CreateBy,Precision:60,JavaType:java.lang.String
        CreateOn,Precision:0,JavaType:oracle.jbo.domain.Date
        ModifyBy,Precision:60,JavaType:java.lang.String
        ModifyOn,Precision:0,JavaType:oracle.jbo.domain.Date
        Version,Precision:0,JavaType:oracle.jbo.domain.Number
     */
    public static final String[] POST_JOB_DISCUSS_VO_ATTR_ALL = {
        "Uuid", "PostJobId", "Content", "IsApply", "SignBy", "Postform", "HourlyPay", "FixedPayMax", "FixedPayMin",
        "WeeklyHours", "EnteryDate", "ParentDiscussId", "CreateByName", "CreateBy", "CreateOn", "ModifyBy", "ModifyOn",
        "Version"
    };

    /**
     * 讨论，申请Job相关字段
     * 此接口也适用于
     * 只传入Uuid,IsApply=Y 代表某人申请某工作
     *
     */
    public static final String[] POST_JOB_DISCUSS_VO_ATTR_CREATE = {
        "PostJobId", "Content", "IsApply", "SignBy", "Postform", "HourlyPay", "FixedPayMax", "FixedPayMin",
        "WeeklyHours", "EnteryDate", "ParentDiscussId"
    };


    public static final String[] POST_JOB_DISCUSS_VO_ATTR_READ = POST_JOB_DISCUSS_VO_ATTR_ALL;

    public PostJobResource() {
    }

    //发布工作信息
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createPostJob(JSONObject json) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        PostJobsVOImpl vo = am.getPostJobs1();
        PostJobsVORowImpl row = (PostJobsVORowImpl) vo.createRow();
        vo.setCurrentRow(row);

        //使用简短ID，1414408397908
        row.setAttribute("Uuid", "" + System.currentTimeMillis());

        updatePostJobFn(am, row, json);
        am.getDBTransaction().commit();
        return row.getUuid();
    }

    /**
     * 修改PostJob
     * @param postJobId
     * @param json
     * @return
     * @throws JSONException
     */
    @POST
    @Path("update/{postJobId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updatePostJob(@PathParam("postJobId") String postJobId, JSONObject json) throws JSONException {
        System.out.println("updatePostJob:" + postJobId);
        LanceRestAMImpl am = LUtil.findLanceAM();
        PostJobsVOImpl vo = am.getPostJobs1();
        PostJobsVORowImpl row = (PostJobsVORowImpl) vo.getCurrentRow();
        if (row == null || !row.getUuid().equals(postJobId)) {
            vo.setpUuid(postJobId);
            vo.setApplyViewCriteriaName("FindByIdVC");
            vo.executeQuery();
            vo.removeApplyViewCriteriaName("FindByIdVC");
            row = (PostJobsVORowImpl) vo.first();
            vo.setCurrentRow(row);
        }
        updatePostJobFn(am, row, json);
        am.getDBTransaction().commit();
        return "ok";
    }

    /**
     * 修改PostJob功能（功能，非对外接口）
     * @param am
     * @param row
     * @param json
     * @throws JSONException
     */
    public void updatePostJobFn(LanceRestAMImpl am, PostJobsVORowImpl row, JSONObject json) throws JSONException {
        System.out.println("updatePostJobFn:" + json.get("Status"));
        if (json.get("Status").equals("draft")) {
            System.out.println("只保存草稿");
            saveDraftPostJobFn(am, row, json);
        } else if (json.get("Status").equals("posted")) {
            System.out.println("发布");
            sendPostJobFn(am, row, json);
        } else if (json.get("Status").equals("deleted")) {
            saveDraftPostJobFn(am, row, json);
        } else {
            am.getDBTransaction().rollback();
        }
    }

    /**
     * 保存草稿功能
     * @param am
     * @param row
     * @param json
     * @throws JSONException
     */
    public void saveDraftPostJobFn(LanceRestAMImpl am, PostJobsVORowImpl row, JSONObject json) throws JSONException {
        System.out.println("发布招聘信息-保存草稿");
        LUtil.transJsonToRow(json, row, POST_JOB_VO_ATTR_UPDATE);
    }

    /**
     * 发布工作
     * 后台验证只做最关键验证
     *
     * @param am
     * @param row
     * @param json
     */
    public JSONObject sendPostJobFn(LanceRestAMImpl am, PostJobsVORowImpl row, JSONObject json) throws JSONException {
        System.out.println("sendPostJobFn");
        JSONObject res = new JSONObject();
        LUtil.jsonHasNullAttrs(json, POST_JOB_VO_ATTR_REQUIRED);
        //非空
        if (json.has("HourlyPayMin") && json.getDouble("HourlyPayMin") < 10) {
            res.put("error", "时薪不能小于10元");
            return res;
        }
        if (json.has("FixedPayMin") && json.getDouble("FixedPayMin") < 80) {
            res.put("error", "支付价格不能小于80元");
            return res;
        }
        //
        LUtil.transJsonToRow(json, row, POST_JOB_VO_ATTR_UPDATE);
        return res;
    }

    /**
     * 删除草稿
     * 发布后的会假删除
     * @param postJobId
     * @return
     */
    @POST
    @Path("delete/{postJobId}")
    public String deletePostJob(@PathParam("postJobId") String postJobId) {
        LanceRestAMImpl am = LUtil.findLanceAM();
        PostJobsVOImpl vo = am.getPostJobs1();
        vo.setApplyViewCriteriaName("FindByIdVC");
        vo.setpUuid(postJobId);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("FindByIdVC");
        PostJobsVORowImpl row = (PostJobsVORowImpl) vo.first();
        if (row.getStatus().equals("draft")) {
            //草稿
            row.remove();
            am.getDBTransaction().commit();
            return "ok";
        } else if (row.getStatus().equals("posted")) {
            //发布
            row.setStatus("deleted");
            am.getDBTransaction().commit();
            return "ok";
        } else {
            return "status not allowed";
        }
    }

    /**
     * 获取指定PostJob
     *
     * @param postJobId
     * @return
     * @throws JSONException
     */
    @GET
    @Path("{postJobId}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getPostJob(@PathParam("postJobId") String postJobId) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        PostJobsVOImpl vo = am.getPostJobs1();
        vo.setpUuid(postJobId);
        vo.setApplyViewCriteriaName("FindByIdVC");
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("FindByIdVC");
        Row row = vo.first();

        return this.convertRowToJsonObject(row, POST_JOB_VO_ATTR_GET);
    }

    /**
     * 找到所有当前用户创建的PostJob
     * @return
     */
    @GET
    @Path("all/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONArray findAllMyPostJob(@PathParam("userName") String userName) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        PostJobsVOImpl vo = am.getPostJobs1();
        //todo userCheck
        //String curUser = this.findCurrentUserName();
        vo.setpCreateBy(userName);
        vo.setApplyViewCriteriaName("FindByCreateByVC");
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("FindByCreateByVC");
        return this.convertVoToJsonArray(vo, this.POST_JOB_VO_ATTR_SORT_GET);
    }

    /**
     * 对指定PostJob发布评论（申请）
     * @param jobId
     * @param json
     * @return
     * @throws JSONException
     */
    @POST
    @Path("{postJobId}/discuss")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postDiscuss(@PathParam("postJobId") String jobId, JSONObject json) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        PostJobsVOImpl vo = am.getPostJobs1();
        vo.setApplyViewCriteriaName("FindByIdVC");
        vo.setpUuid(jobId);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("FindByIdVC");
        vo.setCurrentRow(vo.first());

        PostJobDiscussVOImpl vo2 = am.getPostJobDiscuss1();
        Row row = vo2.createRow();
        for (String attr : POST_JOB_DISCUSS_VO_ATTR_CREATE) {
            if (json.has(attr))
                row.setAttribute(attr, json.get(attr));
        }
        vo2.insertRow(row);
        am.getDBTransaction().commit();
        return "ok";
    }

    /**
     * 获取指定工作下的讨论信息
     * （不含工作信息本身，乙方查看甲方发布的PostJob页面应该用异步方式加载讨论信息）
     *
     * @param jobId
     * @return
     * @throws JSONException
     */
    @GET
    @Path("{postJobId}/discuss")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getJobDiscuss(@PathParam("postJobId") String jobId) throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        PostJobsVOImpl vo = am.getPostJobs1();
        vo.setApplyViewCriteriaName("FindByIdVC");
        vo.setpUuid(jobId);
        vo.executeQuery();
        vo.removeApplyViewCriteriaName("FindByIdVC");
        vo.setCurrentRow(vo.first());

        PostJobDiscussVOImpl vo2 = am.getPostJobDiscuss1();
        vo2.executeQuery();
        return this.packViewObject(vo2, null, null, POST_JOB_DISCUSS_VO_ATTR_READ);
    }

    /**
     * 删除指定PostJob下的评论（申请）
     *
     * 可执行的操作类型
     * 信息发布人执行删除 delete
     * 评论发布人执行删除 delete
     *
     * 会同时删除基于此消息的所有评论
     *
     * @param jobId
     * @param discussId
     * @param operation 执行的操作类型 delete
     * @return
     */
    @POST
    @Path("{postJobId}/discuss/delete/{discussId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteJobDiscuss(@PathParam("postJobId") String postJobId, @PathParam("discussId") String discussId) {
        String currentUser = this.findCurrentUserName();
        //check PostJobs status createBy user
        LanceRestAMImpl am = LUtil.findLanceAM();
        PostJobsVOImpl postJobVo = am.getPostJobs1();
        postJobVo.setApplyViewCriteriaName("FindByIdVC");
        postJobVo.setpUuid(postJobId);
        postJobVo.executeQuery();
        postJobVo.removeApplyViewCriteriaName("FindByIdVC");
        PostJobsVORowImpl postJobRow = (PostJobsVORowImpl) postJobVo.first();
        postJobVo.setCurrentRow(postJobRow);

        PostJobDiscussVOImpl discussVo = am.getPostJobDiscussVO1();

        //非信息发布人执行删除时，需要验证当前用户是否是本discuss发布人
        if (!postJobRow.getCreateBy().equals(currentUser)) {
            findDiscussByIdAndCreator(am, discussId, currentUser);
            if (discussVo.getRowCount() == 0) {
                return "无权执行此操作";
            }
        }

        findDiscuss4Delete(am, discussId);
        if (discussVo.getRowCount() == 0) {
            return "找不到对应的记录";
        }

        RowSetIterator discussIt = discussVo.createRowSetIterator(null);
        PostJobDiscussVORowImpl discussRow;
        while (discussIt.hasNext()) {
            discussRow = (PostJobDiscussVORowImpl) discussIt.next();
            discussRow.setStatus("deleted");
            if (postJobRow.getCreateBy().equals(currentUser)) {
                discussRow.setStatusLog("此信息已被客户删除");
            } else {
                discussRow.setStatusLog("此信息已被发布者删除");
            }
        }
        discussIt.closeRowSetIterator();
        
        am.getDBTransaction().commit();
        return "ok";
    }

    private PostJobDiscussVOImpl findDiscussByIdAndCreator(LanceRestAMImpl am, String discussId, String creator) {
        PostJobDiscussVOImpl discussVo = am.getPostJobDiscussVO1();
        discussVo.setApplyViewCriteriaName("FindByIdAndCreatorVC");
        discussVo.setpCreator(creator);
        discussVo.setpId(discussId);
        discussVo.executeQuery();
        discussVo.removeApplyViewCriteriaName("FindByIdAndCreatorVC");
        return discussVo;
    }

    private PostJobDiscussVOImpl findDiscuss4Delete(LanceRestAMImpl am, String discussId) {
        PostJobDiscussVOImpl discussVo = am.getPostJobDiscussVO1();
        discussVo.setApplyViewCriteriaName("Find4DeleteVC");
        discussVo.setpId(discussId);
        discussVo.executeQuery();
        discussVo.removeApplyViewCriteriaName("Find4DeleteVC");
        return discussVo;
    }


    //    public static void main(String[] args) {
    //        System.out.println(System.currentTimeMillis());
    //        System.out.println(Math.random());
    //        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
    //        System.out.println(sdf.format(new Date()));
    //    }


}
