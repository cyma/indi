package es.inditex.prueba.infrastructure.h2.mapper;

import org.mapstruct.Mapper;

import es.inditex.prueba.domain.model.PricesModel;
import es.inditex.prueba.infrastructure.h2.entity.PricesEntity;

@Mapper(componentModel = "spring")
public interface EntityToModelMapper {

	PricesModel pricesEntityToPricesModel(PricesEntity entity);
}
