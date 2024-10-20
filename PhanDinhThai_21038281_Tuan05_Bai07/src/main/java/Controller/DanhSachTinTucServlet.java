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

import Dao.DanhMucDao;
import Dao.DanhSachTinTucQuanLy;
import DaoImpl.DanhMucImp;
import DaoImpl.DanhSachTinTucQuanLyImpl;
import entities.DanhMuc;
import entities.TinTuc;

/**
 * Servlet implementation class DanhSachTinTucServlet
 */
public class DanhSachTinTucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/QuanLyTT")
	private DataSource dataSource;
	private DanhSachTinTucQuanLy danhSachTinTucQuanLy;
	private DanhMucDao danhMucDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachTinTucServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		danhSachTinTucQuanLy = new DanhSachTinTucQuanLyImpl(dataSource);
		danhMucDao = new DanhMucImp(dataSource);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<DanhMuc> danhMucs = danhMucDao.getAllDanhMuc();
		List<TinTuc> tinTucs = danhSachTinTucQuanLy.getALLTinTuc();
		for (TinTuc tinTuc : tinTucs) {
			System.out.println(tinTuc.getTieuDe());
		}
		for (DanhMuc danhMuc : danhMucs) {
			System.out.println(danhMuc.getMaDM());
		}
		request.setAttribute("danhMuc", danhMucs);
		request.setAttribute("tinTuc", tinTucs);
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("Views/body/DanhSachTinTuc.jsp").forward(request, response);

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
