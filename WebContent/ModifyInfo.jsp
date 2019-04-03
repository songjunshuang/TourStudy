<%@ page contentType="text/html; charset=utf-8" %>
<%@ page session="true" %>
<%
String adminid = (String)session.getAttribute("adminid");//从session中获得用户名
if ( adminid == null || adminid.equals("") ){
response.sendRedirect("login.jsp?msg=nologin");
}%>

<%@ page import="org.pan.web.admin.Admin"%>
<jsp:useBean id="adminmn" scope="page" class="org.pan.web.adminmn" />
<%
String mesg = "";

String submit = (String)request.getParameter("submit");
if (submit!=null && !submit.equals("")){
if(adminmn.update(request)){ //调用update进行更新
mesg = "用户资料修改成功！";
}else {
mesg = "对不起，你提交的参数有错误!" +  adminmn.getMessage();;
}
}
%>
<html>
<head>
<title>修改管理员个人信息</title>
<script>

function checkform() {
if (document.form1.adminid.value==""){
alert("用户名不能为空");
document.form1.adminid.focus();
return false;
}
if (document.form1.passwd.value==""){
alert("用户密码不能为空");
document.form1.passwd.focus();
return false;
}
if (document.form1.passwd.value!=document.form1.passconfirm.value){
alert("确认密码不相符！");
document.form1.passconfirm.focus();
return false;
}

return true;
}

</script>
</head>

<body bgcolor="#BAD9FA" text="#000000">
<div align="center"><br>
  <table width="750" border="0" cellspacing="1" cellpadding="1">
    <tr valign="top">
      <td width="186" align="center">
        <table width="100%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td colspan="2"><a href="admininfo.jsp"></a><a href="modimy.jsp"></a></td>
          </tr>
        </table>
                <p>&nbsp;</p>
      </td>
      <td align="center"> <br>修改我的个人信息<br>
         <% if (!mesg.equals("")){
out.println("<br><font color=red>"+ mesg +"</font><br><br>");
} else {

%>
<FORM name="form1" METHOD=POST ACTION="modimy.jsp">
<table width="95%" border="1" cellspacing="1" cellpadding="1" bordercolor="#2DAE2D">

  <tr><td align=right width=100>用户名</td>
    <td><%= adminmn.getAdminID() %>
  <input type="hidden" name=adminid" maxlength="20" size="14" value="<%= adminmn.getAdminID() %>" ></td></tr>
  <tr><td align=right width=100>用户密码:</td>
<td><input type="password" name="passwd" maxlength="20" size="14" value="<%= adminmn.getPassWord() %>" ></td></tr>
  <tr><td align=right width=100>确认密码:</td>
<td><input type="password" name="passconfirm" maxlength="20" size="14" value="<%= adminmn.getPassWord() %>" ></td></tr>
  <tr><td align=right width=100>用户真名</td>
<td> <input type="text" name="adminname" maxlength="20" size="14" value="<%= adminmn.getAdminName() %>" ></td></tr>
  <tr><td align=right width=100>性别</td>
    <td><select name="sex">
            <option <% if (adminmn.getSex().equals("男")) out.print("selected"); %> >男</option>
            <option <% if (adminmn.getSex().equals("女")) out.print("selected"); %> >女</option>
          </select>
</td></tr>
  <tr><td align=right width=100>联系地址</td>
<td><input type="text" name="address" maxlength="150" size="40" value="<%= adminmn.getAddress() %>" ></td></tr>
  <tr><td align=right width=100>联系电话</td>
<td><input type="text" name="phone" maxlength="25" size="16" value="<%= adminmn.getPhone() %>" ></td></tr>
  <tr><td align=right width=100>邮编</td>
<td><input type="text" name="post" maxlength="8" size="8" value="<%= adminmn.getPost() %>" ></td></tr>
  <tr><td align=right width=100>电子邮件</td>
<td><input type="text" name="email" maxlength="50" size="25" value="<%= adminmn.getEmail() %>" ></td></tr>
  <tr><td align=right width=100>&nbsp;</td>
<td><INPUT TYPE="hidden" name="adminid" value="<%= adminmn.getAdminID() %>">
<INPUT TYPE="submit" name="submit" value="修改" onClick="return(checkform());">
<INPUT TYPE="reset" name="reset" value="取消"></td></tr>
</FORM>
  </table>
  <br>
<%}%>
        <p>&nbsp;</p>
        </td>
    </tr>
  </table>
</div>
</body>
</html>