package es.inditex.prueba.domain.usecase;

import java.time.LocalDateTime;
import java.util.Optional;

import es.inditex.prueba.application.exception.ApplicationException;
import es.inditex.prueba.domain.model.PricesModel;

public interface IGetPriceUseCase {

	Optional<PricesModel> getPrice(LocalDateTime date, Long idProduct, Long idBrand) throws ApplicationException;
}
