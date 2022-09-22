package controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import controller.DB.DatabaseHandler;

public class WebController extends HttpServlet
{
	public static class User{
		private String login;
		private String password;

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public User() {
		}
	}

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  {
	  String url = request.getRequestURL().toString();
	  url = url.substring(url.lastIndexOf("/"));
	  if (url.equals("/test")) {
		  try {

			  HttpSession session = request.getSession(true);

			  User user = (User)session.getAttribute("user");

			  String login = request.getParameter("login");
			  String password = request.getParameter("password");

			  DatabaseHandler DH = new DatabaseHandler();

			  if (true){
				  user = new User();

				  user.setLogin((DH.getUser(login, password)));
				  user.setPassword(password);

				  session.setAttribute("user", user);
				  String view = "main";
				  request.getRequestDispatcher("/WEB-INF/views/" + view + ".jsp").forward(request, response);

			  }else {
				  String view = "index";
				  request.getRequestDispatcher(view + ".jsp").forward(request, response);
			  }

			  /*Object nn = session.getAttribute("n");
			  int n = 0;
			  if (nn != null) {
				  n = (Integer) nn;
			  }
			  n = n + 2;
			  session.setAttribute("n", n);


			  request.setAttribute("n", n);
			  String view = "main";
			  request.getRequestDispatcher("/WEB-INF/views/" + view + ".jsp").forward(request, response);

		  } catch (Exception ex) {
			  assert printWriter != null;
			  printWriter.println("Error: " + ex.getMessage());*/
		  }catch (Exception e) {
			 throw new RuntimeException(e);
		  }
	  }
  }
}