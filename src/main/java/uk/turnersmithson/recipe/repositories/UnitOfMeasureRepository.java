package uk.turnersmithson.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.turnersmithson.recipe.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByDescription( String description );
}
