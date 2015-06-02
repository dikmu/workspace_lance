package com.lance.view.rest.uuser;

import com.lance.model.LanceRestAMImpl;
import com.lance.model.user.vo.UUserVOImpl;
import com.lance.model.user.vo.UUserVORowImpl;
import com.lance.model.vo.JobCategoryVOImpl;
import com.lance.model.vo.JobCategoryVORowImpl;
import com.lance.model.vo.JobSubCategoryVOImpl;
import com.lance.model.vo.JobSubCategoryVORowImpl;
import com.lance.model.vo.SkillSuperTypeVOImpl;
import com.lance.model.vo.SkillSuperTypeVORowImpl;
import com.lance.model.vo.SkillsVOImpl;
import com.lance.model.vo.SkillsVORowImpl;
import com.lance.view.util.LUtil;

import com.tangosol.net.NamedCache;

import com.zngh.platform.front.core.model.cache.AuthCache;
import com.zngh.platform.front.core.model.cache.CacheUtil;
import com.zngh.platform.front.core.view.BaseRestResource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import oracle.jbo.RowSetIterator;
import oracle.jbo.server.ViewRowImpl;

import org.apache.commons.lang.StringUtils;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("cache")
public class CacheResource extends BaseRestResource {

    public CacheResource() {
    }

