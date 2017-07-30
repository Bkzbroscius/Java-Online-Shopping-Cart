package com.mindteck.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindteck.dao.ProductDAO;
import com.mindteck.model.Product;


public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO dao;

	public ProductController() {
		super();
		dao = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String forward = "";
		String action = request.getParameter("action");
		try {
		if (action.equalsIgnoreCase("delete")) {
			int productId = Integer.parseInt(request.getParameter("productId"));
			dao.deleteProduct(productId);
			forward = "/listProduct.jsp";
			request.setAttribute("products", dao.getAllProducts());
		} else if (action.equalsIgnoreCase("find")) {
			forward = "/forward.jsp";
			int productId = Integer.parseInt(request.getParameter("productId"));
			System.out.println("The product id is " + productId);
			Product product = dao.getProductById(productId);
			System.out.println("product afterfunction call is " + product.getId());
			session.setAttribute("product", product);
//			session.setAttribute("productId", product.getId());
//			session.setAttribute("description", product.getDescription());
//			session.setAttribute("price", product.getPrice());
			//request.setAttribute("label", "Update Product");
		} else if (action.equalsIgnoreCase("listProduct")) {
			forward = "/listProduct.jsp";
			request.setAttribute("products", dao.getAllProducts());
		} else {
			request.setAttribute("label", "Add Product");
			forward = "/product.jsp";
		}
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Product();

		product.setDescription(request.getParameter("description"));
		//product.setPrice(Double.parseDouble(request.getParameter("price")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		String productId = request.getParameter("id");
		if (productId == null || productId.isEmpty()) {
			dao.addProduct(product);
		} else {
			int id = Integer.parseInt(productId);
			product.setId(id);
			dao.updateProduct(product);
		}

	

		RequestDispatcher view = request.getRequestDispatcher("/listProduct.jsp");
		request.setAttribute("products", dao.getAllProducts());
		view.forward(request, response);
		
		
	}
}
