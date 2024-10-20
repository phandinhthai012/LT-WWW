package Shopping.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Shopping.DAO.ProductDAO;
import Shopping.entities.Product;

public class ProductDAOImpl implements ProductDAO {
	private DataSource dataSource;

	public ProductDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Product> getAll() {
		String sql = "SELECT * FROM Product";
		List<Product> list = new ArrayList<Product>();
		try (Connection con = dataSource.getConnection();
				PreparedStatement pre = con.prepareStatement(sql);
				ResultSet rs = pre.executeQuery();) {
			while (rs.next()) {
				Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"),
						rs.getString("image"));
				list.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product getByID(int id) {
		String sql = "SELECT * FROM Product WHERE id = ?";
		Product pro = null;
		try (Connection con = dataSource.getConnection();
				PreparedStatement pre = con.prepareStatement(sql);
				) {
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				pro = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("image"));
			}
			return pro;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return pro;
	}

	@Override
	public void add(Product product) {
		String sql = "INSERT INTO Product(name, price, image) VALUES(?, ?, ?)";
		try (Connection con = dataSource.getConnection(); PreparedStatement pre = con.prepareStatement(sql);) {
			pre.setString(1, product.getName());
			pre.setDouble(2, product.getPrice());
			pre.setString(3, product.getImage());
			pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
