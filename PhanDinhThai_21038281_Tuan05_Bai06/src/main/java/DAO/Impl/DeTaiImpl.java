package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import DAO.DetaiDAO;
import entities.DeTai;
import entities.GiangVien;

public class DeTaiImpl implements DetaiDAO {

	private DataSource dataSource;
	
	public DeTaiImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<DeTai> getALLDeTai() {
		String sql = "SELECT * FROM DETAI";
		List<DeTai> list = new ArrayList<DeTai>();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DeTai dt = new DeTai();
				dt.setMaDT(rs.getString("MADT"));
				dt.setTenDT(rs.getString("TENDT"));
				dt.setNamDangKy(rs.getInt("NAMDANGKY"));
				dt.setMotaDeTai(rs.getString("MOTADETAI"));
				dt.setMaGV(rs.getString("MAGV"));
				list.add(dt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<DeTai> getALLDeTaiByMaGV(String maGV) {
		String sql = "SELECT * FROM DETAI WHERE MAGV = ?";
		List<DeTai> list = new ArrayList<DeTai>();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, maGV);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DeTai dt = new DeTai();
				dt.setMaDT(rs.getString("MADT"));
				dt.setTenDT(rs.getString("TENDT"));
				dt.setNamDangKy(rs.getInt("NAMDANGKY"));
				dt.setMotaDeTai(rs.getString("MOTADETAI"));
				dt.setMaGV(rs.getString("MAGV"));
				list.add(dt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<GiangVien> getALLGiangVien() {
		String sql = "SELECT * FROM GIANGVIEN";
		List<GiangVien> list = new ArrayList<GiangVien>();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GiangVien gv = new GiangVien();
				gv.setMaGV(rs.getString("MAGV"));
				gv.setTenGV(rs.getString("TENGV"));
				gv.setLinhVucNghienCuu(rs.getString("LINHVUCNGHIENCUU"));
				gv.setSoDienThoai(rs.getString("SODIENTHOAI"));
				list.add(gv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void AddGiangVien(GiangVien gv) {
		String sql = "INSERT INTO GIANGVIEN(MAGV,TENGV,LINHVUCNGHIENCUU,SODIENTHOAI) VALUES(?,?,?,?)";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);

		) {
			ps.setString(1, gv.getMaGV());
			ps.setString(2, gv.getTenGV());
			ps.setString(3, gv.getLinhVucNghienCuu());
			ps.setString(4, gv.getSoDienThoai());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void AddDeTai(String maGV, DeTai dt) {
		String sql = "INSERT INTO DETAI(MADT,TENDT,NAMDANGKY,MOTADETAI,MAGV) VALUES(?,?,?,?,?)";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);

		) {
			ps.setString(1, dt.getMaDT());
			ps.setString(2, dt.getTenDT());
			ps.setInt(3, dt.getNamDangKy());
			ps.setString(4, dt.getMotaDeTai());
			ps.setString(5, maGV);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
