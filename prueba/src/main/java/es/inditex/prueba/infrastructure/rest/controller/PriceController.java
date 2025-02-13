package es.inditex.prueba.infrastructure.rest.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.inditex.prueba.application.exception.ApplicationException;
import es.inditex.prueba.domain.model.PricesModel;
import es.inditex.prueba.domain.usecase.IGetPriceUseCase;
import es.inditex.prueba.infrastructure.rest.mapper.ModelToResponseMapper;
import es.inditex.prueba.infrastructure.rest.response.GetPriceResponse;

@RestController
@RequestMapping(value = "/price")
public class PriceController {
	
	private final IGetPriceUseCase iGetPriceUseCase;
	private final ModelToResponseMapper modelToResponseMapper;

	private static final Log LOG = LogFactory.getLog(PriceController.class);
	
	@Autowired
	public PriceController(IGetPriceUseCase iGetPriceUseCase, ModelToResponseMapper modelToResponseMapper) {
		this.iGetPriceUseCase = iGetPriceUseCase;
		this.modelToResponseMapper = modelToResponseMapper;
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GetPriceResponse> getPrice(
			@RequestParam(required = true) LocalDateTime date, 
			@RequestParam(required = true) Long idProduct, 
			@RequestParam(required = true) Long idBrand ) {
		
		LOG.info("Request to get price for idProduct: " + idProduct + " idBrand: " 
			+ idBrand + " date: " + date);		
		try {

			Optional<PricesModel> priceModel = iGetPriceUseCase.getPrice(date, idProduct, idBrand);
			if (priceModel.isPresent()) {
				LOG.info("Price found");
				GetPriceResponse getPriceResponse = modelToResponseMapper.pricesModelToGetPriceResponse(priceModel.get());
				return ResponseEntity.ok(getPriceResponse);
			} else {
				LOG.info("Price not found");
				return ResponseEntity.notFound().build();
			}

		} catch (ApplicationException e) {
			LOG.error(e.getMessage());
			return ResponseEntity.internalServerError().build();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return ResponseEntity.internalServerError().build();
		}

	}
}
