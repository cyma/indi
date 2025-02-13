package es.inditex.prueba.domain.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import es.inditex.prueba.domain.model.PricesModel;
import es.inditex.prueba.infrastructure.exception.InfrastructureException;

public interface IPricesRepository {

	Optional<PricesModel> getPrice(LocalDateTime date, Long idProduct, Long idBrand) throws InfrastructureException;
}
