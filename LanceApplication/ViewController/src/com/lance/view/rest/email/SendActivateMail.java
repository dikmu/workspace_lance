package com.lance.view.rest.email;

import com.lance.model.LanceRestAMImpl;
import com.lance.model.user.vo.UUserVORowImpl;
import com.lance.model.util.ConstantUtil;
import com.lance.model.vo.RegEmailChkVOImpl;
import com.lance.model.vo.RegEmailChkVORowImpl;
import com.lance.view.util.LUtil;

import com.zngh.platform.front.core.model.cache.AuthCache;
import com.zngh.platform.front.core.model.util.UUIDGenerator;

import com.zngh.platform.front.core.view.BaseRestResource;

import java.io.IOException;

import java.io.UnsupportedEncodingException;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.faces.context.FacesContext;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import javax.ws.rs.core.MediaType;

import oracle.jbo.Key;
import oracle.jbo.Row;
import javax.ws.rs.core.Response;

import oracle.jbo.server.ViewObjectImpl;

/**
 * 使用Javamail实现邮件发送功能
 *
 */

@Path("sendMail")
public class SendActivateMail extends BaseRestResource{
    public SendActivateMail() {
        super();
    }

//    @GET
//    @Path("validateEmail")
//    public void validateEmail(@QueryParam("validateCode") String validateCode, @QueryParam("sid") String sid
//                              ) {
//        try {
//            HttpServletResponse response =
//                (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//            LanceRestAMImpl am = LUtil.findLanceAM();
//            RegEmailChkVOImpl regEmailChkVO = am.getRegEmailChk1();
//            Row[] regEmailChkRows = regEmailChkVO.findByKey(new Key(new Object[] { validateCode }), 1);
//            if (regEmailChkRows != null && regEmailChkRows.length > 0) {
//                //通过验证码,用户找出系统用户 激活状态，激活截止日期
//                RegEmailChkVORowImpl regEmailChkRow = (RegEmailChkVORowImpl) regEmailChkRows[0];
//                //用户的激活状态    0未激活1激活
//                int uesrStatus = 0;
//                //激活截止日期
//                Date date = new Date();
//                Calendar calendar = new GregorianCalendar();
//                calendar.setTime(date);
//                //激活2天内有效
//                calendar.add(calendar.DATE, -2);
//                Date userLastActivateTime = calendar.getTime();
//                //验证用户激活状态
//                if (uesrStatus == 0) {
//                    ///没激活
//                    Date userCreateTime = regEmailChkRow.getCreateOn(); //获取用户注册的时间
//                    //验证链接是否过期
//                    if (userCreateTime.before(userLastActivateTime)) {
//                        //激活成功， //并更新用户的激活状态，为已激活
//                        System.out.println("激活成功");
//                        //把状态改为激活
//                        uesrStatus = 1;
//                    } else {
//                        System.out.println("激活码已过期！");
//                    }
//                } else {
//                    System.out.println("邮箱已激活，请登录！");
//                    response.sendRedirect("/lance/login.htm");
//                }
//            } else {
//                System.out.println("该用户未注册（邮用户不存在）！");
//            }
//        } catch (IOException ioe) {
//            // TODO: Add catch code
//            ioe.printStackTrace();
//        }
//    }

    public void sendActivateEmail(String userEmail, String validateCode, String uid) throws UnsupportedEncodingException, MessagingException {
        if(userEmail.lastIndexOf("test.com")>=0){
            return;
        }
        StringBuffer sb = new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
        sb.append("<a href=\""+ConstantUtil.ROOT_HTTP_URL+"/page/email/active?uid=");
        sb.append(uid);
        sb.append("&validateCode=");
        sb.append(validateCode);
        sb.append("\">"+ConstantUtil.ROOT_HTTP_URL+"/page/email/active?uid=");
        sb.append(uid);
        sb.append("&validateCode=");
        sb.append(validateCode);
        sb.append("</a>");
        sendEmail(userEmail, "欢迎您注册驻才网，请激活您的驻才用户名",sb.toString());
    }
    
