package iuh.book.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import iuh.book.Dao.ReceiptDao;
import iuh.book.entities.Receipt;

public class ReceiptDaoImpl implements ReceiptDao {
	private DataSource dataSource;
	
	public ReceiptDaoImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
	}
	@Override
	public void addReceipt(Receipt receipt) {
		String sql = "INSERT INTO RECEIPT (name, address, total, payment, listIDBook) VALUES (?,?,?,?,?)";
		try (
				Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				){
			ps.setString(1, receipt.getName());
			ps.setString(2, receipt.getAddress());
			ps.setDouble(3, receipt.getTotal());
			ps.setString(4, receipt.getPayment());
			ps.setString(5, receipt.getListIDBook());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
