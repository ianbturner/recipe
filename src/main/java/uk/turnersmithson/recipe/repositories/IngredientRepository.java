package uk.turnersmithson.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.turnersmithson.recipe.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
