package com.lance.view.servlet;

import com.lance.model.vo.RetrievePasswordVORowImpl;
import com.lance.view.rest.uuser.UserNotificationResource;
import com.lance.view.rest.uuser.UserResource;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;

import oracle.adf.share.ADFContext;

import org.apache.commons.lang.StringUtils;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class RetrieveServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType(CONTENT_TYPE);
            PrintWriter out = response.getWriter();
            String uid = request.getParameter("uid");
            if (!StringUtils.isBlank(uid)) {
                UserResource ur = new UserResource();
                RetrievePasswordVORowImpl rpv = ur.checkRetriveLog(uid);
                if (!StringUtils.isBlank(rpv.getUserName())) {
                    Date date = new Date();
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(date);
                    //激活2天内有效
                    calendar.add(calendar.HOUR, 2);
                    Date userLastActivateTime = calendar.getTime();
                    Date createTime = rpv.getCreateOn(); //获取用户注册的时间
                    //验证链接是否过期
                    System.out.println("--用户激活时间--:"+createTime+" ----:"+userLastActivateTime);
                    JSONObject data = new JSONObject();
                    if (createTime.before(userLastActivateTime)) {
                        data.put("step", 3);
                        data.put("uname", rpv.getUserName());
                        data.put("u-key", uid);
                        request.getSession().setAttribute("u-key", uid);
                    }else{
                        data.put("expire", "true");
                    }
                    toPage(request, response, "/WEB-INF/profile/retrievePw.jsp", data);
                }
            }
            out.close();
        } catch (Exception se) {
            // TODO: Add catch code
            se.printStackTrace();
        }
    }
    public void toPage(HttpServletRequest request, HttpServletResponse response, String page,
                       JSONObject data) throws ServletException, IOException {
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
        request.getRequestDispatcher(page).forward(request, response);
    }
}
