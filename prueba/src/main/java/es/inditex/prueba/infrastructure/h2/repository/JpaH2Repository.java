package es.inditex.prueba.infrastructure.h2.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.inditex.prueba.infrastructure.h2.entity.PricesEntity;

@Repository
public interface JpaH2Repository extends JpaRepository<PricesEntity, Long> {
	
	@Query("""
		    SELECT p FROM PricesEntity p
		    WHERE p.idBrand = :idBrand
		    AND p.idProduct = :idProduct
		    AND :fecha BETWEEN p.startDate AND p.endDate
		    ORDER BY p.priority DESC
		""")
	Page<PricesEntity> getPrice(@Param("fecha") LocalDateTime date,
            @Param("idProduct") Long idProduct,
            @Param("idBrand") Long idBrand,
            Pageable pageable);
}
