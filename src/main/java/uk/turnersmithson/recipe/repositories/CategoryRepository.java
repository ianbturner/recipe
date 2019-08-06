package uk.turnersmithson.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.turnersmithson.recipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
