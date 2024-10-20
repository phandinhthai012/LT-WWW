package springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entities.SinhVien;

@Controller
@RequestMapping("/sinhvien")
public class SinhVienController {
	List<SinhVien> list;
	int count = 6;
	
	public SinhVienController() {
		list = new ArrayList<SinhVien>();
		list.add(new SinhVien(1, "Nguyen", "Van A", 8.5f));
		list.add(new SinhVien(2, "Tran", "Thi B", 7.5f));
		list.add(new SinhVien(3, "Le", "Van C", 6.5f));
		list.add(new SinhVien(4, "Pham", "Thi D", 5.5f));
		list.add(new SinhVien(5, "Hoang", "Van E", 4.5f));
		list.add(new SinhVien(6, "Nguyen", "Thi F", 3.5f));
	}
	@RequestMapping("/sinhvienform")
	public ModelAndView showForm() {
		return new ModelAndView("sinhvienform", "command", new SinhVien());
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("sinhvien") SinhVien sv) {
		int id = count++;
		String fname = sv.getFname();
		String lname = sv.getLname();
		float diemtb = sv.getDiemtb();
		list.add(new SinhVien(id, fname, lname, diemtb));
		return new ModelAndView("viewsinhvien", "list", list);
	}
	
	@RequestMapping("/viewsinhvien")
	public ModelAndView viewSinhVien() {
		return new ModelAndView("viewsinhvien", "list", list);
	}
}
