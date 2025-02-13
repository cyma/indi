package es.inditex.prueba.infrastructure.rest.mapper;

import org.mapstruct.Mapper;

import es.inditex.prueba.domain.model.PricesModel;
import es.inditex.prueba.infrastructure.rest.response.GetPriceResponse;

@Mapper(componentModel = "spring")
public interface ModelToResponseMapper {

	GetPriceResponse pricesModelToGetPriceResponse(PricesModel model);
}
