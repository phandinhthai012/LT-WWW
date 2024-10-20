package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Dao.DanhSachTinTucQuanLy;
import entities.TinTuc;

public class DanhSachTinTucQuanLyImpl implements DanhSachTinTucQuanLy {
	private DataSource dataSource;

	public DanhSachTinTucQuanLyImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<TinTuc> getTinTucByDanhMuc(String maDM) {
		String sql = "SELECT * FROM TINTUC WHERE maDM = ?";
		List<TinTuc> list = new ArrayList<TinTuc>();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, maDM);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TinTuc tinTuc = new TinTuc();
				tinTuc.setMaTT(rs.getString("MATT"));
				tinTuc.setTieuDe(rs.getString("TIEUDE"));
				tinTuc.setNoiDungTT(rs.getString("NOIDUNGTT"));
				tinTuc.setLienKet(rs.getString("LIENKET"));
				tinTuc.setMaDM(rs.getString("MADM"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void themTinTuc(TinTuc tinTuc) {
		String sql = "INSERT INTO TINTUC (MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM) VALUES (?, ?, ?, ?, ?)";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, tinTuc.getMaTT());
			ps.setString(2, tinTuc.getTieuDe());
			ps.setString(3, tinTuc.getNoiDungTT());
			ps.setString(4, tinTuc.getLienKet());
			ps.setString(5, tinTuc.getMaDM());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void xoaTinTuc(String maTT) {
		String sql = "DELETE FROM TINTUC WHERE MATT = ?";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, maTT);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<TinTuc> getALLTinTuc() {
		String sql = "SELECT * FROM TINTUC";
		List<TinTuc> list = new ArrayList<TinTuc>();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TinTuc tinTuc = new TinTuc();
				tinTuc.setMaTT(rs.getString("MATT"));
				tinTuc.setTieuDe(rs.getString("TIEUDE"));
				tinTuc.setNoiDungTT(rs.getString("NOIDUNGTT"));
				tinTuc.setLienKet(rs.getString("LIENKET"));
				tinTuc.setMaDM(rs.getString("MADM"));
				list.add(tinTuc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public TinTuc getTinTucByMaTT(String maTT) {
		String sql = "SELECT * FROM TINTUC WHERE MATT = ?";
		try (
				Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, maTT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TinTuc tinTuc = new TinTuc();
				tinTuc.setMaTT(rs.getString("MATT"));
				tinTuc.setTieuDe(rs.getString("TIEUDE"));
				tinTuc.setNoiDungTT(rs.getString("NOIDUNGTT"));
				tinTuc.setLienKet(rs.getString("LIENKET"));
				tinTuc.setMaDM(rs.getString("MADM"));
				return tinTuc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
