package com.lance.view.servlet;

//import com.lance.view.rest.user.LancerProfileResource;
import com.lance.view.rest.job.PostJobResource;
import com.lance.view.rest.search.BrowseResource;
import com.lance.view.rest.uuser.LookupsResource;
import com.lance.view.rest.uuser.UserEducationResource;
import com.lance.view.rest.uuser.UserNotificationResource;
import com.lance.view.rest.uuser.UserResource;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.share.ADFContext;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * 此页面执行页面跳转
 */
public class PageDirectServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * 页面路径映射
     * 目前只用于登陆后界面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        String uri = request.getRequestURI();
        ADFContext adfctx = ADFContext.getCurrent();
        try {
            //如果用户访问的是登录后(受保护)界面
            if (uri.startsWith("/lance/pages/search") || uri.startsWith("/lance/pages/jobDetail") ||
                uri.startsWith("/lance/pages/browse") || uri.startsWith("/lance/pages/profile/Overview") ||
                uri.startsWith("/lance/pages/profile/client/CompanyProfile") ||
                uri.equals("/lance/pages/profile/retrieve")) {
                //不做登陆拦截



            } else if (uri.startsWith("/lance/pages/")) {
                if (!adfctx.getSecurityContext().isAuthenticated()) {
                    response.sendRedirect("/lance/login.htm");
                }
            }
            String user = adfctx.getSecurityContext().getUserPrincipal().getName();

            if (uri.startsWith("/lance/pages/search")) {
                JSONObject data = new JSONObject();

                if (adfctx.getSecurityContext().isUserInRole("Admin")) {
                    //获取值集——公司性质
                    data.put("Lookup_CompanyPorperty", new LookupsResource().getLookupsByType("CompanyProperty"));
                    //获取值集——公司规模
                    data.put("Lookup_CompNumGrade", new LookupsResource().getLookupsByType("CompNumGrade"));

                    toPage(request, response, "/WEB-INF/search/searchjob.jsp", data);
                } else {
                    toPage(request, response, "/static/err/authFailed.html", data);
                }

            } else if ("/lance/pages/DefaultPage".equals(uri) || "/lance/pages/Search".equals(uri)) {
                //                JSONArray data = new JSONArray();
                //                data.put(new SearchResource().searchLatestPosted());
                //                toPage(request, response, "/WEB-INF/search/searchjob.jsp", data);
                //                toPage(request, response, "/lance/pages/profile/Overview", data,true);
                //如果是个人，供应商账号，跳转至个人主页

                //登录成功后跳转到个人主页
                toPage(request, response, "/lance/pages/profile/Overview", new JSONArray(), true);

            } else if ("/lance/pages/profile/Overview".equals(uri)) {
                String uid = request.getParameter("uid");
                JSONObject data = new JSONObject();
                JSONObject userJson = null;
                if (uid != null) {
                    userJson = new UserResource().findUserById(uid);
                    data.put("User", userJson);
                } else {
                    if (!adfctx.getSecurityContext().isAuthenticated()) {
                        response.sendRedirect("/lance/login.htm");
                    }
                    userJson = new UserResource().findUserById(user);
                    data.put("User", userJson);
                }

                if ("client".equals(userJson.getJSONObject("User").getString("DefaultRole"))) {
                    //如果是公司账号，跳转至公司主页
                    toPage(request, response, "/lance/pages/profile/client/Profile", data, true);
                } else {
                    //如果是个人，供应商账号，跳转至个人主页
                    toPage(request, response, "/lance/pages/profile/lancer/Profile", data, true);
                }
            }
            //Client主页
            else if ("/lance/pages/profile/client/Profile".equals(uri)) {
                String uid = request.getParameter("uid");
                JSONObject data = new JSONObject();
                if (uid != null) {
                    data.put("User", new UserResource().findUserById(uid));
                } else {
                    if (!adfctx.getSecurityContext().isAuthenticated()) {
                        response.sendRedirect("/lance/login.htm");
                    }
                    data.put("User", new UserResource().findUserById(user));
                }
                toPage(request, response, "/WEB-INF/profile/client/Profile.jsp", data);

            }
            //Client PostJob维护
            else if ("/lance/pages/profile/client/EditPostJob".equals(uri)) {
                JSONObject data = new JSONObject();
                data.put("User", new UserResource().findUserById(user));
                toPage(request, response, "/WEB-INF/profile/client/EditPostJob.jsp", data);

            }
            //Client 编辑基本信息
            else if ("/lance/pages/profile/client/EditBasic".equals(uri)) {
                JSONObject data = new JSONObject();
                data.put("User", new UserResource().findUserById(user));
                toPage(request, response, "/WEB-INF/profile/client/EditBasic.jsp", data);

            }
            //Client 编辑联系信息
            else if ("/lance/pages/profile/client/EditContact".equals(uri)) {
                JSONObject data = new JSONObject();
                data.put("User", new UserResource().findUserById(user));
                toPage(request, response, "/WEB-INF/profile/client/EditContact.jsp", data);

            }
            //Lancer 主页
            else if ("/lance/pages/profile/lancer/Profile".equals(uri)) {
                String uid = request.getParameter("uid");
                JSONObject data = new JSONObject();
                if (uid != null) {
                    data.put("User", new UserResource().findUserById(uid));
                } else {
                    if (!adfctx.getSecurityContext().isAuthenticated()) {
                        response.sendRedirect("/lance/login.htm");
                    }
                    data.put("User", new UserResource().findUserById(user));
                }
                toPage(request, response, "/WEB-INF/profile/lancer/Profile.jsp", data);
            }
            //Lancer 编辑基本信息
            else if ("/lance/pages/profile/lancer/EditBasic".equals(uri)) {
                JSONObject data = new JSONObject();
                data.put("User", new UserResource().findUserById(user));
                toPage(request, response, "/WEB-INF/profile/lancer/EditBasic.jsp", data);

            } else if ("/lance/pages/profile/lancer/EditSkill".equals(uri)) {
                JSONObject data = new JSONObject();
                data.put("User", new UserResource().findUserById(user));
                toPage(request, response, "/WEB-INF/profile/lancer/EditSkill.jsp", data);

            } else if ("/lance/pages/profile/lancer/EditContact".equals(uri)) {
                JSONObject data = new JSONObject();
                data.put("User", new UserResource().findUserById(user));
                toPage(request, response, "/WEB-INF/profile/lancer/EditContact.jsp", data);

            } else if ("/lance/pages/profile/lancer/EmailPush".equals(uri)) {
                JSONObject data = new JSONObject();
                data.put("User", new UserResource().findUserById(user));
                toPage(request, response, "/WEB-INF/profile/lancer/EmailPush.jsp", data);

            } else if ("/lance/pages/jobs/PostNewJob".equals(uri)) {
                toPage(request, response, "/WEB-INF/jobs/PostNewJob.jsp", new JSONObject());

            } else if (uri.contains("/lance/pages/UserRegSuccess1")) {
                String param = uri.substring(uri.lastIndexOf("/"), uri.length() - 1);
                JSONObject json = new JSONObject();
                json.put("uuid", param);
                toPage(request, response, "/WEB-INF/profile/UserRegSuccess1.jsp", json);
            } else if ("/lance/pages/UserRegSuccess2".equals(uri)) {
                toPage(request, response, "/WEB-INF/profile/UserRegSuccess2.jsp", new JSONObject());

            } else if (uri.startsWith("/lance/pages/jobDetail")) {
                String param = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
                JSONObject json = new JSONObject();
                json.put("jobId", param);
                PostJobResource pjr = new PostJobResource();
                JSONObject job = pjr.getPostJob(param);
                json.put("Job", job);
                json.put("JobDiscuss", pjr.getJobDiscuss(param));
                request.setAttribute("jobName", job.getString("Name"));
                toPage(request, response, "/WEB-INF/jobs/jobDetail.jsp", json);
            } else if (uri.startsWith("/lance/pages/MyMessage")) {
                JSONObject json = new JSONObject();
                json.put("datas", new UserNotificationResource().findAllNoftification());
                toPage(request, response, "/WEB-INF/profile/MyMessage.jsp", json);
            } else if (uri.startsWith("/lance/pages/browse")) {
                JSONObject json = new JSONObject();
                BrowseResource br = new BrowseResource();
                json.put("JobCategories", br.getBrowseJobCategory());
                json.put("Skills", br.getBrowseSkill());
                toPage(request, response, "/WEB-INF/browse/BrowseJobCategory.jsp", json);
            } else if (uri.equals("/lance/pages/profile/EditEducation")) {
                UserEducationResource uer = new UserEducationResource();
                toPage(request, response, "/WEB-INF/profile/EditEducation.jsp", uer.findAllUserEducation(user));
            } else if (uri.equals("/lance/pages/profile/EditJobHistory")) {
                UserEducationResource uer = new UserEducationResource();
                toPage(request, response, "/WEB-INF/profile/EditJobHistory.jsp", uer.findAllUserEducation(user));
            } else if ("/lance/pages/profile/retrieve".equals(uri)) {
                toPage(request, response, "/WEB-INF/profile/retrievePw.jsp", new JSONObject());
            }
            //邮件订阅
            else if ("/lance/pages/search/EmailPush".equals(uri)) {
                toPage(request, response, "/WEB-INF/search/EmailPush.jsp", new JSONObject());
            }
            //            else if (uri.startsWith("/lance/pages/project/Contract/")) { //uri:http://localhost:7101/lance/pages/project/Contact/157e69a513f942c7bb895e7dddd01a56
            //                //读取合同
            //                uri = uri.replaceFirst("/lance/pages/project/Contract/", "");
            //                String contractId = uri.substring(0, 32); //32位uuid
            //                System.out.println(contractId);
            //                toPage(request, response, "/WEB-INF/project/Contract.jsp",
            //                       new ContractResource().getContractById(contractId));
            //            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toPage(HttpServletRequest request, HttpServletResponse response, String page,
                       JSONObject data) throws ServletException, IOException {
        toPage(request, response, page, data, false);
    }

    public void toPage(HttpServletRequest request, HttpServletResponse response, String page,
                       JSONArray arr) throws ServletException, IOException {
        toPage(request, response, page, arr, false);
    }

    /**
     * 跳转到指定界面
     * @param request
     * @param response
     * @param page 页面文件路径
     * @param data json
     * @throws ServletException
     * @throws IOException
     */
    public void toPage(HttpServletRequest request, HttpServletResponse response, String page, JSONObject data,
                       boolean changeUrl) throws ServletException, IOException {
        try {
            ADFContext adfctx = ADFContext.getCurrent();
            JSONObject userData = null;
            if (adfctx.getSecurityContext().isAuthenticated()) {
                String user = adfctx.getSecurityContext().getUserPrincipal().getName();
                userData = new UserResource().findSimpleUserByName(user);
                userData.put("logined", true);
                String notiCount = new UserNotificationResource().findNotificationCount();
                userData.put("notification", notiCount);
                String[] roles = adfctx.getSecurityContext().getUserRoles();
                JSONArray roleArr = new JSONArray();
                for (String role : roles) {
                    roleArr.put(role);
                }
                userData.put("roles", roleArr);
            } else {
                userData = new JSONObject();
                userData.put("logined", false);
            }
            request.setAttribute("user", userData);
            request.setAttribute("data", data);
        } catch (JSONException jsone) {
            jsone.printStackTrace();
        }
        //不改变URL的跳转，且可以携带Request参数
        System.out.println("即将跳转界面 with json：");
        System.out.println("即将跳转界面到" + page);
        if (!changeUrl) {
            request.getRequestDispatcher(page).forward(request, response);
        } else {
            response.sendRedirect(page);
        }
    }

    /**
     * 跳转到指定界面
     * @param request
     * @param response
     * @param page 页面文件路径
     * @param arr json
     * @throws ServletException
     * @throws IOException
     */
    public void toPage(HttpServletRequest request, HttpServletResponse response, String page, JSONArray arr,
                       boolean changeUrl) throws ServletException, IOException {
        try {
            ADFContext adfctx = ADFContext.getCurrent();
            JSONObject userData = null;
            if (adfctx.getSecurityContext().isAuthenticated()) {
                String user = adfctx.getSecurityContext().getUserPrincipal().getName();
                userData = new UserResource().findSimpleUserByName(user);
                userData.put("logined", true);
                String notiCount = new UserNotificationResource().findNotificationCount();
                userData.put("notification", notiCount);
                String[] roles = adfctx.getSecurityContext().getUserRoles();
                JSONArray roleArr = new JSONArray();
                for (String role : roles) {
                    roleArr.put(role);
                }
                userData.put("roles", roleArr);
            } else {
                userData = new JSONObject();
                userData.put("logined", false);
            }

            request.setAttribute("user", userData);
            request.setAttribute("data", arr);
        } catch (JSONException jsone) {
            jsone.printStackTrace();
        }
        //不改变URL的跳转，且可以携带Request参数
        System.out.println("即将跳转界面 with json：");
        System.out.println("即将跳转界面到" + page);
        if (!changeUrl) {
            request.getRequestDispatcher(page).forward(request, response);
        } else {
            response.sendRedirect(page);
        }
    }


}
