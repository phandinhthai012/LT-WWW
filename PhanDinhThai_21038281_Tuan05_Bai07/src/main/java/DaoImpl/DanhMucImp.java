package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Dao.DanhMucDao;
import entities.DanhMuc;

public class DanhMucImp implements DanhMucDao {
	private DataSource dataSource;

	public DanhMucImp(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<DanhMuc> getAllDanhMuc() {
		String sql = "SELECT * FROM DANHMUC";
		List<DanhMuc> list = new ArrayList();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DanhMuc danhMuc = new DanhMuc();
				danhMuc.setMaDM(rs.getString("MADM"));
				danhMuc.setTenDanhMuc(rs.getString("TENDANHMUC"));
				danhMuc.setNguoiQuanLy(rs.getString("NGUOIQUANLY"));
				danhMuc.setGhiChu(rs.getString("GHICHU"));
				list.add(danhMuc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public DanhMuc getDanhMucById(String maDM) {
		String sql = "SELECT * FROM DANHMUC WHERE MADM = ?";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, maDM);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DanhMuc danhMuc = new DanhMuc();
				danhMuc.setMaDM(rs.getString("MADM"));
				danhMuc.setTenDanhMuc(rs.getString("TENDANHMUC"));
				danhMuc.setNguoiQuanLy(rs.getString("NGUOIQUANLY"));
				danhMuc.setGhiChu(rs.getString("GHICHU"));
				return danhMuc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addDanhMuc(DanhMuc danhMuc) {
		String sql = "INSERT INTO DANHMUC (MADM, TENDANHMUC, NGUOIQUANLY, GHICHU) VALUES (?, ?, ?, ?)";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, danhMuc.getMaDM());
			ps.setString(2, danhMuc.getTenDanhMuc());
			ps.setString(3, danhMuc.getNguoiQuanLy());
			ps.setString(4, danhMuc.getGhiChu());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
