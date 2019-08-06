package uk.turnersmithson.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.turnersmithson.recipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
