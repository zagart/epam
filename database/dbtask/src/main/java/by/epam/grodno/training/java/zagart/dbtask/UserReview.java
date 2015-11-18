package by.epam.grodno.training.java.zagart.dbtask;

public class UserReview {

	private int id;
	private int userId;
	private int shopId;
	private String shopReview;
	private int shopRating;
	private int productId;
	private String productReview;
	private int productRating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopReview() {
		return shopReview;
	}
	public void setShopReview(String shopReview) {
		this.shopReview = shopReview;
	}
	public int getShopRating() {
		return shopRating;
	}
	public void setShopRating(int shopRating) {
		this.shopRating = shopRating;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductReview() {
		return productReview;
	}
	public void setProductReview(String productReview) {
		this.productReview = productReview;
	}
	public int getProductRating() {
		return productRating;
	}
	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}
	
}
