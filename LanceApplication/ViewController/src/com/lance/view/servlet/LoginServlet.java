package com.lance.view.servlet;

import com.lance.model.util.ConstantUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.security.auth.Subject;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import weblogic.security.URLCallbackHandler;
import weblogic.security.services.Authentication;

public class LoginServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * Ajax登陆接口
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost LoginServlet");
        //
        //        Cookie[]  cs=request.getCookies();
        //        for(Cookie c:cs){
        //           System.out.println(c);
        //        }
        //
        String acceptjson = "";
        try {
            BufferedReader br =
                new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer("");
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
            acceptjson = sb.toString();
            JSONObject jo = new JSONObject(acceptjson);
            int c = 0;
            if(request.getSession().getAttribute(ConstantUtil.ERR_INP_COUNT) != null){
                c = Integer.parseInt(request.getSession().getAttribute(ConstantUtil.ERR_INP_COUNT).toString());
            }
            if((jo.has("optype") || c >= 3)){
                String code = jo.getString("vcode");
                HttpSession session = request.getSession(true);  
                if(!code.equalsIgnoreCase((String)session.getAttribute("verifyCode"))){
                    response.setContentType(CONTENT_TYPE);
                    PrintWriter out = response.getWriter();
                    out.println("error:vcode"); //用户名或密码错误
                    out.close();
                    return;
                }   
            }
            System.out.println("doLogin:" + acceptjson);
            String un = jo.getString("name");
            byte[] pw = jo.getString("pass").getBytes();
            String optype = null;
            if(jo.has("optype")){
                optype = jo.getString("optype");
            }
            Subject subject = Authentication.login(new URLCallbackHandler(un, pw));
            weblogic.servlet.security.ServletAuthentication.runAs(subject, request);
            System.out.println(un + " 登录成功");
            response.setContentType(CONTENT_TYPE);
            PrintWriter out = response.getWriter();
            if(optype != null){
                if("regist".equals(optype)){
                   out.println("ok:/lance/pages/profile/Overview"); //成功，跳转页面
                }
            }else{
                out.println("ok:/lance/pages/search"); //成功，跳转页面
            }
            out.close(); 
            return;
        } catch (FailedLoginException fle) {
            int c = 0;
            if(request.getSession().getAttribute(ConstantUtil.ERR_INP_COUNT) != null){
                c = Integer.parseInt(request.getSession().getAttribute(ConstantUtil.ERR_INP_COUNT).toString());
                c++;
                request.getSession().setAttribute(ConstantUtil.ERR_INP_COUNT,c);
            }else{
                c++;
                request.getSession().setAttribute(ConstantUtil.ERR_INP_COUNT,c);
            }
            response.setContentType(CONTENT_TYPE);
            PrintWriter out = response.getWriter();
            if(c >= 3){
                out.println("error:name|pass:vc"); //用户名或密码错误 
            }else{
               out.println("error:name|pass"); //用户名或密码错误
            }
            out.close();
            return;
        } catch (LoginException le) {
            le.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
