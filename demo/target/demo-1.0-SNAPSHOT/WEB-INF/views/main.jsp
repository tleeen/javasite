<%@ page language="java" contentType="text/html; charset=Windows-1251" pageEncoding="Windows-1251" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=Windows-1251">
    <title>Main page</title>
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
</head>

 <body>
  <form method="post" action="test">
      <div>
          <table class="table_dark">
              <tr>
                  <th>Company</th>
                  <th>Q1</th>
                  <th>Q2</th>
                  <th>Q3</th>
                  <th>Q4</th>
              </tr>
              <tr>
                  <td>Microsoft</td>
                  <td>
                      <%@ page import = "controller.WebController.User" %>
                      <%User user = (User) session.getAttribute("user");%>
                      <%=user.getLogin()%></td>

                  <td><%=user.getPassword()%></td>
                  <td>23.5</td>
                  <td>40.3</td>
              </tr>
              <tr>
                  <td>Google</td>
                  <td>50.2</td>
                  <td>40.63</td>
                  <td>45.23</td>
                  <td>39.3</td>
              </tr>
              <tr>
                  <td>Apple</td>
                  <td>25.4</td>
                  <td>30.2</td>
                  <td>33.3</td>
                  <td>36.7</td>
              </tr>
              <tr>
                  <td>IBM</td>
                  <td>20.4</td>
                  <td>15.6</td>
                  <td>22.3</td>
                  <td>29.3</td>
              </tr>
          </table>
     <input type="submit" value="Refresh"></td>
      </div>
  </form>
 </body>

</html>