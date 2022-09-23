<%@ page language="java" contentType="text/html; charset=Windows-1251" pageEncoding="Windows-1251" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=Windows-1251">
    <title>Main page</title>
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
</head>

 <body class="main">
  <form method="post" action="test">
      <div>
          <table class="table_dark", align="center">
              <tr>
                  <th>Номер</th>
                  <th>Название</th>
                  <th>Цена</th>
              </tr>
              <tr>
                  <td>1</td>
                  <td>
                      <%@ page import = "controller.WebController.User" %>
                      <%User user = (User) session.getAttribute("user");%>
                      <%=user.getLogin()%></td>

                  <td><%=user.getPassword()%></td>

              </tr>
              <tr>
                  <td>2</td>
                  <td>Яблоко</td>
                  <td>40.63</td>
              </tr>
          </table>
          <tr>
          <td><input type="submit" value="Удалить", align="left", class="bt2"></td>
              <td><input type="submit" value="Добавить", align="right", class="bt"></td>
          </tr>
      </div>
  </form>
 </body>

</html>