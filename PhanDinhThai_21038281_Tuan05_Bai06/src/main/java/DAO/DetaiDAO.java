package DAO;

import java.util.List;

import entities.DeTai;
import entities.GiangVien;

public interface DetaiDAO {
	public List<DeTai> getALLDeTai();
	public List<DeTai> getALLDeTaiByMaGV(String maGV);
	public List<GiangVien> getALLGiangVien();
	public void AddGiangVien(GiangVien gv);
	public void AddDeTai(String maGV,DeTai dt);
}
