package com.lance.view.rest.search;

import com.tangosol.net.NamedCache;

import com.zngh.platform.front.core.model.cache.CacheUtil;
import com.zngh.platform.front.core.view.BaseRestResource;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("browse")
public class BrowseResource extends BaseRestResource {
    public BrowseResource() {
    }

    /**
     * http://localhost:7101/lance/res/browse/skill/all
     * @return
     * @throws JSONException
     */
    @GET
    @Path("skill/all")
    public JSONObject getBrowseSkill() throws JSONException {
        NamedCache cache3 = CacheUtil.getInstance("lance.browse.skills");
        String skills = (String) cache3.get("skills");
        return new JSONObject(skills);
    }

    /**
     * http://localhost:7101/lance/res/browse/category/all
     * @return
     * @throws JSONException
     */
    @GET
    @Path("category/all")
    public JSONObject getBrowseJobCategory() throws JSONException {
        NamedCache cache3 = CacheUtil.getInstance("lance.browse.jobCategory");
        String jobCategory = (String) cache3.get("jobCategory");
        return new JSONObject(jobCategory);
    }

}
