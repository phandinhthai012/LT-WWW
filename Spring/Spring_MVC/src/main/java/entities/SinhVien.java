package entities;

public class SinhVien {
	private int id;
	private String fname;
	private String lname;
	private float diemtb;
	
	public SinhVien() {
		super();
	}

	public SinhVien(int id, String fname, String lname, float diemtb) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.diemtb = diemtb;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public float getDiemtb() {
		return diemtb;
	}

	public void setDiemtb(float diemtb) {
		this.diemtb = diemtb;
	}
}
