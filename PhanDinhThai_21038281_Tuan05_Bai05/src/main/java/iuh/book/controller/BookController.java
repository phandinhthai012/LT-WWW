package iuh.book.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

import iuh.book.Dao.BookDao;
import iuh.book.Dao.impl.BookDaoImpl;
import iuh.book.entities.Book;

/**
 * Servlet implementation class BookController
 */
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/Book")
	private DataSource dataSource;
	private BookDao bookDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookController() {
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
		/*
		Book b1 = new Book("Java", "Oracle", 100, 10, "Java is a programming language", "java.jpg");
		bookDao.addBook(b1);
		Book b2 = new Book("Số tay viết văn", "Tô Hoài", 99000, 10,
				"Là một đứa con tinh thần do chính Tô Hoài chắt chiu, gom góp từ những kinh nghiệm viết lách của mình",
				"soTay.jpg");
		bookDao.addBook(b2);
		Book b3 = new Book("Nhật ký ma cà rồng 03", "L. J. Smith", 48000, 10,
				"Elena đã biến đổi, cô đã trở thành một người mà đã có lúc cô vừa sợ hãi, vừa khao khát.",
				"nhatKi.jpg");
		bookDao.addBook(b3);
		Book b4 = new Book("Bí mật tư duy triệu phú", "T. Harv Eker", 99000, 10,
				"Bí mật tư duy triệu phú là cuốn sách giúp bạn hiểu rõ hơn về tư duy của mình, giúp bạn thay đổi tư duy để trở thành một triệu phú.",
				"biMat.jpg");
		bookDao.addBook(b4);
		Book b5 = new Book("Bily va Beth", "Jim Randel", 52000, 10,
				"Thông qua quyển sách này, chúng tôi sẽ chỉ rõ những bước mà chúng tôi tin rằng sẽ tăng khả năng bạn đạt được điều mà bạn mong muốn",
				"bb.jpg");
        bookDao.addBook(b5);
		Book b6 = new Book("Kẻ trộm sách", "Markus Zusak", 71000, 10,
				"ẻ trộm sách khi mới ra đời đã lập tức gây ngạc nhiên cho những cây bút phê bình văn học trên thế giới và làm hàng triệu cặp mắt phải nhòa lệ",
				"ke_trom_sach_1.jpg");
		bookDao.addBook(b6);
		Book b7 = new Book("Cơm & phở", "Xuân Sách", 120000, 10,"Mượn chuyện xưa để nói chuyện nay qua 188 tiểu phẩm hài hước mà sâu cay","com.jpg");
		bookDao.addBook(b7);
		Book b8 = new Book("Dấu chân trên cát", "Nguyễn Ngọc Thạch", 50000, 10,"Dấu chân trên cát là một tác phẩm văn học nổi tiếng của nhà văn Nguyễn Ngọc Thạch","dauChan.jpg");
		bookDao.addBook(b8);
		Book b9 = new Book("Hoa sen trên tuyết", "Nguyễn Ngọc Thạch", 50000, 10,"Hoa sen trên tuyết là một tác phẩm văn học nổi tiếng của nhà văn Nguyễn Ngọc Thạch","hoaSen.jpg");
		bookDao.addBook(b9);*/
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		if (action.equals("detail")) {
			String id = request.getParameter("id");
			Book book = bookDao.getBookByID(Integer.parseInt(id));
			request.setAttribute("book", book);
			request.getRequestDispatcher("views/viewBook/ChiTietSP.jsp").forward(request, response);
		}else {
			request.setAttribute("listBook", bookDao.getAllBook());
			request.getRequestDispatcher("views/viewBook/DanhSachSP.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