    @GET
    @Path("all")
    public String cacheAll() throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        cacheUserInfoFn(am);
        cacheCategoryInfoFn(am);
        cacheSkillsFn(am);
        return "done";
    }


    @GET
    @Path("userInfo")
    public String cacheUserInfo() {
        LanceRestAMImpl am = LUtil.findLanceAM();
        cacheUserInfoFn(am);
        return "ok";
    }

    public void cacheUserInfoFn(LanceRestAMImpl am) {
        System.out.println("cache user in CacheUtil.KEY_AUTH_USER");
        UUserVOImpl vo = am.getUUser1();
        UUserVORowImpl row = null;
        RowSetIterator it = vo.createRowSetIterator(null);
        String[] attrs = AuthCache.CACHED_USER_ATTRIBUTES;
        NamedCache cache = CacheUtil.getInstance(CacheUtil.KEY_AUTH_USER);
        cache.clear();
        while (it.hasNext()) {
            row = (UUserVORowImpl) it.next();
            cacheSingleUserFn(row, cache, attrs);
        }
        it.closeRowSetIterator();
    }

    public void cacheSingleUser(UUserVORowImpl row) {
        String[] attrs = AuthCache.CACHED_USER_ATTRIBUTES;
        NamedCache cache = CacheUtil.getInstance(CacheUtil.KEY_AUTH_USER);
        cacheSingleUserFn(row, cache, attrs);
    }

    public void cacheSingleUserFn(UUserVORowImpl row, NamedCache cache, String[] attrs) {
        cache = CacheUtil.getInstance(CacheUtil.KEY_AUTH_USER);
        cache.put(row.getUserName(), convertRowToMap(row, attrs));
    }

    @GET
    @Path("categoryInfo")
    public String cacheCategoryInfo() throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        return cacheCategoryInfoFn(am);
    }

    /**
     * 缓存工作，JobCategory & JobSubCategory
     *
     * @param am
     * @return ['英文','中文','类别ID']
     */
    public String cacheCategoryInfoFn(LanceRestAMImpl am) throws JSONException {
        NamedCache cache = CacheUtil.getInstance(CacheUtil.KEY_JOB_CATEGORY);
        cache.clear();
        JSONObject json_jobType = new JSONObject();
        JobCategoryVOImpl vo1 = am.getJobCategory1();
        RowSetIterator it1 = vo1.createRowSetIterator(null);
        JobCategoryVORowImpl row1;
        while (it1.hasNext()) {
            row1 = (JobCategoryVORowImpl) it1.next();
            row1.getUuid();
            //添加到缓存
            cache.put(row1.getUuid(), new String[] { row1.getNameEn(), row1.getNameCn(), row1.getUuid() });
            //添加到json
            JSONArray data = new JSONArray();
            data.put(row1.getNameEn());
            data.put(row1.getNameCn());
            data.put(new JSONArray());
            json_jobType.put(row1.getUuid(), data);
        }
        it1.closeRowSetIterator();

        addNoTypeJobCategory(json_jobType);

        NamedCache cache2 = CacheUtil.getInstance(CacheUtil.KEY_JOB_SUBCATEGORY);
        JobSubCategoryVOImpl vo2 = am.getJobSubCategory2();
        RowSetIterator it2 = vo2.createRowSetIterator(null);
        JobSubCategoryVORowImpl row2;
        String categoryId;
        while (it2.hasNext()) {
            row2 = (JobSubCategoryVORowImpl) it2.next();
            row2.getUuid();
            categoryId = row2.getCategoryId();
            categoryId = categoryId == null ? "NULL_TYPE" : categoryId;
            //添加到缓存
            cache2.put(row2.getUuid(), new String[] { row2.getName(), row2.getNameCn(), row2.getCategoryId() });
            //添加到json
            JSONArray arr0 = json_jobType.getJSONArray(row2.getCategoryId());
            JSONArray arr = arr0.getJSONArray(2);
            JSONArray data = new JSONArray();
            data.put(row2.getName());
            if (StringUtils.isNotBlank(row2.getNameCn())) {
                data.put(row2.getNameCn());
            }
            arr.put(data);
        }
        it1.closeRowSetIterator();

        NamedCache cache3 = CacheUtil.getInstance("lance.browse.jobCategory");
        cache3.put("jobCategory", json_jobType.toString());

        return "ok";
    }

    private void addNoTypeJobCategory(JSONObject json_jobType) throws JSONException {
        JSONArray data = new JSONArray();
        data.put("No Typed");
        data.put("未分类");
        json_jobType.put("NULL_TYPE", data);
    }

    @GET
    @Path("user/{userId}")
    public String getUserFromCache(@PathParam("userId") String userId) {
        System.out.println(userId);
        String name;
        try {
            name = AuthCache.getUserDisplayNameByUserId(userId);
            System.out.println(name);
            //获取当前用户显示名
            System.out.println(AuthCache.getCurrentUserDisplayNameFromCache());
            //输入所有缓存的用户信息
            Map map = AuthCache.getCurrentUserFromCache();
            for (String attr : AuthCache.CACHED_USER_ATTRIBUTES) {
                System.out.println(attr + ":" + map.get(attr));
            }
            //输出所有用户（NamedCache的用法同Map）
            NamedCache cache = AuthCache.getAllUsers();
            for (Object o : cache.keySet()) {
                System.out.println(o);
            }
            return name;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("jobCategory/{categoryId}")
    public String getJobCategoryNameFromCache(@PathParam("categoryId") String categoryId) {
        try {
            NamedCache cache = CacheUtil.getInstance(CacheUtil.KEY_JOB_CATEGORY);
            cache.clear();
            String[] res = (String[]) cache.get(categoryId);
            if (res[1] != null && "".equals(res[1])) {
                return res[1];
            } else {
                return res[0];
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("jobSubCategory/{subCategoryId}")
    public String getJobSubCategoryNameFromCache(@PathParam("subCategoryId") String subCategoryId) {
        try {
            NamedCache cache = CacheUtil.getInstance(CacheUtil.KEY_JOB_SUBCATEGORY);
            cache.clear();
            String[] res = (String[]) cache.get(subCategoryId);
            if (res[1] != null && "".equals(res[1])) {
                return res[1];
            } else {
                return res[0];
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("Skill")
    public String cacheAllSkills() throws JSONException {
        LanceRestAMImpl am = LUtil.findLanceAM();
        return cacheSkillsFn(am);
    }

    /**
     * 缓存技能Skill
     * 同时产生一个关于Skill的JSON对象，用法详见BrowseResource.getBrowseSkill()
     *
     * @param am
     * @return [英文名,中文名,技能类别ID]
     */
    public String cacheSkillsFn(LanceRestAMImpl am) throws JSONException {
        System.out.println("cache SkillSuperType in CacheUtil.KEY_SKILL_TYPE");
        JSONObject json_SkillType = new JSONObject();
        NamedCache cache1 = CacheUtil.getInstance(CacheUtil.KEY_SKILL_TYPE);
        cache1.clear();
        SkillSuperTypeVOImpl vo1 = am.getSkillSuperType1();
        RowSetIterator it1 = vo1.createRowSetIterator(null);
        SkillSuperTypeVORowImpl row1 = null;
        while (it1.hasNext()) {
            row1 = (SkillSuperTypeVORowImpl) it1.next();
            //添加到缓存
            cache1.put(row1.getUuid(), new String[] { row1.getName(), row1.getNameCn(), row1.getUuid() });
            //添加到json
            JSONArray data = new JSONArray();
            data.put(row1.getName());
            data.put(row1.getNameCn());
            data.put(new JSONArray());
            json_SkillType.put(row1.getUuid(), data);
            //
        }
        it1.closeRowSetIterator();

        addNullTypeSkill(json_SkillType);

        System.out.println("cache Skills in CacheUtil.KEY_SKILL");
        NamedCache cache2 = CacheUtil.getInstance(CacheUtil.KEY_SKILL);
        cache2.clear();
        SkillsVOImpl vo2 = am.getSkills1();
        RowSetIterator it2 = vo2.createRowSetIterator(null);
        SkillsVORowImpl row2 = null;
        String superTypeId;

        while (it2.hasNext()) {
            row2 = (SkillsVORowImpl) it2.next();
            superTypeId = row2.getSuperTypeId();
            superTypeId = superTypeId == null ? "NULL_TYPE" : superTypeId;
            //添加到缓存
            cache2.put(row2.getUuid(), new String[] { row2.getName(), row2.getNameCn(), superTypeId });
            //添加到json
            JSONArray arr0 = json_SkillType.getJSONArray(superTypeId);
            JSONArray arr = (JSONArray) arr0.get(2);

            JSONArray data = new JSONArray();
            data.put(row2.getName());
            if (StringUtils.isNotBlank(row2.getNameCn())) {
                data.put(row2.getNameCn());
            }
            arr.put(data);
        }
        it2.closeRowSetIterator();

        NamedCache cache3 = CacheUtil.getInstance("lance.browse.skills");
        cache3.clear();
        cache3.put("skills", json_SkillType.toString());

        return "ok";
    }

    private void addNullTypeSkill(JSONObject json_SkillType) throws JSONException {
        JSONArray data = new JSONArray();
        data.put("No Typed");
        data.put("未分类");
        data.put(new JSONArray());
        json_SkillType.put("NULL_TYPE", data);
    }


    private Map convertRowToMap(ViewRowImpl row, String[] attrs) {
        Map map = new HashMap();
        for (String attr : attrs) {
            map.put(attr, row.getAttribute(attr));
        }
        return map;
    }

}
