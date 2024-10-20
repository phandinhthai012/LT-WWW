package Dao;

import java.util.List;

import entities.DanhMuc;

public interface DanhMucDao {
	public List<DanhMuc> getAllDanhMuc();
	public DanhMuc getDanhMucById(String maDM);
	public void addDanhMuc(DanhMuc danhMuc);
}
