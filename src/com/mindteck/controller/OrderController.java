package com.mindteck.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindteck.dao.OrderDAO;
import com.mindteck.dao.OrderDAOImpl;
import com.mindteck.model.CartItem;
import com.mindteck.model.Order;
import com.mindteck.model.User;

/* Controller class for customer orders */
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDAO dao = new OrderDAOImpl();
		HttpSession session = request.getSession(true);
		String username = "";
		Order order = new Order();
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("confirmOrder")) {
			System.out.println("inside place order");

			PrintWriter out = response.getWriter();
			List<CartItem> li = new ArrayList<CartItem>();

			/* get a list of the items in cart */
			li = dao.getCartItems((String) session.getAttribute("loggedIn"));
			Date orderDate = new java.util.Date();

			/*
			 * check if user is logged in. If not direct to login.jsp else get
			 * list details for order
			 */
			if (session.getAttribute("loggedIn") == null) {
				out.println("You must log in to check out");
				request.setAttribute("username", request.getParameter("username"));
				RequestDispatcher req = request.getRequestDispatcher("login.jsp");
				req.include(request, response);
				req.forward(request, response);
			} else {
				for (CartItem i : li) {
					int orderId = i.getOrderId();
					System.out.println(orderId);
					double price = i.getPrice();
					int num = (int) (Math.random() * 100);
					String orderNumber = "order" + num;

					username = (String) session.getAttribute("loggedIn");
					System.out.println("Username is " + username);
					double amount = (Double) session.getAttribute("total");
					System.out.println("Amount: " + amount);
					// double money = Double.parseDouble(amount);
					order.setOrderAmount(amount);
					System.out.println("The money is " + amount);
					order.setOrderNumber(orderNumber);
					order.setOrderId(orderId);
					order.setOrderDate(orderDate);

				}
				User user = new User();
				System.out.println("The username is " + username);
				/*
				 * Get customer information given his username
				 */
				user = dao.getUserByUsername(username);
				order.setFirstname(user.getFirstName());
				System.out.println("Firstname is " + user.getFirstName());
				order.setLastname(user.getLastName());
				order.setEmail(user.getEmail());
				order.setPhone("111-111-1111");
				System.out.println("The order email " + order.getEmail());

				/* place the order */
				if (order.getEmail() != null && order.getFirstname() != null) {
					dao.placeOrder(order);
				} else  {
					request.setAttribute("msg", "You must add to cart to place your order.");
					RequestDispatcher req = request.getRequestDispatcher("home.jsp");
					req.forward(request, response);
				
				}
				/* delete the cart */
				dao.clearCart(username);
				RequestDispatcher req = request.getRequestDispatcher("orderConfirm.jsp");
				req.forward(request, response);
			}

		} else if (action.equalsIgnoreCase("viewOrderHistory")) {
			List<Order> orderList = new ArrayList<Order>();

			User user = new User();
			String email;
			/*
			 * Check if user is logged in. If not logged in forward user to
			 * login page
			 */
			if (session.getAttribute("loggedIn") == null) {
				request.setAttribute("message", "You must login first.");
				RequestDispatcher req = request.getRequestDispatcher("login.jsp");
				req.forward(request, response);
			} else {
				System.out.println(session.getAttribute("loggedIn"));

				/* get user with matching username */
				user = dao.getUserByUsername((String) session.getAttribute("loggedIn"));
				email = user.getEmail();
				System.out.println("The user email is " + email);

				/* Get user with matching email to display order history */
				orderList = dao.getOrderByEmail(email);
				for (Order orders : orderList) {
					System.out.println("Order Number" + orders.getOrderNumber());
					System.out.println(orders.getOrderDate());
				}

				// CartItem cartItem = new CartItem();
				request.setAttribute("orderList", dao.getOrderByEmail(email));
				RequestDispatcher req = request.getRequestDispatcher("orderHistory.jsp");
				req.forward(request, response);

			} // end else

		} // end if

		/* Choose this action to view the order */
		else if (action.equalsIgnoreCase("ViewOrder")) {
			RequestDispatcher req = request.getRequestDispatcher("listOrder.jsp");
			req.forward(request, response);
		} // end if
		else if (action.equalsIgnoreCase("orderNow")) {
			if (session.getAttribute("loggedIn") == null) {
				request.setAttribute("message", "You must login first.");
				RequestDispatcher req = request.getRequestDispatcher("login.jsp");
				req.forward(request, response);
			} else {
				RequestDispatcher req = request.getRequestDispatcher("checkout.jsp");
				req.forward(request, response);
			}
		}

	} // end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * Receives customer shipping details from checkput.jsp. Gets cart items
		 * information from the database and forwards the information to
		 * reviewOrder.jsp
		 */
		double price = 0.0;
		HttpSession session = request.getSession(true);
		OrderDAO dao = new OrderDAOImpl();
		String action = request.getParameter("action");
		String shippingMethod = request.getParameter("method");
		if (shippingMethod.equals("regular")) {
			price = 4.00;
		} else if (shippingMethod.equals("express")) {
			price = 20.00;
		} else if (shippingMethod.equals("")) {
			price = 0.00;
		}
		session.setAttribute("shippingAmount", price);
		if (action.equalsIgnoreCase("checkout")) {

			List<CartItem> li = new ArrayList<CartItem>();
			li = dao.getCartItems((String) session.getAttribute("loggedIn"));
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");
			request.setAttribute("li", li);
			RequestDispatcher req = request.getRequestDispatcher("reviewOrder.jsp");
			req.forward(request, response);
		}
	}
}
