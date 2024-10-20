package entities;

public class DeTai {
	private String maDT;
	private String tenDT;
	private int namDangKy;
	private String MotaDeTai;
	private String maGV;

	public DeTai() {
	}

	public DeTai(String maDT, String tenDT, int namDangKy, String motaDeTai, String maGV) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.namDangKy = namDangKy;
		MotaDeTai = motaDeTai;
		this.maGV = maGV;
	}

	public String getMaDT() {
		return maDT;
	}

	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public int getNamDangKy() {
		return namDangKy;
	}

	public void setNamDangKy(int namDangKy) {
		this.namDangKy = namDangKy;
	}

	public String getMotaDeTai() {
		return MotaDeTai;
	}

	public void setMotaDeTai(String motaDeTai) {
		MotaDeTai = motaDeTai;
	}

	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
}
