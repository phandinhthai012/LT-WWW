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
import java.util.List;

import javax.sql.DataSource;

import iuh.book.Dao.ReceiptDao;
import iuh.book.Dao.impl.ReceiptDaoImpl;
import iuh.book.entities.CartItem;
import iuh.book.entities.Receipt;

/**
 * Servlet implementation class ReceiptController
 */
public class ReceiptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/Book")
	private DataSource dataSource;
	private ReceiptDao receiptDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	receiptDao = new ReceiptDaoImpl(dataSource);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<CartItem> listCart = (List<CartItem>) session.getAttribute("cart");
		String name = request.getParameter("fullname");
		String address = request.getParameter("address");
		String total = request.getParameter("total");
		String PaymentMethod = request.getParameter("payment");
		String listID = request.getParameter("listID");
		listID = listID.substring(0, listID.length() - 1);
		System.out.println("name: " + listID);
		Receipt receipt = new Receipt(name, address, Double.parseDouble(total), PaymentMethod, listID);
		receiptDao.addReceipt(receipt);
		listCart = null;
		session.removeAttribute("cart");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
