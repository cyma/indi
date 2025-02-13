package es.inditex.prueba.infrastructure.rest.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GetPriceResponse {
	
	private Long id;
	private Long idProduct;
	private Long idBrand;
	private Long idRate;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal price;
	
	public GetPriceResponse() {
		/* Empty constructor */
	}
	
	public GetPriceResponse(Long id, Long idProduct, Long idBrand, 
			Long idRate, LocalDateTime startDate, LocalDateTime endDate, BigDecimal price) {
		this.idProduct = idProduct;
		this.idBrand = idBrand;
		this.idRate = idRate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Long getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(Long idBrand) {
		this.idBrand = idBrand;
	}

	public Long getIdRate() {
		return idRate;
	}

	public void setIdRate(Long idRate) {
		this.idRate = idRate;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
