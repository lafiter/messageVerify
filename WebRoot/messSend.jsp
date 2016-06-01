<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import = "com.chinasms.*" %>
<%@page import="com.chinasms.sms.Sender"%>



<html ><meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  <head >
   <title>短信发送</title>

  </head>
  
  <body>
  
   <form name="f1" method="post" action="" >
  <table align="center" width="75%" border="1">
    <tr> 
      <td bgcolor="#E9F0F6" width="24%"><div align="center">用户登陆名称 </div></td>
      <td width="76%"> <input name="name" type="text" size="30" id="name"> </td>
    </tr>
    <tr> 
      <td align="center" bgcolor="#E9F0F6" >用户登录密码 </td>
      <td><input name="pwd" type="password" size="10" id="pwd"></td>
    </tr>
    <tr> 
      <td align="center" bgcolor="#E9F0F6" >目标手机号</td>
      <td><input name="dst" type="text" size="80" id="dst"></td>
    </tr>
    <tr> 
      <td align="center" bgcolor="#E9F0F6" >发送短信内容</td>
      <td><textarea name="msg" cols="50" rows="5"></textarea></td>
      
    </tr>
    <tr> 
      <td align="center" bgcolor="#E9F0F6" >短信类型</td>
      <td><input name="txt" type="text" size="17" id="txt"></td>
    </tr>
    <tr> 
      <td align="center" bgcolor="#E9F0F6" >定时时间</td>
      <td><input name="time" type="text" size="17" id="time">
        <font color="#FF0000">（格式: YYYYMMDDHHMM）</font></td>
    </tr>
    <tr> 
      <td bgcolor="#E9F0F6"  align="center" colspan="2">
	    <input type="submit" name="send"  value="发送">
        <input type="reset" name="reset" value="重填">
	  </td>
    </tr>
  </table>
</form>

<%
response.setContentType("text/html");
request.setCharacterEncoding("UTF-8");
String   name=request.getParameter("name"); 
String pwd = request.getParameter("pwd");
String dst = request.getParameter("dst");
String msg = request.getParameter("msg");
String txt = request.getParameter("txt");
String time = request.getParameter("time");
String returnCode = null;

try {
if(name!=null&&name!=""&&pwd!=null&&pwd!=""){
	Sender sd=new Sender();
	returnCode = sd.massSend(dst, msg, time);
}
}
 catch (Exception e) {
    System.out.println("发送时错误信息为：" + e.getMessage());
}
out.println("返回码是：" + returnCode);
%>
  </body>
</html>
