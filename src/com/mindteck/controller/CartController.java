package com.mindteck.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindteck.model.CartItem;
import com.mindteck.model.Product;
import com.mindteck.service.CartService;
import com.mindteck.service.CartServiceImpl;

/* Controller class for the shopping cart */
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private CartItemDAOImpl dao;

	public CartController() {
		super();

	}

	/*
	 * The doGet method has the actions "delete", "listcartItem", and
	 * "addToCart"
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CartService service = new CartServiceImpl();
		HttpSession session = request.getSession(true);
		
		// UserService userService = new UserServiceImpl();
		// dao = new CartItemDAOImpl();
		String action = request.getParameter("action");
		try {

			/* Delete cart item with a given id */
			if (action.equalsIgnoreCase("delete")) {
				int cartItemId = Integer.parseInt(request.getParameter("id"));
				service.removeFromCart(cartItemId);
				String username = (String) session.getAttribute("loggedIn");
				request.setAttribute("cart", service.listCartItemsByUsername(username));
				RequestDispatcher req = request.getRequestDispatcher("listCart.jsp");
				req.forward(request, response);

				/* Display items in the cart on the listCart.jsp page */
			} else if (action.equalsIgnoreCase("listCartItem")) {
				String username = (String) session.getAttribute("loggedIn");
				//String pass = (String) session.getAttribute("pass");
				// if (service.authenticateUser(username, pass) == true)
				// if (username == null || username.equals("") || pass == null
				// || pass.equals("")) {
				if (session.getAttribute("loggedIn") == null) {
					request.setAttribute("message", "You must login first.");
					RequestDispatcher req = request.getRequestDispatcher("login.jsp");
					req.forward(request, response);
				} else {
					List<CartItem> li = service.listCartItemsByUsername(username);
					double total = 0;
					for (CartItem item: li) {
						total = total + item.getPrice();
					}
					System.out.println("The total is " + total);
					session.setAttribute("total", total);
					request.setAttribute("cart", service.listCartItemsByUsername(username));
					RequestDispatcher view = request.getRequestDispatcher("listCart.jsp");
					view.forward(request, response);
				}
			}

			/*
			 * Add products to the cart if action is equal to "add to cart" and
			 * forward the response to the home page
			 */
			else if (action.equalsIgnoreCase("addToCart")) {

				System.out.println("inside add to cart");
				if (session.getAttribute("loggedIn") == null) {
					request.setAttribute("message", "You must login to begin shopping.");
					RequestDispatcher req = request.getRequestDispatcher("login.jsp");
					req.forward(request, response);
				} else {
				CartItem cartItem = new CartItem();
				// HttpSession sess = request.getSession();
				String username = (String) session.getAttribute("loggedIn");
				System.out.println("The username is " + username);
				cartItem.setUsername(username);
				String quantity = request.getParameter("quantity");
				Product prod = (Product)session.getAttribute("product");
//				System.out.println("The quanity is  " + quantity);
//				cartItem.setDescription(request.getParameter("description"));
//				cartItem.setPrice(Double.parseDouble(request.getParameter("price")));
				//Product prod = (Product) session.getAttribute("product");
				//String desc = (String) session.getAttribute("description");
				System.out.println("In cart price is  " + prod.getPrice());
				System.out.println("In cart descrition is  " + prod.getDescription());
				cartItem.setPrice(prod.getPrice());
				cartItem.setProductId(prod.getId());
				cartItem.setQuantity(prod.getQuantity());
				cartItem.setDescription(prod.getDescription());
				if (quantity.equals("")) {
					cartItem.setQuantity(1);
				} else {
					cartItem.setQuantity(Integer.parseInt(quantity));
				}
			
				cartItem.setOrderId((int) Math.round(Math.random() * 1000));
				System.out.println("Quantity is " + request.getParameter("quantity"));
				service.insertIntoCart(cartItem);
				request.setAttribute("cartItem", cartItem);
				RequestDispatcher req = request.getRequestDispatcher("home.jsp");
				req.forward(request, response);
			}
		  }
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
