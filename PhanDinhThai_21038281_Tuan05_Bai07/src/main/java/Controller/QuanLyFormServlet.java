package Controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import Dao.DanhSachTinTucQuanLy;
import DaoImpl.DanhSachTinTucQuanLyImpl;
import entities.TinTuc;

/**
 * Servlet implementation class QuanLyFormServlet
 */
public class QuanLyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/QuanLyTT")
	private DataSource dataSource;
	private DanhSachTinTucQuanLy danhSachTinTucQuanLy;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuanLyFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		danhSachTinTucQuanLy = new DanhSachTinTucQuanLyImpl(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		switch (action) {
		case "re": {
			String maTT = request.getParameter("maTT");
			danhSachTinTucQuanLy.xoaTinTuc(maTT);
			response.sendRedirect("QuanLyFormServlet");
			break;
		}
		default:
			List<TinTuc> list = danhSachTinTucQuanLy.getALLTinTuc();
			request.setAttribute("tinTuc", list);
			request.getRequestDispatcher("Views/body/QuanLyForm.jsp").forward(request, response);
			break;
		}
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
