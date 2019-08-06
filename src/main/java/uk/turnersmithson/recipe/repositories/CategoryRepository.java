package uk.turnersmithson.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.turnersmithson.recipe.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
