package Shopping.DAO;

import java.util.List;

import Shopping.entities.Product;

public interface ProductDAO {
	public List<Product> getAll();

	public Product getByID(int id);

	public void add(Product product);
//
//	public void delete(int id);
//
//	public void update(Product product);
}
