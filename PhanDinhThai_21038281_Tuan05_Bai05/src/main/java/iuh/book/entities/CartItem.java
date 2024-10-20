package iuh.book.entities;

public class CartItem {
	private Book  book;
	private int quantityCart;
	
	public CartItem() {
		super();
	}

	public CartItem(Book book, int quantityCart) {
		super();
		this.book = book;
		this.quantityCart = quantityCart;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantityCart() {
		return quantityCart;
	}

	public void setQuantityCart(int quantityCart) {
		this.quantityCart = quantityCart;
	}
	
}
