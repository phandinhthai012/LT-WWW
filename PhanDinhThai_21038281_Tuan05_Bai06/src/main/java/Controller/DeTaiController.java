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

import DAO.DetaiDAO;
import DAO.Impl.DeTaiImpl;
import entities.DeTai;
import entities.GiangVien;

/**
 * Servlet implementation class DeTaiController
 */
public class DeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/QuanLyGiangVienDeTai")
	private DataSource dataSource;
	
	private DetaiDAO detaiDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeTaiController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	detaiDAO = new DeTaiImpl(dataSource);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<GiangVien> list = detaiDAO.getALLGiangVien();
		List<DeTai> list1 = detaiDAO.getALLDeTai();
		request.setAttribute("DSDT", list1);
		request.setAttribute("DSGV", list);
		request.getRequestDispatcher("views/GVDT.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
