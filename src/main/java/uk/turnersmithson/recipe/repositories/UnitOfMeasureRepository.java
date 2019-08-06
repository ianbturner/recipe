package uk.turnersmithson.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.turnersmithson.recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
