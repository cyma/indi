package es.inditex.prueba.infrastructure.h2.repository.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import es.inditex.prueba.domain.model.PricesModel;
import es.inditex.prueba.domain.repository.IPricesRepository;
import es.inditex.prueba.infrastructure.exception.InfrastructureException;
import es.inditex.prueba.infrastructure.h2.entity.PricesEntity;
import es.inditex.prueba.infrastructure.h2.mapper.EntityToModelMapper;
import es.inditex.prueba.infrastructure.h2.repository.JpaH2Repository;

@Repository
public class PricesRepositoryDb2Impl implements IPricesRepository {
	
	private final JpaH2Repository jpaDb2Repository;
	private final EntityToModelMapper entityToModelMapper;
	
	@Autowired
	PricesRepositoryDb2Impl(JpaH2Repository jpaDb2Repository,
			EntityToModelMapper entityToModelMapper) {
		this.jpaDb2Repository = jpaDb2Repository;
		this.entityToModelMapper = entityToModelMapper;
	}

	@Override
	public Optional<PricesModel> getPrice(LocalDateTime date, Long idProduct, Long idBrand) throws InfrastructureException {	
		try {
			PageRequest pageRequest = PageRequest.of(0, 1);
			Page<PricesEntity> page = jpaDb2Repository.getPrice(date, idProduct, idBrand, pageRequest);
			return page.stream().findFirst().map(entityToModelMapper::pricesEntityToPricesModel);
		} catch (Exception e) {
			throw new InfrastructureException("Error db2 getPrice", e);
		}
	}

}
