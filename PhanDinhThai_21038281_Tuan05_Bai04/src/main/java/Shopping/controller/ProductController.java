package Shopping.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

import Shopping.DAO.ProductDAO;
import Shopping.DAOImpl.ProductDAOImpl;
import Shopping.entities.Product;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/shopping")
	private DataSource dataSource;
	private ProductDAO productDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();

	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		productDAO = new ProductDAOImpl(dataSource);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Product p1 = new Product("Iphone 12", 120000, "ip1.jpg");
//		productDAO.add(p1);
//		Product p2 = new Product("Iphone XR", 110000, "ip2.jpg");
//		productDAO.add(p2);
//		Product p3 = new Product("Iphone 11", 100000, "ip3.jpg");
//		productDAO.add(p3);
//		Product p4 = new Product("Oppo", 90000, "opp1.jpg");
//		productDAO.add(p4);
//		Product p5 = new Product("Samsung", 800000, "ss1.jpg");
//		productDAO.add(p5);
//		Product p6 = new Product("Samsung note", 700000, "ss7.jpg");
//		productDAO.add(p6);
//		Product p7 = new Product("Samsung A", 600000, "ss2.jpg");
//		productDAO.add(p7);
//		Product p8 = new Product("Vsmart", 500000, "vsm1.jpg");
//		productDAO.add(p8);
//		Product p9 = new Product("Vsmart 2", 400000, "vsm2.jpg");
//		productDAO.add(p9);
		
		request.setAttribute("listProduct", productDAO.getAll());
		request.getRequestDispatcher("views/product/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