    public void sendEmail(String userEmail,String subject,String content) throws UnsupportedEncodingException,
                                                                                    MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.163.com");
        props.put("mail.smtp.auth", "true");
        PopupAuthenticator auth = new PopupAuthenticator();
        Session session = Session.getInstance(props, auth);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        Address addressFrom = new InternetAddress(PopupAuthenticator.mailuser + "@163.com", "驻才网");
        Address addressTo = new InternetAddress(userEmail, ""); //接收邮箱和用户
        message.setContent(content, "text/html;charset=utf-8");
        // message.setText(sb.toString());
        message.setSubject(subject);
        message.setFrom(addressFrom);
        message.addRecipient(Message.RecipientType.TO, addressTo);
        message.saveChanges();
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.163.com", PopupAuthenticator.mailuser, PopupAuthenticator.password);
        transport.send(message);
        transport.close();
        System.out.println("发送成功");    
    }
    
    /**
     *重新发送邮件  xiexiaojun
     * @param email
     * @return
     */
    @GET
    @Path("resend/{email}")
    public String sendEmail(@PathParam("email")String email){
        LanceRestAMImpl am = LUtil.findLanceAM();
        RegEmailChkVOImpl regEmailChkVO = am.getRegEmailChk1();
        String uuid = UUIDGenerator.getUuid();
        RegEmailChkVORowImpl regEmailChkRow = (RegEmailChkVORowImpl) regEmailChkVO.createRow();
        regEmailChkRow.setUuid(uuid);
        regEmailChkRow.setUserName(findCurrentUserName());
        boolean tag = false;
        try {
            sendActivateEmail(email, uuid, findCurrentUserName());
            tag = true;
        } catch (Exception e) {
            tag = false;
        } 
        if(!tag){
           return "err:请检查邮箱地址是否正确!";
        }
        UUserVORowImpl row = LUtil.getUUserByName(findCurrentUserName(), am);
        if(!email.equals(row.getEmail())){
            row.setEmail(email);
        }
        return am.commit();
    }
    
    /**
     *重新发送邮件  xiexiaojun
     * @param email
     * @return
     */
    @GET
    @Path("resend2/{uname}")
    public String sendEmail2(@PathParam("uname")String uname){
        LanceRestAMImpl am = LUtil.findLanceAM();
        RegEmailChkVOImpl regEmailChkVO = am.getRegEmailChk1();
        String uuid = UUIDGenerator.getUuid();
        RegEmailChkVORowImpl regEmailChkRow = (RegEmailChkVORowImpl) regEmailChkVO.createRow();
        regEmailChkRow.setUuid(uuid);
        regEmailChkRow.setUserName(uname);
        String email = (String)AuthCache.getUserById(uname).get("Email");
        boolean tag = false;
        try {
            sendActivateEmail((String) AuthCache.getUserById(uname).get("Email"), uuid, uname);
            tag = true;
        } catch (Exception e) {
            tag = false;
        } 
        if(!tag){
           return "err:请检查邮箱地址是否正确!";
        }
        String flag = am.commit();
        if("ok".equals(flag)){
            return "ok:"+email;
        }
        return "err:发送邮件出现异常";
    }


    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.163.com");
        props.put("mail.smtp.auth", "true");
        try {
            PopupAuthenticator auth = new PopupAuthenticator();
            Session session = Session.getInstance(props, auth);
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            Address addressFrom = new InternetAddress(PopupAuthenticator.mailuser + "@163.com", "驻才网！");
            Address addressTo = new InternetAddress("lzm1507008@126.com", ""); //接收邮箱和用户
            ///邮件的内容  validateCode通过MD5加密
            StringBuffer sb = new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
            sb.append("<a href=\"http://localhost:7101/lance/res/sendMail/validateEmail?uid=");
            sb.append("lzm1507008");
            sb.append("&validateCode=");
            sb.append("12345678");
            sb.append("\">http://http://localhost:7101/lance/res/sendMail/validateEmail?uid=");
            sb.append("lzm1507008");
            sb.append("&validateCode=");
            sb.append("12345678");
            sb.append("</a>");
            message.setContent(sb.toString(), "text/html;charset=utf-8");
            // message.setText(sb.toString());
            message.setSubject("欢迎您注册驻才网，请激活您的驻才用户名");
            message.setFrom(addressFrom);
            message.addRecipient(Message.RecipientType.TO, addressTo);
            message.saveChanges();
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.163.com", PopupAuthenticator.mailuser, PopupAuthenticator.password);
            transport.send(message);
            transport.close();
            System.out.println("sent suc");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("sent fail");
        }
    }
}

class PopupAuthenticator extends Authenticator {
    public static final String mailuser = "zhucai_me"; //邮箱账号
    public static final String password = "******123"; //邮箱密码

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(mailuser, password);
    }
}
