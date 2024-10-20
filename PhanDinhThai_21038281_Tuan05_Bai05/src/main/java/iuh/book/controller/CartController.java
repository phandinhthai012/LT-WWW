package iuh.book.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import iuh.book.Dao.BookDao;
import iuh.book.Dao.impl.BookDaoImpl;
import iuh.book.entities.CartItem;

/**
 * Servlet implementation class CartController
 */
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/Book")
	private DataSource dataSource;
	private BookDao bookDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		bookDao = new BookDaoImpl(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		System.out.println("action: " + action);
		switch (action) {
			case "add": {
				addBookCart(request, response);
				break;
			}
			case "remove": {
				RemoveBookCart(request, response);
				break;
			}
			case "checkout": {
				doGetCheckOut(request, response);
				break;
			}
			default: {
				showCart(request, response);
				break;
			}
		}
	}

	private void showCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/viewCart/XuLyMuaHang.jsp").forward(request, response);

	}

	protected void RemoveBookCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<CartItem> list = session.getAttribute("cart") == null ? null
				: (List<CartItem>) session.getAttribute("cart");
		int id = Integer.parseInt(request.getParameter("id"));
		int index = checkIndex(id, list);
		list.remove(index);
		session.setAttribute("cart", list);
		response.sendRedirect("CartController");
	}

	protected void addBookCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<CartItem> list = null;
		if (session.getAttribute("cart") == null) {
			list = new ArrayList<CartItem>();
		} else {
			list = (List<CartItem>) session.getAttribute("cart");
		}
		System.out.println("list: " + list);
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id: " + id);
		int index = checkIndex(id, list);
		System.out.println(index);
		if (index == -1) {
			CartItem item = new CartItem(bookDao.getBookByID(id), 1);
			list.add(item);
		} else {
			int quantity = list.get(index).getQuantityCart() + 1;
			list.get(index).setQuantityCart(quantity);
		}
		session.setAttribute("cart", list);
		response.sendRedirect("CartController");
	}
	
	private void doGetCheckOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<CartItem> list = session.getAttribute("cart") == null ? null
                : (List<CartItem>) session.getAttribute("cart");
		if (list == null) {
			response.sendRedirect("CartController");
			return;
		}
		double total = 0;
		for (CartItem item : list) {
			total += item.getBook().getPrice() * item.getQuantityCart();
		}
		int size = list.size();
		session.setAttribute("cart", list);
		request.setAttribute("total", total);
		request.setAttribute("size", size);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/viewCart/XuLiThanhToan.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private int checkIndex(int id, List<CartItem> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBook().getId() == id) {
				return i;
			}
		}
		return -1;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
