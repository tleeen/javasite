<%@ page language="java" contentType="text/html; charset=Windows-1251" pageEncoding="Windows-1251" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=Windows-1251">
 <title>Start page</title>
 <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
</head>
<body>
<div id="login">
 <form  method="post" action="test">
  <fieldset class="clearfix">
   <p><span class="fontawesome-user"></span><label>
    <input name="login" type="text" value="�����" onBlur="if(this.value == '') this.value = '�����'" onFocus="if(this.value == '�����') this.value = ''" required>
   </label></p>
   <p><span class="fontawesome-lock"></span><label>
    <input name="password" type="password"  value="������" onBlur="if(this.value == '') this.value = '������'" onFocus="if(this.value == '������') this.value = ''" required>
   </label></p>
   <p><input type="submit" value="�����"></p>
  </fieldset>
 </form>
</div>
</body>
</html>