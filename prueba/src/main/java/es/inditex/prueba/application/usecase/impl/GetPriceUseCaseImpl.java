package es.inditex.prueba.application.usecase.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.inditex.prueba.application.exception.ApplicationException;
import es.inditex.prueba.domain.model.PricesModel;
import es.inditex.prueba.domain.repository.IPricesRepository;
import es.inditex.prueba.domain.usecase.IGetPriceUseCase;
import es.inditex.prueba.infrastructure.exception.InfrastructureException;

@Service
public class GetPriceUseCaseImpl implements IGetPriceUseCase {


	private final IPricesRepository iPricesRepository;
		
	private static final Log LOG = LogFactory.getLog(GetPriceUseCaseImpl.class);
	
	@Autowired
	public GetPriceUseCaseImpl(IPricesRepository iPricesRepository) {
		this.iPricesRepository = iPricesRepository;
	}
		
	@Override
	public Optional<PricesModel> getPrice(LocalDateTime date, Long idProduct, Long idBrand) throws ApplicationException {
		try {
			return iPricesRepository.getPrice(date, idProduct, idBrand);
		} catch (InfrastructureException e) {
			LOG.error(e);
			throw new ApplicationException("Application UserCase error getPrice from Infrastructure");
		}
	}

}
