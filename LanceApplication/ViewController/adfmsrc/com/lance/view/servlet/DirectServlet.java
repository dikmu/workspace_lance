package com.lance.view.servlet;

import com.lance.view.rest.job.SearchResource;
import com.lance.view.rest.uuser.LookupsResource;
import com.lance.view.rest.uuser.UserResource;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import oracle.adf.share.ADFContext;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class DirectServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        String uri = request.getRequestURI();
        ADFContext adfctx = ADFContext.getCurrent();
        try {
            if ("/lance/page/MyHome".equals(uri)) {
                JSONObject data = new JSONObject();
                //获取值集——公司性质
                data.put("Lookup_CompanyPorperty", new LookupsResource().getLookupsByType("CompanyProperty"));
                //获取值集——公司规模
                data.put("Lookup_CompNumGrade", new LookupsResource().getLookupsByType("CompNumGrade"));
                data.put("search-type", "jobs");
                toPage(request, response, "/WEB-INF/search/searchjob.jsp", data);

            } else if(uri.contains("/lance/page/jobDetail")){
                String param = uri.substring(uri.lastIndexOf("/")+1, uri.length());
                JSONObject json = new JSONObject();
                json.put("jobId", param);
                toPage(request, response, "/WEB-INF/jobs/jobDetail.jsp", json);
            }else if(uri.startsWith("/lance/page/MyHome/contractors")){
                JSONObject data = new JSONObject();
                handleUri(uri, data);
                toPage(request, response, "/WEB-INF/search/searchjob.jsp", data);
            }else if(uri.startsWith("/lance/page/MyHome/jobs")){
                JSONObject data = new JSONObject();
                handleUri(uri, data);
                toPage(request, response, "/WEB-INF/search/searchjob.jsp", data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void handleUri(String uri,JSONObject data) throws JSONException {
        //处理大类型
        String huri = null;
        if(uri.startsWith("/lance/page/MyHome/contractors")){
            data.put("search-type", "contractors");
            huri = "/lance/page/MyHome/contractors";
        } else if(uri.startsWith("/lance/page/MyHome/jobs")){
            data.put("search-type", "jobs");
            huri = "/lance/page/MyHome/jobs";
        }
        if(huri == null || huri.equals(uri)){
            return;
        }
        
        String _uri = uri.substring(huri.length(), uri.length());
        for(String k : _uri.split("/")){
            if(k.startsWith("kw-")){
                data.put("keyword", k.substring(3, k.length()));
            }else if(k.startsWith("ct-")){
                data.put("catetory", k.substring(3, k.length()));
            }else if(k.startsWith("sct-")){
                String sct = k.substring(3, k.length()).replaceAll("-", ",");
                data.put("subcatetory", sct);
            }else if(k.startsWith("ind")){
//                data.put("subcatetory", sct);
            }
        }
    }
    
    public void toPage(HttpServletRequest request, HttpServletResponse response, String page,
                       JSONObject data) throws ServletException, IOException {
        try {
            ADFContext adfctx = ADFContext.getCurrent();
            String user = adfctx.getSecurityContext().getUserPrincipal().getName();
            JSONObject userData = new UserResource().findSimpleUserByName(user);
            String[] roles = adfctx.getSecurityContext().getUserRoles();
            JSONArray roleArr = new JSONArray();
            for (String role : roles) {
                roleArr.put(role);
            }
            userData.put("roles", roleArr);

            request.setAttribute("user", userData);
            request.setAttribute("data", data);
        } catch (JSONException jsone) {
            jsone.printStackTrace();
        }
        //不改变URL的跳转，且可以携带Request参数
        System.out.println("即将跳转界面 with json：");
        System.out.println("即将跳转界面到" + page);
        request.getRequestDispatcher(page).forward(request, response);
    }

    public void toPage(HttpServletRequest request, HttpServletResponse response, String page,
                       JSONArray arr) throws ServletException, IOException {
        try {
            ADFContext adfctx = ADFContext.getCurrent();
            String user = adfctx.getSecurityContext().getUserPrincipal().getName();
            JSONObject userData = new UserResource().findSimpleUserByName(user);
            String[] roles = adfctx.getSecurityContext().getUserRoles();
            JSONArray roleArr = new JSONArray();
            
            for (String role : roles) {
                roleArr.put(role);
            }
            userData.put("roles", roleArr);
            System.out.println("roles:"+roleArr);
            
            request.setAttribute("user", userData);
            request.setAttribute("data", arr);
        } catch (JSONException jsone) {
            jsone.printStackTrace();
        }
        //不改变URL的跳转，且可以携带Request参数
        System.out.println("即将跳转界面 with json：");
        System.out.println("即将跳转界面到" + page);
        request.getRequestDispatcher(page).forward(request, response);
    }
}
