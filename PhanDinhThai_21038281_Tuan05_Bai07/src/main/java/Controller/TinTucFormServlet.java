package Controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

import Dao.DanhMucDao;
import Dao.DanhSachTinTucQuanLy;
import DaoImpl.DanhMucImp;
import DaoImpl.DanhSachTinTucQuanLyImpl;
import entities.DanhMuc;
import entities.TinTuc;

/**
 * Servlet implementation class TinTucFormServlet
 */
public class TinTucFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Resource(name = "jdbc/QuanLyTT")  
	private DataSource dataSource;
    private DanhMucDao danhMucDao;
    private DanhSachTinTucQuanLy danhSachTinTucQuanLy;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TinTucFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	danhMucDao = new DanhMucImp(dataSource);
    	danhSachTinTucQuanLy = new DanhSachTinTucQuanLyImpl(dataSource);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maTT = request.getParameter("maTT");
		String tieuDe = request.getParameter("tieuDe");
		String noiDungTT = request.getParameter("noiDungTT");
		String lienKet = request.getParameter("lienKet");
		String maDM = request.getParameter("maDM");
		System.out.println(maTT + " " + tieuDe + " " + noiDungTT + " " + lienKet + " " + maDM);
		DanhMuc danhMuc = danhMucDao.getDanhMucById(maDM);
		if (danhMuc == null) {
			String tenDanhMuc = request.getParameter("tenDM");
			String nguoiQuanLy = request.getParameter("nguoiQuanLy");
			String ghiChu = request.getParameter("ghiChu");
			danhMuc = new DanhMuc(maDM, tenDanhMuc, nguoiQuanLy, ghiChu);
			danhMucDao.addDanhMuc(danhMuc);
		}
		TinTuc tinTuc = new TinTuc(maTT, tieuDe, noiDungTT, lienKet, maDM);
		danhSachTinTucQuanLy.themTinTuc(tinTuc);
		response.sendRedirect("DanhSachTinTucServlet");
	}

}
