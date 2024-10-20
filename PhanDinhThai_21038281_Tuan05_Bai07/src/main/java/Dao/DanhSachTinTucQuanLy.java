package Dao;

import java.util.List;

import entities.TinTuc;

public interface DanhSachTinTucQuanLy {
	public List<TinTuc> getALLTinTuc();
	public List<TinTuc> getTinTucByDanhMuc(String maDM);
	public TinTuc getTinTucByMaTT(String maTT);
	public void themTinTuc(TinTuc tinTuc);

	public void xoaTinTuc(String maTT);
}
