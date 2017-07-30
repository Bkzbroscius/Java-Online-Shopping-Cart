package com.mindteck.controller;

import java.io.*;
import java.sql.*;
import org.json.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

import com.mindteck.dao.UserDAO;
import com.mindteck.model.User;
import com.mindteck.service.UserService;
import com.mindteck.service.UserServiceImpl;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	/*
	 * This function receives input from the user using the doGet Method. It
	 * gets the user action The actions are delete, edit and listUser. If the
	 * action is delete, the user is deleted by username. If the action is edit
	 * the function gets the user by id. The request attribute is set to update
	 * and the request is forwarded to User.jsp
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			String userId = request.getParameter("username");
			try {
				service.removeUser(userId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				request.setAttribute("users", service.returnAllUsers());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher req = request.getRequestDispatcher("listUser.jsp");
			req.forward(request, response);
		}

		else if (action.equalsIgnoreCase("edit")) {
			User user;
			try {
				user = service.returnUserById(request.getParameter("userId"));
				request.setAttribute("user", user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("label", "Update User");
			RequestDispatcher req = request.getRequestDispatcher("User.jsp");
			req.forward(request, response);
		} else if (action.equalsIgnoreCase("listUser")) {
			try {
				request.setAttribute("users", service.returnAllUsers());
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher req = request.getRequestDispatcher("listUser.jsp");
			req.forward(request, response);
		} else {
			String userId = request.getParameter("userId");
			request.setAttribute("label", "Add User");
			RequestDispatcher req = request.getRequestDispatcher("user.jsp");
			req.forward(request, response);
		}

	}

	/*
	 * This function gets requests sent from register.jsp and login.jsp and
	 * processes them. It checks if the username is already in use before
	 * registering user. If the username is available it adds registration
	 * information to the users table and sends user back to registrer.jsp.
	 * Otherwise, an error message is sent back to the user. If the user is
	 * logged in, the session attribute is set to loggedIn, otherwise if the
	 * username is invalid, an error message is given.
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		User user = new User();
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		System.out.println(action);
		HttpSession session = request.getSession();

		if (action.equals("register")) {
			try {
				String pass = request.getParameter("pass");

				String fname = request.getParameter("firstName");
				String lname = request.getParameter("lastName");
				String email = request.getParameter("email");
				String userid = request.getParameter("username");

				System.out.println(userid);
				if (pass == null || fname == null || email == null || lname == null || userid == null || pass.equals("")
						|| fname.equals("") || email.equals("") || lname.equals("") || userid.equals("")) {
					request.setAttribute("message", "Please provide valid data");
					RequestDispatcher req = request.getRequestDispatcher("register.jsp");
					req.forward(request, response);
				} else {
					user.setFirstName(fname);
					user.setLastName(lname);
					user.setEmail(email);
					user.setPassword(pass);
					user.setUserid(userid);

					if (!(service.isLoggedInOrNot(userid, email))) {
						service.insertUser(user);
						RequestDispatcher view = request.getRequestDispatcher("registrationConfirm.jsp");
						request.setAttribute("users", service.returnAllUsers());
						view.forward(request, response);
					} else {
						request.setAttribute("message", "Username already exists. Choose a different username or email.");
						RequestDispatcher req = request.getRequestDispatcher("register.jsp");
						req.include(request, response);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (action.equals("login")) {
			System.out.println("action is login.");
			String pass = request.getParameter("pass");
			String userid = request.getParameter("username");
			System.out.println("Inside logged in username is " + userid);
			session.setAttribute("username", userid);
			session.setAttribute("pass", pass);
			try {
				if (userid == null || pass == null || userid.equals("") || pass.equals("")) {
					request.setAttribute("message", "Please enter a user name or password");
					RequestDispatcher req = request.getRequestDispatcher("login.jsp");
					req.forward(request, response);
				} else {
					if (service.authenticateUser(userid, pass) == true) {
						session.setAttribute("loggedIn", request.getParameter("username"));
						session.setAttribute("users", service.returnAllUsers());
						RequestDispatcher req = request.getRequestDispatcher("home.jsp");
						req.forward(request, response);
					} else {
						request.setAttribute("message", "Invalid username or password");
						RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
						rd.include(request, response);

					}
				}
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
	}
}
