package cn.zh.jdbc.domain;

public class Product {
	private Integer product_id;
	private String product_name;
	private String product_catalog;
	private String product_baseprice;
	private String product_description;
	private String product_status;
	private String product_depatement;
	private Integer product_sale_unit;
	private String product_image;
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_catalog() {
		return product_catalog;
	}
	public void setProduct_catalog(String product_catalog) {
		this.product_catalog = product_catalog;
	}
	public String getProduct_baseprice() {
		return product_baseprice;
	}
	public void setProduct_baseprice(String product_baseprice) {
		this.product_baseprice = product_baseprice;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public String getProduct_status() {
		return product_status;
	}
	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}
	public String getProduct_depatement() {
		return product_depatement;
	}
	public void setProduct_depatement(String product_depatement) {
		this.product_depatement = product_depatement;
	}
	public Integer getProduct_sale_unit() {
		return product_sale_unit;
	}
	public void setProduct_sale_unit(Integer product_sale_unit) {
		this.product_sale_unit = product_sale_unit;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_catalog="
				+ product_catalog + ", product_baseprice=" + product_baseprice + ", product_description="
				+ product_description + ", product_status=" + product_status + ", product_depatement="
				+ product_depatement + ", product_sale_unit=" + product_sale_unit + ", product_image=" + product_image
				+ "]";
	}

	
	
}
