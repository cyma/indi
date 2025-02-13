package es.inditex.prueba.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PricesModel {

    private Long id;	
	private Long idBrand;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Long idRate;
	private Long idProduct;	
	private Integer priority;	
	private BigDecimal price;	
	private String currency;
	
	public PricesModel() {
		/* Empty Constructor */
	}

	public PricesModel(Long id, Long idBrand, LocalDateTime startDate, LocalDateTime endDate, Long idRate, Long idProduct,
			Integer priority, BigDecimal price, String currency) {
		this.id = id;
		this.idBrand = idBrand;
		this.startDate = startDate;
		this.endDate = endDate;
		this.idRate = idRate;
		this.idProduct = idProduct;
		this.priority = priority;
		this.price = price;
		this.currency = currency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(Long idBrand) {
		this.idBrand = idBrand;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Long getIdRate() {
		return idRate;
	}

	public void setIdRate(Long idRate) {
		this.idRate = idRate;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
