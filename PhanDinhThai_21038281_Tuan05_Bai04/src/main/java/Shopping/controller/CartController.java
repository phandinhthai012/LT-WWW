package Shopping.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Shopping.DAO.ProductDAO;
import Shopping.DAOImpl.ProductDAOImpl;
import Shopping.entities.ItemCart;
import Shopping.entities.Product;

/**
 * Servlet implementation class CartController
 */
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/shopping")
	private DataSource dataSource;
	private ProductDAO productDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		productDAO = new ProductDAOImpl(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		case "add": {
			doGetAddCart(request, response);
			break;
		}
		case "remove": {
			doGetRemoveItem(request, response);
			break;
		}
		default:
			doGetDisPlayCart(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

	private void doGetDisPlayCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/cart/index.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	private void doGetAddCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<ItemCart> cart = null;
		int id = Integer.parseInt(request.getParameter("id"));
		if (session.getAttribute("cart") == null) {
			cart = new ArrayList<ItemCart>();
		} else {
			cart = (List<ItemCart>) session.getAttribute("cart");
			System.out.println("cart: " + cart);
		}
		int index = checkkExist(id, cart);
		System.out.println("index: " + index + " id: " + id);
		if (index == -1) {
			Product product = productDAO.getByID(id);
			System.out.println("product: " + product);
			ItemCart itemCart = new ItemCart(product, 1);
			cart.add(itemCart);
		} else {
			int quantity = cart.get(index).getQuantity() + 1;
			cart.get(index).setQuantity(quantity);
		}
		session.setAttribute("cart", cart);
		response.sendRedirect("CartController");

	}

	@SuppressWarnings("unchecked")
	private void doGetRemoveItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<ItemCart> cart = (List<ItemCart>) session.getAttribute("cart");
		int id = Integer.parseInt(request.getParameter("id"));
		cart.remove(checkkExist(id, cart));
		session.setAttribute("cart", cart);
		response.sendRedirect("CartController");

	}
	private int checkkExist(int id, List<ItemCart> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}

}
