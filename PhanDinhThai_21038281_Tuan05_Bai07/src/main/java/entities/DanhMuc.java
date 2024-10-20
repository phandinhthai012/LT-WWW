package entities;

public class DanhMuc {
	private String maDM;
	private String tenDanhMuc;
	private String nguoiQuanLy;
	private String ghiChu;
	
	public DanhMuc() {
	}

	public DanhMuc(String maDM, String tenDanhMuc, String nguoiQuanLy, String ghiChu) {
		super();
		this.maDM = maDM;
		this.tenDanhMuc = tenDanhMuc;
		this.nguoiQuanLy = nguoiQuanLy;
		this.ghiChu = ghiChu;
	}

	public String getMaDM() {
		return maDM;
	}

	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getNguoiQuanLy() {
		return nguoiQuanLy;
	}

	public void setNguoiQuanLy(String nguoiQuanLy) {
		this.nguoiQuanLy = nguoiQuanLy;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
}
