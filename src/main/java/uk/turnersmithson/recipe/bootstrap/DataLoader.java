package uk.turnersmithson.recipe.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uk.turnersmithson.recipe.domain.Ingredient;
import uk.turnersmithson.recipe.domain.Recipe;
import uk.turnersmithson.recipe.domain.UnitOfMeasure;
import uk.turnersmithson.recipe.repositories.RecipeRepository;
import uk.turnersmithson.recipe.repositories.UnitOfMeasureRepository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

@Component
public class DataLoader implements CommandLineRunner {

    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    DataLoader( RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository ){
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println( "Loading test data" );
        final Optional<UnitOfMeasure> tableSpoon = unitOfMeasureRepository.findByDescription("Tablespoon");
        final Optional<UnitOfMeasure> teaSpoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        final Optional<UnitOfMeasure> dash = unitOfMeasureRepository.findByDescription("Dash");

        Recipe guacamoleRecipe = new Recipe();
        Set<Ingredient> guacamoleIngredients = new HashSet<>();
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setDescription("Avacardo");
        ingredient1.setAmount( BigDecimal.valueOf(2) );
        ingredient1.setRecipe( guacamoleRecipe );

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setDescription("Kosher");
        ingredient2.setAmount( BigDecimal.valueOf(0.5) );
        ingredient2.setUnitOfMeas( teaSpoon.get() );
        ingredient2.setRecipe( guacamoleRecipe );

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setDescription("fresh line or lemon juice");
        ingredient3.setAmount( BigDecimal.ONE );
        ingredient3.setUnitOfMeas( tableSpoon.get() );
        ingredient3.setRecipe( guacamoleRecipe );

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setDescription("minced red onion or thinly sliced green onion");
        ingredient4.setAmount( BigDecimal.valueOf(2) );
        ingredient4.setUnitOfMeas( tableSpoon.get() );
        ingredient4.setRecipe( guacamoleRecipe );

        Ingredient ingredient5 = new Ingredient();
        ingredient5.setDescription("serrano chiles, stems and seeds removed");
        ingredient5.setAmount( BigDecimal.valueOf(2) );
        ingredient5.setRecipe( guacamoleRecipe );

        Ingredient ingredient6 = new Ingredient();
        ingredient6.setDescription("cilantro (leaves and tender stems), freshly chopped");
        ingredient6.setAmount( BigDecimal.valueOf(2) );
        ingredient6.setRecipe( guacamoleRecipe );

        Ingredient ingredient7 = new Ingredient();
        ingredient7.setDescription("freshly grated black pepper");
        ingredient7.setAmount( BigDecimal.ONE );
        ingredient7.setUnitOfMeas( dash.get() );
        ingredient7.setRecipe( guacamoleRecipe );

        Ingredient ingredient8 = new Ingredient();
        ingredient8.setDescription("cilantro (leaves and tender stems), freshly chopped");
        ingredient8.setAmount( BigDecimal.valueOf(2) );
        ingredient8.setRecipe( guacamoleRecipe );



        guacamoleIngredients.add(ingredient1);
        guacamoleIngredients.add(ingredient2);
        guacamoleIngredients.add(ingredient3);
        guacamoleIngredients.add(ingredient4);
        guacamoleIngredients.add(ingredient5);
        guacamoleIngredients.add(ingredient6);
        guacamoleIngredients.add(ingredient7);
        guacamoleIngredients.add(ingredient8);

        guacamoleRecipe.setDescription("How To Make Perfect Guacamole");
        guacamoleRecipe.setDirections("Need to grab these");
        guacamoleRecipe.setIngredients( guacamoleIngredients );
        recipeRepository.save(guacamoleRecipe);
    }
}
